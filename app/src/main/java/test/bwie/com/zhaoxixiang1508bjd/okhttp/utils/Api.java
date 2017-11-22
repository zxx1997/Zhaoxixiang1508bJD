package test.bwie.com.zhaoxixiang1508bjd.okhttp.utils;

/**
 * Created by admin on 2017/11/02/002.
 */

public interface Api {

    public static final String IP="https://www.zhaoapi.cn";
    public static final String Reg=IP+"/user/reg";
    public static final String Login=IP+"/user/login";
    public static final String USERINFO=IP+"/user/getUserInfo";
    public static final String CLASS=IP+"/product/getCatagory";
    public static final String CLASS_CHILD=IP+"/product/getProductCatagory";
    public static final String SHOP_DETAIL=IP+"/product/getProductDetail";
    public static final String SHOP_LIST=IP+"/product/getProducts";
    public static final String ADD_CART=IP+"/product/addCart";
    public static final String GET_CART=IP+"/product/getCarts";
    public static final String UPDATE_CART=IP+"/product/updateCarts";
    public static final String DELETE_CART=IP+"/product/deleteCart";
    public static final String ADD_ADRESS=IP+"/user/addAddr";
    public static final String GET_ADRESS=IP+"/user/getAddrs";
    public static final String SET_ADRESS=IP+"/user/setAddr";
    public static final String ADD_ORDER=IP+"/product/createOrder";
    public static final String GET_ORDER=IP+"/product/getOrders";
}
