package com.host809.ratingdommovil;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.host809.ratingdommovil.services.PalabrasNegativas;
import com.host809.ratingdommovil.services.PalabrasPositivas;
import com.host809.ratingdommovil.services.TwitterService;

import org.json.JSONArray;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import twitter4j.TwitterException;


public class MainActivity extends Activity {

    public ListView mListView;
    public static Context ctx;
    ProgressDialog progressDialog;
    public static List<String> negativas = new ArrayList<>();
    public static List<String> positivas= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading Libraries...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        PalabrasPositivas pos = new PalabrasPositivas(ctx,progressDialog);

        pos.execute("http://pornuestropais.org/twitter/positive.json");


        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading Libraries...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        PalabrasNegativas neg = new PalabrasNegativas(ctx,progressDialog);
        neg.execute("http://pornuestropais.org/twitter/negative.json");

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        Button buscar = (Button)findViewById(R.id.btn_find);
        final TextView txt = (TextView) findViewById(R.id.txt_main_tweets);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Loading tweets from Twitter");
                progressDialog.setCancelable(false);
                progressDialog.show();
              EditText screenname = (EditText) findViewById(R.id.txt_screenname);
              String tweet = screenname.getText().toString();
              if(tweet.equals(null))
              Toast.makeText(getBaseContext(), "The user cannot be empty.", Toast.LENGTH_LONG).show();
              TwitterService ts = new TwitterService(tweet,getBaseContext(),progressDialog);
              ts.execute();
            }
        });




    }
    @Override
    public void onResume() {
        super.onResume();




    }






}
