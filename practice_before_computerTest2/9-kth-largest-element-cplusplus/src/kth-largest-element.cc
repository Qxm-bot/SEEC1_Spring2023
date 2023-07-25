#include "kth-largest-element.h"

#include <iostream>
using namespace std;





int findKthLargest(int a[], int n, int K) {
  for(int i = n - 1; i >= 1; i--){
    for(int j = 0; j < i; j++){
        if(a[j] >= a[j + 1]){
            int temp = a[j];
            a[j] = a[j + 1];
            a[j + 1] = temp;
        }
    }
  }
  return a[n - K];
}



