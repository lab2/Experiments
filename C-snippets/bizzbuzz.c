/*
 * bizzbuzz.c: bizz buzz drinking game.
 * Copyright 2009 by lab2@codespin.ch
 */

#include <stdio.h>

int c = 1;

int main() {
	do {
		(c % 3 == 0 && c % 5 == 0) ? printf("Bizz Buzz,") :
		(c % 3 == 0) ? printf("Bizz,") :
		(c % 5 == 0) ? printf("Buzz,") : printf("%d,", c);
		c++;
	} while (c <= 100);
	return 0;
}