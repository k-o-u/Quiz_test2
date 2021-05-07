package com.websarva.wings.android.quiz_test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Answer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        //インテントオブジェクト取得
        Intent intent = getIntent();

        //questionリストから渡された問題番号,科目名を取得
        int answerNum = intent.getIntExtra("answerNum", 0);
    }


}