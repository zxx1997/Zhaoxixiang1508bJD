package test.bwie.com.zhaoxixiang1508bjd.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import test.bwie.com.zhaoxixiang1508bjd.Bean.AddCartBean;
import test.bwie.com.zhaoxixiang1508bjd.Bean.BaseBean;
import test.bwie.com.zhaoxixiang1508bjd.Bean.ShopDetailBean;
import test.bwie.com.zhaoxixiang1508bjd.MainActivity;
import test.bwie.com.zhaoxixiang1508bjd.R;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.Api;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.GsonObjectCallback;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.OkHttp3Utils;
import test.bwie.com.zhaoxixiang1508bjd.presenter.AddCart.AddCartPresenter;
import test.bwie.com.zhaoxixiang1508bjd.presenter.shopdetail.ShopDetailPresenter;
import test.bwie.com.zhaoxixiang1508bjd.view.listener.ShopDetailView;

public class ShopDetailActivity extends AppCompatActivity implements ShopDetailView {

    private SimpleDraweeView shopDetailSdv;
    private TextView shopDetailTitle;
    private TextView shopDetailSubhead;
    private TextView shopDetailPrice;
    private TextView shopDetailSalenum;
    private TextView shopDetailAreaName;
    private TextView shopDetailContent;
    private TextView shopDetailStoreCn;
    private TextView shopDetailStoreName;
    private Button shopDetailShopping;
    private Button shopDetailAddCart;
    private String pid;
    private String uid;
    private String token;
    private AddCartPresenter addCartPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);

        initView();
        ShopDetailPresenter presenter = new ShopDetailPresenter(this);
        presenter.get();
        addCartPresenter = new AddCartPresenter(this);


    }

    @Override
    public String getPid() {
        return pid;
    }

    @Override
    public void getData(final ShopDetailBean bean) {
        String s = bean.getData().getImages();
        String [] img=null;
        img=s.split("\\|");
        Uri uri = Uri.parse(img[0]);
        shopDetailSdv.setImageURI(uri);
        shopDetailTitle.setText(bean.getData().getTitle());
        shopDetailSubhead.setText(bean.getData().getSubhead());
        shopDetailPrice.setText(bean.getData().getPrice() + "");
        shopDetailSalenum.setText(bean.getData().getSalenum() + "");
        shopDetailStoreName.setText(bean.getSeller().getName());
        shopDetailAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uid = getSharedPreferences("user", Context.MODE_PRIVATE).getString("uid", null);
                token=getSharedPreferences("user",Context.MODE_PRIVATE).getString("token",null);

                addCartPresenter.get();

            }
        });

        shopDetailShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String price=bean.getData().getPrice()+"";
                uid = getSharedPreferences("user", Context.MODE_PRIVATE).getString("uid", null);
                token=getSharedPreferences("user",Context.MODE_PRIVATE).getString("token",null);

                Map<String,String> map=new HashMap<String, String>();
                map.put("uid",uid);
                map.put("price",price);
                map.put("token",token);
                OkHttp3Utils.doPost(Api.ADD_ORDER, map, new GsonObjectCallback<BaseBean>() {
                    @Override
                    public void onUi(BaseBean baseBean) {
                        Toast.makeText(ShopDetailActivity.this,baseBean.getMsg(),Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(ShopDetailActivity.this,GetOrderActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {

                    }
                });
            }
        });
    }

    @Override
    public String getUid() {
        return uid;
    }

    @Override
    public String getSellerid() {
        return token;
    }

    @Override
    public void getDateCart(AddCartBean bean) {
        String str = bean.getMsg();
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
        showNormalDialog();
    }

    private void initView() {
        shopDetailSdv = (SimpleDraweeView) findViewById(R.id.shop_detail_sdv);
        shopDetailTitle = (TextView) findViewById(R.id.shop_detail_title);
        shopDetailSubhead = (TextView) findViewById(R.id.shop_detail_subhead);
        shopDetailPrice = (TextView) findViewById(R.id.shop_detail_price);
        shopDetailSalenum = (TextView) findViewById(R.id.shop_detail_salenum);
        shopDetailStoreName = (TextView) findViewById(R.id.shop_detail_store_name);
        shopDetailShopping = (Button) findViewById(R.id.shop_detail_shopping);
        shopDetailAddCart = (Button) findViewById(R.id.shop_detail_add_cart);
        Intent intent = getIntent();
        pid = intent.getStringExtra("pid");

    }

    private void showNormalDialog() {
    /* @setIcon 设置对话框图标
     * @setTitle 设置对话框标题
     * @setMessage 设置对话框消息提示
     * setXXX方法返回Dialog对象，因此可以链式设置属性
     */
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(ShopDetailActivity.this);
        normalDialog.setIcon(R.mipmap.ic_launcher_round);
        normalDialog.setTitle("已经加入购物车！");
        //normalDialog.setMessage("加入的商品："+list.getTitle().toString());
        normalDialog.setPositiveButton("继续看看",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                        dialog.dismiss();
                    }
                });
        normalDialog.setNegativeButton("去购物车",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                        Intent show = new Intent(ShopDetailActivity.this, MainActivity.class);

                        show.putExtra("id", 2);
                        startActivity(show);
                        finish();

                    }
                });
        // 显示
        normalDialog.show();
    }

}
