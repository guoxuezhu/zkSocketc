package com.lh.zksocketc.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.data.DbDao.IcCardNumerDao;
import com.lh.zksocketc.data.model.HttpData;
import com.lh.zksocketc.data.model.HttpRow;
import com.lh.zksocketc.data.model.IcCardNumer;

import java.io.IOException;
import java.util.List;

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
                .url(url + "/api/get_ic_card_list")
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
                Gson gson = new Gson();
                HttpData httpData = gson.fromJson(responseText, HttpData.class);
                ELog.e("==========IcCard==response=====" + httpData.toString());
                if (httpData.flag == 1) {
                    HttpData<HttpRow<List<IcCardNumer>>> httpRowHttpData = gson.fromJson(responseText, new TypeToken<HttpData<HttpRow<List<IcCardNumer>>>>() {
                    }.getType());
                    ELog.e("========IcCard==get=====" + httpRowHttpData);
                    IcCardNumerDao icCardNumerDao = MyApplication.getDaoSession().getIcCardNumerDao();
                    icCardNumerDao.deleteAll();
                    for (int i = 0; i < httpRowHttpData.getData().getRows().size(); i++) {
                        icCardNumerDao.update(httpRowHttpData.getData().getRows().get(i));
                    }

                } else {

                }
            }
        });


    }


}