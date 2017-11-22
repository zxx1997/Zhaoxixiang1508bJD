package test.bwie.com.zhaoxixiang1508bjd.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import test.bwie.com.zhaoxixiang1508bjd.R;

/**
 * Created by admin on 2017/11/07/007.
 */

public class AddDel extends LinearLayout{
    private int count =1;
    private TextView num;
    private OnItemClick onItemClick;

    public interface OnItemClick {
        void onItemAddClick(int count);

        void onItemDelClick(int count);
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public AddDel(Context context) {
        super(context);
    }
    public AddDel(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.add_del,this);
        TextView add=findViewById(R.id.goods_add);
        TextView del=findViewById(R.id.goods_del);
        num=findViewById(R.id.goods_num);
        add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                num.setText(++count+"");
                //onItemClick.onItemAddClick(1);
            }
        });
        del.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count!=1){
                    count=--count;
                    // onItemClick.onItemDelClick(-1);
                }
                num.setText(count>=1?count+"":1+"");
            }
        });
    }
    /**
     * 获取商品数量
     *
     * @return
     */
    public int getCount() {
        return count;
    }

    public void setCount() {
        count = 1;
        num.setText(count + "");

    }
}
