/*
 * reverse.c: reverse array elements.
 * Copyright 2009 by lab2@codespin.ch
 */

#include <stdio.h>

#ifndef LENGTH
#include "helper.h"
#endif

int array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
int i, tmp;

void reverse(int x[]) {
	for (i = 0; i < LENGTH(array) / 2; i++) {
		tmp = x[i];
		x[i] = x[LENGTH(array) - 1 - i];
		x[LENGTH(array) - 1 - i] = tmp;
	}
}

int main() {
	reverse(array);
	for (i = 0; i < LENGTH(array); i++)
		printf("[%d]", array[i]);
	return 0;
}