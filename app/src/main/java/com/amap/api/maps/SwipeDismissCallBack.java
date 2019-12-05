package com.amap.api.maps;

import android.view.View;
import com.amap.api.maps.SwipeDismissTouchListener;

public class SwipeDismissCallBack implements SwipeDismissTouchListener.DismissCallbacks {
    SwipeDismissView a;

    public boolean canDismiss(Object obj) {
        return true;
    }

    public SwipeDismissCallBack(SwipeDismissView swipeDismissView) {
        this.a = swipeDismissView;
    }

    public void onDismiss(View view, Object obj) {
        if (this.a.onDismissCallback != null) {
            this.a.onDismissCallback.onDismiss();
        }
    }

    public void onNotifySwipe() {
        if (this.a.onDismissCallback != null) {
            this.a.onDismissCallback.onNotifySwipe();
        }
    }
}
