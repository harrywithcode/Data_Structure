//Implement Insert/Delete/Traverse for a single linked list.

#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>

typedef struct Node{
	int data;
	struct Node *next;
}node;

node *Add(node *head, int data);
node *Delete(node *head, int deletenum);
node *Sort(node *head);
void Traverse(node *head);

node *Add(node *head, int data)
{
	node *p=NULL;
	if (head==NULL)
	{
		head=(node*)malloc(sizeof(node));
		head->data=data;
		head->next=NULL;
	}
	else
	{
		p=(node*)malloc(sizeof(node));
		p->data=data;
		p->next=head;
		head=p;
	}
	return head;
}

node*Sort(node *head)
{
	int t=10;
	int temp;
	node *p1=head, *p2=head, *tail=NULL;
	while (t-- > 0)
	{
		p1=p2=head;
		while (p2!=tail)
		{
			p2=p2->next;

			if (p2==tail)
				break;
			else if (p1->data > p2->data)
			{
				temp=p1->data;
				p1->data=p2->data;
				p2->data=temp;
			}
			p1=p2;
		}
	}
	return head;
}

node*Delete(node *head, int deletenum)
{
	node *p1,*p2;
	p1=head;
	p2=head->next;
	
	while (p2!=NULL)
	{
		if (deletenum==head->data)
		{
			head=head->next;
			return head;
		}
	
		if (deletenum==p2->data)
		{
			p1->next=p2->next;
			return head;
		}
		p1=p1->next;
		p2=p2->next;
	}
	printf("Key < %d > not found\n", deletenum);
	return head;
}


void Traverse(node *head)
{
	
	while (head->next!=NULL)
	{
		printf("%d->", head->data);
		head=head->next;
	}
	printf("%d", head->data);
	printf("\n");
}


int main()
{
	node *head=NULL;

	head=Add(head,5);
	head=Add(head,2);
	head=Add(head,3);
	head=Add(head,8);
	head=Add(head,15);
	head=Add(head,52);
	head=Add(head,33);
	head=Add(head,6);
	head=Add(head,56);

	Sort(head);

	Traverse(head);

	head=Delete(head,2);
	head=Delete(head,3);
	head=Delete(head,1);

	Traverse(head);

	return 1;
}