/*
 * sieve.c: sieve of Eratosthenes.
 * Copyright 2010 by lab2@codespin.ch
 */

#include <stdio.h>

#define MAX 100

void sieve() {
	int num[MAX];
	int i, c = 0;
	int j = 0, temp = 1;

	for (i = 0; i < MAX; i++) {
		num[i] = j++;
	}
	j = 2;
	do {
		for (i = 0; i < MAX; i++) {
			if (num[i] == j)
				i++;
			else {
				if (num[i] % j == 0)
					num[i] = 0;
			}
		}
		j++;
	} while (j < MAX);
	for (i = 0; i < MAX; i++) {
		if (num[i] != 0)
			printf("%d\n", num[i]);
	}
}

int main() {
	sieve();
	return 0;
}