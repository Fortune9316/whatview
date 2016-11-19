package com.izi.whatview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by KENNY on 18/11/2016.
 */

public class PerfilFragment extends Fragment{
    public  PerfilFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_perfil,container,false);

        return rootView;
    }
}
