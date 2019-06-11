package hms;

import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Suson
 */
public class StringSort {
// instance variable

    private String[] myArray;
    private String[] sorted;

    /**
     * Constructor of string sort class
     *
     * @param stringArray
     */
    public StringSort(String[] stringArray) {
        this.myArray = stringArray;
        mergeSort(myArray);
    }

    /**
     * This method performs recursively divides the array into smaller chunks
     *
     * @param myArray to be sorted
     * @return array being sort
     */
    private String[] mergeSort(String[] myArray) {
        sorted = new String[myArray.length];
        if (myArray.length == 1) {
            sorted = myArray;
        } else {
            int mid = myArray.length / 2;
            String[] leftArray = null;
            String[] rightArray = null;
            if ((myArray.length % 2) == 0) {
                leftArray = new String[myArray.length / 2];
                rightArray = new String[myArray.length / 2];
            } else {
                leftArray = new String[myArray.length / 2];
                rightArray = new String[(myArray.length / 2) + 1];
            }
            int counterOne = 0;

            for (; counterOne < mid; counterOne++) {
                leftArray[counterOne] = myArray[counterOne];
            }
            for (int counterTwo = 0; counterOne < myArray.length; counterOne++) {
                rightArray[counterTwo++] = myArray[counterOne];
            }
            leftArray = mergeSort(leftArray);
            rightArray = mergeSort(rightArray);
            sorted = mergeArray(leftArray, rightArray);
        }

        return sorted;
    }

    /**
     * This method compares the and swaps the from the smaller chunks
     *
     * @param leftArray lower most index of the array
     * @param rightArray higher index of the array
     * @return the sorted array
     */
    private String[] mergeArray(String[] leftArray, String[] rightArray) {
        String[] mergedArray = new String[leftArray.length + rightArray.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int midIndex = 0;
        int comparator = 0;
        while (leftIndex < leftArray.length || rightIndex < rightArray.length) {
            if (leftIndex == leftArray.length) {
                mergedArray[midIndex++] = rightArray[rightIndex++];
            } else if (rightIndex == rightArray.length) {
                mergedArray[midIndex++] = leftArray[leftIndex++];
            } else {
                comparator = leftArray[leftIndex].compareTo(rightArray[rightIndex]);
                if (comparator > 0) {
                    mergedArray[midIndex++] = rightArray[rightIndex++];
                } else if (comparator < 0) {
                    mergedArray[midIndex++] = leftArray[leftIndex++];
                } else {
                    mergedArray[midIndex++] = leftArray[leftIndex++];
                }
            }
        }
        return mergedArray;
    }

    /**
     * This method returns the sorted array
     *
     * @return sorted array
     */
    public String[] getSortedArray() {
        return sorted;
    }
}
