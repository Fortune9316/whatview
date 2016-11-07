package com.izi.whatview;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.izi.whatview.Carousel.MyPagerAdapter;


public class HomeActivity extends AppCompatActivity {

    UiController uiController;

    public final static int PAGES = 5;
    // You can choose a bigger number for LOOPS, but you know, nobody will fling
    // more than 1000 times just in order to test your "infinite" ViewPager :D
    public final static int LOOPS = 1000;
    public final static int FIRST_PAGE = PAGES * LOOPS / 2;

    public MyPagerAdapter adapter;
    public ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        uiController = new UiController();
        uiController.HideUiBars(getWindow());

        pager = (ViewPager) findViewById(R.id.vpgHome);

        adapter = new MyPagerAdapter(this, this.getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.setPageTransformer(false, adapter);

        // Set current item to the middle page so we can fling to both
        // directions left and right
        pager.setCurrentItem(FIRST_PAGE);

        // Necessary or the pager will only have one extra page to show
        // make this at least however many pages you can see
        pager.setOffscreenPageLimit(3);

    }
}
