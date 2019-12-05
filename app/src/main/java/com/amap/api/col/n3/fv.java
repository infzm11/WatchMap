package com.amap.api.col.n3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.col.n3.fx;
import com.android.hoinnet.highde.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: NaviGuideAdapter */
public final class fv extends BaseExpandableListAdapter {
    List<fx> a = new ArrayList();
    Context b = null;
    private int[] c = {2130837505, 2130837505, 2130837512, 2130837513, 2130837514, 2130837515, 2130837516, 2130837517, 2130837518, 2130837519, 2130837507, 2130837508, 2130837509, 2130837510, 2130837511, 2130837519};

    /* compiled from: NaviGuideAdapter */
    class a {
        ImageView a;
        TextView b;
        View c;

        a() {
        }
    }

    /* compiled from: NaviGuideAdapter */
    class b {
        ImageView a;
        TextView b;
        TextView c;
        TextView d;
        TextView e;
        ImageView f;
        View g;

        b() {
        }
    }

    public final long getChildId(int i, int i2) {
        return (long) i2;
    }

    public final long getGroupId(int i) {
        return (long) i;
    }

    public final boolean hasStableIds() {
        return false;
    }

    public final boolean isChildSelectable(int i, int i2) {
        return false;
    }

    public fv(Context context, List<fx> list) {
        this.b = context;
        this.a = list;
    }

    public final int getGroupCount() {
        return this.a.size();
    }

    public final int getChildrenCount(int i) {
        return this.a.get(i).a().size();
    }

    public final Object getGroup(int i) {
        return this.a.get(i);
    }

    public final Object getChild(int i, int i2) {
        return this.a.get(i).a().get(i2);
    }

    public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            try {
                bVar = new b();
                View a2 = hs.a(this.b, R.attr.actionLayout, (ViewGroup) null);
                try {
                    bVar.a = (ImageView) a2.findViewById(2131296355);
                    bVar.b = (TextView) a2.findViewById(2131296356);
                    bVar.c = (TextView) a2.findViewById(2131296357);
                    bVar.d = (TextView) a2.findViewById(2131296358);
                    bVar.e = (TextView) a2.findViewById(2131296360);
                    bVar.f = (ImageView) a2.findViewById(2131296359);
                    bVar.g = a2.findViewById(2131296354);
                    a2.setTag(bVar);
                    view = a2;
                } catch (Throwable unused) {
                    return a2;
                }
            } catch (Throwable unused2) {
                return view;
            }
        } else {
            bVar = (b) view.getTag();
        }
        fx fxVar = this.a.get(i);
        if (fxVar == null) {
            return view;
        }
        int e = fxVar.e();
        bVar.a.setBackgroundResource(a(e));
        bVar.c.setText(fxVar.b());
        if (e != -1) {
            if (e != -2) {
                bVar.b.setVisibility(8);
                bVar.d.setVisibility(8);
                bVar.e.setVisibility(0);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(hq.a(fxVar.c()));
                stringBuffer.append(" ");
                if (fxVar.d() > 0) {
                    stringBuffer.append("红绿灯");
                    stringBuffer.append(fxVar.d());
                    stringBuffer.append("个");
                }
                bVar.e.setText(stringBuffer.toString());
                bVar.f.setVisibility(0);
                if (z) {
                    bVar.f.setBackgroundResource(2130837756);
                    bVar.g.setVisibility(8);
                    return view;
                }
                bVar.f.setBackgroundResource(2130837555);
                bVar.g.setVisibility(0);
                return view;
            }
        }
        bVar.e.setVisibility(8);
        bVar.f.setVisibility(8);
        bVar.b.setVisibility(0);
        if (e == -1) {
            bVar.b.setText(this.b.getResources().getString(R.drawable.abc_btn_radio_to_on_mtrl_000));
            bVar.d.setVisibility(0);
            bVar.d.setText(this.b.getResources().getString(R.drawable.abc_cab_background_internal_bg));
            return view;
        }
        bVar.d.setVisibility(8);
        bVar.b.setText(this.b.getResources().getString(R.drawable.abc_cab_background_top_material));
        return view;
    }

    public final View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            try {
                aVar = new a();
                View a2 = hs.a(this.b, R.attr.actionDropDownStyle, (ViewGroup) null);
                try {
                    aVar.a = (ImageView) a2.findViewById(2131296352);
                    aVar.b = (TextView) a2.findViewById(2131296353);
                    aVar.c = a2.findViewById(2131296354);
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
        fx.a aVar2 = this.a.get(i).a().get(i2);
        if (aVar2 != null) {
            aVar.a.setBackgroundResource(a(aVar2.c()));
            Locale locale = Locale.CHINA;
            Object[] objArr = new Object[3];
            objArr[0] = hq.a(aVar2.b());
            int c2 = aVar2.c();
            String str = "";
            switch (c2) {
                case 2:
                    str = "左转";
                    break;
                case 3:
                    str = "右转";
                    break;
                case 4:
                    str = "向左前方转";
                    break;
                case 5:
                    str = "向右前方转";
                    break;
                case 6:
                    str = "向左后方行驶";
                    break;
                case 7:
                    str = "向右后方行驶";
                    break;
                case 8:
                    str = "左转调头";
                    break;
                case 9:
                    str = "直行";
                    break;
                case 10:
                    str = "到达途径点";
                    break;
                case 11:
                    str = "进入环岛";
                    break;
                case 12:
                    str = "驶出环岛";
                    break;
                default:
                    switch (c2) {
                        case 51:
                            str = "靠左";
                            break;
                        case 52:
                            str = "靠右";
                            break;
                    }
            }
            objArr[1] = str;
            objArr[2] = aVar2.a();
            aVar.b.setText(String.format(locale, "行驶%s%s进入%s", objArr));
        }
        if (z) {
            aVar.c.setVisibility(0);
            return view;
        }
        aVar.c.setVisibility(8);
        return view;
    }

    private int a(int i) {
        int i2;
        if (i >= 0) {
            if (i == 51) {
                return 2130837514;
            }
            if (i == 52) {
                return 2130837515;
            }
            if (i == 53) {
                return 2130837519;
            }
            try {
                i2 = this.c[i];
            } catch (Throwable unused) {
                return 2130837505;
            }
        } else if (i == -1) {
            i2 = 2130837521;
        } else if (i != -2) {
            return 2130837505;
        } else {
            i2 = 2130837520;
        }
        return i2;
    }
}
