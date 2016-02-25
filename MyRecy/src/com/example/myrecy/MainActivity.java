package com.example.myrecy;

import java.util.ArrayList;

import com.example.library.MyViewPager;
import com.example.library.StickyNavLayout;
import com.gxz.PagerSlidingTabStrip;
import com.gxz.PagerSlidingTabStrip.OnClickGon;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{

	PagerSlidingTabStrip pagerSlidingTabStrip;
	MyViewPager viewPager;
    StickyNavLayout stickyNavLayout;
    ArrayList<String> list;
    RecycleViewAdapter radapter,radapter1,radapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_stick);
        pagerSlidingTabStrip=(PagerSlidingTabStrip) findViewById(R.id.id_stickynavlayout_indicator);
        viewPager=(MyViewPager) findViewById(R.id.id_stickynavlayout_viewpager);
        stickyNavLayout=(StickyNavLayout) findViewById(R.id.id_stick);
        
        stickyNavLayout.setOnStickStateChangeListener(onStickStateChangeListener);
        
        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("RecycleView----item-->>>>" + i);
        }

        radapter=new RecycleViewAdapter(list);
        radapter1=new RecycleViewAdapter(list);
        radapter2=new RecycleViewAdapter(list);
        ArrayList<BaseFragmentRe> fragments = new ArrayList<>();
        fragments.add(RecycleViewFragment.newInstance(radapter));
        fragments.add(RecycleViewFragment1.newInstance(radapter));
        fragments.add(RecycleViewFragment2.newInstance(radapter));
        FragmentsViewPagerAdapter adapter = new FragmentsViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        pagerSlidingTabStrip.setViewPager(viewPager);
        pagerSlidingTabStrip.setOnPageChangeListener(mPageChangeListener);
        pagerSlidingTabStrip.setOnClickGon(new OnClickGon() {
			
			@Override
			public void OnChang() {
				// TODO Auto-generated method stub
				stickyNavLayout.beginScroll();
			}
		});
    }

    private ViewPager.OnPageChangeListener mPageChangeListener = new ViewPager.SimpleOnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }

        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            Log.e("MyRecycleView", "当前的坐标是:"+position);
            if(position==2){
            	list.clear();
            	list.add("哈哈哈哈哈哈哈哈");
            	radapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
        }
    };

    private boolean lastIsTopHidden;//记录上次是否悬浮
    private StickyNavLayout.onStickStateChangeListener onStickStateChangeListener = new StickyNavLayout.onStickStateChangeListener() {
        @Override
        public void isStick(boolean isStick) {
            if (lastIsTopHidden != isStick) {
                lastIsTopHidden = isStick;
//                if (isStick) {
//                    Toast.makeText(MainActivity.this, "本宝宝悬浮了", Toast.LENGTH_LONG).show();
//                } else {
//                    Toast.makeText(MainActivity.this, "本宝宝又不悬浮了", Toast.LENGTH_LONG).show();
//                }
            }
        }

        @Override
        public void scrollPercent(float percent) {
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}