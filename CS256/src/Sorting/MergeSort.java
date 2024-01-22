package Sorting;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    /**
     * Preforms merge sort on given array of values
     *
     * @param values the array of elements to sort
     * @param <T>    the type of elements in array
     */
    public static <T extends Comparable<T>> void mergeSort(T[] values) {
        // base case
        if (values.length == 1)
            return;

        // Gen case

        // 1. split into 2 pieces
        T[] left, right;
        //copy all correct values into left side, then right side
        left = Arrays.copyOfRange(values, 0, values.length / 2);
        right = Arrays.copyOfRange(values, values.length / 2, values.length);


        // 2. recursively sort the left and right
        mergeSort(left); // once this returns, the left array is sorted
        mergeSort(right);


        // 3. merge 2 sorted pieces
        merge(left, right, values); // can reuse the og array, bc we already copied everything from it

    }

    /**
     * Takes two sorted array and places all elements in these arrays in the correct order
     *
     * @param left  a sorted array
     * @param right a sorted array
     * @param dst   the destination array (capacity = sum of two sorted arrays)
     * @param <T>   the type of elements in array
     */
    private static <T extends Comparable<T>> void merge(T[] left, T[] right, T[] dst) {

        // 3 indexes to track
        int leftIndex = 0;
        int rightIndex = 0;
        int dstIndex = 0;

        // compare elements from left and right arrays as long as the length is not 0
        while (leftIndex < left.length && rightIndex < right.length) {

            // access two elements to compare
            T leftElement = left[leftIndex];
            T rightElement = right[rightIndex];

            // compare these elements and place the smaller one in dst[]
            if (leftElement.compareTo(rightElement) < 0) {
                dst[dstIndex] = leftElement; // leftElement < rightElement
                leftIndex++;
            } else {
                dst[dstIndex] = rightElement;
                rightIndex++;
            }
            //increment the dst index, so we don't override values in the dst array
            dstIndex++;
        }
        // while loop is no longer true (the values are remaining in the sorted array) only one

        // copy remaining elements form left array
        for (; leftIndex < left.length; leftIndex++) { // doesn't need initialization cause its already on left
            dst[dstIndex] = left[leftIndex];
            dstIndex++;
        }

        for (; rightIndex < right.length; rightIndex++) { // doesn't need initialization cause its already on right
            dst[dstIndex] = right[rightIndex];
            dstIndex++;
        }

    }

    // testing program

    public static void main(String[] args) {
        Integer[] numbers = new Integer[100];
        Random randomizer = new Random();

        // before sort
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " , ");
        }
            //preform sort
            mergeSort(numbers);
            // after sort
            for (int i = 0; i < numbers.length; i++) {
                System.out.print(numbers[i] + " , ");
            }
        }
    }

