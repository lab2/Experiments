#include <stdio.h>
#include <math.h> 
#include <stdlib.h>
#include <time.h>

long long c=3;

int isprime(int n){
  if (n==1)
    return 0;
  if (n==2)
    return 1;
  if (n%2==0)
    return 0;
  int sqr = sqrt(n*1);
  for(c=3;c<=sqr;c+=2){
    if(n%c==0)
      return 0;
  }
  return 1;
}

int main(){
  clock_t start = clock();
  long long i=2, prime=0, sum=0LL;
  do{
    if(isprime(i)==1){
      if(i<2000000){
        prime=i;
        sum+=prime;
      }else
      break;
    }
    i++;
  }while(1);
  printf("%I64d", sum);
  printf("\nTime: %g sec", ((double)clock() - start) / (double)CLOCKS_PER_SEC);
  return 0;     
}