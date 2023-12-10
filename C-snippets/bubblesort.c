/*
 * bubblesort.c: bubble sort algorithm.
 * Copyright 2009 by lab2@codespin.ch
 */

#include <stdio.h>
#include <stdbool.h>

#ifndef LENGTH
#include "helper.h"
#endif

int array[] = { 0, 9, 4, 6, 2, 8, -5, 1, 7, 3, -20 };
int tmp = 0, i;
bool swap = true;

void bubblesort(int x[]) {
	while (swap) {
		swap = false;
		for (i = 0; i < LENGTH(array); i++)
			if (x[i] > x[i + 1]) {
				tmp = x[i];
				x[i] = x[i + 1];
				x[i + 1] = tmp;
				swap = true;
			}
	}
}

int main() {
	bubblesort(array);
	for (i = 0; i < LENGTH(array); i++)
		printf("%d ", array[i]);
	return 0;
}