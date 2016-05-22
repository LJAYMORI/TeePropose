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

        /*

        내 사랑 소라에게

편지 정말 오랜만이지?
항상 결혼 승락 전 근사하게 프로포즈를 해야 한다고 생각했는데
갑작스럽게 진행된 결혼에 그러질 못해서 미안했어.
많이 늦었지만 그래도 어설프게나마 직접 만든 앱으로
나의 진심을 전하고 싶어.


10년 넘는 시간 동안 참 많은 일이 있었다 그치?
즐거운 기억, 행복한 기억, 웃긴 기억, 화나는 기억, 그리고 슬픈 기억도..
앞으로도 많은 추억과 기억을 쌓게 되겠지.
그것들이 항상 재미있고 행복할 수만은 없겠지만
우리가 함께 하는 모든 순간
의미 있는 날들이 되도록 노력할게요.


뻣뻣하고 다정하지만은 않은 오빠였고 많은 표현은 못했지만
항상 너의 기분은 곧 나의 기분이었고
니가 웃으면 나도 즐거웠고
니가 슬프면 나도 슬펐고
관심을 주지 않으면 외로웠던
넌 나의 삶의 일부였어.


이제 같은 곳을 보고 갈 너의 동반자로서
너를 생각하며
너에게 빠져서
너를 위한 다짐을 쓰던 어릴적의 나로 돌아가
존중하며
사랑하며
항상 너의 편이 되어 줄 것을
다짐 하고 또 다짐합니다.

행복하다.
이제 쭈욱 넌 나의 반쪽이니까
우리 앞으로 계속 함께 할 수 있으니까
영원히
사랑해

         */

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
