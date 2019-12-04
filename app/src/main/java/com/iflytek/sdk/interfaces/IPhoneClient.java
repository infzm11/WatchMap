package com.iflytek.sdk.interfaces;

import com.iflytek.clientadapter.aidl.ActionModel;
import com.iflytek.clientadapter.aidl.ContactEntity;
import java.util.List;

public interface IPhoneClient {
    void cancelInteractUI();

    void doAction(ActionModel actionModel);

    void inCommingCall(String str);

    int selectItem(ContactEntity contactEntity);

    int setBookList(List<ContactEntity> list);

    void setCallState(int i);

    void setListener(IPhoneListener iPhoneListener);

    void setNumbersOnePage(int i);
}
