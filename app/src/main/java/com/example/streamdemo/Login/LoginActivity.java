package com.example.streamdemo.Login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.InputType;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;

import com.blankj.utilcode.util.NetworkUtils;
import com.example.MainActivity;
import com.example.http.HttpRequestCallback;
import com.example.http.HttpUtils;
import com.example.location.Utils.DeviceIdUtil;
import com.example.location.Utils.DtUtils;
import com.example.location.Utils.MyToast;
import com.example.location.Utils.ViewLoading;
import com.example.streamdemo.Const;
import com.example.streamdemo.R;
import com.example.streamdemo.register.RegisterActivity;
import com.google.gson.Gson;
import com.mylhyl.circledialog.CircleDialog;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class LoginActivity extends FragmentActivity implements View.OnClickListener {
    private EditText et_user, et_pwd;
    private ImageView iv_show;
    private Button bt_login;
    private boolean showaBoolean = false;
    private TextView tv_version;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
                String str= (String) msg.obj;
                ViewLoading.dismiss(LoginActivity.this);//隐藏加载窗
                if(TextUtils.isEmpty(str)){
                    MyToast.showToast("登录失败");
                }else{
                    loginSuccessBean json = new Gson().fromJson(str, loginSuccessBean.class);
                    if(json.getCode()==200){
                        Log.i("yltffff", "handleMessage: "+json.toString()+"---"+address);
                        if(json.getData().getMacAddress().equals(address)){
                            //保存登录成功后的用户名密码
                            SharedPreferences preferences = getSharedPreferences("setting", MODE_PRIVATE);
                            SharedPreferences.Editor edit = preferences.edit();
                            edit.putString("user", et_user.getText().toString());
                            edit.putString("pwd", et_pwd.getText().toString());
                            edit.commit();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                            MyToast.showToast("登录成功");
                        }else{
                            MyToast.showToast("请使用绑定手机登录");
                        }
                    }else if(json.getCode()==400&&json.getMsg().equals("该手机机器码为空")){
                        new CircleDialog.Builder()
                        .setTitle("")
                        .setText("用户未绑定本手机,需要绑定本手机吗?")
                        .setTitleColor(Color.parseColor("#00acff"))
                        .setNegative("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                                intent.putExtra("user", et_user.getText().toString());
                                intent.putExtra("pwd", et_pwd.getText().toString());
                                startActivity(intent);
                            }
                        })
                        .setPositive("取消", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
//                                Toast.makeText(LoginActivity.this, "取消", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setWidth(0.7f).setMaxHeight(0.5f).show(getSupportFragmentManager());
                    }else{
                        MyToast.showToast(json.getMsg());
                    }
                }
            }
        }
    };
    private String address;

    private void setUser_pwd() {
        SharedPreferences userSettings = getSharedPreferences("setting", 0);
        String data = userSettings.getString("nameData", "");
        String user = userSettings.getString("user", "");
        String pwd = userSettings.getString("pwd", "");
        et_user.setText(user);
        et_pwd.setText(pwd);
//        String appVersionName = AppUtils.getAppVersionName();//获取版本名字
        tv_version.setText("有效期:" + data + "");
    }

    @SuppressLint("NewApi")
    public void setStatBar() {//根据版本设置沉浸式状态栏
        View decorView = getWindow().getDecorView();
        int option =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(option);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
    }

    private void findViews() {
        et_user = findViewById(R.id.et_user);
        et_pwd = findViewById(R.id.et_pwd);
        iv_show = findViewById(R.id.iv_show);
        iv_show.setOnClickListener(this);
        bt_login = findViewById(R.id.bt_login);
        bt_login.setOnClickListener(this);
        et_pwd.setOnClickListener(this);
        tv_version = findViewById(R.id.tv_version);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login2);
        setStatBar();
        findViews();
        setUser_pwd();//默认保存上次的用户日期和账号密码
    }

    @Override
    protected void onResume() {
        super.onResume();
        getUserData();
    }

    private void getUserData() {
        if(tv_version!=null){
            tv_version.setText("有效期:");
        }
        //首先获取Mac地址
        String macAddress = null;
        macAddress=   DtUtils.getMacAddress(this);
        if(TextUtils.isEmpty(macAddress)||macAddress.equals("02:00:00:00:00:00")){
            macAddress= DeviceIdUtil.getDeviceId(this);
        }
        Log.i("yltttt", "getUserData: "+macAddress);
        HttpUtils.getInstance().executePathGet(this, Const.loginMacYXQ+macAddress, Const.loginMacYXQi, new HttpRequestCallback() {
            @Override
            public void onRequestNetFail(int type) {//网络错误
                Log.e("ylt", "onRequestNetFail: "+type);
            }

            @Override
            public void onRequestSuccess(String result, int type) {
                Log.e("ylt", "onRequestSuccess: "+result+type);
                if(!TextUtils.isEmpty(result)){
                    LoginMACBean bean = new Gson().fromJson(result, LoginMACBean.class);
                    if(bean.getCode()==200){
                        String[] s = bean.getData().getEndTime().split(" ");
                        SharedPreferences pf = getSharedPreferences("setting", MODE_PRIVATE);
                        SharedPreferences.Editor edit = pf.edit();
                                edit.putString("nameData",s[0]);
                                edit.commit();
                        if(tv_version!=null){
                            tv_version.setText("有效期:" + s[0] + "");
                        }
                    }
                }
            }

            @Override
            public void onRequestFail(String value, int type) {
                Log.e("ylt", "onRequestFail: "+value+type);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.et_pwd:

                break;
            case R.id.iv_show:
//                Toast.makeText(LoginActivity.this, "你点击了展示密码功能", Toast.LENGTH_LONG).show();
                if (showaBoolean == false) {
                    showaBoolean = true;
                    iv_show.setImageResource(R.mipmap.yanjing);
                    et_pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    et_pwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else if (showaBoolean == true) {
                    showaBoolean = false;
                    iv_show.setImageResource(R.mipmap.showpassword);
                    et_pwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }


                break;
            case R.id.bt_login:
                if (!NetworkUtils.isAvailableByPing()) {
                   MyToast.showToast("网络不可用");
                    return;
                }
                Login();//登陆功能
                break;
        }
    }

    private void Login() {
        address = null;
        address = DtUtils.getMacAddress(this);
        if(TextUtils.isEmpty(address)|| address.equals("02:00:00:00:00:00")){
            address = DeviceIdUtil.getDeviceId(this);
        }
        String et_user1 = et_user.getText().toString();
        String et_pwd1 = et_pwd.getText().toString();
        if(TextUtils.isEmpty(et_user1)){
            MyToast.showToast("请输入用户名");
            return;
        }
        if(TextUtils.isEmpty(et_pwd1)){
            MyToast.showToast("请输入密码");
            return;
        }
        if(TextUtils.isEmpty(address)|| address.equals("02:00:00:00:00:00")){
            MyToast.showToast("获取不到本手机mac地址");
            return;
        }
        //请求登录接口
        ViewLoading.show(LoginActivity.this, "正在登录");
        getDatas(et_user1, et_pwd1, address, new onNetWork() {
            @Override
            public void getData(String msg) {
                Message message = new Message();
                        message.what=1;
                        message.obj=msg;
                        handler.sendMessage(message);
            }
        });
    }
    private void getDatas(String user, String pwd, String address, onNetWork network){
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //通过FormBody对象构建Builder来添加表单参数
        FormBody mFormBody = new FormBody.Builder()
                .add("username",user)
                .add("password",pwd)
//                .add("macaddress",address)
                .build();

        Request mRequest = new Request.Builder()
                .url("http://39.107.141.215:8088/app/login")
                .post(mFormBody)
                .build();

        mOkHttpClient.newCall(mRequest).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull okhttp3.Call call, @NotNull IOException e) {
                //响应失败
                Log.e("TAG", "onResponse: "+e.getMessage());
                network.getData("");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull okhttp3.Response response) throws IOException {
                Log.i("ylt", "getData: "+Thread.currentThread());
                network.getData(response.body().string());
            }
        });

    }
    interface onNetWork{
        void getData(String msg);
    }
}

