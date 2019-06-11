package hms;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Suson
 */
public class IntegerSort {
// instance varibale

    private int[] myArray;
    private int[] tempArray;
    private int length;

    /**
     * The constructor which initializes the instance variable and create new
     * object
     *
     * @param arrayToSort array that is to be sorted
     */
    public IntegerSort(int[] arrayToSort) {
        this.myArray = arrayToSort;
        this.length = arrayToSort.length;
        this.tempArray = new int[length];
        mergeSort(0, length - 1);
    }

    /**
     * This method calls recursively to separate the array into smaller chunks
     *
     * @param firstIndex the first index of the array
     * @param lastIndex the last index of the array
     */
    private void mergeSort(int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            int midIndex = firstIndex + (lastIndex - firstIndex) / 2;
            mergeSort(firstIndex, midIndex);
            mergeSort(midIndex + 1, lastIndex);
            merger(firstIndex, midIndex, lastIndex);
        }

    }

    /**
     * This method performs the merge sorting
     *
     * @param low the lower index
     * @param mid the middle index
     * @param high the upper index
     */
    private void merger(int low, int mid, int high) {
        // (L+(r-l)/2) mid value
        tempArray = myArray.clone();

        int firstIdx = low;
        int midIdx = mid + 1;
        int lastIdx = low;
        //comparing
        while (firstIdx <= mid && midIdx <= high) {
            if (tempArray[firstIdx] <= tempArray[midIdx]) {
                myArray[lastIdx] = tempArray[firstIdx];
                firstIdx++;
            } else {
                myArray[lastIdx] = tempArray[midIdx];
                midIdx++;
            }
            lastIdx++;
        }
        while (firstIdx <= mid) {
            myArray[lastIdx] = tempArray[firstIdx];
            firstIdx++;
            lastIdx++;
        }

    }

    /**
     * This method return the sorted array
     *
     * @return Sorted Array
     */
    public int[] getSortedArray() {
        return myArray;
    }

}
