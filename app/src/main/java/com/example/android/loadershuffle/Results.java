package com.example.android.loadershuffle;

public class Results {

    private int[] primary;
    private int[] bonus;

    public final static int PRIMARY = 0;
    public final static int BONUS = 1;


    public Results(int[] pVals, int[] bVals) {
        primary = pVals;
        bonus = bVals;
    }

    public String getPrimaryNumbers() {
        String returnVal = "";
        if (primary != null) {

            for (int p = 0; p < primary.length - 1; p++) {
                returnVal = returnVal + primary[p] + ", ";
            }

            returnVal = returnVal + primary[primary.length - 1];
        }

        return returnVal;
    }

    public String getBonusNumbers() {
        String returnVal = "";
        if (bonus != null) {
            returnVal = returnVal + "Bonus: ";

            for (int p = 0; p < bonus.length - 1; p++) {
                returnVal = returnVal + bonus[p] + ", ";
            }

            returnVal = returnVal + bonus[bonus.length - 1];
        }

        return returnVal;
    }
}
