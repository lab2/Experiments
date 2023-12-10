#include <stdio.h>
#include <time.h>

#define MAX 20

int c=1;
int i=0;

void solve(int n){
 int check=0;
   for (i=1;i<=MAX;i++){
     if (n%i==0)
       check++;
     else
       break;
   }
  return check;
}

int main(){
  clock_t start = clock();
  do{
    if (solve(c)==MAX){
	printf("%d", c);
 	break;
    }
    c++;
  }while(1);
  printf("\nTime: %g sec", ((double)clock() - start) / (double)CLOCKS_PER_SEC);
  return 0;
}