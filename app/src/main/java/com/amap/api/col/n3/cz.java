package com.amap.api.col.n3;

import android.text.TextUtils;

/* compiled from: StyleItemAdaptor */
public final class cz {
    public static final int[][] a = {new int[]{0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, new int[]{12}, new int[]{1}, new int[]{13}, new int[]{14}, new int[]{15, 16}, new int[]{17, 18, 19, 20, 21, 26, 27, 28}, new int[]{22, 23}, new int[]{24, 25}, new int[]{39, 40, 41}, new int[]{29, 30, 31}, new int[]{32, 33, 34, 35, 36, 37, 38}};
    public static final String[] b = {"land", "water", "green", "building", "highway", "arterial", "local", "railway", "subway", "boundary", "poilabel", "districtlable"};

    public static int[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= b.length) {
                break;
            } else if (b[i2].equals(str)) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i >= 0) {
            return a[i];
        }
        return null;
    }
}
