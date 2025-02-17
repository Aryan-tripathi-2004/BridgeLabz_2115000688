import java.util.Arrays;
import java.util.Random;

public class CompareSortingAlgo {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000}; 
        
        for (int size : sizes) {
            int[] arr = generateRandomArray(size);
            
            System.out.println("Dataset Size: " + size);

            int[] bubbleArr = Arrays.copyOf(arr, arr.length);
            long start = System.currentTimeMillis();
            bubbleSort(bubbleArr);
            long end = System.currentTimeMillis();
            System.out.println("Bubble Sort Time: " + (end - start) + "ms");

            int[] mergeArr = Arrays.copyOf(arr, arr.length);
            start = System.currentTimeMillis();
            mergeSort(mergeArr, 0, mergeArr.length - 1);
            end = System.currentTimeMillis();
            System.out.println("Merge Sort Time: " + (end - start) + "ms");

            int[] quickArr = Arrays.copyOf(arr, arr.length);
            start = System.currentTimeMillis();
            quickSort(quickArr, 0, quickArr.length - 1);
            end = System.currentTimeMillis();
            System.out.println("Quick Sort Time: " + (end - start) + "ms");

            System.out.println();
        }
    }

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10000); 
        }
        return arr;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            arr[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];
        }
        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
