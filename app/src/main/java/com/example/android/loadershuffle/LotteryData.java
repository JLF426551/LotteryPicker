package com.example.android.loadershuffle;

public class LotteryData {

    final static String[] names = {"Power Ball","Mega Millions","Texas Lotto","Texas Two Step","Triple Chance","All Or Nothing","Pick Three","Daily Four","Cash Five",""};

    //PowerBall   5.69 1.26
    private final static int[] POWERBALL_PRIMARY = new int[]{5,1};
    private final static int[] POWERBALL_LIMIT = new int[]{69,26};
    private final static boolean POWERBALL_REPEAT = false;
    public final static int POWERBALL_INDEX = 0;

    //MegaMillions    5.75 1.15
    private final static int[] MEGA_PRIMARY = new int[]{5,1};
    private final static int[] MEGA_LIMIT = new int[]{75,15};
    private final static boolean MEGA_REPEAT = false;
    public final static int MEGA_INDEX = 1;

    // LottoTexas  6.54
    private final static int[] LOTTO_PRIMARY = new int[]{6};
    private final static int[] LOTTO_LIMIT = new int[]{54};
    private final static boolean LOTTO_REPEAT = false;
    public final static int LOTTO_INDEX = 2;

    //TX Two-Step 4.35 1.35
    private final static int[] TWO_PRIMARY = new int[]{4,1};
    private final static int[] TWO_LIMIT = new int[]{35,35};
    private final static boolean TWO_REPEAT = false;
    public final static int TWO_INDEX = 3;

    //All Or Nothing  12.24
    private final static int[] ALL_OR_NOTHING_PRIMARY = new int[]{12};
    private final static int[] ALL_OR_NOTHING_LIMIT = new int[]{24};
    private final static boolean ALL_OR_NOTHING_REPEAT = false;
    public final static int ALL_OR_NOTHING_INDEX = 5;

    //Pick 3      3.10 (0-9)
    private final static int[] THREE_PRIMARY = new int[]{3};
    private final static int[] THREE_LIMIT = new int[]{10};
    private final static boolean THREE_REPEAT = false;
    public final static int THREE_INDEX = 6;

    //Daily 4     4.10 (Repeatable)
    private final static int[] FOUR_PRIMARY = new int[]{4};
    private final static int[] FOUR_LIMIT = new int[]{10};
    private final static boolean FOUR_REPEAT = true;
    public final static int FOUR_INDEX = 7;

    //CashFive    5.37
    private final static int[] CASH_FIVE_PRIMARY = new int[]{5};
    private final static int[] CASH_FIVE_LIMIT = new int[]{37};
    private final static boolean CASH_FIVE_REPEAT = false;
    public final static int CASH_FIVE_INDEX = 8;

    public static int[] getSelections(int i) {

        int[] returnVals;
        switch(i)
        {
            case POWERBALL_INDEX: returnVals = POWERBALL_PRIMARY;
                break;
            case MEGA_INDEX: returnVals = MEGA_PRIMARY;
                break;
            case LOTTO_INDEX: returnVals = LOTTO_PRIMARY;
                break;
            case TWO_INDEX: returnVals = TWO_PRIMARY;
                break;
            case ALL_OR_NOTHING_INDEX: returnVals = ALL_OR_NOTHING_PRIMARY;
                break;
            case THREE_INDEX: returnVals = THREE_PRIMARY;
                break;
            case FOUR_INDEX: returnVals = FOUR_PRIMARY;
                break;
            case CASH_FIVE_INDEX: returnVals = CASH_FIVE_PRIMARY;
                break;
            default: returnVals = null;
        }

        return returnVals;
    }

    public static int[] getLimits(int k) {

        int[] returnVals;

        switch(k)
        {
            case POWERBALL_INDEX: returnVals = POWERBALL_LIMIT;
                break;
            case MEGA_INDEX: returnVals = MEGA_LIMIT;
                break;
            case LOTTO_INDEX: returnVals = LOTTO_LIMIT;
                break;
            case TWO_INDEX: returnVals = TWO_LIMIT;
                break;
            case ALL_OR_NOTHING_INDEX: returnVals = ALL_OR_NOTHING_LIMIT;
                break;
            case THREE_INDEX: returnVals = THREE_LIMIT;
                break;
            case FOUR_INDEX: returnVals = FOUR_LIMIT;
                break;
            case CASH_FIVE_INDEX: returnVals = CASH_FIVE_LIMIT;
                break;
            default: returnVals = null;
        }

        return returnVals;
    }

    public static boolean getRepeat(int i)
    {
            boolean returnVals;
            switch(i)
            {
                case POWERBALL_INDEX: returnVals = POWERBALL_REPEAT;
                    break;
                case MEGA_INDEX: returnVals = MEGA_REPEAT;
                    break;
                case LOTTO_INDEX: returnVals = LOTTO_REPEAT;
                    break;
                case TWO_INDEX: returnVals = TWO_REPEAT;
                    break;
                case ALL_OR_NOTHING_INDEX: returnVals = ALL_OR_NOTHING_REPEAT;
                    break;
                case THREE_INDEX: returnVals = THREE_REPEAT;
                    break;
                case FOUR_INDEX: returnVals = FOUR_REPEAT;
                    break;
                case CASH_FIVE_INDEX: returnVals = CASH_FIVE_REPEAT;
                    break;
                default: returnVals = false;
            }

            return returnVals;
    }
}
