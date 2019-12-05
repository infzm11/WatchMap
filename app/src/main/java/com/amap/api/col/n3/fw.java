package com.amap.api.col.n3;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.android.hoinnet.highde.R;
import java.util.List;

/* compiled from: SearchResultAdapter */
public final class fw extends BaseAdapter {
    private Context a;
    private List<he> b;

    /* compiled from: SearchResultAdapter */
    class a {
        TextView a;
        TextView b;

        a() {
        }
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public fw(Context context, List<he> list) {
        this.a = context;
        this.b = list;
    }

    public final int getCount() {
        if (this.b != null) {
            return this.b.size();
        }
        return 0;
    }

    public final Object getItem(int i) {
        if (this.b != null) {
            return this.b.get(i);
        }
        return null;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            try {
                aVar = new a();
                View a2 = hs.a(this.a, R.attr.actionModeCutDrawable, (ViewGroup) null);
                try {
                    aVar.a = (TextView) a2.findViewById(2131296442);
                    aVar.b = (TextView) a2.findViewById(2131296443);
                    a2.setTag(aVar);
                    view = a2;
                } catch (Throwable unused) {
                    return a2;
                }
            } catch (Throwable unused2) {
                return view;
            }
        } else {
            aVar = (a) view.getTag();
        }
        if (this.b == null) {
            return view;
        }
        aVar.a.setText(this.b.get(i).c());
        String d = this.b.get(i).d();
        if (TextUtils.isEmpty(d)) {
            aVar.b.setVisibility(8);
            return view;
        }
        aVar.b.setVisibility(0);
        aVar.b.setText(d);
        return view;
    }
}
