package test.bwie.com.zhaoxixiang1508bjd.adapter;


import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import test.bwie.com.zhaoxixiang1508bjd.Bean.DeleteCartBean;
import test.bwie.com.zhaoxixiang1508bjd.Bean.GetCartBean;
import test.bwie.com.zhaoxixiang1508bjd.R;
import test.bwie.com.zhaoxixiang1508bjd.eventbus.MessageCountEvent;
import test.bwie.com.zhaoxixiang1508bjd.eventbus.MessageEvent;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.Api;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.GsonObjectCallback;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.OkHttp3Utils;

/**
 * Created by admin on 2017/11/10/010.
 */

public class GetCartAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<GetCartBean.DataBean> list;
    private int count, price;

    public GetCartAdapter(Context context, List<GetCartBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return list.get(i).getList().size();
    }

    @Override
    public Object getGroup(int i) {
        return list.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return list.get(i).getList().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        GroupViewHolder holder = new GroupViewHolder();

        GetCartBean.DataBean bean = list.get(i);
        view = View.inflate(context, R.layout.get_cart_item, null);
        holder.cb = view.findViewById(R.id.get_cart_cb_fu);
        holder.name = view.findViewById(R.id.get_cart_fu_tv);
        holder.cb.setChecked(bean.isCheck());
        holder.name.setText(bean.getSellerName());

        holder.cb.setOnClickListener(new GroupCbOnClick(i));
        return view;
    }

    @Override
    public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup) {

        ChildViewHolder holder = new ChildViewHolder();
        view = View.inflate(context, R.layout.get_cart_child_item, null);
        holder.cb = view.findViewById(R.id.get_cart_child_cb);
        holder.sdv = view.findViewById(R.id.get_cart_child_sdv);
        holder.name = view.findViewById(R.id.get_cart_child_name);
        holder.price = view.findViewById(R.id.get_cart_child_price);
        holder.num = view.findViewById(R.id.get_cart_child_num);
        holder.delete = view.findViewById(R.id.get_cart_child_delete);
        GetCartBean.DataBean.ListBean bean = list.get(i).getList().get(i1);
        // holder.cb.setChecked(bean.isCheck());
        String s = bean.getImages();
        String[] img = null;
        img = s.split("\\|");
        Uri uri = Uri.parse(img[0]);
        holder.cb.setChecked(bean.isCheck());
        holder.sdv.setImageURI(uri);
        holder.name.setText(bean.getTitle());
        holder.price.setText(bean.getPrice() + "");
        holder.num.setText(bean.getNum() + "");

        holder.cb.setOnClickListener(new ChildCbOnClick(i, i1));

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, "删除", Toast.LENGTH_LONG).show();
                String uid = context.getSharedPreferences("user", Context.MODE_PRIVATE).getString("uid", null);
                String token = context.getSharedPreferences("user", Context.MODE_PRIVATE).getString("token", null);
                String pid = list.get(i).getList().get(i1).getPid() + "";

                Map<String, String> map = new HashMap<String, String>();
                map.put("uid", uid);
                map.put("pid", pid);
                map.put("token", token);

                OkHttp3Utils.doPost(Api.DELETE_CART, map, new GsonObjectCallback<DeleteCartBean>() {
                    @Override
                    public void onUi(DeleteCartBean deleteCartBean) {
                        Toast.makeText(context, deleteCartBean.getMsg(), Toast.LENGTH_LONG).show();
                        list.get(i).getList().remove(i1);
                        notifyDataSetChanged();
                        if (list.get(i).getList().size() == 0) {
                            list.remove(i);
                            notifyDataSetChanged();
                        }

                    }

                    @Override
                    public void onFailed(Call call, IOException e) {

                    }
                });

            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    class GroupViewHolder {
        CheckBox cb;
        TextView name;
    }

    class ChildViewHolder {
        CheckBox cb;
        SimpleDraweeView sdv;
        TextView name, price, num;
        Button delete;
    }

    class ChildCbOnClick implements View.OnClickListener {

        private int groupPosition;
        private int childPosition;

        public ChildCbOnClick(int groupPosition, int childPosition) {
            this.groupPosition = groupPosition;
            this.childPosition = childPosition;
        }

        @Override
        public void onClick(View view) {
            if (view instanceof CheckBox) {
                CheckBox cb = (CheckBox) view;
                List<GetCartBean.DataBean.ListBean> cBean = list.get(groupPosition).getList();
                GetCartBean.DataBean.ListBean bean = cBean.get(childPosition);
                bean.setCheck(cb.isChecked());

                MessageCountEvent messageCountEvent = new MessageCountEvent();
                messageCountEvent.setCount(totalCount());
                EventBus.getDefault().post(messageCountEvent);

                if (isChildChecked(cBean)) {
                    list.get(groupPosition).setCheck(true);
                    MessageEvent event = new MessageEvent();
                    event.setFlag(isGroupChecked());
                    EventBus.getDefault().post(event);
                    notifyDataSetChanged();
                } else {
                    list.get(groupPosition).setCheck(false);
                    MessageEvent event = new MessageEvent();
                    event.setFlag(false);
                    EventBus.getDefault().post(event);
                    notifyDataSetChanged();
                }
            }
        }
    }

    class GroupCbOnClick implements View.OnClickListener {

        private int groupPostion;

        public GroupCbOnClick(int groupPostion) {
            this.groupPostion = groupPostion;
        }

        @Override
        public void onClick(View view) {
            if (view instanceof CheckBox) {
                CheckBox cb = (CheckBox) view;

                list.get(groupPostion).setCheck(cb.isChecked());
                List<GetCartBean.DataBean.ListBean> listBeen = list.get(groupPostion).getList();
                for (GetCartBean.DataBean.ListBean bean : listBeen) {
                    bean.setCheck(cb.isChecked());
                }
                MessageCountEvent messageCountEvent = new MessageCountEvent();
                messageCountEvent.setCount(totalCount());
                EventBus.getDefault().post(messageCountEvent);

                MessageEvent event = new MessageEvent();
                event.setFlag(isGroupChecked());
                EventBus.getDefault().post(event);
                notifyDataSetChanged();
            }
        }
    }

    /**
     * 判断该商家的所有商品的checkbox是否都选中
     *
     * @return
     */
    private boolean isChildChecked(List<GetCartBean.DataBean.ListBean> bean) {
        for (int i = 0; i < bean.size(); i++) {
            GetCartBean.DataBean.ListBean b = bean.get(i);
            if (!b.isCheck()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断其它的商家是否选中
     *
     * @return
     */
    private boolean isGroupChecked() {
        for (GetCartBean.DataBean bean : list) {
            if (!bean.isCheck()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 主界面全选按钮的操作
     *
     * @param bool
     */
    public void allChecked(boolean bool) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setCheck(bool);
            for (int j = 0; j < list.get(i).getList().size(); j++) {
                list.get(i).getList().get(j).setCheck(bool);
            }
        }
        //计算选中的商品数，并发送到主界面进行显示
        MessageCountEvent msgCount = new MessageCountEvent();
        msgCount.setCount(totalCount());
        EventBus.getDefault().post(msgCount);
        notifyDataSetChanged();
    }

    private int totalCount() {
        count = 0;
        price = 0;
        List<GetCartBean.DataBean> dataBeen = list;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getList().size(); j++) {
                if (list.get(i).getList().get(j).isCheck()) {
                    //遍历所有的商品，只要是选中状态的，就加1
                    count++;
                    price += list.get(i).getList().get(j).getPrice()*list.get(i).getList().get(j).getNum();
                }
            }
        }

        return price;
    }
}
