package com.amap.api.navi;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import com.amap.api.col.n3.fu;
import com.amap.api.col.n3.fy;
import com.amap.api.col.n3.fz;
import com.amap.api.col.n3.ge;
import com.amap.api.col.n3.gf;
import com.amap.api.col.n3.gg;
import com.amap.api.col.n3.hk;
import com.amap.api.col.n3.hs;

public class AmapRouteActivity extends CheckPermissionsActivity implements View.OnClickListener {
    private static final int PAGE_STACK_LENGTH = 32;
    private static int pageStackLength;
    private fu currentModule;
    private fy currentPage;
    public Handler handler = new Handler() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                try {
                    AmapRouteActivity.this.newScr(new fy(3, (Bundle) null));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    };
    private ge naviPage;
    private fy[] pageStack = new fy[32];
    private int pageStackTop = -1;
    private gf routePage;
    private gg searchPage;
    private fz searchResult = new fz();

    public Handler getHandler() {
        return this.handler;
    }

    public fz getSearchResult() {
        return this.searchResult;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            getWindow().setSoftInputMode(32);
            requestWindowFeature(1);
            hs.a(getApplicationContext());
            getWindow().setFormat(-3);
            this.pageStackTop = -1;
            boolean z = false;
            pageStackLength = 0;
            Bundle bundleExtra = getIntent().getBundleExtra("data");
            if (bundleExtra != null) {
                bundleExtra.putInt("from", 4);
                z = bundleExtra.getBoolean(AmapNaviPage.PAGE_TYPE, false);
            }
            if (z) {
                newScr(new fy(2, bundleExtra));
            } else {
                newScr(new fy(1, bundleExtra));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void showScr() {
        try {
            setContentView(this.currentModule.d());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void switchScr(fy fyVar) {
        try {
            if (this.currentModule != null) {
                this.currentModule.e();
                this.currentModule = null;
            }
            this.currentModule = creator(fyVar);
            if (this.currentModule != null) {
                this.currentPage = fyVar;
                this.currentModule.a(this);
                this.currentModule.a(this.currentPage.b);
                fu fuVar = this.currentModule;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void newScr(fy fyVar) {
        try {
            pageStackLength++;
            switchScr(fyVar);
            this.pageStackTop = (this.pageStackTop + 1) % 32;
            this.pageStack[this.pageStackTop] = fyVar;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private fu creator(fy fyVar) {
        try {
            switch (fyVar.a) {
                case 1:
                    if (this.routePage == null) {
                        this.routePage = new gf();
                    }
                    return this.routePage;
                case 2:
                    if (this.naviPage == null) {
                        this.naviPage = new ge();
                    }
                    return this.naviPage;
                case 3:
                    if (this.searchPage == null) {
                        this.searchPage = new gg();
                    }
                    return this.searchPage;
                default:
                    return null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        try {
            super.onStart();
            if (this.currentModule != null) {
                fu fuVar = this.currentModule;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        try {
            super.onResume();
            if (this.currentModule != null) {
                this.currentModule.f();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        try {
            super.onPause();
            if (this.currentModule != null) {
                this.currentModule.h();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        try {
            super.onStop();
            if (this.currentModule != null) {
                this.currentModule.g();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void showLoadingDialog() {
        try {
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getFragmentManager().findFragmentByTag("loadingFragment");
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
            hk hkVar = new hk();
            hkVar.setCancelable(false);
            hkVar.show(getFragmentManager(), "loadingFragment");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void removeLoadingDialog() {
        try {
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getFragmentManager().findFragmentByTag("loadingFragment");
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
            beginTransaction.commit();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void closeScr() {
        try {
            if (!backScr((Bundle) null)) {
                if (this.currentModule != null) {
                    this.currentModule.e();
                }
                finish();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void closeScr(Bundle bundle) {
        try {
            if (!backScr(bundle)) {
                if (this.currentModule != null) {
                    this.currentModule.e();
                }
                finish();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean backScr(Bundle bundle) {
        try {
            if ((pageStackLength != 1 || this.currentModule == null) && pageStackLength > 1) {
                pageStackLength--;
                this.pageStackTop = ((this.pageStackTop - 1) + 32) % 32;
                fy fyVar = this.pageStack[this.pageStackTop];
                fyVar.b = bundle;
                switchScr(fyVar);
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            super.onDestroy();
            if (this.currentModule != null) {
                this.currentModule.e();
                this.currentModule = null;
            }
            this.currentPage = null;
            this.pageStack = null;
            if (this.routePage != null) {
                this.routePage.e();
                this.routePage = null;
            }
            if (this.naviPage != null) {
                this.naviPage.e();
                this.naviPage = null;
            }
            if (this.searchPage != null) {
                this.searchPage.e();
                this.searchPage = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onClick(View view) {
        try {
            if (this.currentModule != null) {
                this.currentModule.a(view);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            try {
                if (this.currentModule != null && !this.currentModule.a()) {
                    return true;
                }
                if (backScr((Bundle) null)) {
                    return false;
                }
                if (keyEvent == null) {
                    if (pageStackLength == 1) {
                        finish();
                    }
                    return false;
                }
                this.pageStackTop = -1;
                pageStackLength = 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }
}
