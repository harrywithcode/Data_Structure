#include <stdio.h>

void Search( int a[],int low,int high,int num ){

	int middle1=0, middle2=0;


	if( high-low != 1 ){

		middle1=(high-low)/3 +low;
		middle2=(high-low)*2/3 + low;
	}
	if( high-low == 1 ){
		
		middle1=(high-low)/3 +low;
		middle2=(high-low)*2/3 + low +1;		
	}


	if( middle2-middle1 == 1 && a[middle1] != num && a[middle2] != num ){

		printf("Doesn't exist\n");
		return;
	}
	if( a[1] > num || a[11] < num ){

		printf("Doesn't exist\n");
		return;
	}


	if( a[middle1] == num ){

		printf("the number is at < %d >\n",middle1);
		printf("the number's value is %d\n",a[middle1]);
		return;
	}
	if( a[middle2] == num ){

		printf("the number is at < %d >\n",middle2);
		printf("the number's value is %d\n",a[middle2]);
		return;
	}
	if( a[high] == num ){

		printf("the number is at < %d >\n",high);
		printf("the number's value is %d\n",a[high]);
		return;
	}
	if( a[low] == num ){

		printf("the number is at < %d >\n",low);
		printf("the number's value is %d\n",a[low]);
		return;
	}


	else if( a[middle1] > num )
	{
		 Search(a,low,middle1,num);
	}

	else if( a[middle1] < num && a[middle2] != num )
	{
		if ( a[middle2] < num )
		{
			Search(a,middle2,high,num);
		}
		else
		{
			Search(a,middle1,middle2,num);
		}
	}
}

int main()
{
	int p[11]={ NULL, 12, 15, 19, 25, 26, 37, 48, 59, 110, 111 };
	int num;
	for ( int i=0;i<10;i++ )
	{
		printf("Put in the number you want to find-->");
		scanf("%d",&num);
		Search(p,1,10,num);
	}
	return 0;
}
