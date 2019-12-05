package com.amap.api.col.n3;

@jb(a = "update_item_download_info")
/* compiled from: DTDownloadInfo */
class ax {
    @jc(a = "mAdcode", b = 6)
    private String a = "";
    @jc(a = "fileLength", b = 5)
    private long b = 0;
    @jc(a = "splitter", b = 2)
    private int c = 0;
    @jc(a = "startPos", b = 5)
    private long d = 0;
    @jc(a = "endPos", b = 5)
    private long e = 0;

    public ax() {
    }

    public ax(String str, long j, int i, long j2, long j3) {
        this.a = str;
        this.b = j;
        this.c = i;
        this.d = j2;
        this.e = j3;
    }

    public static String a(String str) {
        return "mAdcode" + "='" + str + "'";
    }
}
