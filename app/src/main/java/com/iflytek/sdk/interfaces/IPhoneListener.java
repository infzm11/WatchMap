package com.iflytek.sdk.interfaces;

import com.iflytek.clientadapter.aidl.ActionModel;
import com.iflytek.clientadapter.aidl.ContactEntity;
import java.util.List;

public interface IPhoneListener {
    void onBookResult(int i);

    boolean onDoActioin(ActionModel actionModel);

    void onSelectItem(int i);

    void onSelectPage(int i);

    void onShowList(List<ContactEntity> list);

    void toAcceptCall(String str);

    void toCallPhone(String str);

    void toRejectCall(String str);
}
