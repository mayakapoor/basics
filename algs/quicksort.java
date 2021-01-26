import java.util.Scanner;

class QuickSort {

    public static void main(String[] args) {

        /* Just some driver code, read in a comma-separated list
           of numbers and quicksort it. */

        Scanner s = new Scanner(System.in);
        System.out.println("Enter comma-separated list of numbers:");
        String [] nums = s.nextLine().split(",");
        int [] arr = new int [nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }

        quicksort(arr, 0, arr.length-1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    /* QuickSort leverages the divide-and-conquer principle. Essentially,
       this means the problem is divided into subproblems which are 
       solved recursively.

       Average time complexity = O(n log n)
       Space complexity = O(log n)
       Stable = N
       
       In QuickSort, the pivot is the element which divides the list 
       into two-sublists. Choosing the pivot greatly affects this
       algorithm's performance.
       
       When the recursive iteration finishes, these 3 things will be 
       true about the pivot:
       
       1) the pivot is in the correct final position in the array.
       2) all items to the left of the pivot are smaller than it.
       3) all items to the right of the pivot are greater than it. */       

    /* QuickSort written recursively requires the integer array 
       to be sorted, the beginning index, and ending index. Note
       that these indexes shift to reflect the sublists when quicksort
       is recursively called. */

    public static void quicksort(int [] arr, int begin, int end) {
        
       //base case, we stop when we have partitioned enough
       if (begin < end) {

            //get a pivot that meets the three criteria.
            int p = partition(arr, begin, end);
            
            //call quicksort on the two sublists
            quicksort(arr, begin, p-1);
            quicksort(arr, p+1, end);
        }
    }

    /* The parition function, which makes true the above
       pivot criteria and returns the pivot index. */
    public static int partition(int [] arr, int begin, int end) {
        
        //we assign the last element to be the pivot
        int p = arr[end];
        
        /* We are going to be swapping items to the left of the pivot
           if they are smaller, so we need an index to hold that place.
         */
        int i = begin-1;

        // swap items smaller than or equal to the pivot.
        for (int j = begin; j < end; j++) {
            if (arr[j] <= p) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
       
        //one final swap so the pivot is in the right place
        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;

        //return the pivot's final sorted position
        return i+1;
    }
}        
