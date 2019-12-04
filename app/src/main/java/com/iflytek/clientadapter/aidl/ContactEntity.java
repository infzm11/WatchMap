package com.iflytek.clientadapter.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class ContactEntity implements Parcelable {
    public static final Parcelable.Creator<ContactEntity> CREATOR = new Parcelable.Creator<ContactEntity>() {
        public ContactEntity createFromParcel(Parcel parcel) {
            return new ContactEntity(parcel, (ContactEntity) null);
        }

        public ContactEntity[] newArray(int i) {
            return new ContactEntity[i];
        }
    };
    private String city;
    private String name;
    private String number;
    private String pinyin;

    public int describeContents() {
        return 0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public String getPinyin() {
        return this.pinyin;
    }

    public void setPinyin(String str) {
        this.pinyin = str;
    }

    public ContactEntity() {
    }

    private ContactEntity(Parcel parcel) {
        readFromParcel(parcel);
    }

    /* synthetic */ ContactEntity(Parcel parcel, ContactEntity contactEntity) {
        this(parcel);
    }

    public void readFromParcel(Parcel parcel) {
        setName(parcel.readString());
        setNumber(parcel.readString());
        setCity(parcel.readString());
        setPinyin(parcel.readString());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getName());
        parcel.writeString(getNumber());
        parcel.writeString(getCity());
        parcel.writeString(getPinyin());
    }
}
