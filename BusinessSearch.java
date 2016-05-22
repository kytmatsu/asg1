//
//Kyle Matsumoto
//kytmatsu
//CMPS012B
//10/22/14
//This program takes the data from a file mergesorts it then binary searches the query.
//
import static java.lang.System.*;
import java.util.List;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
public class BusinessSearch {

static String[] business = new String[100];

public static void mergeSort(int x) throws IOException {
	String[] merger = new String[x];
    recMergeSort(merger, 0, x-1);
}

public static void recMergeSort(String[] merger, int lowerBound,int upperBound) throws IOException
{
if(lowerBound == upperBound)            
return;                              
else
{                                    
int mid = (lowerBound + upperBound) / 2;
recMergeSort(merger, lowerBound, mid);
recMergeSort(merger, mid + 1, upperBound);
merge(merger, lowerBound, mid + 1, upperBound);
} 
}

public static void merge(String[] merger, int low, int high, int upperBound) throws IOException
{
int x = 0;
int lowerBound = low;
int mid = high - 1;
int y = upperBound-lowerBound + 1;       

while(low <= mid && high <= upperBound)
if(business[high].compareTo(business[low])> 0)
	merger[x++] = business[low++];
else
	merger[x++] = business[high++];
while(low <= mid)
	
	merger[x++] = business[low++];

while(high <= upperBound)
	merger[x++] = business[high++];

for(x=0; x<y; x++)
	business[lowerBound+x] = merger[x];
}

public static int binarySearch(String[] x, String key) {
    int first = 0;
    int last = x.length - 1;
    int mid;
    while (first <= last) {
        mid = (first+last) /2;
        if (x[mid].substring(0, x[mid].indexOf(",")).compareTo(key) > 0) 
            last = mid;
        else if (x[mid].substring(0, x[mid].indexOf(",")).compareTo(key) < 0) 
            first = mid + 1;
        else 
            return mid;
    }
    return -1;
}

public static void main(String[] args) throws IOException
{
	BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	BufferedReader in = new BufferedReader(new FileReader(args[0]));
	String read = in.readLine();
	int size = Integer.parseInt(read);
	business = new String[size];
	for(int x = 0; x < size; x++)
	{
	 business[x] = in.readLine();
	}
	mergeSort(size);
	while(true)
	{
	String query = stdin.readLine();
	if(query.isEmpty())
		break;
	else
	{
		String getNumber = null;
		int x =  binarySearch(business, query);
		if(x == -1)
			System.out.println("NOT FOUND");
		else
		{
        getNumber = BusinessSearch.business[x].substring(BusinessSearch.business[x].indexOf(",") + 1 , BusinessSearch.business[x].length());
		System.out.println(getNumber);
		}
  }
	
	}
	}
}


