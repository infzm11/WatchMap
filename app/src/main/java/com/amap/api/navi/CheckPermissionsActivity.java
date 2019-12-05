package com.amap.api.navi;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;

public class CheckPermissionsActivity extends Activity {
    private static final int PERMISSON_REQUESTCODE = 0;
    private boolean isNeedCheck = true;
    protected String[] needPermissions = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE"};

    /* access modifiers changed from: protected */
    public void onResume() {
        try {
            super.onResume();
            if (Build.VERSION.SDK_INT >= 23 && this.isNeedCheck) {
                checkPermissions(this.needPermissions);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @TargetApi(23)
    private void checkPermissions(String... strArr) {
        try {
            if (Build.VERSION.SDK_INT >= 23 && getApplicationInfo().targetSdkVersion >= 23) {
                List<String> findDeniedPermissions = findDeniedPermissions(strArr);
                if (findDeniedPermissions != null && findDeniedPermissions.size() > 0) {
                    try {
                        getClass().getMethod("requestPermissions", new Class[]{String[].class, Integer.TYPE}).invoke(this, new Object[]{(String[]) findDeniedPermissions.toArray(new String[findDeniedPermissions.size()]), 0});
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @TargetApi(23)
    private List<String> findDeniedPermissions(String[] strArr) {
        try {
            ArrayList arrayList = new ArrayList();
            if (Build.VERSION.SDK_INT >= 23 && getApplicationInfo().targetSdkVersion >= 23) {
                for (String str : strArr) {
                    if (checkMySelfPermission(str) != 0 || shouldShowMyRequestPermissionRationale(str)) {
                        arrayList.add(str);
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private int checkMySelfPermission(String str) {
        try {
            return ((Integer) getClass().getMethod("checkSelfPermission", new Class[]{String.class}).invoke(this, new Object[]{str})).intValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    private boolean shouldShowMyRequestPermissionRationale(String str) {
        try {
            return ((Boolean) getClass().getMethod("shouldShowRequestPermissionRationale", new Class[]{String.class}).invoke(this, new Object[]{str})).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean verifyPermissions(int[] iArr) {
        try {
            for (int i : iArr) {
                if (i != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        try {
            if (Build.VERSION.SDK_INT >= 23 && i == 0 && !verifyPermissions(iArr)) {
                showMissingPermissionDialog();
                this.isNeedCheck = false;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void showMissingPermissionDialog() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("提示");
            builder.setMessage("当前应用缺少必要权限。\\n\\n请点击\\\"设置\\\"-\\\"权限\\\"-打开所需权限");
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    try {
                        CheckPermissionsActivity.this.finish();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    try {
                        CheckPermissionsActivity.this.startAppSettings();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            builder.setCancelable(false);
            builder.show();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void startAppSettings() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
