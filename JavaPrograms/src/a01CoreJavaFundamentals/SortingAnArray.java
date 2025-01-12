package a01CoreJavaFundamentals;

import java.util.Arrays;

public class SortingAnArray {

	public static void main(String[] args) {
		int[] arr = {64, 25, 12, 22, 11};
//        bubbleSort(arr);
//        System.out.println("Sorted array (Bubble Sort): " + Arrays.toString(arr));
//        selectionSort(arr);
//        System.out.println("Sorted array (Selection Sort): " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("Sorted array (Insertion Sort): " + Arrays.toString(arr));
	}
	
	public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];//25//12
            int j = i - 1;//0//1

            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
	
	public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
	
	public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped, the array is already sorted
            if (!swapped) break;
        }
    }
}
