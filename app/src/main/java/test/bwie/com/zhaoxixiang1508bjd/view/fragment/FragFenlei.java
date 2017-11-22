package test.bwie.com.zhaoxixiang1508bjd.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

import test.bwie.com.zhaoxixiang1508bjd.Bean.ClassLeftBean;
import test.bwie.com.zhaoxixiang1508bjd.Bean.ClassRightBean;
import test.bwie.com.zhaoxixiang1508bjd.R;
import test.bwie.com.zhaoxixiang1508bjd.adapter.fenlei.ClassLeftAdapter;
import test.bwie.com.zhaoxixiang1508bjd.adapter.fenlei.ClassRightAdapter;
import test.bwie.com.zhaoxixiang1508bjd.presenter.fenlei.ClassLeftPresenter;
import test.bwie.com.zhaoxixiang1508bjd.presenter.fenlei.ClassRightPresenter;
import test.bwie.com.zhaoxixiang1508bjd.view.listener.ClassView;

/**
 * Created by admin on 2017/11/01/001.
 */

public class FragFenlei extends Fragment implements ClassView{

    private RecyclerView classRlv;
    private RecyclerView classChildRlv;
    private List<ClassLeftBean.DataBean> leftlist=new ArrayList<>();
    private ClassLeftAdapter adapterLeft;
    private ClassRightAdapter adapterRight;
    private String cid;
    private ClassRightPresenter rightPresenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Fresco.initialize(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.frag_fenlei, container, false);

        classRlv = (RecyclerView)view.findViewById(R.id.class_rlv);
        classChildRlv = (RecyclerView) view.findViewById(R.id.class_child_rlv);

        classRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        classChildRlv.setLayoutManager(new LinearLayoutManager(getActivity()));

        ClassLeftPresenter presenterLeft=new ClassLeftPresenter(this);
        rightPresenter=new ClassRightPresenter(this);
        presenterLeft.get();

        return view;
    }


    @Override
    public void getDataLeft(ClassLeftBean bean) {
        leftlist=bean.getData();
        adapterLeft=new ClassLeftAdapter(getActivity(),leftlist);
        classRlv.setAdapter(adapterLeft);
        adapterLeft.setOnItemList(new ClassLeftAdapter.OnItemList() {
            @Override
            public void onItem(ClassLeftBean.DataBean bean) {
                cid=bean.getCid()+"";
                rightPresenter.get();
            }
        });
    }

    @Override
    public void getDataRight(ClassRightBean bean) {
        adapterRight=new ClassRightAdapter(getActivity(),bean.getData());
        classChildRlv.setAdapter(adapterRight);

    }

    @Override
    public String getCid() {
        return cid;
    }
}
