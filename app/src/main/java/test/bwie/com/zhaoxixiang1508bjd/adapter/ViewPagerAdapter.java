package test.bwie.com.zhaoxixiang1508bjd.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import test.bwie.com.zhaoxixiang1508bjd.view.fragment.FragFaxian;
import test.bwie.com.zhaoxixiang1508bjd.view.fragment.FragFenlei;
import test.bwie.com.zhaoxixiang1508bjd.view.fragment.FragGouwuche;
import test.bwie.com.zhaoxixiang1508bjd.view.fragment.FragIndex;
import test.bwie.com.zhaoxixiang1508bjd.view.fragment.FragMyself;

/**
 * Created by admin on 2017/11/01/001.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter{

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch (position){
            case 0:
                fragment=new FragIndex();
                break;
            case 1:
                fragment=new FragFenlei();
                break;
            case 2:
                fragment=new FragFaxian();
                break;
            case 3:
                fragment=new FragGouwuche();
                break;
            case 4:
                fragment=new FragMyself();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
