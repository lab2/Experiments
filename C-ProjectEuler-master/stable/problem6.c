#include <stdio.h>
#include <time.h>
#include <math.h>

#define MAX 100

int squares(int n){
  if (n<1)
    return 0;
  else
    return pow(n,2)+squares(n-1);
}

int squaresum(int n){
  if (n<1)
    return 0;
  else
    return n+squaresum(n-1);
}

int main(){
  clock_t start = clock();
  double sum = squaresum(MAX);
  printf("%f\n", pow(sum,2)-squares(MAX));
  printf("\nTime: %g sec", ((double)clock() - start) / (double)CLOCKS_PER_SEC);
  return 0;
}