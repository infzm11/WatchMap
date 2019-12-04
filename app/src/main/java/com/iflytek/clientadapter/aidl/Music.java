package com.iflytek.clientadapter.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class Music implements Parcelable {
    public static final Parcelable.Creator<Music> CREATOR = new Parcelable.Creator<Music>() {
        public Music createFromParcel(Parcel parcel) {
            return new Music(parcel);
        }

        public Music[] newArray(int i) {
            return new Music[i];
        }
    };
    public String album;
    public String category;
    public String singer;
    public String song;

    public int describeContents() {
        return 0;
    }

    public Music() {
    }

    public Music(Parcel parcel) {
        this.song = parcel.readString();
        this.singer = parcel.readString();
        this.album = parcel.readString();
        this.category = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.song);
        parcel.writeString(this.singer);
        parcel.writeString(this.album);
        parcel.writeString(this.category);
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public String getSong() {
        return this.song;
    }

    public void setSong(String str) {
        this.song = str;
    }

    public String getSinger() {
        return this.singer;
    }

    public void setSinger(String str) {
        this.singer = str;
    }

    public String getAlbum() {
        return this.album;
    }

    public void setAlbum(String str) {
        this.album = str;
    }

    public String toString() {
        return "song: " + this.song + " singer: " + this.singer + " album: " + this.album + " category: " + this.category;
    }
}
