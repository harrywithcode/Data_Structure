//Implement a queue using 2 stacks. The stacks should be an array of some max size.
#include<stdio.h>
#define N 100
int stack1[N], stack2[N];
int n=0, top1=0, top2=0, val;

void enqueue(int val)
{
	stack1[top1++]=val;
	printf("item < %d > enqueued\n", val);
}

void dequeue()
{
	if (top2==0)
	{
		while (top1!=0)
		{
			stack2[top2++]=stack1[--top1];
		}
	}
	if (top2!=0)
	{
		printf("item < %d > dequeued\n", stack2[--top2]);
	}
	else
	{
		printf("-1\n");
	}
}

int main()
{
	enqueue(1);
	enqueue(2);
	dequeue();
	enqueue(3);
	dequeue();
	enqueue(4);
	enqueue(5);
	dequeue();
	dequeue();
	dequeue();
	dequeue();

	return 0;
}