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
public class StringSearch {
// instance variable

    private String[] myArray;
    private String searchedValue;
    private int foundIndex;

    /**
     * Construction of string search class
     *
     * @param stringArray array to be searched
     * @param searchedValue search value by which search is being carried out
     */
    public StringSearch(String[] stringArray, String searchedValue) {
        this.myArray = stringArray;
        this.searchedValue = searchedValue;
        this.foundIndex = binarySearch();
    }

    /**
     * This method performs the binary search
     *
     * @return the index if found
     */
    private int binarySearch() {
        int leftIndex = 0, rightIndex = myArray.length - 1;
        while (leftIndex <= rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;

            int result = searchedValue.compareTo(myArray[midIndex]);

            // Check if the searched value is present at middle index 
            if (result == 0) {
                return midIndex;
            }

            // If searched Value is greater, discard left half 
            if (result > 0) {
                leftIndex = midIndex + 1;
            } // If search value  is smaller, discarf right half 
            else {
                rightIndex = midIndex - 1;
            }
        }

        return -1;
    }

    /**
     * This method returns the index where searched value is found
     *
     * @return the index which value is found, if not sends -1
     */
    public int getFoundIndex() {
        return foundIndex;
    }

}
