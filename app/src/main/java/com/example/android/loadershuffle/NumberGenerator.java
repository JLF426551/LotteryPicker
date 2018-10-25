package com.example.android.loadershuffle;

import android.util.Log;

import java.util.Arrays;
import java.util.Random;

public class NumberGenerator {

    public static Results getSelections(int[] count, int[] limit, boolean isDuplicateAllowed) {
        Results r = null;
        Random randomizer = new Random();

        int[] primary;
        int[] secondary;

        if (count.length > 0) {
            primary = new int[count[0]];

            for (int i = 0; i < primary.length; i++) {
                primary[i] = randomizer.nextInt(limit[0] - 1) + 1;
            }

            Arrays.sort(primary);

            //Run duplicate check and removal algorithm
            int duplicateCheck = 0;
            while (duplicateCheck != -1) {
                duplicateCheck = hasDuplicates(isDuplicateAllowed, primary);
                if (duplicateCheck != -1) {
                    primary[duplicateCheck]++; //add one to current value.
                    Arrays.sort(primary);
                }
            }
        }
        //The array length is zero.
        else {
            primary = null;
            secondary = null;
        }

        //Check for results where there are no 'bonus' or secondary selections.
        if (count.length > 1) {
            secondary = new int[count[1]];
            for (int i = 0; i < secondary.length; i++) {
                secondary[i] = randomizer.nextInt(limit[0] - 1) + 1;
            }

            Arrays.sort(secondary);
            int duplicateCheck = 0;
            while (duplicateCheck != -1) {
                duplicateCheck = hasDuplicates(isDuplicateAllowed, secondary);
                if (duplicateCheck != -1)
                    secondary[duplicateCheck]++; //add one to current value.
            }
        } else {
            //No bonus selection. Setting as null.
            secondary = null;
        }

        r = new Results(primary, secondary);
        return r;
    }

    private static int hasDuplicates(boolean duplicateAllowed, int[] sortedArray) {
        int duplicateLocation = -1;
        if (duplicateAllowed)
            return -1;

            //Runs check to ensure there are no duplicate in the random selection.
            //Assumes the array is sorted.
        else {
            boolean duplicate = false;
            if (sortedArray.length > 1) {
                int i = 0;

                while (!duplicate && i < sortedArray.length - 1) {
                    if (sortedArray[i] == sortedArray[i + 1]) {
                        Log.v("NG.hD", "System duplicate found at " + i);
                        duplicate = true;
                        duplicateLocation = i + 1;

                        return duplicateLocation;
                    } else i++;
                }

                return -1;
            } else return -1;

        }
    }
}
