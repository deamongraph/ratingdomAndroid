package com.host809.ratingdommovil;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.host809.ratingdommovil.entities.Counts;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Status;


public class Tweets extends ActionBarActivity {
    Counts count;
    ListView listView;
    List<Status> statuses = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweets);
        listView = (ListView) findViewById(R.id.listaTweets);
        count = (Counts) getIntent().getSerializableExtra("Counts");
        statuses = count.getTweets();
        int cont=1;
        List<String> valores = new ArrayList<>();
        for(Status status:statuses)
        {
        valores.add(cont+" : "+status.getText()+" \n\n Date: "+status.getCreatedAt().toGMTString()+"\n\n Sentiment: "+Ratingdom.sentiment(status.getText()));
        cont++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, valores);

        listView.setAdapter(adapter);
        Button back = (Button)findViewById(R.id.btn_tweets_atras);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
