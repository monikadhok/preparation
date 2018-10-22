package oata.basics;

public class Sorting{

    public static void print(int arr[]){
        for(int i = 0 ; i < arr.length; i++){
            System.out.println(arr[i]);        
        }
    }
    
    
    public static void insertionSort(int arr[]){
        int i, j;
        
        for(i = 1 ; i < arr.length; i++){
            j = i - 1;
            int val = arr[i];
            while(j >= 0){
                if(arr[j] > val){
                    arr[j+1] = arr[j];
                    j--;
                } else {
                    arr[j+1] = val;
                    break;
                }
            }
           
        }
    }
    
    public static void bubbleSort(int arr[]){
        int i, j;
        
        for(i = 0 ; i < arr.length; i++){
            for(j = 0; j < arr.length-1; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
    
    public static void selectionSort(int arr[]){
        int i, j;
        
        for(i = 0 ; i < arr.length; i++){
            int min = i;
            for(j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            
            if(i != min){
                int tmp = arr[min];
                arr[min] = arr[i];
                arr[i] = tmp;
            }
            
        }
    }
    
    
    public static void mergeSort(int arr[], int l, int r){
        if(l < r){
            int mid = (l + r)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            
            merge(arr, l, mid, r);
        }
    }
    
    public static void merge(int arr[], int l, int mid, int r){
        int i, j;
        int l1 = mid - l + 1;
        int l2 = r - mid;
        
        int arr1[] = new int[l1];
        int arr2[] = new int[l2];
        
        for(i = 0 ; i < l1; i++){
            arr1[i] = arr[l + i];
        }
        
        for(j = 0 ; j < l2; j++){
            arr2[j] = arr[mid + 1 + j];
        }
        
        i = 0 ; j = 0;
        int k = l;
        while(i < l1 && j < l2){
            if(arr1[i] <= arr2[j])
                arr[k++] = arr1[i++];
            else if(arr1[i] > arr2[j])
                arr[k++] = arr2[j++];
        }
        while(i < l1)
            arr[k++] = arr1[i++];
        
        while(j < l2)
            arr[k++] = arr2[j++];
    }
    
    
    public static void quickSort(int arr[], int l, int r){
        if(l < r){
            int pi = partition(arr, l, r);
            
            quickSort(arr, l, pi-1);
            quickSort(arr, pi+1, r);
        }
    }
    
    public static int partition(int arr[], int l, int r){
        int i = l, j = r;
        int pivot = arr[l];
        
        while(true){
            while(i < j && i < arr.length && j >= 0){
                if(arr[i] <= pivot)
                    i++;
                if(arr[j] > pivot)
                    j--;
            }
            if(i < j && arr[i] > pivot && arr[j] < pivot){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            } else 
            break;
        }
        
        //place pivot at appropriate position
        int tmp = arr[j];
        arr[j] = arr[l];
        arr[l] = tmp;
        return j;
    }
    
  
    
    public static void main(String []args){
        System.out.println("Hello World");
        
        int arr[] = {1, 10, 2, 3, 4, 89, 66};
        insertionSort(arr);
        System.out.println("After insertion sort:");
        print(arr);
          
        int arr1[] = {1, 10, 2, 3, 4, 89, 66};
        bubbleSort(arr1);
        System.out.println("After insertion sort:");
        print(arr1);
        
        int arr2[] = {1, 10, 2, 3, 4, 89, 66};
        bubbleSort(arr2);
        System.out.println("After selection sort:");
        print(arr2);
        
        int arr3[] = {1, 10, 2, 3, 4, 89, 66};
        mergeSort(arr3, 0, 6);
        System.out.println("After merge sort:");
        print(arr3);
        
        int arr4[] = {1, 10, 2, 3, 4, 89, 66};
        quickSort(arr4, 0, 6);
        System.out.println("After quick sort:");
        print(arr4);
     }
}