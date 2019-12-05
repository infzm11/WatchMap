package com.amap.api.navi.model;

public class InnerNaviInfo extends NaviInfo {
    byte[] m_IconData;

    public void setInnerNaviInfo(NaviInfo naviInfo) {
        if (naviInfo != null) {
            try {
                this.m_Type = naviInfo.m_Type;
                this.m_CurRoadName = naviInfo.m_CurRoadName;
                this.m_NextRoadName = naviInfo.m_NextRoadName;
                this.m_SAPADist = naviInfo.m_SAPADist;
                this.m_CameraDist = naviInfo.m_CameraDist;
                this.m_CameraType = naviInfo.m_CameraType;
                this.m_CameraSpeed = naviInfo.m_CameraSpeed;
                this.m_Icon = naviInfo.m_Icon;
                this.m_RouteRemainDis = naviInfo.m_RouteRemainDis;
                this.m_RouteRemainTime = naviInfo.m_RouteRemainTime;
                this.m_SegRemainDis = naviInfo.m_SegRemainDis;
                this.m_SegRemainTime = naviInfo.m_SegRemainTime;
                this.m_CarDirection = naviInfo.m_CarDirection;
                this.m_Longitude = naviInfo.m_Longitude;
                this.m_Latitude = naviInfo.m_Latitude;
                this.m_CurSegNum = naviInfo.m_CurSegNum;
                this.m_CurLinkNum = naviInfo.m_CurLinkNum;
                this.m_CurPointNum = naviInfo.m_CurPointNum;
                this.currentCoord = new NaviLatLng(naviInfo.m_Latitude, naviInfo.m_Longitude);
                this.cameraCoord = naviInfo.getCameraCoord();
                this.currentSpeed = naviInfo.getCurrentSpeed();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public byte[] getIconData() {
        return this.m_IconData;
    }

    public void setIconData(byte[] bArr) {
        this.m_IconData = bArr;
    }
}
