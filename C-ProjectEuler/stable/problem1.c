#include <stdio.h>

int c=1;
int sum=0;

int main(){
  do{
    if (c%3==0 || c%5==0)
	sum+=c;
    c++;
  }while(c<1000);
  printf("%d", sum);
  return 0;
}