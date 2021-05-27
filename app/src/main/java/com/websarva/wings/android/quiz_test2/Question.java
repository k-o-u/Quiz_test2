package com.websarva.wings.android.quiz_test2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Question extends AppCompatActivity {

    private int questionNum;
    private String subject = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        ListView lvAnswer = findViewById(R.id.lvAnswer);

        //インテントオブジェクト取得
        Intent intent = getIntent();

        //questionリストから渡された問題番号,科目名を取得
        questionNum = intent.getIntExtra("questionNum", 0);
        subject = intent.getStringExtra("subject");

        switch (subject) {
            case "数学":
                displayMathQuestion(questionNum);
                break;
            case "英語":
                displayEnglishQuestion(questionNum);
                break;
        }

        //アクションバー取得
        ActionBar actionBar = getSupportActionBar();
        //「戻る」を有効化
        actionBar.setDisplayHomeAsUpEnabled(true);

        //リストタップのリスナクラスの登録
        lvAnswer.setOnItemClickListener(new Question.ListItemClickListener());
    }

    private void displayMathQuestion(int num) {
        TextView tvQuestion = findViewById(R.id.tvQuestion);
        ListView lvAnswer = findViewById(R.id.lvAnswer);
        List<String> answerList = new ArrayList<>();

        switch(num) {
            case 0:
                tvQuestion.setText("Q1：1+1 = ?");
                answerList.add("0");
                answerList.add("1");
                answerList.add("2");
                answerList.add("3");
                answerList.add("4");
                answerList.add("etc");
                break;

            case 1:
                tvQuestion.setText("Q2：9 × 8 = ?");
                answerList.add("63");
                answerList.add("70");
                answerList.add("72");
                answerList.add("79");
                answerList.add("81");
                answerList.add("etc");
                break;

            case 2:
                tvQuestion.setText("Q3：900 × 213 × 665 × 0 = ?");
                answerList.add("123456");
                answerList.add("984245");
                answerList.add("94658");
                answerList.add("457209");
                answerList.add("0");
                answerList.add("etc");
                break;

            default:
                tvQuestion.setText("Error");
                break;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(Question.this, android.R.layout.simple_list_item_1, answerList);
        lvAnswer.setAdapter(adapter);
    }

    private void displayEnglishQuestion(int num) {
        TextView tvQuestion = findViewById(R.id.tvQuestion);
        ListView lvAnswer = findViewById(R.id.lvAnswer);
        List<String> answerList = new ArrayList<>();

        switch(num) {
            case 0:
                tvQuestion.setText("Q1:私の名前は太郎です。");
                answerList.add("My name is Taro.");
                answerList.add("Your name is Taro.");
                answerList.add("This is Taro.");
                answerList.add("My name are Taro.");
                answerList.add("He is Taro.");
                answerList.add("etc");
                break;

            case 1:
                tvQuestion.setText("Q2：これはペンですか？");
                answerList.add("Am I a pen?");
                answerList.add("This is a pen.");
                answerList.add("You are a pen.");
                answerList.add("Is this a pen?");
                answerList.add("Is he a pen?");
                answerList.add("etc");
                break;

            case 2:
                tvQuestion.setText("Q3：テーブルの上にりんごが２個あります。");
                answerList.add("They are two apples.");
                answerList.add("There is an apple on the table.");
                answerList.add("There are two oranges on the table.");
                answerList.add("There are two apples in the table.");
                answerList.add("There are two apples on the table.");
                answerList.add("etc");
                break;

            default:
                tvQuestion.setText("Error");
                break;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(Question.this, android.R.layout.simple_list_item_1, answerList);
        lvAnswer.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean returnVal = true;
        int itemId = item.getItemId();

        if (itemId == android.R.id.home) {
            finish();
        }
        else {
            returnVal = super.onOptionsItemSelected(item);
        }

        return returnVal;
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(Question.this, Answer.class);
            intent.putExtra("questionNum", questionNum);
            intent.putExtra("answerNum", position);
            intent.putExtra("subject", subject);
            startActivity(intent);
            finish();
        }
    }
}