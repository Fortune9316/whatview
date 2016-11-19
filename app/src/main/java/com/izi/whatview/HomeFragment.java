package com.izi.whatview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.app.AppCompatActivity;
import com.izi.whatview.Carousel.MyPagerAdapter;

/**
 * Created by Alumno-JG on 31/10/2016.
 */
public class HomeFragment extends Fragment {
    public HomeFragment(){}

    UiController uiController;

    public final static int PAGES = 5;
    // You can choose a bigger number for LOOPS, but you know, nobody will fling
    // more than 1000 times just in order to test your "infinite" ViewPager :D
    public final static int LOOPS = 1000;
    public final static int FIRST_PAGE = PAGES * LOOPS / 2;

    public MyPagerAdapter adapter;
    public ViewPager pager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_home,container,false);

        uiController = new UiController();
        uiController.HideUiBars(getActivity().getWindow());

        pager = (ViewPager) rootView.findViewById(R.id.vpgHome);

        adapter = new MyPagerAdapter(this,this.getActivity().getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.setPageTransformer(false, adapter);

        // Set current item to the middle page so we can fling to both
        // directions left and right
        pager.setCurrentItem(FIRST_PAGE);

        // Necessary or the pager will only have one extra page to show
        // make this at least however many pages you can see
        pager.setOffscreenPageLimit(3);



        return rootView;
    }

}
