package test.bwie.com.zhaoxixiang1508bjd.Bean;

import java.util.List;

/**
 * Created by admin on 2017/11/16/016.
 */

public class GetOrderBean extends BaseBean{

    /**
     * data : [{"createtime":"2017-11-16T15:30:52","orderid":1805,"price":13888,"status":0,"title":null,"uid":503}]
     * page : 1
     */

    private String page;
    private List<DataBean> data;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createtime : 2017-11-16T15:30:52
         * orderid : 1805
         * price : 13888
         * status : 0
         * title : null
         * uid : 503
         */

        private String createtime;
        private int orderid;
        private int price;
        private int status;
        private Object title;
        private int uid;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getOrderid() {
            return orderid;
        }

        public void setOrderid(int orderid) {
            this.orderid = orderid;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Object getTitle() {
            return title;
        }

        public void setTitle(Object title) {
            this.title = title;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }
    }
}
