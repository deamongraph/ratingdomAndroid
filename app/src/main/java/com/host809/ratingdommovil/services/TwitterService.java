package com.host809.ratingdommovil.services;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.host809.ratingdommovil.MainActivity;
import com.host809.ratingdommovil.Ratingdom;
import com.host809.ratingdommovil.Result;
import com.host809.ratingdommovil.entities.Counts;

import java.util.List;

import twitter4j.TwitterException;

/**
 * Created by deamon3 on 16/04/15.
 */
public class TwitterService extends AsyncTask<String, Void, Counts> {

    String screen_name;
    Context ctx;
    ProgressDialog progressDialog;

    public TwitterService(String screen_name, Context ctx, ProgressDialog progressDialog) {
        this.screen_name = screen_name;
        this.ctx = ctx;
        this.progressDialog = progressDialog;
    }

    @Override
    protected Counts doInBackground(String... params) {
        Counts response = new Counts();
        Ratingdom.posWords= MainActivity.positivas;
        Ratingdom.negWords= MainActivity.negativas;
        try {
            response.settCount(Ratingdom.tweetcount(screen_name));
            response.setRtCount(Ratingdom.retweetcount(screen_name));
            response.setfCount(Ratingdom.followercount(screen_name));
            response.setmCount(Ratingdom.mentionscount(screen_name));
            response.settScore(Ratingdom.totalscore(screen_name));
            //sentiment
            response.setsScore(Ratingdom.sentimentscore(screen_name));
            response.setPosCount(Ratingdom.positiveCount(screen_name));
            response.setNegCount(Ratingdom.negativeCount(screen_name));
            response.setNeuCount(Ratingdom.neutralCount(screen_name));


        } catch (TwitterException e) {
            e.printStackTrace();

        }

        return response;
    }

    @Override
    protected void onPostExecute(Counts counts) {
    progressDialog.cancel();
        Intent myIntent = new Intent(ctx,Result.class);
        myIntent.putExtra("Counts", counts);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ctx.startActivity(myIntent);


    }
}
