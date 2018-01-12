public class QuickSort {
    public static void quicksort(int[] array){
        //works through recursion
        quicksort(array, 0,array.length-1);
    }
    public static void quicksort(int[] array, int left, int right){
        if (left>=right){
            return;
        }
        int pivot=((left+right)/2);
        int index = partition(array, left,right, pivot);
        quicksort(array,left,index-1);
        quicksort(array,index,right);
    }

    public static int partition(int[] array, int left, int right, int pivot){
        //had to use <= or the pivot would get stuck at 1
        while(left<=pivot){
            while(array[left]<array[pivot]) {
                left++;
            }
            while(array[right]>array[pivot]) {
                right--;
            }
            if(array[left]>=array[right]){
                swap(array,left,right);
                left++;
                right--;
            }

        }
        return left;
    }
    //Method to swap variables when a number greater than the pivot is on the left of the pivot and less than on the right.
    public static void swap(int [] array,int left,int right){
        int greater=array[left];
        int less=array[right];
        array[left]=less;
        array[right]=greater;
    }
    public static void main (String [] args){

        System.out.println("Unsorted:");
        int [] arrayTest={2,4,6,7,1,9};
        for(int i=0;i<arrayTest.length;i++)
            System.out.print(arrayTest[i]+",");
        System.out.println();
        System.out.println("Sorted:");
        quicksort(arrayTest);
        for(int i=0;i<arrayTest.length;i++)
            System.out.print(arrayTest[i]+",");
    }

}