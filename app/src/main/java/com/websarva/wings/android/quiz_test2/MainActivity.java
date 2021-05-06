package com.websarva.wings.android.quiz_test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = findViewById(R.id.subject);
        ListView lvQuestion = findViewById(R.id.lvQuestion);
        List<String> questionList = new ArrayList<>();

        text.setText("数学");
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //メニューインフレーター取得
        MenuInflater inflater = getMenuInflater();
        //オプションメニュー用xmlファイルをインフレート
        inflater.inflate(R.menu.menu_options_menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean returnVal = true;
        int itemId = item.getItemId();
        TextView text = findViewById(R.id.subject);

        switch (itemId) {
            case R.id.menuListOptionMath:
                text.setText("数学");
                break;
            case R.id.menuListOptionEnglish:
                text.setText("英語");
                break;
            default:
                returnVal = super.onOptionsItemSelected(item);
                break;
        }

        return returnVal;
    }
}