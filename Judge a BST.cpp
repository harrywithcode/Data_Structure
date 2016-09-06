#include <stdio.h>
#include <stdlib.h>

typedef struct node{

		int data;
		struct node *Lchild, *Rchild;

	}Tree;

Tree *b[100];

Tree *CreateTree(int a[31])
{
	int num,i;
	Tree *Node,*Root;
	Node=NULL;
	
	num=0;
	
	for( int j=0;j<30;j++ ){

		

		Root=(Tree *)malloc(sizeof(Tree));
		Root->data=a[j];
		Root->Lchild=Root->Rchild=NULL;
		num++;

		if( Node==NULL ){
			
			Node=Root;
		}

		b[num]=Root;
		
	}



	for( i=1;i<=num;i++ ){
	
		if( b[i]->data!=-1 ){

			if( 2*i<=num && b[2*i]->data!=-1 ){

				b[i]->Lchild=b[2*i];

			}

			if( 2*i+1<=num && b[2*i+1]->data!=-1 ){

				b[i]->Rchild=b[2*i+1];

			}
		}
	}

	return Node;

}


int IsBST( const Tree *Node, int min, int max ){

	if( Node==NULL ){
        
		return 1;

	}

	
	if ( Node->data < min || Node->data > max ){

		return 0;

	}
	
	return ( IsBST( Node->Lchild, min, Node->data-1 ) && IsBST( Node->Rchild, Node->data+1, max ) );
		
}



int main()
{
	int flag=0;
	Tree *tree;
	int a[31] = { 50, 35, 65, 20, -1, 60, 75, 10, 25, -1, -1, 58, 63, -1, 80, 8, -1, 23, 27, -1, -1, -1, -1, 55, 56, 62, 64, -1, -1, 79, 81 };

	tree=CreateTree( a );
	flag=IsBST( tree, -1000000, 1000000 );

	if( flag==1 ){

		printf("TRUE\n");

	}
	else{

		printf("FALSE\n");

	}
}