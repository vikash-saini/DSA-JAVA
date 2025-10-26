package ArrayProblems;

public class rotateByOnePlace {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        System.out.println("Array before rotation: ");
        printArray(arr);
        leftRotateByOne(arr);
        System.out.println("Array after rotation by one place: ");
        printArray(arr);
    }

    static void leftRotateByOne(int[] arr){
        int n = arr.length;
        int firstElement = arr[0];
        for(int i=0; i<n-1; i++){
            arr[i] = arr[i+1];
        }
        arr[n-1] = firstElement;
    }

    static void printArray(int[] arr){
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }

    static void rightRotateByOne(int[] arr){
        int n = arr.length;
        int lastElement = arr[n-1];
        for(int i=n-1; i>0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = lastElement;
    }
}
