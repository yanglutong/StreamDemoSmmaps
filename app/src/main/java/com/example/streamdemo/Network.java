package com.example.streamdemo;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;


import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;



/*请求网络数据类*/
public class Network {
 
    //上下文
    private Context mContext;
    //请求的url
    private String       mUrl;
    //通过单例类得到的OkHttpClient 对象
    private OkHttpClient mClient;
    //解析服务器返回数据的Gson
    private Gson mGson;
    private Handler mHandler;
    //登录之后返回的Token字符串
    private String       mToken;
 
    public Network(Context context, String url) {
        this.mContext = context;
        this.mUrl = url;
        mClient = OkHttpClientInstance.getInstance();
        mGson = new Gson();
        mHandler = new Handler();
        //获取Token的方式可以在进入程序时获取，存为全局变量
//        mToken = SPUtil.getString(context, SPUtil.LOGIN_TOKEN, "");
    }
 
    /**
     * 执行普通的post请求，参数集合全部转为json
     *
//     * @param map  传入的参数集合
     * @param netCallBack  回调接口
     */
    public void performPost(HashMap<Object, Object> map,final NetCallBack netCallBack) {
//        map.put("x", "1cc-0-31FB-4E40-0");
//        map.put("x", "1cc-0-4E40-4E40-0");
        map.put("p", "1");
        map.put("mt", "2");
        //将map转为字符串
        String params = mGson.toJson(map);
        //设置Content-Type数据格式
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, params);





        final Request request = new Request.Builder()
                .url(mUrl)
//                .addHeader("Authorization", "Bearer" + mToken)
                .post(body)
                .build();
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                netCallBack.onNetFailure(e.getMessage());
//                doFailure(netCallBack);
            }
 
            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                netCallBack.onSuccess(response.body().string());
//                doResponse(response, netCallBack);
            }
        });
    }
    /**
     * 执行普通的post请求，参数集合全部转为json
     *
//     * @param map  传入的参数集合
     * @param netCallBack  回调接口
     */
    public void performget(final NetCallBack netCallBack) {
        final Request request = new Request.Builder()
                .url(mUrl)
                .get()
                .build();
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                netCallBack.onNetFailure(e.getMessage());
//                doFailure(netCallBack);
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                netCallBack.onSuccess(response.body().string());
//                doResponse(response, netCallBack);
            }
        });
    }
 
 
    /**
     * post上传图片，全部转为json上传
     *
     * @param params  参数集合
     * @param picturePathList  图片的路径集合
     * @param netCallBack  回调接口
     */
//    public void upLoadPicture(Map<Object, Object> params, List<String> picturePathList, final NetCallBack netCallBack) {
//
//        List<PictureFileBean> fileList = new ArrayList<>();
//
//        //处理图片
//        for (int i = 0; i < picturePathList.size(); i++) {
//            File file = new File(picturePathList.get(i));
//            PictureFileBean fileBean = new PictureFileBean();
//            try {
//                //压缩图片
//                File compressedFile = new Compressor(mContext).compressToFile(file);
//                //把图片转为base64
//                String base64String = ImageToBase64.GetImageStr(compressedFile);
//                //拼接图片集合
//                fileBean.setPicFile(base64String);
//                fileBean.setPicType("JPEG");
//                fileList.add(fileBean);
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        params.put("file", fileList);
//        String json = mGson.toJson(params);
//        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
//        RequestBody requestBody = RequestBody.create(JSON, json);
//
//        final Request request = new Request.Builder()
//                .url(mUrl)
//                .addHeader("Authorization", "Bearer" + mToken)
//                .post(requestBody)
//                .build();
//
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mClient.newCall(request).enqueue(new Callback() {
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//                        doFailure(netCallBack);
//                    }
//
//                    @Override
//                    public void onResponse(Call call, final Response response) throws IOException {
//                        doResponse(response, netCallBack);
//                    }
//                });
//            }
//        }, 200);
//    }
 
//     /**
//     * 处理失败
//     *
//     * @param netCallBack
//     */
//    private void doFailure(final NetCallBack netCallBack) {
//        mHandler.post(new Runnable() {
//            @Override
//            public void run() {
//                netCallBack.onNetFailure();
//            }
//        });
//    }
//
//    /**
//     * 处理成功
//     *
//     * @param response
//     * @param netCallBack
//     * @throws IOException
//     */
//    private void doResponse(Response response, final NetCallBack netCallBack) throws IOException {
//        final String result = response.body().string();
//        if (!TextUtils.isEmpty(result)) {
//            try {
//                JSONObject jsonObject = new JSONObject(result);
//                String success = jsonObject.getString("success");
//
//                if ("true".equals(success)) {
//                    mHandler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            netCallBack.onSuccess(result);
//                        }
//                    });
//                } else if ("false".equals(success)) {
//                    mHandler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            netCallBack.onError(result);
//                        }
//                    });
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        //服务器返回错误
//                        netCallBack.onError(result);
//                    }
//                });
//            }
//        }
//    }
//
 
   /**
     * 回调接口
     */
    public interface NetCallBack {

 
        //网络请求成功
        void onSuccess(String result);

       void onNetFailure(String message);
   }
}