package com.example.android.playsy.feature;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Songs extends ArrayList<Parcelable> implements Parcelable {

    private String mSongName;
    private String mPerformer;

    public Songs(Parcel source) {
        mSongName = source.readString();
        mPerformer = source.readString();
    }

    public Songs (String songName,String performer){
        mSongName = songName;
        mPerformer = performer;
    }
    public String getSongName (){
        return mSongName;
    }
    public String getPerformer (){
        return mPerformer;
    }

    // Parcelable implementation performed by Android Parcelable Code Generator plugin
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSongName);
        dest.writeString(mPerformer);
    }


    public static final Parcelable.Creator<Songs> CREATOR = new Parcelable.Creator<Songs>() {
        @Override
        public Songs createFromParcel(Parcel in) {
            return new Songs(in);
        }

        @Override
        public Songs[] newArray(int size) {
            return new Songs[size];
        }
    };


}



