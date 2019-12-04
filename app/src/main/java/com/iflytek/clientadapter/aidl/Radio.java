package com.iflytek.clientadapter.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class Radio implements Parcelable {
    public static final Parcelable.Creator<Radio> CREATOR = new Parcelable.Creator<Radio>() {
        public Radio createFromParcel(Parcel parcel) {
            return new Radio(parcel);
        }

        public Radio[] newArray(int i) {
            return new Radio[i];
        }
    };
    private int albumId;
    private String albumName;
    private String anchor;
    private String authorName;
    private String cateforyName;
    private long categoryId;
    private String channel;
    private String describe;
    private long duration;
    private long id;
    private String img;
    private long listenNum;
    private String name;
    private long radioId;
    private String radioName;
    private String singleTitle;
    private int type;
    private String urlStr;

    public int describeContents() {
        return 0;
    }

    public Radio() {
    }

    public Radio(Parcel parcel) {
        this.name = parcel.readString();
        this.channel = parcel.readString();
        this.anchor = parcel.readString();
        this.singleTitle = parcel.readString();
        this.id = parcel.readLong();
        this.img = parcel.readString();
        this.listenNum = parcel.readLong();
        this.type = parcel.readInt();
        this.radioId = parcel.readLong();
        this.radioName = parcel.readString();
        this.albumId = parcel.readInt();
        this.albumName = parcel.readString();
        this.categoryId = parcel.readLong();
        this.cateforyName = parcel.readString();
        this.urlStr = parcel.readString();
        this.duration = parcel.readLong();
        this.describe = parcel.readString();
        this.authorName = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.channel);
        parcel.writeString(this.anchor);
        parcel.writeString(this.singleTitle);
        parcel.writeLong(this.id);
        parcel.writeString(this.img);
        parcel.writeLong(this.listenNum);
        parcel.writeInt(this.type);
        parcel.writeLong(this.radioId);
        parcel.writeString(this.radioName);
        parcel.writeInt(this.albumId);
        parcel.writeString(this.albumName);
        parcel.writeLong(this.categoryId);
        parcel.writeString(this.cateforyName);
        parcel.writeString(this.urlStr);
        parcel.writeLong(this.duration);
        parcel.writeString(this.describe);
        parcel.writeString(this.authorName);
    }

    public String getSingleTitle() {
        return this.singleTitle;
    }

    public void setSingleTitle(String str) {
        this.singleTitle = str;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String str) {
        this.img = str;
    }

    public long getListenNum() {
        return this.listenNum;
    }

    public void setListenNum(long j) {
        this.listenNum = j;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public String getAnchor() {
        return this.anchor;
    }

    public void setAnchor(String str) {
        this.anchor = str;
    }

    public long getRadioId() {
        return this.radioId;
    }

    public void setRadioId(long j) {
        this.radioId = j;
    }

    public String getRadioName() {
        return this.radioName;
    }

    public void setRadioName(String str) {
        this.radioName = str;
    }

    public int getAlbumId() {
        return this.albumId;
    }

    public void setAlbumId(int i) {
        this.albumId = i;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public void setAlbumName(String str) {
        this.albumName = str;
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(long j) {
        this.categoryId = j;
    }

    public String getCateforyName() {
        return this.cateforyName;
    }

    public void setCateforyName(String str) {
        this.cateforyName = str;
    }

    public String getUrlStr() {
        return this.urlStr;
    }

    public void setUrlStr(String str) {
        this.urlStr = str;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public String getDescribe() {
        return this.describe;
    }

    public void setDescribe(String str) {
        this.describe = str;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String str) {
        this.authorName = str;
    }
}
