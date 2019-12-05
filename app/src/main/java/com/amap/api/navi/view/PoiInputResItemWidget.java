package com.amap.api.navi.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.col.n3.hs;
import com.amap.api.maps.model.Poi;
import com.android.hoinnet.highde.R;

public class PoiInputResItemWidget extends RelativeLayout {
    private TextView mPoiTV;
    private ImageView mTypeNoinputIV;
    private TextView mTypeTV;

    public PoiInputResItemWidget(Context context) {
        super(context);
        init();
    }

    public PoiInputResItemWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PoiInputResItemWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        hs.a(getContext(), R.attr.actionModePasteDrawable, this);
        this.mTypeTV = (TextView) findViewById(2131296444);
        this.mPoiTV = (TextView) findViewById(2131296446);
        this.mTypeNoinputIV = (ImageView) findViewById(2131296447);
    }

    public void setPoi(int i, Poi poi) {
        setPoi(i, poi == null ? "" : poi.getName());
    }

    public void setPoi(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            this.mTypeNoinputIV.setVisibility(0);
            this.mTypeTV.setVisibility(8);
            this.mPoiTV.setTextColor(hs.a().getColor(R.color.accent_material_dark));
            if (i == 0) {
                this.mPoiTV.setText("输入起点");
            } else if (i == 1) {
                this.mPoiTV.setText("输入终点");
            }
        } else {
            this.mTypeNoinputIV.setVisibility(8);
            this.mTypeTV.setVisibility(0);
            this.mTypeTV.setText(getTypeStr(i));
            if (!TextUtils.isEmpty(str)) {
                this.mPoiTV.setText(str);
                this.mPoiTV.setTextColor(hs.a().getColor(R.color.accent_material_light));
            }
        }
    }

    private String getTypeStr(int i) {
        switch (i) {
            case 0:
                return hs.a().getString(R.drawable.abc_btn_radio_to_on_mtrl_000);
            case 1:
                return hs.a().getString(R.drawable.abc_btn_radio_to_on_mtrl_015);
            case 2:
                return hs.a().getString(R.drawable.abc_btn_switch_to_on_mtrl_00001);
            default:
                return "";
        }
    }
}
