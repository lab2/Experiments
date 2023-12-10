/*
 * xorswap.c: swap array elements without a temporary variable.
 * Copyright 2009 by lab2@codespin.ch
 */

#include <stdio.h>

#ifndef LENGTH
#include "helper.h"
#endif

int array[] = { 64, 33 };
int i, tmp;

void swap(int x[]) {
	tmp = x[1];
	x[1] = x[0];
	x[0] = tmp;
}

//Swap without a temporary variable
void xorswap(int x[]) {
	x[0] = x[0] ^ x[1];
	x[1] = x[0] ^ x[1];
	x[0] = x[0] ^ x[1];
}

int main() {
	swap(array);
	for (i = 0; i < LENGTH(array); i++)
		printf("[%d]", array[i]);
	xorswap(array);
	for (i = 0; i < LENGTH(array); i++)
		printf("[%d]", array[i]);
	return 0;
}