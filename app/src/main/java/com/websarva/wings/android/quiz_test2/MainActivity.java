package com.websarva.wings.android.quiz_test2;

import androidx.appcompat.app.AppCompatActivity;

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

        ListView lvAnswer = findViewById(R.id.lvAnswer);
        List<String> answerList = new ArrayList<>();
        answerList.add("0");
        answerList.add("1");
        answerList.add("2");
        answerList.add("3");
        answerList.add("4");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, answerList);
        lvAnswer.setAdapter(adapter);
        lvAnswer.setOnItemClickListener(new ListItemClickListener());
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            AnswerConfirmDialogFragment dialogFragment = new AnswerConfirmDialogFragment();
            dialogFragment.show(getSupportFragmentManager(), "AnswerConfirmDialogFragment");
        }
    }
}