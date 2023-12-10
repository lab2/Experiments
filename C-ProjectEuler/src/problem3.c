#include <stdio.h>
#include <math.h> 
#include <time.h>

#define MAX 600851475143

int c=3;

int isprime(int n){
  if (n==1)
    return 0;
  if (n==2)
    return 1;
  if (n%2==0)
    return 0;
  int sqr = sqrt(n*1);
  for(c=3; c<=sqr; c+=2){
    if(n%c==0)
      return 0;
  }
  return 1;
}

int main(){
  clock_t start = clock();
  long long i=2, prime=0;
  long long largest=0;
  do{
    if(isprime(i)==1){
      prime=i;
      if(MAX%prime==0)
        largest=i;
    }
  i++;
  }while(i<MAX);
  printf("%I64d", largest);
  printf("\nTime: %g sec", ((double)clock() - start) / (double)CLOCKS_PER_SEC);
  return 0;     
}


