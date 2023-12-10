#include <stdio.h>

int fibonacci(int n){
  int start = 0;
  int end = 1;
  int sum;
  int i;
  int even=0;
  for (i=0;i<n;i++){
    sum = start + end;
    if (sum%2==0)
	even+=sum;
    start = end;
    end = sum;
    if (sum>4000000)
	break;
  }
  printf("%d\n",even);
  return 0;
}

int main(){
  int n=47, sum=0;
  fibonacci(n);
  return 0;
}