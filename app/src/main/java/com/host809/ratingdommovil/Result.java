package com.host809.ratingdommovil;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.host809.ratingdommovil.entities.Counts;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


public class Result extends ActionBarActivity {
    Counts count;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        String[] values = new String[] { "Cantidad de Tweets: "+count.gettCount(),
                "Retweets: "+count.getRtCount(),
                "Seguidores: "+count.getfCount(),
                "Mentions: "+count.getmCount(),
                "Rating Aproximado: "+count.gettScore(),
                "Tweets Positivos: "+count.getPosCount(),
                "Tweets Negativos: "+count.getNegCount(),
                "Tweets Neutrales: "+count.getNeuCount()
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
        graph.setTitle("Neutrales:"+count.getNeuCount()+", Positivos:"+count.getPosCount()+", Negativos:"+count.getNegCount());
    Button atras = (Button)findViewById(R.id.btn_result_atras);
    atras.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
