/*
 * cartesian.c: simple cartesian product of arrays.
 * Copyright 2009 by lab2@codespin.ch
 */

#include <stdio.h>
#include <assert.h>

#ifndef LENGTH
#include "helper.h"
#endif

int i = 0, d = 0;

char *ver[] = { "a", "b", "c" };
int cpu[] = { 1, 2, 3 };

int main() {
	for (i = 0; i < LENGTH(ver); i++) {
		for (d = 0; d < LENGTH(cpu); d++) {
			printf("[%d,%s]\n", cpu[d], ver[i]);
		}
	}
	assert(LENGTH(ver) * LENGTH(cpu) == i * d);
	return 0;
}