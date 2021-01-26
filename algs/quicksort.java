import java.util.Scanner;

class QuickSort {

    public static void main(String[] args) {
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

    public static void quicksort(int [] arr, int begin, int end) {
        if (begin < end) {
            int p = partition(arr, begin, end);
            quicksort(arr, begin, p-1);
            quicksort(arr, p+1, end);
        }
    }

    public static int partition(int [] arr, int begin, int end) {
        int p = arr[end];
        int i = begin-1;

        for (int j = begin; j < end; j++) {
            if (arr[j] <= p) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
       
        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;

        return i+1;
    }
}        
