package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.iflytek.clientadapter.constant.FocusType;
import com.iflytek.speech.VoiceWakeuperAidl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CloudSearchKeywordsHandler */
public class g extends e<CloudSearch.Query, CloudResult> {
    private int i = 0;

    public g(Context context, CloudSearch.Query query) {
        super(context, query);
    }

    public String i() {
        String str = h.c() + "/datasearch";
        String shape = ((CloudSearch.Query) this.a).getBound().getShape();
        if (shape.equals("Bound")) {
            return str + "/around?";
        } else if (shape.equals("Polygon") || shape.equals("Rectangle")) {
            return str + "/polygon?";
        } else if (!shape.equals(CloudSearch.SearchBound.LOCAL_SHAPE)) {
            return str;
        } else {
            return str + "/local?";
        }
    }

    /* renamed from: f */
    public CloudResult a(String str) throws AMapException {
        ArrayList<CloudItem> arrayList;
        if (str == null || str.equals("")) {
            return CloudResult.createPagedResult((CloudSearch.Query) this.a, this.i, ((CloudSearch.Query) this.a).getBound(), ((CloudSearch.Query) this.a).getPageSize(), (ArrayList<CloudItem>) null);
        }
        try {
            arrayList = b(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            arrayList = null;
            return CloudResult.createPagedResult((CloudSearch.Query) this.a, this.i, ((CloudSearch.Query) this.a).getBound(), ((CloudSearch.Query) this.a).getPageSize(), arrayList);
        } catch (Exception e2) {
            e2.printStackTrace();
            arrayList = null;
            return CloudResult.createPagedResult((CloudSearch.Query) this.a, this.i, ((CloudSearch.Query) this.a).getBound(), ((CloudSearch.Query) this.a).getPageSize(), arrayList);
        }
        return CloudResult.createPagedResult((CloudSearch.Query) this.a, this.i, ((CloudSearch.Query) this.a).getBound(), ((CloudSearch.Query) this.a).getPageSize(), arrayList);
    }

    private ArrayList<CloudItem> b(JSONObject jSONObject) throws JSONException {
        ArrayList<CloudItem> arrayList = new ArrayList<>();
        if (!jSONObject.has("datas")) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("datas");
        this.i = jSONObject.getInt("count");
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            CloudItemDetail a = a(optJSONObject);
            a(a, optJSONObject);
            arrayList.add(a);
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        if (((CloudSearch.Query) this.a).getBound() != null) {
            if (((CloudSearch.Query) this.a).getBound().getShape().equals("Bound")) {
                double a = i.a(((CloudSearch.Query) this.a).getBound().getCenter().getLongitude());
                double a2 = i.a(((CloudSearch.Query) this.a).getBound().getCenter().getLatitude());
                sb.append("&center=");
                sb.append(a + "," + a2);
                sb.append("&radius=");
                sb.append(((CloudSearch.Query) this.a).getBound().getRange());
            } else if (((CloudSearch.Query) this.a).getBound().getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((CloudSearch.Query) this.a).getBound().getLowerLeft();
                LatLonPoint upperRight = ((CloudSearch.Query) this.a).getBound().getUpperRight();
                double a3 = i.a(lowerLeft.getLatitude());
                double a4 = i.a(lowerLeft.getLongitude());
                double a5 = i.a(upperRight.getLatitude());
                double a6 = i.a(upperRight.getLongitude());
                sb.append("&polygon=" + a4 + "," + a3 + VoiceWakeuperAidl.PARAMS_SEPARATE + a6 + "," + a5);
            } else if (((CloudSearch.Query) this.a).getBound().getShape().equals("Polygon")) {
                List<LatLonPoint> polyGonList = ((CloudSearch.Query) this.a).getBound().getPolyGonList();
                if (polyGonList != null && polyGonList.size() > 0) {
                    sb.append("&polygon=" + i.a(polyGonList, VoiceWakeuperAidl.PARAMS_SEPARATE));
                }
            } else if (((CloudSearch.Query) this.a).getBound().getShape().equals(CloudSearch.SearchBound.LOCAL_SHAPE)) {
                String c = c(((CloudSearch.Query) this.a).getBound().getCity());
                sb.append("&city=");
                sb.append(c);
            }
        }
        sb.append("&tableid=" + ((CloudSearch.Query) this.a).getTableID());
        if (!i.a(k())) {
            k();
            String c2 = c(k());
            sb.append("&filter=");
            sb.append(c2);
        }
        if (!i.a(j())) {
            sb.append("&sortrule=");
            sb.append(j());
        }
        String c3 = c(((CloudSearch.Query) this.a).getQueryString());
        if (((CloudSearch.Query) this.a).getQueryString() == null || ((CloudSearch.Query) this.a).getQueryString().equals("")) {
            sb.append("&keywords=");
        } else {
            sb.append("&keywords=" + c3);
        }
        sb.append("&limit=" + ((CloudSearch.Query) this.a).getPageSize());
        sb.append("&page=" + ((CloudSearch.Query) this.a).getPageNum());
        sb.append("&key=" + az.f(this.d));
        return sb.toString();
    }

    private String j() {
        return ((CloudSearch.Query) this.a).getSortingrules() != null ? ((CloudSearch.Query) this.a).getSortingrules().toString() : "";
    }

    private String k() {
        StringBuffer stringBuffer = new StringBuffer();
        String filterString = ((CloudSearch.Query) this.a).getFilterString();
        String filterNumString = ((CloudSearch.Query) this.a).getFilterNumString();
        stringBuffer.append(filterString);
        if (!i.a(filterString) && !i.a(filterNumString)) {
            stringBuffer.append(FocusType.SPLIT_AND);
        }
        stringBuffer.append(filterNumString);
        return stringBuffer.toString();
    }
}
