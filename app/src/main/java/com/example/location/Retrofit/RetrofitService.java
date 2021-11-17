package com.example.location.Retrofit;





import com.example.location.Retrofit.Bean.JzDataQury;
import com.example.location.Retrofit.Bean.JzGetData;
import com.example.location.Utils.Bean.DownBean;
import com.example.streamdemo.bean.AppUpBean;
import com.example.streamdemo.register.RegisterBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**登录请求
 * Created by Administrator on 2018/1/29 0029.
 */

public interface RetrofitService {
    /**
     * 1.移动联通基站
     *
     * @param
     * @param
     * @param lac
     * @return
     */
    @POST(MyURL.UserLogin)
    retrofit2.Call<DataBean> GETBaseStation(@Query("mnc") int mnc, @Query("lac") int lac, @Query("ci") int ci, @Query("key") String key);
//
//    @POST(MyURL.UserAli)
//    retrofit2.Call<DataAliBean> GETBaseStationAli(@Query("mnc") int mnc, @Query("lac") int lac, @Query("cellid") int ci, @Header("Authorization") String appKey, @Header("Content-Type") String Content);
//
//
//    @POST(MyURL.UserAli)
//    retrofit2.Call<DataAliBean> GETBaseStationAliCdm(@Query("sid") int sid, @Query("nid") int nid, @Query("cellid") int ci, @Header("Authorization") String appKey, @Header("Content-Type") String Content);
//
//    //    登陆
//    @POST(MyURL.Login)
//    retrofit2.Call<LoginBena> login(@Query("userName") String userName, @Query("passWord") String passWord);
//
    //    App更新
    @POST(MyURL.DOWNLOAD)
    retrofit2.Call<DownBean> download(@Query("appId") String appId);

    //    App更新
    @GET(MyURL.AppDOWNLOAD)
    retrofit2.Call<AppUpBean> downloadUp(@Query("appId") int appId);
//
//    //    查询次数
//    @POST(MyURL.NUMBER)
//    retrofit2.Call<NumberBean> NUMBER(@Query("userId") String userId);
//
    //根据经纬度查询
    @POST(MyURL.SMJIZHAN)
    retrofit2.Call<JzGetData> JzData(@Query("business") String dwId,
                                     @Query("longitudeStart") String longitudeStart,//经度
                                     @Query("latitudeStart") String latitudeStart,//纬度
                                     @Query("longitudeEnd") String longitudeEnd,//经度
                                     @Query("latitudeEnd") String latitudeEnd);//纬度

    @FormUrlEncoded
    @POST(MyURL.BASESTATION)
    retrofit2.Call<RegisterBean> upMac(@Field("userName") String userName,//运营商
                                       @Field("macAddress") String macAddress
    );

}
