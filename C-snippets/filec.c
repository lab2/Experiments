/*
 * filec.c: file creation with a given size.
 * Copyright 2009 by lab2@codespin.ch
 */

#define BYTES 1048576

#include <stdio.h>
#include <string.h>

void help(void) {
	printf("\nCreates a file of a given size in MB");
	printf("\n-usage: filec <arg>=MB\n");
}

int main(int argc, char *argv[]) {
	int payload = 0, chars;
	if (argc < 2) {
		help();
		return 1;
	} else {
		FILE *file;
		file = fopen("filec", "w+");
		if (atoi(argv[1]) > 50)
			payload = 5;
		else
			payload = atoi(argv[1]);
		for (chars = 0; chars <= payload * BYTES; ++chars) {
			fputc(chars, file);
		}
		fclose(file);
	}
	return 0;
}