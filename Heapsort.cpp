#include<stdio.h>

int total;

void Swap(int &x,int &y){
	int temp; 
	temp=x; 
	x=y; 
	y=temp; 
} 

void Heapify(int A[], int i)	
{

	if(2*i+1 == total){
		if (A[2*i+1] > A[i]) {	

			Swap(A[i], A[2*i+1]);
			Heapify(A, 2*i+1);
		}
		return;
	}

	while(2*i+2<=total){

		if(A[2*i+1] > A[i] && A[2*i+1] >= A[2*i+2] ){
		
			Swap(A[i], A[2*i+1]);
			Heapify(A, 2*i+1);
		}
		if(A[2*i+1] > A[i] && A[2*i+1] <= A[2*i+2] ){
		
			Swap(A[i], A[2*i+2]);
			Heapify(A, 2*i+2);
		}
		if(A[2*i+2] > A[i] && A[2*i+1] >= A[2*i+2] ){
		
			Swap(A[i], A[2*i+1]);
			Heapify(A, 2*i+1);
		}
		if(A[2*i+2] > A[i] && A[2*i+1] <= A[2*i+2] ){
		
			Swap(A[i], A[2*i+2]);
			Heapify(A, 2*i+2);
		}
		
		return;
	
	}
	return;
}
    


void Buildheap(int A[]){      

    for (int i = (total - 1)/2; i >= 0; i--){
	
        Heapify(A, i);
		}
	
}


void Heapsort(int A[]){
	
	Buildheap(A);

	for(int i = total; i >= 1; i--){	
	
		Swap(A[0],A[i]);
		
		total = total - 1;
		
		Heapify(A,0);
		
	}
return;
}




int main(){
	
	int A[20] = {14,14,18,11,10,12,54,112,117,69,23,77,68,62,21,52,34,42,238,75};

	int length = 20 ;
	total = length - 1;

	printf("Befor sorting:");
	for (int i = 0; i < length; i++){
	
		printf(" %d ",A[i]);
	}
	printf("\n");
	
	
	Heapsort(A);
	
	
	printf("After sorting:");
	for (int j = 0; j < length; j++){
	
		printf(" %d ",A[j]);
	
	}
	printf("\n");
}
