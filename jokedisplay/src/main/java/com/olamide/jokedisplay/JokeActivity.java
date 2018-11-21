package com.olamide.jokedisplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {


    public static final String JOKE_CONTENT_KEY = "jokeContent";
    //public static final String JOKE_AUTHOR_KEY = "jokeAuthor";

    TextView tvContent;


    TextView tvAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);


        Intent intent = getIntent();
        if(intent!=null){
            //String jokeAuthor = intent.getStringExtra(JokeActivity.JOKE_AUTHOR_KEY);
            String jokeContent = intent.getStringExtra(JokeActivity.JOKE_CONTENT_KEY);

//            tvAuthor = (TextView) findViewById(R.id.tv_author);
//            if (jokeAuthor != null && jokeAuthor.length() != 0) {
//                tvAuthor.setText(jokeAuthor);
//            }

            tvContent = (TextView) findViewById(R.id.tv_content);
            if (jokeContent != null && jokeContent.length() != 0) {
                tvContent.setText(jokeContent);
            }
        }

    }
}
