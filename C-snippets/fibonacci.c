/*
 * fibonacci.c: simple fibonacci sequence.
 * Copyright 2010 by lab2@codespin.ch
 */

#include <stdio.h>

int fibonacci(int n) {
	int start = 0;
	int end = 1;
	int sum, i;

	for (i = 0; i < n; i++) {
		printf("%d\n", start);
		sum = start + end;
		start = end;
		end = sum;
	}
	return 0;
}

int main() {
	int n = 47;
	fibonacci(n);
	return 0;
}