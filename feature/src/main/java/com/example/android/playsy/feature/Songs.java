package com.example.android.playsy.feature;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Songs implements Parcelable {

    //create a Parcelable Creator that allows to display a single item from position
    public static final Parcelable.Creator<Songs> CREATOR = new Parcelable.Creator<Songs>() {
        @Override
        public Songs createFromParcel(Parcel parcel) {
            return new Songs(parcel);
        }

        @Override
        public Songs[] newArray(int size) {
            return new Songs[size];
        }
    };
    private String mSongName;
    private String mPerformer;

    //read data from parcel
    public Songs(Parcel source) {
        mSongName = source.readString();
        mPerformer = source.readString();
    }

    //string textViews
    public Songs(String songName, String performer) {
        this.mSongName = songName;
        this.mPerformer = performer;
    }

    //get the txtViews and return them to be used
    public String getSongName() {
        return mSongName;
    }

    public String getPerformer() {
        return mPerformer;
    }

    //write to the parcel
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSongName);
        dest.writeString(mPerformer);
    }

    // Parcelable implementation performed by Android Parcelable Code Generator plugin
    @Override
    public int describeContents() {
        return hashCode();
    }
}



