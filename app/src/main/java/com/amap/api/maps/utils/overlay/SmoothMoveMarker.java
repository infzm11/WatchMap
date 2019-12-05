package com.amap.api.maps.utils.overlay;

import android.view.animation.LinearInterpolator;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.animation.Animation;
import com.amap.api.maps.model.animation.TranslateAnimation;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SmoothMoveMarker {
    /* access modifiers changed from: private */
    public TranslateAnimation animation;
    private BitmapDescriptor descriptor;
    /* access modifiers changed from: private */
    public long duration = 10000;
    /* access modifiers changed from: private */
    public LinkedList<Double> eachDistance = new LinkedList<>();
    private LatLng endPoint;
    boolean exitFlag = false;
    /* access modifiers changed from: private */
    public int index = 0;
    private LatLng lastEndPoint;
    /* access modifiers changed from: private */
    public AMap mAMap;
    /* access modifiers changed from: private */
    public Marker marker = null;
    /* access modifiers changed from: private */
    public MoveListener moveListener;
    private Thread moveThread = null;
    /* access modifiers changed from: private */
    public LinkedList<LatLng> points = new LinkedList<>();
    /* access modifiers changed from: private */
    public double remainDistance = 0.0d;
    private LatLng tempPosition;
    /* access modifiers changed from: private */
    public Timer timer = null;
    /* access modifiers changed from: private */
    public double totalDistance = 0.0d;
    private boolean useDefaultDescriptor = false;

    public interface MoveListener {
        void move(double d);
    }

    public SmoothMoveMarker(AMap aMap) {
        this.mAMap = aMap;
    }

    public void setPoints(List<LatLng> list) {
        synchronized (this) {
            try {
                this.points.clear();
                for (LatLng add : list) {
                    this.points.add(add);
                }
                if (list.size() > 1) {
                    this.endPoint = this.points.get(this.points.size() - 1);
                    this.lastEndPoint = this.points.get(this.points.size() - 2);
                }
                this.eachDistance.clear();
                this.totalDistance = 0.0d;
                int i = 0;
                while (i < this.points.size() - 1) {
                    i++;
                    double calculateLineDistance = (double) AMapUtils.calculateLineDistance(this.points.get(i), this.points.get(i));
                    this.eachDistance.add(Double.valueOf(calculateLineDistance));
                    this.totalDistance += calculateLineDistance;
                }
                this.remainDistance = this.totalDistance;
                LatLng removeFirst = this.points.removeFirst();
                if (this.marker != null) {
                    this.marker.setPosition(removeFirst);
                    checkMarkerIcon();
                } else {
                    if (this.descriptor == null) {
                        this.useDefaultDescriptor = true;
                    }
                    this.marker = this.mAMap.addMarker(new MarkerOptions().belowMaskLayer(true).position(removeFirst).icon(this.descriptor).title("").anchor(0.5f, 0.5f));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void checkMarkerIcon() {
        if (!this.useDefaultDescriptor) {
            return;
        }
        if (this.descriptor == null) {
            this.useDefaultDescriptor = true;
            return;
        }
        this.marker.setIcon(this.descriptor);
        this.useDefaultDescriptor = false;
    }

    public void setTotalDuration(int i) {
        this.duration = (long) (i * 1000);
    }

    public void startSmoothMove() {
        if (this.points.size() > 0) {
            this.index = 0;
            this.exitFlag = false;
            try {
                if (this.moveThread != null) {
                    this.moveThread.interrupt();
                }
                this.moveThread = new Thread(new Runnable() {
                    public final void run() {
                        a();
                    }

                    /* access modifiers changed from: private */
                    public void a() {
                        try {
                            if (SmoothMoveMarker.this.points.size() <= 0) {
                                if (SmoothMoveMarker.this.moveListener != null) {
                                    SmoothMoveMarker.this.moveListener.move(0.0d);
                                }
                                SmoothMoveMarker.this.setEndRotate();
                                return;
                            }
                            double doubleValue = ((Double) SmoothMoveMarker.this.eachDistance.poll()).doubleValue();
                            long access$400 = (long) (((double) SmoothMoveMarker.this.duration) * (doubleValue / SmoothMoveMarker.this.totalDistance));
                            double unused = SmoothMoveMarker.this.remainDistance = SmoothMoveMarker.this.remainDistance - doubleValue;
                            if (SmoothMoveMarker.this.moveListener != null) {
                                if (SmoothMoveMarker.this.remainDistance < 0.0d) {
                                    double unused2 = SmoothMoveMarker.this.remainDistance = 0.0d;
                                }
                                SmoothMoveMarker.this.moveListener.move(SmoothMoveMarker.this.remainDistance);
                            }
                            LatLng position = SmoothMoveMarker.this.marker.getPosition();
                            LatLng latLng = (LatLng) SmoothMoveMarker.this.points.poll();
                            if (SmoothMoveMarker.this.timer != null) {
                                SmoothMoveMarker.this.timer.cancel();
                            }
                            Timer unused3 = SmoothMoveMarker.this.timer = new Timer();
                            SmoothMoveMarker.this.timer.schedule(new TimerTask() {
                                public final void run() {
                                    try {
                                        if (SmoothMoveMarker.this.points.size() > 0) {
                                            int unused = SmoothMoveMarker.this.index = SmoothMoveMarker.this.index + 1;
                                            AnonymousClass1.this.a();
                                            return;
                                        }
                                        int unused2 = SmoothMoveMarker.this.index = SmoothMoveMarker.this.index + 1;
                                        if (SmoothMoveMarker.this.moveListener != null) {
                                            SmoothMoveMarker.this.moveListener.move(0.0d);
                                        }
                                        SmoothMoveMarker.this.setEndRotate();
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                            }, access$400);
                            if (latLng != null) {
                                if (AMapUtils.calculateLineDistance(position, latLng) > 5.0f) {
                                    SmoothMoveMarker.this.marker.setRotateAngle((360.0f - SmoothMoveMarker.this.getRotate(position, latLng)) + SmoothMoveMarker.this.mAMap.getCameraPosition().bearing);
                                }
                                TranslateAnimation unused4 = SmoothMoveMarker.this.animation = new TranslateAnimation(latLng);
                                SmoothMoveMarker.this.animation.setInterpolator(new LinearInterpolator());
                                SmoothMoveMarker.this.animation.setDuration(access$400);
                                if (!SmoothMoveMarker.this.exitFlag) {
                                    if (!Thread.interrupted()) {
                                        SmoothMoveMarker.this.marker.setAnimation(SmoothMoveMarker.this.animation);
                                        SmoothMoveMarker.this.marker.startAnimation();
                                        return;
                                    }
                                }
                                SmoothMoveMarker.this.marker.setAnimation((Animation) null);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                this.moveThread.start();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void setEndRotate() {
        if (this.marker != null) {
            if (!(this.lastEndPoint == null || this.endPoint == null || this.lastEndPoint.latitude == this.endPoint.latitude || this.lastEndPoint.longitude == this.endPoint.longitude)) {
                this.marker.setRotateAngle((360.0f - getRotate(this.lastEndPoint, this.endPoint)) + this.mAMap.getCameraPosition().bearing);
            }
            this.marker.setPosition(this.endPoint);
        }
    }

    /* access modifiers changed from: private */
    public float getRotate(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            return 0.0f;
        }
        double d = latLng.latitude;
        double d2 = latLng2.latitude;
        return (float) ((Math.atan2(latLng2.longitude - latLng.longitude, d2 - d) / 3.141592653589793d) * 180.0d);
    }

    public void stopMove() {
        this.exitFlag = true;
        if (this.marker != null) {
            this.marker.setAnimation((Animation) null);
        }
        if (this.timer != null) {
            this.timer.cancel();
        }
        if (this.moveThread != null) {
            this.moveThread.interrupt();
        }
        this.index = 0;
    }

    public Marker getMarker() {
        return this.marker;
    }

    public LatLng getPosition() {
        if (this.marker == null) {
            return null;
        }
        return this.marker.getPosition();
    }

    public int getIndex() {
        return this.index;
    }

    public void resetIndex() {
        this.index = 0;
    }

    public void destroy() {
        stopMove();
        if (this.descriptor != null) {
            this.descriptor.recycle();
        }
        if (this.marker != null) {
            this.marker.destroy();
            this.marker = null;
        }
        this.points.clear();
        this.eachDistance.clear();
    }

    public void removeMarker() {
        if (this.marker != null) {
            this.marker.remove();
            this.marker = null;
        }
        this.points.clear();
        this.eachDistance.clear();
    }

    public void setPosition(LatLng latLng) {
        if (this.marker != null) {
            this.marker.setPosition(latLng);
        }
    }

    public void setDescriptor(BitmapDescriptor bitmapDescriptor) {
        if (this.descriptor != null) {
            this.descriptor.recycle();
        }
        this.descriptor = bitmapDescriptor;
        if (this.marker != null) {
            this.marker.setIcon(bitmapDescriptor);
        }
    }

    public void setRotate(float f) {
        if (this.marker != null && this.mAMap != null) {
            this.marker.setRotateAngle((360.0f - f) + this.mAMap.getCameraPosition().bearing);
        }
    }

    public void setVisible(boolean z) {
        if (this.marker != null) {
            this.marker.setVisible(z);
        }
    }

    public void setMoveListener(MoveListener moveListener2) {
        this.moveListener = moveListener2;
    }
}
