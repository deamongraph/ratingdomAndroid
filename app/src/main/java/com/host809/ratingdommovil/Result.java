package com.host809.ratingdommovil;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.host809.ratingdommovil.entities.Counts;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


public class Result extends Activity {
    Counts count;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        count = (Counts) getIntent().getSerializableExtra("Counts");
        listView = (ListView) findViewById(R.id.list);
        TextView happiness = (TextView)findViewById(R.id.txt_result_happiness);
        if(count.getNeuCount()>=count.getPosCount() && count.getNeuCount()>=count.getNegCount()){
            happiness.setText("Neutral");
            happiness.setBackgroundColor(Color.GRAY);
        }else if(count.getPosCount()>=count.getNegCount()&& count.getPosCount()>=count.getNeuCount()){
            happiness.setText("Yes");
            happiness.setBackgroundColor(Color.GREEN);
        }else if(count.getNegCount()>=count.getPosCount()&&count.getNegCount()>=count.getNeuCount()){
            happiness.setText("No");
            happiness.setBackgroundColor(Color.RED);
        }

        String[] values = new String[] { "Tweets: "+count.gettCount(),
                "Retweets: "+count.getRtCount(),
                "Followers: "+count.getfCount(),
                "Mentions: "+count.getmCount(),
                "Score: "+count.gettScore(),
                "Positives Tweets: "+count.getPosCount(),
                "Negatives Tweets: "+count.getNegCount(),
                "Neutrals Tweets: "+count.getNeuCount()
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);
        GraphView graph = (GraphView) findViewById(R.id.graph1);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, count.getNeuCount()),
                new DataPoint(1, count.getPosCount()),
                new DataPoint(2, count.getNegCount()),
        });
        graph.addSeries(series);
        graph.setTitle("Neutrals:"+count.getNeuCount()+", Positives:"+count.getPosCount()+", Negatives:"+count.getNegCount());
    Button atras = (Button)findViewById(R.id.btn_result_atras);
    atras.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });
    }




}
