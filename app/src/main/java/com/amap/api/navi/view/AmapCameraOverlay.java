package com.amap.api.navi.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.amap.api.col.n3.hq;
import com.amap.api.col.n3.hs;
import com.amap.api.col.n3.iu;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Marker;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"NewApi"})
public class AmapCameraOverlay {
    private BitmapDescriptor mBusLeftIcon = null;
    private BitmapDescriptor mBusRightIcon = null;
    private BitmapDescriptor mCameraIcon = null;
    private BitmapDescriptor mCameraLeftIcon = null;
    private BitmapDescriptor mCameraRightIcon = null;
    private Context mContext;
    private boolean mLastFlag = false;
    private BitmapDescriptor mRedLeftIcon = null;
    private BitmapDescriptor mRedRightIcon = null;
    private BitmapDescriptor mYingjiLeftIcon = null;
    private BitmapDescriptor mYingjiRightIcon = null;
    private Map<String, List<Marker>> markerMap = new HashMap();

    public AmapCameraOverlay(Context context) {
        try {
            this.mCameraIcon = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837548));
            this.mBusLeftIcon = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837573));
            this.mBusRightIcon = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837574));
            this.mCameraLeftIcon = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837575));
            this.mCameraRightIcon = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837576));
            this.mYingjiLeftIcon = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837577));
            this.mYingjiRightIcon = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837578));
            this.mRedLeftIcon = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837579));
            this.mRedRightIcon = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(hs.a(), 2130837580));
            this.mContext = context;
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "CameraOverlay", "CameraOverlay()");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x025b A[Catch:{ Throwable -> 0x0252 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(com.amap.api.maps.AMap r19, com.amap.api.navi.model.AMapNaviCameraInfo[] r20) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = 0
            r5 = r4
        L_0x0008:
            r6 = 1
            if (r3 == 0) goto L_0x0256
            int r7 = r3.length     // Catch:{ Throwable -> 0x0252 }
            if (r5 >= r7) goto L_0x0256
            r7 = r3[r5]     // Catch:{ Throwable -> 0x0252 }
            int r8 = r7.getCameraType()     // Catch:{ Throwable -> 0x0252 }
            if (r8 != 0) goto L_0x001d
            int r8 = r7.getCameraSpeed()     // Catch:{ Throwable -> 0x0252 }
            if (r8 != 0) goto L_0x001d
            return
        L_0x001d:
            if (r2 != 0) goto L_0x0020
            return
        L_0x0020:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0252 }
            r8.<init>()     // Catch:{ Throwable -> 0x0252 }
            double r9 = r7.getX()     // Catch:{ Throwable -> 0x0252 }
            r8.append(r9)     // Catch:{ Throwable -> 0x0252 }
            java.lang.String r9 = "-"
            r8.append(r9)     // Catch:{ Throwable -> 0x0252 }
            int r9 = r7.getCameraType()     // Catch:{ Throwable -> 0x0252 }
            r8.append(r9)     // Catch:{ Throwable -> 0x0252 }
            java.lang.String r9 = "-"
            r8.append(r9)     // Catch:{ Throwable -> 0x0252 }
            double r9 = r7.getY()     // Catch:{ Throwable -> 0x0252 }
            r8.append(r9)     // Catch:{ Throwable -> 0x0252 }
            java.lang.String r8 = r8.toString()     // Catch:{ Throwable -> 0x0252 }
            java.util.Map<java.lang.String, java.util.List<com.amap.api.maps.model.Marker>> r9 = r1.markerMap     // Catch:{ Throwable -> 0x0252 }
            java.util.Set r9 = r9.keySet()     // Catch:{ Throwable -> 0x0252 }
            boolean r9 = r9.contains(r8)     // Catch:{ Throwable -> 0x0252 }
            if (r9 == 0) goto L_0x006d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0252 }
            java.lang.String r8 = "key 包含在 map 中,距离摄像头:"
            r6.<init>(r8)     // Catch:{ Throwable -> 0x0252 }
            int r7 = r7.getCameraDistance()     // Catch:{ Throwable -> 0x0252 }
            r6.append(r7)     // Catch:{ Throwable -> 0x0252 }
            java.lang.String r7 = "米"
            r6.append(r7)     // Catch:{ Throwable -> 0x0252 }
            r6.toString()     // Catch:{ Throwable -> 0x0252 }
            r15 = r5
            goto L_0x024d
        L_0x006d:
            boolean r9 = r1.mLastFlag     // Catch:{ Throwable -> 0x0252 }
            if (r9 == 0) goto L_0x0075
            r1.mLastFlag = r4     // Catch:{ Throwable -> 0x0252 }
            r9 = r4
            goto L_0x0078
        L_0x0075:
            r1.mLastFlag = r6     // Catch:{ Throwable -> 0x0252 }
            r9 = r6
        L_0x0078:
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ Throwable -> 0x0252 }
            r10.<init>()     // Catch:{ Throwable -> 0x0252 }
            int r11 = r7.getCameraType()     // Catch:{ Throwable -> 0x0252 }
            if (r9 == 0) goto L_0x0086
            r12 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0087
        L_0x0086:
            r12 = 0
        L_0x0087:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0252 }
            java.lang.String r14 = "key 不包含在 map 中,摄像头类型="
            r13.<init>(r14)     // Catch:{ Throwable -> 0x0252 }
            r13.append(r11)     // Catch:{ Throwable -> 0x0252 }
            java.lang.String r14 = ",距离:"
            r13.append(r14)     // Catch:{ Throwable -> 0x0252 }
            int r14 = r7.getCameraDistance()     // Catch:{ Throwable -> 0x0252 }
            r13.append(r14)     // Catch:{ Throwable -> 0x0252 }
            r13.toString()     // Catch:{ Throwable -> 0x0252 }
            r13 = 1060320051(0x3f333333, float:0.7)
            switch(r11) {
                case 0: goto L_0x0180;
                case 1: goto L_0x014a;
                case 2: goto L_0x0114;
                case 3: goto L_0x014a;
                case 4: goto L_0x00de;
                case 5: goto L_0x00ab;
                default: goto L_0x00a6;
            }     // Catch:{ Throwable -> 0x0252 }
        L_0x00a6:
            r15 = r5
            com.amap.api.maps.model.MarkerOptions r4 = new com.amap.api.maps.model.MarkerOptions     // Catch:{ Throwable -> 0x0252 }
            goto L_0x021d
        L_0x00ab:
            com.amap.api.maps.model.MarkerOptions r11 = new com.amap.api.maps.model.MarkerOptions     // Catch:{ Throwable -> 0x0252 }
            r11.<init>()     // Catch:{ Throwable -> 0x0252 }
            com.amap.api.maps.model.LatLng r14 = new com.amap.api.maps.model.LatLng     // Catch:{ Throwable -> 0x0252 }
            r15 = r5
            double r4 = r7.getY()     // Catch:{ Throwable -> 0x0252 }
            double r6 = r7.getX()     // Catch:{ Throwable -> 0x0252 }
            r14.<init>(r4, r6)     // Catch:{ Throwable -> 0x0252 }
            com.amap.api.maps.model.MarkerOptions r4 = r11.position(r14)     // Catch:{ Throwable -> 0x0252 }
            com.amap.api.maps.model.MarkerOptions r4 = r4.anchor(r12, r13)     // Catch:{ Throwable -> 0x0252 }
            if (r9 == 0) goto L_0x00cb
            com.amap.api.maps.model.BitmapDescriptor r5 = r1.mYingjiLeftIcon     // Catch:{ Throwable -> 0x0252 }
            goto L_0x00cd
        L_0x00cb:
            com.amap.api.maps.model.BitmapDescriptor r5 = r1.mYingjiRightIcon     // Catch:{ Throwable -> 0x0252 }
        L_0x00cd:
            com.amap.api.maps.model.MarkerOptions r4 = r4.icon(r5)     // Catch:{ Throwable -> 0x0252 }
            com.amap.api.maps.model.Marker r4 = r2.addMarker(r4)     // Catch:{ Throwable -> 0x0252 }
            r5 = 1
            r4.setVisible(r5)     // Catch:{ Throwable -> 0x0252 }
            r10.add(r4)     // Catch:{ Throwable -> 0x0252 }
            goto L_0x0248
        L_0x00de:
            r15 = r5
            com.amap.api.maps.model.MarkerOptions r4 = new com.amap.api.maps.model.MarkerOptions     // Catch:{ Throwable -> 0x0252 }
            r4.<init>()     // Catch:{ Throwable -> 0x0252 }
            com.amap.api.maps.model.LatLng r5 = new com.amap.api.maps.model.LatLng     // Catch:{ Throwable -> 0x0252 }
            double r13 = r7.getY()     // Catch:{ Throwable -> 0x0252 }
            double r6 = r7.getX()     // Catch:{ Throwable -> 0x0252 }
            r5.<init>(r13, r6)     // Catch:{ Throwable -> 0x0252 }
            com.amap.api.maps.model.MarkerOptions r4 = r4.position(r5)     // Catch:{ Throwable -> 0x0252 }
            r5 = 1060320051(0x3f333333, float:0.7)
            com.amap.api.maps.model.MarkerOptions r4 = r4.anchor(r12, r5)     // Catch:{ Throwable -> 0x0252 }
            if (r9 == 0) goto L_0x0101
            com.amap.api.maps.model.BitmapDescriptor r5 = r1.mBusLeftIcon     // Catch:{ Throwable -> 0x0252 }
            goto L_0x0103
        L_0x0101:
            com.amap.api.maps.model.BitmapDescriptor r5 = r1.mBusRightIcon     // Catch:{ Throwable -> 0x0252 }
        L_0x0103:
            com.amap.api.maps.model.MarkerOptions r4 = r4.icon(r5)     // Catch:{ Throwable -> 0x0252 }
            com.amap.api.maps.model.Marker r4 = r2.addMarker(r4)     // Catch:{ Throwable -> 0x0252 }
            r5 = 1
            r4.setVisible(r5)     // Catch:{ Throwable -> 0x0252 }
            r10.add(r4)     // Catch:{ Throwable -> 0x0252 }
            goto L_0x0248
        L_0x0114:
            r15 = r5
            com.amap.api.maps.model.MarkerOptions r4 = new com.amap.api.maps.model.MarkerOptions     // Catch:{ Throwable -> 0x0252 }
            r4.<init>()     // Catch:{ Throwable -> 0x0252 }
            com.amap.api.maps.model.LatLng r5 = new com.amap.api.maps.model.LatLng     // Catch:{ Throwable -> 0x0252 }
            double r13 = r7.getY()     // Catch:{ Throwable -> 0x0252 }
            double r6 = r7.getX()     // Catch:{ Throwable -> 0x0252 }
            r5.<init>(r13, r6)     // Catch:{ Throwable -> 0x0252 }
            com.amap.api.maps.model.MarkerOptions r4 = r4.position(r5)     // Catch:{ Throwable -> 0x0252 }
            r5 = 1060320051(0x3f333333, float:0.7)
            com.amap.api.maps.model.MarkerOptions r4 = r4.anchor(r12, r5)     // Catch:{ Throwable -> 0x0252 }
            if (r9 == 0) goto L_0x0137
            com.amap.api.maps.model.BitmapDescriptor r5 = r1.mRedLeftIcon     // Catch:{ Throwable -> 0x0252 }
            goto L_0x0139
        L_0x0137:
            com.amap.api.maps.model.BitmapDescriptor r5 = r1.mRedRightIcon     // Catch:{ Throwable -> 0x0252 }
        L_0x0139:
            com.amap.api.maps.model.MarkerOptions r4 = r4.icon(r5)     // Catch:{ Throwable -> 0x0252 }
            com.amap.api.maps.model.Marker r4 = r2.addMarker(r4)     // Catch:{ Throwable -> 0x0252 }
            r5 = 1
            r4.setVisible(r5)     // Catch:{ Throwable -> 0x0252 }
            r10.add(r4)     // Catch:{ Throwable -> 0x0252 }
            goto L_0x0248
        L_0x014a:
            r15 = r5
            com.amap.api.maps.model.MarkerOptions r4 = new com.amap.api.maps.model.MarkerOptions     // Catch:{ Throwable -> 0x0252 }
            r4.<init>()     // Catch:{ Throwable -> 0x0252 }
            com.amap.api.maps.model.LatLng r5 = new com.amap.api.maps.model.LatLng     // Catch:{ Throwable -> 0x0252 }
            double r13 = r7.getY()     // Catch:{ Throwable -> 0x0252 }
            double r6 = r7.getX()     // Catch:{ Throwable -> 0x0252 }
            r5.<init>(r13, r6)     // Catch:{ Throwable -> 0x0252 }
            com.amap.api.maps.model.MarkerOptions r4 = r4.position(r5)     // Catch:{ Throwable -> 0x0252 }
            r5 = 1060320051(0x3f333333, float:0.7)
            com.amap.api.maps.model.MarkerOptions r4 = r4.anchor(r12, r5)     // Catch:{ Throwable -> 0x0252 }
            if (r9 == 0) goto L_0x016d
            com.amap.api.maps.model.BitmapDescriptor r5 = r1.mCameraLeftIcon     // Catch:{ Throwable -> 0x0252 }
            goto L_0x016f
        L_0x016d:
            com.amap.api.maps.model.BitmapDescriptor r5 = r1.mCameraRightIcon     // Catch:{ Throwable -> 0x0252 }
        L_0x016f:
            com.amap.api.maps.model.MarkerOptions r4 = r4.icon(r5)     // Catch:{ Throwable -> 0x0252 }
            com.amap.api.maps.model.Marker r4 = r2.addMarker(r4)     // Catch:{ Throwable -> 0x0252 }
            r5 = 1
            r4.setVisible(r5)     // Catch:{ Throwable -> 0x0252 }
            r10.add(r4)     // Catch:{ Throwable -> 0x0252 }
            goto L_0x0248
        L_0x0180:
            r15 = r5
            android.widget.TextView r4 = new android.widget.TextView     // Catch:{ Throwable -> 0x0252 }
            android.content.Context r5 = r1.mContext     // Catch:{ Throwable -> 0x0252 }
            r4.<init>(r5)     // Catch:{ Throwable -> 0x0252 }
            r5 = -65536(0xffffffffffff0000, float:NaN)
            r4.setTextColor(r5)     // Catch:{ Throwable -> 0x0252 }
            r5 = 49
            r4.setGravity(r5)     // Catch:{ Throwable -> 0x0252 }
            int r5 = r7.getCameraSpeed()     // Catch:{ Throwable -> 0x0252 }
            r6 = 99
            if (r5 <= r6) goto L_0x01a6
            r6 = 1101004800(0x41a00000, float:20.0)
            r4.setTextSize(r6)     // Catch:{ Throwable -> 0x0252 }
            r6 = 16
            r11 = 0
            r4.setPadding(r11, r6, r11, r11)     // Catch:{ Throwable -> 0x0252 }
            goto L_0x01b1
        L_0x01a6:
            r11 = 0
            r6 = 1103101952(0x41c00000, float:24.0)
            r4.setTextSize(r6)     // Catch:{ Throwable -> 0x0252 }
            r6 = 12
            r4.setPadding(r11, r6, r11, r11)     // Catch:{ Throwable -> 0x0252 }
        L_0x01b1:
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Throwable -> 0x0252 }
            r4.setText(r5)     // Catch:{ Throwable -> 0x0252 }
            android.content.res.Resources r5 = com.amap.api.col.n3.hs.a()     // Catch:{ Throwable -> 0x0252 }
            if (r9 == 0) goto L_0x01c2
            r6 = 2130837581(0x7f02004d, float:1.728012E38)
            goto L_0x01c5
        L_0x01c2:
            r6 = 2130837582(0x7f02004e, float:1.7280122E38)
        L_0x01c5:
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeResource(r5, r6)     // Catch:{ Throwable -> 0x0252 }
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x0252 }
            r9 = 17
            if (r6 < r9) goto L_0x01dc
            android.graphics.drawable.BitmapDrawable r6 = new android.graphics.drawable.BitmapDrawable     // Catch:{ Throwable -> 0x0252 }
            android.content.res.Resources r9 = com.amap.api.col.n3.hs.a()     // Catch:{ Throwable -> 0x0252 }
            r6.<init>(r9, r5)     // Catch:{ Throwable -> 0x0252 }
            r4.setBackground(r6)     // Catch:{ Throwable -> 0x0252 }
            goto L_0x01e8
        L_0x01dc:
            android.graphics.drawable.BitmapDrawable r6 = new android.graphics.drawable.BitmapDrawable     // Catch:{ Throwable -> 0x0252 }
            android.content.res.Resources r9 = com.amap.api.col.n3.hs.a()     // Catch:{ Throwable -> 0x0252 }
            r6.<init>(r9, r5)     // Catch:{ Throwable -> 0x0252 }
            r4.setBackgroundDrawable(r6)     // Catch:{ Throwable -> 0x0252 }
        L_0x01e8:
            com.amap.api.maps.model.BitmapDescriptor r4 = com.amap.api.maps.model.BitmapDescriptorFactory.fromView(r4)     // Catch:{ Throwable -> 0x0252 }
            com.amap.api.maps.model.MarkerOptions r5 = new com.amap.api.maps.model.MarkerOptions     // Catch:{ Throwable -> 0x0252 }
            r5.<init>()     // Catch:{ Throwable -> 0x0252 }
            com.amap.api.maps.model.LatLng r6 = new com.amap.api.maps.model.LatLng     // Catch:{ Throwable -> 0x0252 }
            double r13 = r7.getY()     // Catch:{ Throwable -> 0x0252 }
            r16 = r12
            double r11 = r7.getX()     // Catch:{ Throwable -> 0x0252 }
            r6.<init>(r13, r11)     // Catch:{ Throwable -> 0x0252 }
            com.amap.api.maps.model.MarkerOptions r5 = r5.position(r6)     // Catch:{ Throwable -> 0x0252 }
            r12 = r16
            r6 = 1060320051(0x3f333333, float:0.7)
            com.amap.api.maps.model.MarkerOptions r5 = r5.anchor(r12, r6)     // Catch:{ Throwable -> 0x0252 }
            com.amap.api.maps.model.MarkerOptions r4 = r5.icon(r4)     // Catch:{ Throwable -> 0x0252 }
            com.amap.api.maps.model.Marker r4 = r2.addMarker(r4)     // Catch:{ Throwable -> 0x0252 }
            r5 = 1
            r4.setVisible(r5)     // Catch:{ Throwable -> 0x0252 }
            r10.add(r4)     // Catch:{ Throwable -> 0x0252 }
            goto L_0x0248
        L_0x021d:
            r4.<init>()     // Catch:{ Throwable -> 0x0252 }
            com.amap.api.maps.model.LatLng r5 = new com.amap.api.maps.model.LatLng     // Catch:{ Throwable -> 0x0252 }
            double r11 = r7.getY()     // Catch:{ Throwable -> 0x0252 }
            double r6 = r7.getX()     // Catch:{ Throwable -> 0x0252 }
            r5.<init>(r11, r6)     // Catch:{ Throwable -> 0x0252 }
            com.amap.api.maps.model.MarkerOptions r4 = r4.position(r5)     // Catch:{ Throwable -> 0x0252 }
            r5 = 1056964608(0x3f000000, float:0.5)
            com.amap.api.maps.model.MarkerOptions r4 = r4.anchor(r5, r5)     // Catch:{ Throwable -> 0x0252 }
            com.amap.api.maps.model.BitmapDescriptor r5 = r1.mCameraIcon     // Catch:{ Throwable -> 0x0252 }
            com.amap.api.maps.model.MarkerOptions r4 = r4.icon(r5)     // Catch:{ Throwable -> 0x0252 }
            com.amap.api.maps.model.Marker r4 = r2.addMarker(r4)     // Catch:{ Throwable -> 0x0252 }
            r5 = 1
            r4.setVisible(r5)     // Catch:{ Throwable -> 0x0252 }
            r10.add(r4)     // Catch:{ Throwable -> 0x0252 }
        L_0x0248:
            java.util.Map<java.lang.String, java.util.List<com.amap.api.maps.model.Marker>> r4 = r1.markerMap     // Catch:{ Throwable -> 0x0252 }
            r4.put(r8, r10)     // Catch:{ Throwable -> 0x0252 }
        L_0x024d:
            int r5 = r15 + 1
            r4 = 0
            goto L_0x0008
        L_0x0252:
            r0 = move-exception
            r2 = r0
            goto L_0x02e9
        L_0x0256:
            r5 = r6
            java.util.Map<java.lang.String, java.util.List<com.amap.api.maps.model.Marker>> r2 = r1.markerMap     // Catch:{ Throwable -> 0x0252 }
            if (r2 == 0) goto L_0x02e8
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Throwable -> 0x0252 }
            r2.<init>()     // Catch:{ Throwable -> 0x0252 }
            java.util.Map<java.lang.String, java.util.List<com.amap.api.maps.model.Marker>> r4 = r1.markerMap     // Catch:{ Throwable -> 0x0252 }
            java.util.Set r4 = r4.keySet()     // Catch:{ Throwable -> 0x0252 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Throwable -> 0x0252 }
        L_0x026a:
            boolean r6 = r4.hasNext()     // Catch:{ Throwable -> 0x0252 }
            if (r6 == 0) goto L_0x02d5
            java.lang.Object r6 = r4.next()     // Catch:{ Throwable -> 0x0252 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Throwable -> 0x0252 }
            r7 = 0
            r8 = 0
        L_0x0278:
            if (r3 == 0) goto L_0x02b1
            int r9 = r3.length     // Catch:{ Throwable -> 0x0252 }
            if (r7 >= r9) goto L_0x02b1
            r9 = r3[r7]     // Catch:{ Throwable -> 0x0252 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0252 }
            r10.<init>()     // Catch:{ Throwable -> 0x0252 }
            double r11 = r9.getX()     // Catch:{ Throwable -> 0x0252 }
            r10.append(r11)     // Catch:{ Throwable -> 0x0252 }
            java.lang.String r11 = "-"
            r10.append(r11)     // Catch:{ Throwable -> 0x0252 }
            int r11 = r9.getCameraType()     // Catch:{ Throwable -> 0x0252 }
            r10.append(r11)     // Catch:{ Throwable -> 0x0252 }
            java.lang.String r11 = "-"
            r10.append(r11)     // Catch:{ Throwable -> 0x0252 }
            double r11 = r9.getY()     // Catch:{ Throwable -> 0x0252 }
            r10.append(r11)     // Catch:{ Throwable -> 0x0252 }
            java.lang.String r9 = r10.toString()     // Catch:{ Throwable -> 0x0252 }
            boolean r9 = r9.equals(r6)     // Catch:{ Throwable -> 0x0252 }
            if (r9 == 0) goto L_0x02ae
            r8 = r5
        L_0x02ae:
            int r7 = r7 + 1
            goto L_0x0278
        L_0x02b1:
            if (r8 != 0) goto L_0x026a
            java.util.Map<java.lang.String, java.util.List<com.amap.api.maps.model.Marker>> r7 = r1.markerMap     // Catch:{ Throwable -> 0x0252 }
            java.lang.Object r7 = r7.get(r6)     // Catch:{ Throwable -> 0x0252 }
            java.util.List r7 = (java.util.List) r7     // Catch:{ Throwable -> 0x0252 }
            r2.add(r6)     // Catch:{ Throwable -> 0x0252 }
            r6 = 0
        L_0x02bf:
            int r8 = r7.size()     // Catch:{ Throwable -> 0x0252 }
            if (r6 >= r8) goto L_0x02d1
            java.lang.Object r8 = r7.get(r6)     // Catch:{ Throwable -> 0x0252 }
            com.amap.api.maps.model.Marker r8 = (com.amap.api.maps.model.Marker) r8     // Catch:{ Throwable -> 0x0252 }
            r8.remove()     // Catch:{ Throwable -> 0x0252 }
            int r6 = r6 + 1
            goto L_0x02bf
        L_0x02d1:
            r7.clear()     // Catch:{ Throwable -> 0x0252 }
            goto L_0x026a
        L_0x02d5:
            r3 = 0
        L_0x02d6:
            int r4 = r2.size()     // Catch:{ Throwable -> 0x0252 }
            if (r3 >= r4) goto L_0x02e8
            java.util.Map<java.lang.String, java.util.List<com.amap.api.maps.model.Marker>> r4 = r1.markerMap     // Catch:{ Throwable -> 0x0252 }
            java.lang.Object r5 = r2.get(r3)     // Catch:{ Throwable -> 0x0252 }
            r4.remove(r5)     // Catch:{ Throwable -> 0x0252 }
            int r3 = r3 + 1
            goto L_0x02d6
        L_0x02e8:
            return
        L_0x02e9:
            com.amap.api.col.n3.hq.a((java.lang.Throwable) r2)
            java.lang.String r3 = "CameraOverlay"
            java.lang.String r4 = "draw(AMap aMap, LatLng latLng)"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r2, (java.lang.String) r3, (java.lang.String) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.navi.view.AmapCameraOverlay.draw(com.amap.api.maps.AMap, com.amap.api.navi.model.AMapNaviCameraInfo[]):void");
    }

    public void removeAllCamera() {
        try {
            if (this.markerMap != null) {
                for (String str : this.markerMap.keySet()) {
                    List list = this.markerMap.get(str);
                    for (int i = 0; i < list.size(); i++) {
                        ((Marker) list.get(i)).remove();
                    }
                    list.clear();
                }
                this.markerMap.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setAllCameraVisible(boolean z) {
        try {
            if (this.markerMap != null) {
                for (String str : this.markerMap.keySet()) {
                    List list = this.markerMap.get(str);
                    for (int i = 0; i < list.size(); i++) {
                        ((Marker) list.get(i)).setVisible(z);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void destroy() {
        try {
            if (this.markerMap != null) {
                removeAllCamera();
                this.markerMap.clear();
            }
            if (this.mCameraIcon != null) {
                this.mCameraIcon.recycle();
            }
            if (this.mBusLeftIcon != null) {
                this.mBusLeftIcon.recycle();
                this.mBusLeftIcon = null;
            }
            if (this.mBusRightIcon != null) {
                this.mBusRightIcon.recycle();
                this.mBusRightIcon = null;
            }
            if (this.mCameraRightIcon != null) {
                this.mCameraRightIcon.recycle();
                this.mCameraRightIcon = null;
            }
            if (this.mCameraLeftIcon != null) {
                this.mCameraLeftIcon.recycle();
                this.mCameraLeftIcon = null;
            }
            if (this.mYingjiRightIcon != null) {
                this.mYingjiRightIcon.recycle();
                this.mYingjiRightIcon = null;
            }
            if (this.mYingjiLeftIcon != null) {
                this.mYingjiLeftIcon.recycle();
                this.mYingjiLeftIcon = null;
            }
            if (this.mRedRightIcon != null) {
                this.mRedRightIcon.recycle();
                this.mRedRightIcon = null;
            }
            if (this.mRedLeftIcon != null) {
                this.mRedLeftIcon.recycle();
                this.mRedLeftIcon = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setCameraBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                this.mCameraIcon = BitmapDescriptorFactory.fromBitmap(bitmap);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setBusBitmap(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap != null) {
            try {
                this.mBusLeftIcon = BitmapDescriptorFactory.fromBitmap(bitmap);
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (bitmap2 != null) {
            this.mBusRightIcon = BitmapDescriptorFactory.fromBitmap(bitmap2);
        }
    }

    public void setCameraMoniterBitmap(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap != null) {
            this.mCameraLeftIcon = BitmapDescriptorFactory.fromBitmap(bitmap);
        }
        if (bitmap2 != null) {
            this.mCameraRightIcon = BitmapDescriptorFactory.fromBitmap(bitmap2);
        }
    }

    public void setEmergencyBitmap(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap != null) {
            this.mYingjiLeftIcon = BitmapDescriptorFactory.fromBitmap(bitmap);
        }
        if (bitmap2 != null) {
            this.mYingjiRightIcon = BitmapDescriptorFactory.fromBitmap(bitmap2);
        }
    }

    public void setRedLightBitmap(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap != null) {
            try {
                this.mRedLeftIcon = BitmapDescriptorFactory.fromBitmap(bitmap);
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (bitmap2 != null) {
            this.mRedRightIcon = BitmapDescriptorFactory.fromBitmap(bitmap2);
        }
    }
}
