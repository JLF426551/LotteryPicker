package com.example.android.loadershuffle;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int mLotterySelection;
    ArrayList<Results> data;
    ResultsAdapter adapter;
    ListView listView;
    SwipeRefreshLayout mRefreshLayout;

    SwipeRefreshLayout.OnRefreshListener mListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            updateAdapterData();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        mRefreshLayout = findViewById(R.id.swiperefresh);
        mRefreshLayout.setOnRefreshListener(mListener);

        data = new ArrayList<>();
        mLotterySelection = 0;
        ResultsAdapter adapter = new ResultsAdapter(this, data);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_aon:
                mLotterySelection = LotteryData.ALL_OR_NOTHING_INDEX;
                break;
            case R.id.option_cf:
                mLotterySelection = LotteryData.CASH_FIVE_INDEX;
                break;
            case R.id.option_df:
                mLotterySelection = LotteryData.FOUR_INDEX;
                break;
            case R.id.option_lt:
                mLotterySelection = LotteryData.LOTTO_INDEX;
                break;
            case R.id.option_mm:
                mLotterySelection = LotteryData.MEGA_INDEX;
                break;
            case R.id.option_pb:
                mLotterySelection = LotteryData.POWERBALL_INDEX;
                break;
            case R.id.option_pt:
                mLotterySelection = LotteryData.THREE_INDEX;
                break;
            case R.id.option_tt:
                mLotterySelection = LotteryData.TWO_INDEX;
                break;
        }

        updateAdapterData();
        return super.onOptionsItemSelected(item);
    }

    private void updateAdapterData() {
        data = new ArrayList<>();
        Results tempResult;

        for (int i = 0; i < 5; i++) {
            tempResult = NumberGenerator.getSelections(LotteryData.getSelections(mLotterySelection),
                    LotteryData.getLimits(mLotterySelection), LotteryData.getRepeat(mLotterySelection));
            data.add(tempResult);
        }

        adapter = new ResultsAdapter(this, data);
        listView.setAdapter(adapter);
        updateTitle();
        mRefreshLayout.setRefreshing(false);

    }

    private void updateTitle() {
        String mtitle = "";

        switch (mLotterySelection) {
            case LotteryData.ALL_OR_NOTHING_INDEX:
                mtitle = getString(R.string.game_aon);
                break;
            case LotteryData.CASH_FIVE_INDEX:
                mtitle = getString(R.string.game_cf);
                break;
            case LotteryData.FOUR_INDEX:
                mtitle = getString(R.string.game_df);
                break;
            case LotteryData.LOTTO_INDEX:
                mtitle = getString(R.string.game_lt);
                break;
            case LotteryData.MEGA_INDEX:
                mtitle = getString(R.string.game_mm);
                break;
            case LotteryData.POWERBALL_INDEX:
                mtitle = getString(R.string.game_pb);
                break;
            case LotteryData.THREE_INDEX:
                mtitle = getString(R.string.game_pt);
                break;
            case LotteryData.TWO_INDEX:
                mtitle = getString(R.string.game_tt);
        }

        setTitle(mtitle);
    }
}