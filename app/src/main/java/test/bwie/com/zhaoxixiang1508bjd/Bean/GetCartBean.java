package test.bwie.com.zhaoxixiang1508bjd.Bean;

import java.util.List;

/**
 * Created by admin on 2017/11/10/010.
 */

public class GetCartBean extends BaseBean{

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * list : [{"bargainPrice":5599,"createtime":"2017-10-10T17:30:32","detailUrl":"https://item.m.jd.com/product/4824715.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends","images":"https://m.360buyimg.com/n12/jfs/t7768/184/1153704394/148460/f42e1432/599a930fN8a85626b.jpg!q70.jpg","num":4,"pid":59,"price":5599,"pscid":40,"selected":0,"sellerid":3,"subhead":"游戏本选择4G独显，拒绝掉帧】升级版IPS全高清防眩光显示屏，WASD方向键颜色加持，三大出风口立体散热！","title":"戴尔DELL灵越游匣15PR-6648B GTX1050 15.6英寸游戏笔记本电脑(i5-7300HQ 8G 128GSSD+1T 4G独显 IPS)黑"},{"bargainPrice":1599,"createtime":"2017-10-14T21:48:08","detailUrl":"https://item.m.jd.com/product/1993026402.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t5863/302/8961270302/97126/41feade1/5981c81cNc1b1fbef.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7003/250/1488538438/195825/53bf31ba/5981c57eN51e95176.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5665/100/8954482513/43454/418611a9/5981c57eNd5fc97ba.jpg!q70.jpg","num":1,"pid":47,"price":111,"pscid":39,"selected":0,"sellerid":3,"subhead":"碳黑色 32GB 全网通 官方标配   1件","title":"锤子 坚果Pro 特别版 巧克力色 酒红色 全网通 移动联通电信4G手机 双卡双待 碳黑色 32GB 全网通"}]
         * sellerName : 商家3
         * sellerid : 3
         */

        private String sellerName;
        private String sellerid;
        private List<ListBean> list;
        private boolean check;

        public boolean isCheck() {
            return check;
        }

        public void setCheck(boolean check) {
            this.check = check;
        }

        public String getSellerName() {
            return sellerName;
        }

        public void setSellerName(String sellerName) {
            this.sellerName = sellerName;
        }

        public String getSellerid() {
            return sellerid;
        }

        public void setSellerid(String sellerid) {
            this.sellerid = sellerid;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * bargainPrice : 5599
             * createtime : 2017-10-10T17:30:32
             * detailUrl : https://item.m.jd.com/product/4824715.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends
             * images : https://m.360buyimg.com/n12/jfs/t7768/184/1153704394/148460/f42e1432/599a930fN8a85626b.jpg!q70.jpg
             * num : 4
             * pid : 59
             * price : 5599
             * pscid : 40
             * selected : 0
             * sellerid : 3
             * subhead : 游戏本选择4G独显，拒绝掉帧】升级版IPS全高清防眩光显示屏，WASD方向键颜色加持，三大出风口立体散热！
             * title : 戴尔DELL灵越游匣15PR-6648B GTX1050 15.6英寸游戏笔记本电脑(i5-7300HQ 8G 128GSSD+1T 4G独显 IPS)黑
             */

            private int bargainPrice;
            private String createtime;
            private String detailUrl;
            private String images;
            private int num;
            private int pid;
            private int price;
            private int pscid;
            private int selected;
            private int sellerid;
            private String subhead;
            private String title;
            private boolean check;

            public boolean isCheck() {
                return check;
            }

            public void setCheck(boolean check) {
                this.check = check;
            }

            public int getBargainPrice() {
                return bargainPrice;
            }

            public void setBargainPrice(int bargainPrice) {
                this.bargainPrice = bargainPrice;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getDetailUrl() {
                return detailUrl;
            }

            public void setDetailUrl(String detailUrl) {
                this.detailUrl = detailUrl;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public int getPid() {
                return pid;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getPscid() {
                return pscid;
            }

            public void setPscid(int pscid) {
                this.pscid = pscid;
            }

            public int getSelected() {
                return selected;
            }

            public void setSelected(int selected) {
                this.selected = selected;
            }

            public int getSellerid() {
                return sellerid;
            }

            public void setSellerid(int sellerid) {
                this.sellerid = sellerid;
            }

            public String getSubhead() {
                return subhead;
            }

            public void setSubhead(String subhead) {
                this.subhead = subhead;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
