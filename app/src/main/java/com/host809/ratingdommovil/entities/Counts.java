package com.host809.ratingdommovil.entities;

import java.io.Serializable;
import java.util.List;

import twitter4j.Status;

/**
 * Created by deamon3 on 16/04/15.
 */
public class Counts implements Serializable {
    int rtCount;
    int tCount;
    int fCount;
    int mCount;
    int tScore;
    int sScore;
    int posCount;
    int negCount;
    int neuCount;
    List<Status> tweets;

    public Counts() {

    }

    public List<Status> getTweets() {
        return tweets;
    }

    public void setTweets(List<Status> tweets) {
        this.tweets = tweets;
    }

    public int getRtCount() {
        return rtCount;
    }

    public void setRtCount(int rtCount) {
        this.rtCount = rtCount;
    }

    public int gettCount() {
        return tCount;
    }

    public void settCount(int tCount) {
        this.tCount = tCount;
    }

    public int getfCount() {
        return fCount;
    }

    public void setfCount(int fCount) {
        this.fCount = fCount;
    }

    public int getmCount() {
        return mCount;
    }

    public void setmCount(int mCount) {
        this.mCount = mCount;
    }

    public int gettScore() {
        return tScore;
    }

    public void settScore(int tScore) {
        this.tScore = tScore;
    }

    public int getsScore() {
        return sScore;
    }

    public void setsScore(int sScore) {
        this.sScore = sScore;
    }

    public int getPosCount() {
        return posCount;
    }

    public void setPosCount(int posCount) {
        this.posCount = posCount;
    }

    public int getNegCount() {
        return negCount;
    }

    public void setNegCount(int negCount) {
        this.negCount = negCount;
    }

    public int getNeuCount() {
        return neuCount;
    }

    public void setNeuCount(int neuCount) {
        this.neuCount = neuCount;
    }

    public Counts(int rtCount, int tCount, int fCount, int mCount, int tScore, int sScore, int posCount, int negCount, int neuCount) {
        this.rtCount = rtCount;
        this.tCount = tCount;
        this.fCount = fCount;
        this.mCount = mCount;
        this.tScore = tScore;
        this.sScore = sScore;
        this.posCount = posCount;
        this.negCount = negCount;
        this.neuCount = neuCount;
    }
}
