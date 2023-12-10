/*
 * qotd.c: quote of the day win32 API.
 * Copyright 2008 by lab2@codespin.ch
 */

#include <stdio.h>
#include <windows.h>
#include <winsock2.h>

#define PORT 17
#define BUFSIZE 1024

char buffer[BUFSIZE];
HOSTENT *hostentry;
int addr;

int startSocket(void) {
	WSADATA wsa;
	return WSAStartup(MAKEWORD(2, 0), &wsa);
}

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nCmdShow) {
	if (startSocket()!=0) {
		fprintf(stderr, "\nWinsock error\n");
		exit(0);
	}
	hostentry = gethostbyname("ota.iambic.com");
	if (hostentry==NULL)
	exit(0);
	SOCKET _server;
	_server = socket(AF_INET,SOCK_STREAM,0);

	if(_server==INVALID_SOCKET) {
		fprintf(stderr, "\nInvalid socket\n");
		WSACleanup();
	}
	SOCKADDR_IN _request;
	_request.sin_family = AF_INET;
	_request.sin_addr.s_addr = inet_addr(inet_ntoa(*(struct in_addr*)(hostentry->h_addr_list[0])));
	_request.sin_port = htons(PORT);
	if(connect(_server,(SOCKADDR*)&_request, sizeof(_request))==SOCKET_ERROR) {
		fprintf(stderr, "\nNo connection to server\n");
		WSACleanup();
	}
	recv(_server, buffer, BUFSIZE, 0);
	WSACleanup();
	MessageBox(0, buffer, "Quote of the day via ota.iambic.com", MB_OK);
	return 0;
}