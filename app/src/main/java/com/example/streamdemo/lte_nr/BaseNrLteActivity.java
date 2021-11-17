package com.example.streamdemo.lte_nr;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.location.Utils.MyViewPager;
import com.example.streamdemo.nr_lte_cdma_gsm_info.GijFragment;
import com.example.streamdemo.R;


import java.util.ArrayList;

public class BaseNrLteActivity extends AppCompatActivity {

    private MyViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_nr_lte);
//        setStatBar();
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }


        LinearLayout mTab = findViewById(R.id.tab);
        TextView sim1 = mTab.findViewById(R.id.sim1);
        TextView sim2 = mTab.findViewById(R.id.sim2);
        sim2.setBackground(null);
        mVp = findViewById(R.id.vp);
        ImageView finsh = findViewById(R.id.finsh);
        finsh.setOnClickListener(v -> {
            finish();
        });
            setTab(sim1, sim2);
    }



    /*双卡 第一条为4G*/
    private void setTab(TextView s1, TextView s2) {
        //这里的TabLayout数据较多，用集合存储
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(GijFragment.newInstance(0));
        fragments.add(GijFragment.newInstance(1));
        //定义适配器与绑定
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), fragments);
        mVp.setAdapter(adapter);
        s1.setTextColor(Color.parseColor("#01E6FC"));
        s2.setTextColor(Color.parseColor("#000000"));
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    s1.setBackground(getDrawable(R.mipmap.base_nr_tab));
                    s2.setBackground(null);
                }
                s1.setTextColor(Color.parseColor("#01E6FC"));
                s2.setTextColor(Color.parseColor("#000000"));

                mVp.setCurrentItem(0);
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    s2.setBackground(getDrawable(R.mipmap.base_nr_tab));
                    s1.setBackground(null);
                }
                s2.setTextColor(Color.parseColor("#01E6FC"));
                s1.setTextColor(Color.parseColor("#000000"));

                mVp.setCurrentItem(1);
            }
        });
        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                    if(position==0){
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            s1.setBackground(getDrawable(R.mipmap.base_nr_tab));
                            s2.setBackground(null);
                        }
                        s1.setTextColor(Color.parseColor("#01E6FC"));
                        s2.setTextColor(Color.parseColor("#000000"));
                    }else if(position==1){
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            s2.setBackground(getDrawable(R.mipmap.base_nr_tab));
                            s1.setBackground(null);
                        }
                        s2.setTextColor(Color.parseColor("#01E6FC"));
                        s1.setTextColor(Color.parseColor("#000000"));
                    }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mVp.setCurrentItem(0);
    }

    @SuppressLint("NewApi")
    public void setStatBar() {//根据版本设置沉浸式状态栏
        View decorView = getWindow().getDecorView();
        int option =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(option);
        getWindow().setStatusBarColor(Color.TRANSPARENT
        );
    }
}