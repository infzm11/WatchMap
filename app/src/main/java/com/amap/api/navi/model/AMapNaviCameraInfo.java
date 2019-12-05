package com.amap.api.navi.model;

import com.autonavi.ae.guide.model.NaviCamera;
import com.autonavi.ae.route.model.RouteCamera;

public class AMapNaviCameraInfo {
    private int cameraDistance;
    private int cameraSpeed;
    private int cameraType;
    private double x;
    private double y;

    public AMapNaviCameraInfo(NaviCamera naviCamera) {
        try {
            this.x = naviCamera.x;
            this.y = naviCamera.y;
            this.cameraType = naviCamera.cameraType;
            this.cameraSpeed = naviCamera.cameraSpeed;
            this.cameraDistance = naviCamera.cameraDistance;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public AMapNaviCameraInfo(RouteCamera routeCamera) {
        try {
            this.x = routeCamera.longitude;
            this.y = routeCamera.latitude;
            this.cameraType = routeCamera.cameraType;
            this.cameraSpeed = routeCamera.cameraSpeed;
            this.cameraDistance = 0;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public int getCameraDistance() {
        return this.cameraDistance;
    }

    public int getCameraSpeed() {
        return this.cameraSpeed;
    }

    public int getCameraType() {
        return this.cameraType;
    }
}
