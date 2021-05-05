package com.websarva.wings.android.quiz_test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvQuestion = findViewById(R.id.lvQuestion);
        List<String> questionList = new ArrayList<>();
        questionList.add("Q1");
        questionList.add("Q2");
        questionList.add("Q3");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, questionList);
        lvQuestion.setAdapter(adapter);

//        リストタップのリスナクラスの登録
        lvQuestion.setOnItemClickListener(new ListItemClickListener());
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(MainActivity.this, Question.class);
            intent.putExtra("questionNum", position);
            startActivity(intent);
        }
    }
}