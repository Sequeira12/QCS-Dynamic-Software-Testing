package Code;
// Java program to find triplets in a given 
// array whose sum is zero 
import java.util.*; 
  
public class CodeJava  
{ 
  
    // function to print triplets with 0 sum 
    public static int[][] findTriplets(int arr[], int n)  
    { 
        boolean found = false; 
        int[][] result = new int[n*3][3];
        int count = 0;
        for (int i = 0; i < n - 1; i++)  
        { 
            // Find all pairs with sum equals to 
            // "-arr[i]" 
            HashSet<Integer> s = new HashSet<Integer>(); 
            for (int j = i + 1; j < n; j++)  
            { 
                int x = -(arr[i] + arr[j]); 
                if (s.contains(x))  
                { 
                    result[count][0] = x;
                    result[count][1] = arr[i];
                    result[count][2] = arr[j];
                    count++;
                    found = true; 
                }  
                else 
                { 
                    s.add(arr[j]); 
                } 
            } 
        } 
  
        
        return result;
    } 
  
    // Driver code 
    public static void main(String[] args)  
    { 
        int arr[] = {0, -1, 2, -3, 1}; 
        int n = arr.length; 
        int[][] result = findTriplets(arr, n); 
        for(int i = 0; i < result.length;i++){
            System.out.printf("%d %d %d\n",result[i][0],result[i][1],result[i][2]);
        }
    } 
} 
  
// This code contributed by Rajput-Ji






