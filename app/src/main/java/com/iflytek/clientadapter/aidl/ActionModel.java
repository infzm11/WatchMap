package com.iflytek.clientadapter.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class ActionModel implements Parcelable {
    public static final int ACTION_CANCLE = 11;
    public static final int ACTION_NEXTPAGE = 9;
    public static final int ACTION_PREPAGE = 10;
    public static final int Action_Answer = 7;
    public static final int Action_Call = 1;
    public static final int Action_Hangup = 8;
    public static final int Action_SendSMS = 2;
    public static final int Action_StartSpeechRecord = 3;
    public static final int Action_StartWakeRecord = 5;
    public static final int Action_StopSpeechRecord = 4;
    public static final int Action_StopWakeRecord = 6;
    public static final Parcelable.Creator<ActionModel> CREATOR = new Parcelable.Creator<ActionModel>() {
        public ActionModel createFromParcel(Parcel parcel) {
            return new ActionModel(parcel, (ActionModel) null);
        }

        public ActionModel[] newArray(int i) {
            return new ActionModel[i];
        }
    };
    private int mAction;
    private String mFocus;
    private String mParam1;
    private String mParam2;

    public int describeContents() {
        return 0;
    }

    public ActionModel() {
    }

    public int getAction() {
        return this.mAction;
    }

    public void setAction(int i) {
        this.mAction = i;
    }

    public String getMessage() {
        return this.mParam1;
    }

    public void setMessage(String str) {
        this.mParam1 = str;
    }

    public String getExtral() {
        return this.mParam2;
    }

    public void setExtral(String str) {
        this.mParam2 = str;
    }

    public void setFocus(String str) {
        this.mFocus = str;
    }

    public String getFocus() {
        return this.mFocus;
    }

    private ActionModel(Parcel parcel) {
        readFromParcel(parcel);
    }

    /* synthetic */ ActionModel(Parcel parcel, ActionModel actionModel) {
        this(parcel);
    }

    public void readFromParcel(Parcel parcel) {
        this.mAction = parcel.readInt();
        this.mParam1 = parcel.readString();
        this.mParam2 = parcel.readString();
        this.mFocus = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAction);
        parcel.writeString(this.mParam1);
        parcel.writeString(this.mParam2);
        parcel.writeString(this.mFocus);
    }
}
