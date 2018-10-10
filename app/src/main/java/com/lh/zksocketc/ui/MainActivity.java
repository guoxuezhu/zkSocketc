package com.lh.zksocketc.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.Toast;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.R;
import com.lh.zksocketc.utils.ELog;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {


    @BindView(R.id.cb_lock)
    CheckBox cb_lock;

    private Socket clientSocket;
    private PrintWriter out;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        openClientThread();
        initView();


    }


    private void openClientThread() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (clientSocket == null || clientSocket.isClosed()) {
                    createlientSocket();
                } else {
                    ELog.d("=======心跳=========网络检测=======socket=====");
                }
            }
        }, 1, 5000);

    }

    private void createlientSocket() {
        try {
            clientSocket = new Socket(MyApplication.prefs.getZKIP(), Integer.parseInt(MyApplication.prefs.getZKPORT()));
            if (clientSocket != null) {
                out = new PrintWriter(clientSocket.getOutputStream());
            }
        } catch (ConnectException e) {
            ELog.e("==========createlientSocket============ConnectException====");
            e.printStackTrace();
        } catch (IOException e) {
            ELog.e("==========createlientSocket============IOException====");
            e.printStackTrace();
        }
    }

    private void initView() {


    }


    @OnClick(R.id.cb_lock)
    public void cb_lock() {
        if (cb_lock.isChecked()) {
            Toast.makeText(this, "锁定", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "解锁", Toast.LENGTH_SHORT).show();
        }
        sendMsg(1);
    }

    @OnClick(R.id.cb_shangke)
    public void cb_shangke() {
        Toast.makeText(this, "上课", Toast.LENGTH_SHORT).show();
        sendMsg(2);
    }

    @OnClick(R.id.cb_xiuxi)
    public void cb_xiuxi() {
        Toast.makeText(this, "课间休息", Toast.LENGTH_SHORT).show();
        sendMsg(3);
    }

    @OnClick(R.id.cb_xiake)
    public void cb_xiake() {
        Toast.makeText(this, "下课", Toast.LENGTH_SHORT).show();
        sendMsg(4);
    }

    @OnClick(R.id.cb_monitor1)
    public void cb_monitor1() {
        Toast.makeText(this, "开显示器", Toast.LENGTH_SHORT).show();
        sendMsg(5);
    }

    private void stop() {
        try {
            if (clientSocket != null) {
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (out != null) {
            out.close();
        }
    }


    private void sendMsg(final int tyep) {
        new Thread() {
            @Override
            public void run() {
                if (clientSocket != null) {
                    if (tyep == 1) {
                        out.print("锁定" + "\n");
                    } else if (tyep == 2) {
                        out.print("上课" + "\n");
                    } else if (tyep == 3) {
                        out.print("课间休息" + "\n");
                    } else if (tyep == 4) {
                        out.print("下课" + "\n");
                    } else if (tyep == 5) {
                        out.print("开显示器" + "\n");
                    } else if (tyep == 6) {
                        out.print("开显示器2" + "\n");
                    }
                    out.flush();
                } else {
                    ELog.i("======网络连接已断开，请重新连接=====");
                }
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stop();
    }
}
