package com.lh.zksocketc.utils;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.data.DbDao.IcCardNumerDao;
import com.lh.zksocketc.data.model.IcCardNumer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtil {


    public static void getCards(String url) {
        OkHttpClient okHttpClient = new OkHttpClient();
        //2.创建Request对象，设置一个url地址（百度地址）,设置请求方式。
        Request request = new Request.Builder()
                .url("https://smart.rovemaker.com/api/school/menu")
//                .url(url)
                .build();
        //3.创建一个call对象,参数就是Request请求对象
        Call call = okHttpClient.newCall(request);
        //4.请求加入调度，重写回调方法
        call.enqueue(new Callback() {
            //请求失败执行的方法
            @Override
            public void onFailure(Call call, IOException e) {

            }

            //请求成功执行的方法
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseText = response.body().string();
                ELog.e("==========数据=======" + responseText);
                try {
                    JSONObject jsonObject = new JSONObject(responseText);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    IcCardNumerDao icCardNumerDao = MyApplication.getDaoSession().getIcCardNumerDao();
                    icCardNumerDao.deleteAll();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        String IcCardNumer = jsonArray.getJSONObject(i).get("value").toString();
                        icCardNumerDao.insert(new IcCardNumer(IcCardNumer));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });


    }


}