import java.util.Scanner;

class Array {
    static int [] arr;

    public static void main(String [] args) {
        arr = new int [10];
        System.out.print("Started with this array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        insert(arr, 1, 5);
        insert(arr, 1, 4);
        System.out.print("Added some things at O(1) time complexity: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        delete(arr, 5);
        System.out.print("Deleted some thing at O(1) time complexity: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("Found value 1 at O(n) time complexity at index: " + find(arr, 1));
    }

    public static void insert(int [] arr, int val, int index) {
        arr[index] = val;
    }

    public static void delete(int [] arr, int index) {
        arr[index] = 0;
    }

    public static int find(int [] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
