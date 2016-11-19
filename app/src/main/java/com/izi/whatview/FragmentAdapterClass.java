package com.izi.whatview;

/**
 * Created by KENNY on 18/11/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Alumno-JG on 31/10/2016.
 */
public class FragmentAdapterClass extends FragmentStatePagerAdapter{
    int CountTab;
    public FragmentAdapterClass(FragmentManager fm,int CountTabs) {
        super(fm);
        this.CountTab=CountTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                PerfilFragment perfilFragment=new PerfilFragment();

                return perfilFragment;
            case 1:
                HomeFragment homeFragment=new HomeFragment();

                return homeFragment;
            case 2:
                FavoriteFragment favoriteFragment=new FavoriteFragment();

                return favoriteFragment;
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return CountTab;
    }
}
