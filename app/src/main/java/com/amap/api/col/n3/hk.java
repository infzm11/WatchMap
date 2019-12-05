package com.amap.api.col.n3;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.android.hoinnet.highde.R;

/* compiled from: LoadingFragment */
public final class hk extends DialogFragment {
    private Animation a;

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawableResource(17170445);
        View a2 = hs.a(getActivity(), R.attr.actionBarWidgetTheme, (ViewGroup) null);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.a = rotateAnimation;
        this.a.setRepeatCount(-1);
        this.a.setInterpolator(new LinearInterpolator());
        this.a.setDuration(2000);
        this.a.setRepeatCount(-1);
        ((ImageView) a2.findViewById(2131296330)).startAnimation(this.a);
        dialog.setContentView(a2);
        dialog.setCancelable(false);
        return dialog;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.a != null) {
            this.a.cancel();
        }
    }
}
