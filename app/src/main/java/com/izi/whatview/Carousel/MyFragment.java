package com.izi.whatview.Carousel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.izi.whatview.HomeFragment;
import com.izi.whatview.R;

public class MyFragment extends Fragment {


    public static Fragment newInstance(HomeFragment context, int pos, float scale) {
        Bundle b = new Bundle();
        b.putInt("pos", pos);
        b.putFloat("scale", scale);
        return Fragment.instantiate(context.getActivity(), MyFragment.class.getName(), b);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        LinearLayout l = (LinearLayout) inflater.inflate(R.layout.swipe_layout, container, false);


        MyLinearLayout root = (MyLinearLayout) l.findViewById(R.id.root);
        float scale = this.getArguments().getFloat("scale");
        root.setScaleBoth(scale);



        return l;
    }
}
