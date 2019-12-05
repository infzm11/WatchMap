package com.amap.api.col.n3;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: PluginContext */
public final class hr extends ContextThemeWrapper {
    private static final String[] d = {"android.widget", "android.webkit", "android.app"};
    private Resources a = hs.a();
    private LayoutInflater b;
    private ClassLoader c;
    private a e = new a();
    private LayoutInflater.Factory f = new LayoutInflater.Factory() {
        public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
            "name:" + str;
            return hr.this.a(str, context, attributeSet);
        }
    };

    /* compiled from: PluginContext */
    public class a {
        public HashSet<String> a = new HashSet<>();
        public HashMap<String, Constructor<?>> b = new HashMap<>();

        public a() {
        }
    }

    public hr(Context context, ClassLoader classLoader) {
        super(context, 0);
        this.c = classLoader;
        "classloader:" + this.c;
    }

    public final Resources getResources() {
        if (this.a != null) {
            return this.a;
        }
        return super.getResources();
    }

    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return super.getSystemService(str);
        }
        if (this.b == null) {
            this.b = ((LayoutInflater) super.getSystemService(str)).cloneInContext(this);
            this.b.setFactory(this.f);
            this.b = this.b.cloneInContext(this);
        }
        return this.b;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008a A[SYNTHETIC, Splitter:B:36:0x008a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View a(java.lang.String r13, android.content.Context r14, android.util.AttributeSet r15) {
        /*
            r12 = this;
            com.amap.api.col.n3.hr$a r0 = r12.e
            java.util.HashSet<java.lang.String> r0 = r0.a
            boolean r0 = r0.contains(r13)
            r1 = 0
            if (r0 == 0) goto L_0x000c
            return r1
        L_0x000c:
            com.amap.api.col.n3.hr$a r0 = r12.e
            java.util.HashMap<java.lang.String, java.lang.reflect.Constructor<?>> r0 = r0.b
            java.lang.Object r0 = r0.get(r13)
            java.lang.reflect.Constructor r0 = (java.lang.reflect.Constructor) r0
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x00b6
            java.lang.String r5 = "api.navi"
            boolean r5 = r13.contains(r5)     // Catch:{ Throwable -> 0x006c }
            if (r5 == 0) goto L_0x002a
            java.lang.ClassLoader r5 = r12.c     // Catch:{ Throwable -> 0x006c }
            java.lang.Class r5 = r5.loadClass(r13)     // Catch:{ Throwable -> 0x006c }
            goto L_0x0052
        L_0x002a:
            java.lang.String[] r5 = d     // Catch:{ Throwable -> 0x006c }
            int r6 = r5.length     // Catch:{ Throwable -> 0x006c }
            r7 = r4
        L_0x002e:
            if (r7 >= r6) goto L_0x0051
            r8 = r5[r7]     // Catch:{ Throwable -> 0x006c }
            java.lang.ClassLoader r9 = r12.c     // Catch:{ Throwable -> 0x004e }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x004e }
            r10.<init>()     // Catch:{ Throwable -> 0x004e }
            r10.append(r8)     // Catch:{ Throwable -> 0x004e }
            java.lang.String r8 = "."
            r10.append(r8)     // Catch:{ Throwable -> 0x004e }
            r10.append(r13)     // Catch:{ Throwable -> 0x004e }
            java.lang.String r8 = r10.toString()     // Catch:{ Throwable -> 0x004e }
            java.lang.Class r8 = r9.loadClass(r8)     // Catch:{ Throwable -> 0x004e }
            r5 = r8
            goto L_0x0052
        L_0x004e:
            int r7 = r7 + 1
            goto L_0x002e
        L_0x0051:
            r5 = r1
        L_0x0052:
            if (r5 != 0) goto L_0x0055
            goto L_0x006a
        L_0x0055:
            java.lang.Class<android.view.ViewStub> r6 = android.view.ViewStub.class
            if (r5 == r6) goto L_0x006a
            java.lang.ClassLoader r6 = r5.getClassLoader()     // Catch:{ Throwable -> 0x0065 }
            java.lang.ClassLoader r7 = r12.c     // Catch:{ Throwable -> 0x0065 }
            if (r6 == r7) goto L_0x0062
            goto L_0x006a
        L_0x0062:
            r6 = r5
            r5 = r3
            goto L_0x0080
        L_0x0065:
            r6 = move-exception
            r11 = r6
            r6 = r5
            r5 = r11
            goto L_0x006e
        L_0x006a:
            r6 = r5
            goto L_0x007f
        L_0x006c:
            r5 = move-exception
            r6 = r1
        L_0x006e:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "load view err:"
            r7.<init>(r8)
            java.lang.String r5 = android.util.Log.getStackTraceString(r5)
            r7.append(r5)
            r7.toString()
        L_0x007f:
            r5 = r4
        L_0x0080:
            if (r5 != 0) goto L_0x008a
            com.amap.api.col.n3.hr$a r14 = r12.e
            java.util.HashSet<java.lang.String> r14 = r14.a
            r14.add(r13)
            return r1
        L_0x008a:
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ Throwable -> 0x00a4 }
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r5[r4] = r7     // Catch:{ Throwable -> 0x00a4 }
            java.lang.Class<android.util.AttributeSet> r7 = android.util.AttributeSet.class
            r5[r3] = r7     // Catch:{ Throwable -> 0x00a4 }
            java.lang.reflect.Constructor r5 = r6.getConstructor(r5)     // Catch:{ Throwable -> 0x00a4 }
            com.amap.api.col.n3.hr$a r0 = r12.e     // Catch:{ Throwable -> 0x00a1 }
            java.util.HashMap<java.lang.String, java.lang.reflect.Constructor<?>> r0 = r0.b     // Catch:{ Throwable -> 0x00a1 }
            r0.put(r13, r5)     // Catch:{ Throwable -> 0x00a1 }
            r0 = r5
            goto L_0x00b6
        L_0x00a1:
            r13 = move-exception
            r0 = r5
            goto L_0x00a5
        L_0x00a4:
            r13 = move-exception
        L_0x00a5:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "create view err:"
            r5.<init>(r6)
            java.lang.String r13 = android.util.Log.getStackTraceString(r13)
            r5.append(r13)
            r5.toString()
        L_0x00b6:
            java.lang.Object[] r13 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x00c3 }
            r13[r4] = r14     // Catch:{ Throwable -> 0x00c3 }
            r13[r3] = r15     // Catch:{ Throwable -> 0x00c3 }
            java.lang.Object r13 = r0.newInstance(r13)     // Catch:{ Throwable -> 0x00c3 }
            android.view.View r13 = (android.view.View) r13     // Catch:{ Throwable -> 0x00c3 }
            return r13
        L_0x00c3:
            r13 = move-exception
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r15 = "create view err:"
            r14.<init>(r15)
            java.lang.String r13 = android.util.Log.getStackTraceString(r13)
            r14.append(r13)
            r14.toString()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.hr.a(java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }
}
