package com.wxf.language;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public class MainActivity extends BaseAc {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        locale = Store.getLanguageLocal(this);
        changeAppLanguage(locale);

        setContentView(R.layout.activity_main);
        setTitle("第一个Activity");
        findViewById(R.id.btn_setting1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingAc.class));
            }
        });

        String fragmentName = TestFragment.class.getName();
        if (null == getSupportFragmentManager().findFragmentByTag(fragmentName)) {
            Fragment f = TestFragment.instantiate(this, fragmentName);
            getSupportFragmentManager().beginTransaction().add(R.id.container, f, fragmentName).commitAllowingStateLoss();
        }

    }
}
