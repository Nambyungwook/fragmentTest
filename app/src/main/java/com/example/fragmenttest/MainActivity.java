package com.example.fragmenttest;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        Button btn_1 = (Button)findViewById(R.id.btn_1);
        Button btn_2 = (Button)findViewById(R.id.btn_2);
        Button btn_3 = (Button)findViewById(R.id.btn_3);

        viewPager.setAdapter(new viewPagerAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(0);

        View.OnClickListener movePageListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = (int)v.getTag();
                viewPager.setCurrentItem(tag);
            }
        };

        btn_1.setOnClickListener(movePageListener);
        btn_1.setTag(0);
        btn_2.setOnClickListener(movePageListener);
        btn_2.setTag(1);
        btn_3.setOnClickListener(movePageListener);
        btn_3.setTag(2);
    }

    private class viewPagerAdapter extends FragmentStatePagerAdapter {
        public viewPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return new Fragment_1();
                case 1:
                    return new Fragment_2();
                case 2:
                    return new Fragment_3();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
