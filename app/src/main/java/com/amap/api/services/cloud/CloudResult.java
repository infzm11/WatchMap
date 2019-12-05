package com.amap.api.services.cloud;

import com.amap.api.services.cloud.CloudSearch;
import java.util.ArrayList;

public final class CloudResult {
    private int a = a(this.c);
    private ArrayList<CloudItem> b;
    private int c;
    private int d;
    private CloudSearch.Query e;
    private CloudSearch.SearchBound f;

    public static CloudResult createPagedResult(CloudSearch.Query query, int i, CloudSearch.SearchBound searchBound, int i2, ArrayList<CloudItem> arrayList) {
        CloudResult cloudResult = new CloudResult(query, i, searchBound, i2, arrayList);
        return cloudResult;
    }

    private CloudResult(CloudSearch.Query query, int i, CloudSearch.SearchBound searchBound, int i2, ArrayList<CloudItem> arrayList) {
        this.e = query;
        this.c = i;
        this.d = i2;
        this.b = arrayList;
        this.f = searchBound;
    }

    public int getPageCount() {
        return this.a;
    }

    public CloudSearch.Query getQuery() {
        return this.e;
    }

    public CloudSearch.SearchBound getBound() {
        return this.f;
    }

    public ArrayList<CloudItem> getClouds() {
        return this.b;
    }

    public int getTotalCount() {
        return this.c;
    }

    private int a(int i) {
        return ((i + this.d) - 1) / this.d;
    }
}
