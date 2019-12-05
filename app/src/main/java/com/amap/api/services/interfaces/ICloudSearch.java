package com.amap.api.services.interfaces;

import com.amap.api.services.cloud.CloudSearch;

public interface ICloudSearch {
    void searchCloudAsyn(CloudSearch.Query query);

    void searchCloudDetailAsyn(String str, String str2);

    void setOnCloudSearchListener(CloudSearch.OnCloudSearchListener onCloudSearchListener);
}
