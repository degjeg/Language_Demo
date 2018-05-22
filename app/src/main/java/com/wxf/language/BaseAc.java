package com.wxf.language;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Locale;


public class BaseAc extends AppCompatActivity {

    public static String locale;
    public String myLocale = locale;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // EventBus.getDefault().register(this);
        // changeAppLanguage(locale);
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateLanguageIfNeeded();
    }

    protected void updateLanguageIfNeeded() {
        if (!TextUtils.equals(myLocale, locale)) {
            changeAppLanguage(locale);
            recreate(); // 刷新界面
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(String str) {
        /*switch (str) {
            case "EVENT_REFRESH_LANGUAGE":
                changeAppLanguage();
                recreate();//刷新界面
                break;
        }*/
    }


    public void changeAppLanguage(String locale) {
        if (TextUtils.equals(this.myLocale, locale)) {
            return;
        }

        this.myLocale = locale;
        if (!TextUtils.isEmpty(locale)) {
            // 本地语言设置
            Locale myLocale = new Locale(locale);
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = myLocale;
            res.updateConfiguration(conf, dm);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // EventBus.getDefault().unregister(this);
    }
}
