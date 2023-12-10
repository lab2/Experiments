#include <stdio.h>
#include <math.h> 
#include <time.h>

int c=3;

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
  int i=2, prime=0;
  int count=0;
  do{
    if(isprime(i)==1){
      prime=i;
      count++;
    }
  i++;
  }while(count<10001);
  printf("%d ", prime);
  printf("\nTime: %g sec", ((double)clock() - start) / (double)CLOCKS_PER_SEC);
  return 0;     
}