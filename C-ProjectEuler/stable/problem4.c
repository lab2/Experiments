#include <stdio.h>
#include <time.h>
#include <stdbool.h>

bool isPalindromic(int n){
  double s=0, a=n, rem;
  bool check;
  do{
    rem=n%10;
    s=s*10+rem;
    n=n/10;
  }while(n>0);
  if (s==a)
    check=true;
  else
    check=false; 
  return check;
}

int main(){
  int i, j, max=0;
  clock_t start = clock();
  for (i=100;i<=999;i++){
    for (j=100;j<=999;j++){
      if (isPalindromic(i*j)==true){
        if (i*j>max)
          max=i*j;
      }
    }
  }
  printf("%d\n", max);
  printf("\nTime: %g sec", ((double)clock() - start) / (double)CLOCKS_PER_SEC);
  return 0;     
}