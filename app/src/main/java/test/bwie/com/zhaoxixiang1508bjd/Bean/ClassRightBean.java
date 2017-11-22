package test.bwie.com.zhaoxixiang1508bjd.Bean;

import java.util.List;

/**
 * Created by admin on 2017/11/03/003.
 */

public class ClassRightBean extends BaseBean{

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * cid : 2
         * list : [{"icon":"http://120.27.23.105/images/icon.png","name":"手机","pcid":6,"pscid":39},{"icon":"http://120.27.23.105/images/icon.png","name":"笔记本","pcid":6,"pscid":40},{"icon":"http://120.27.23.105/images/icon.png","name":"平板电脑","pcid":6,"pscid":41},{"icon":"http://120.27.23.105/images/icon.png","name":"游戏机","pcid":6,"pscid":42},{"icon":"http://120.27.23.105/images/icon.png","name":"摄影摄像","pcid":6,"pscid":43}]
         * name : 数码家电
         * pcid : 6
         */

        private String cid;
        private String name;
        private String pcid;
        private List<ListBean> list;

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPcid() {
            return pcid;
        }

        public void setPcid(String pcid) {
            this.pcid = pcid;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * icon : http://120.27.23.105/images/icon.png
             * name : 手机
             * pcid : 6
             * pscid : 39
             */

            private String icon;
            private String name;
            private int pcid;
            private int pscid;

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getPcid() {
                return pcid;
            }

            public void setPcid(int pcid) {
                this.pcid = pcid;
            }

            public int getPscid() {
                return pscid;
            }

            public void setPscid(int pscid) {
                this.pscid = pscid;
            }
        }
    }
}
