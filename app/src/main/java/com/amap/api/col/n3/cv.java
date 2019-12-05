package com.amap.api.col.n3;

import android.opengl.GLES20;

/* compiled from: GLShader */
public class cv {
    private boolean a;
    public int d;
    public int e;
    public int f;

    /* access modifiers changed from: protected */
    public final boolean a(String str) {
        String a2 = dc.a("amap_sdk_shaders/" + str);
        if (a2 == null) {
            throw new IllegalArgumentException("shader file not found: " + r5);
        }
        int indexOf = a2.indexOf(36);
        if (indexOf < 0 || a2.charAt(indexOf + 1) != '$') {
            throw new IllegalArgumentException("not a shader file " + r5);
        }
        this.d = a(a2.substring(0, indexOf), a2.substring(indexOf + 2));
        if (this.d != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final int b(String str) {
        return GLES20.glGetAttribLocation(this.d, str);
    }

    /* access modifiers changed from: protected */
    public final int c(String str) {
        return GLES20.glGetUniformLocation(this.d, str);
    }

    public final int a(String str, String str2) {
        this.e = a(35633, str);
        this.f = a(35632, str2);
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, this.e);
        GLES20.glAttachShader(glCreateProgram, this.f);
        GLES20.glLinkProgram(glCreateProgram);
        return glCreateProgram;
    }

    private static int a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    public final void a() {
        if (this.d >= 0) {
            GLES20.glDeleteProgram(this.d);
        }
        if (this.e >= 0) {
            GLES20.glDeleteShader(this.e);
        }
        if (this.f >= 0) {
            GLES20.glDeleteShader(this.f);
        }
        this.a = true;
    }

    public final boolean b() {
        return this.a;
    }
}
