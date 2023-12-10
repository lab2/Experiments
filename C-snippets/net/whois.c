/*
 * whois.c: simple whois .ch domains request.
 * Copyright 2008 by lab2@codespin.ch
 */

#include <stdio.h>
#include <winsock2.h>

#define PORT 43	//whois server port
#define BUFSIZE 1024

char *query = "";
char buffer[BUFSIZE];
HOSTENT *hostentry;
int addr;

int startSocket(void) {
	WSADATA wsa;
	return WSAStartup(MAKEWORD(2, 0), &wsa);
}

int main(int argc, char **argv) {
	if (argc == 3 && strcmp(argv[1], "-h") == 0) {
		query = strcat(argv[2], "\n\r");
	} else {
		fprintf(stderr, "\ncmd -h [query]\n");
		exit(0);
	}
	if (startSocket() != 0) {
		fprintf(stderr, "\nFehler bei starten von Winsock\n");
		exit(0);
	}
	hostentry = gethostbyname("whois.nic.ch");
	if (hostentry == NULL)
		exit(0);
	SOCKET _server;
	_server = socket(AF_INET, SOCK_STREAM, 0);
	if (_server == INVALID_SOCKET) {
		fprintf(stderr, "\nKein gueltiger Socket\n");
		WSACleanup();
	}
	SOCKADDR_IN _request;
	_request.sin_family = AF_INET;
	_request.sin_addr.s_addr = inet_addr(
			inet_ntoa(*(struct in_addr*) (hostentry->h_addr_list[0])));
	_request.sin_port = htons(PORT);

	if (connect(_server, (SOCKADDR*) &_request, sizeof(_request))
			== SOCKET_ERROR) {
		fprintf(stderr, "\nKeine Verbindung zu Server\n");
		WSACleanup();
	}
	send(_server, query, strlen(query), 0);
	recv(_server, buffer, BUFSIZE, 0);
	printf("\n%s", buffer);

	WSACleanup();
	return 0;
}