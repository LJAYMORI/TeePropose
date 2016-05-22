package com.tee.teepropose;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by tee on 16. 5. 22..
 */
@EActivity(R.layout.activity_letter)
public class LetterActivity extends AppCompatActivity {

    private static final int MAXIMU_SCROLL_DISTANCE = 20;
    @ViewById(R.id.recyclerview)
    RecyclerView recyclerView;
    private int scroll = 0;
    private LinearLayoutManager layoutManager;
    private LetterListAdapter adapter;

    @AfterViews
    void initViews() {

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new LetterListAdapter();
        recyclerView.setAdapter(adapter);

        adapter.addItems(new LetterListData(""));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData("하하하하하하"));
        adapter.addItems(new LetterListData(""));

        Runnable r = new Runnable() {
            @Override
            public void run() {
                recyclerView.smoothScrollBy(0, scroll > MAXIMU_SCROLL_DISTANCE ? MAXIMU_SCROLL_DISTANCE : scroll++);
                recyclerView.postDelayed(this, 100);
            }
        };

        recyclerView.post(r);


    }

}
