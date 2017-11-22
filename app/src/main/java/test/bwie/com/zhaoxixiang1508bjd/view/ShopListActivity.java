package test.bwie.com.zhaoxixiang1508bjd.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import test.bwie.com.zhaoxixiang1508bjd.Bean.ShopListBean;
import test.bwie.com.zhaoxixiang1508bjd.R;
import test.bwie.com.zhaoxixiang1508bjd.adapter.ShopListAdapter;
import test.bwie.com.zhaoxixiang1508bjd.presenter.shoplist.ShopListPresenter;
import test.bwie.com.zhaoxixiang1508bjd.view.listener.ShopListView;

public class ShopListActivity extends AppCompatActivity implements ShopListView{

    private RecyclerView shopListRlv;
    private String pscid;
    private List<ShopListBean.DataBean> list=new ArrayList<>();
    private ShopListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);

        initView();
    }

    private void initView() {
        shopListRlv = (RecyclerView) findViewById(R.id.shop_list_rlv);
        shopListRlv.setLayoutManager(new LinearLayoutManager(this));
        Intent intent=getIntent();

        pscid=intent.getStringExtra("pscid");
        //String i=pscid;
        ShopListPresenter presenter=new ShopListPresenter(this);
        presenter.get();
    }

    @Override
    public String getPscid() {
        return pscid;
    }

    @Override
    public void getData(ShopListBean bean) {
        list=bean.getData();
        adapter=new ShopListAdapter(this,list);
        shopListRlv.setAdapter(adapter);
        adapter.setOnItem(new ShopListAdapter.OnItemClick() {
            @Override
            public void onItem(ShopListBean.DataBean bean) {
                int i=bean.getPid();
                String pid=i+"";
                Intent intent=new Intent(ShopListActivity.this,ShopDetailActivity.class);
                intent.putExtra("pid",pid);
                startActivity(intent);
            }
        });
    }
}
