#include <stdio.h>

int main() {
    // 1. Added [] to declare it as an array
    int arr[] = {1, 2, 3, 4, 6, 7, 8}; 
    
    
    int length = sizeof(arr) / sizeof(arr[0]); 

    
    for (int i = 0; i < length; i++) {
        printf("%d ", arr[i]); 
    }
    
    return 0;
}