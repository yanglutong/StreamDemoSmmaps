package com.example.streamdemo.register;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
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

import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;

import com.blankj.utilcode.util.NetworkUtils;
import com.example.location.Retrofit.RetrofitFactory;
import com.example.location.Utils.DeviceIdUtil;
import com.example.location.Utils.DtUtils;
import com.example.location.Utils.MyToast;
import com.example.streamdemo.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends FragmentActivity implements View.OnClickListener {
    private static String TAG="RegisterActivity1";
    private EditText et_user, et_pwd;
    private ImageView iv_show;
    private Button bt_login,bt_back;
    private boolean showaBoolean = false;
    private TextView tv_version;

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
        bt_back = findViewById(R.id.bt_back);
        bt_back.setOnClickListener(this);
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
        setContentView(R.layout.activity_register);
        setStatBar();
        findViews();
        Intent intent = getIntent();
        String user = intent.getStringExtra("user");
        String pwd = intent.getStringExtra("pwd");
        if(!TextUtils.isEmpty(user)){
            et_user.setText(user);
        }
        if(!TextUtils.isEmpty(pwd)){
            et_pwd.setText(pwd);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_back:
                finish();
                break;
            case R.id.et_pwd:

                break;
            case R.id.iv_show:
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
        String address = null;
        address= DtUtils.getMacAddress(this);
        if(TextUtils.isEmpty(address)||address.equals("02:00:00:00:00:00")){
            address=DeviceIdUtil.getDeviceId(this);
        }
        Log.e(TAG, "Login: "+address);
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
        if(TextUtils.isEmpty(address)||address.equals("02:00:00:00:00:00")){
            MyToast.showToast("获取不到该手机码,请稍后重试");
            return;
        }
        //将该手机的机器码上传服务器进行注册
        Call<RegisterBean> call = RetrofitFactory.getInstence().API().upMac(et_user1, address);
        call.enqueue(new Callback<RegisterBean>() {
            @Override
            public void onResponse(Call<RegisterBean> call, Response<RegisterBean> response) {
                RegisterBean bean = response.body();
                String s = Md5Util.encrypt(et_pwd1);
                if(bean==null){
                    MyToast.showToast("不好意思绑定失败");
                    return;
                }
                if(bean.getCode()==200){
                    if(bean.getData().getPassWord().equals(s)){
                        //将用户有效期保存起来
                        SharedPreferences sf = getSharedPreferences("setting", MODE_PRIVATE);
                        SharedPreferences.Editor edit = sf.edit();
                        edit.putString("nameData", bean.getData().getEndTime());
                        edit.commit();
                        MyToast.showToast("绑定成功");
                        finish();
                    }else{
                        MyToast.showToast("密码错误");
                    }
                }else if(bean.getCode()==400){
                    MyToast.showToast(bean.getMsg());
                }
            }
            @Override
            public void onFailure(Call<RegisterBean> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
                MyToast.showToast("绑定失败");
            }
        });
    }
}

