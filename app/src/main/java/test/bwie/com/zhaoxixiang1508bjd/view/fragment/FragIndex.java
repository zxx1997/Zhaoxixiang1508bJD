package test.bwie.com.zhaoxixiang1508bjd.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import test.bwie.com.zhaoxixiang1508bjd.R;

/**
 * Created by admin on 2017/11/01/001.
 */

public class FragIndex extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=LayoutInflater.from(getActivity()).inflate(R.layout.frag_index,container,false);


        return view;
    }
}
