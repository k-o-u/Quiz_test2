package com.websarva.wings.android.quiz_test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Answer extends AppCompatActivity {

    private int questionNum;
    private int answerNum;
    private String subject = "";

    private final int[] MATH_ANSWER_LIST = {2, 2, 4};
    private final int[] ENGLISH_ANSWER_LIST = {0, 3, 4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        //インテントオブジェクト取得
        Intent intent = getIntent();

        //questionリストから渡された問題番号,科目名を取得
        questionNum = intent.getIntExtra("questionNum", -1);
        answerNum = intent.getIntExtra("answerNum", -1);
        subject = intent.getStringExtra("subject");

        TextView tv = findViewById(R.id.judge);
        tv.setText(subject);
    }

    private void judgeAnswer(int questionNum, int answerNum, String subject) {

    }
}