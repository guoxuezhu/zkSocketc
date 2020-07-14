package com.lh.zksocketc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import com.lh.zksocketc.R;
import com.lh.zksocketc.utils.DateUtil;
import com.lh.zksocketc.utils.ELog;
import com.lh.zksocketc.utils.SerialPortUtil;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {


    @BindView(R.id.time_tv_home)
    TextView time_tv_home;

    @BindView(R.id.spbtn_all_gpy)
    CheckBox spbtn_all_gpy;
    @BindView(R.id.spbtn_all_diannao)
    CheckBox spbtn_all_diannao;
    @BindView(R.id.spbtn_all_bjb_1)
    CheckBox spbtn_all_bjb_1;
    @BindView(R.id.spbtn_all_laoshi_diannao)
    CheckBox spbtn_all_laoshi_diannao;

    @BindView(R.id.lubo_luzhi_stop)
    CheckBox lubo_luzhi_stop;


    @BindView(R.id.zhuping_fuwei)
    RadioButton zhuping_fuwei;
    @BindView(R.id.sp_fen_ping)
    RadioButton sp_fen_ping;

    @BindView(R.id.sp_all_guangbo)
    CheckBox sp_all_guangbo;
    @BindView(R.id.sp_out_banshu)
    CheckBox sp_out_banshu;
    @BindView(R.id.sp_xz_1)
    CheckBox sp_xz_1;
    @BindView(R.id.sp_xz_2)
    CheckBox sp_xz_2;
    @BindView(R.id.sp_xz_3)
    CheckBox sp_xz_3;
    @BindView(R.id.sp_xz_4)
    CheckBox sp_xz_4;
    @BindView(R.id.sp_xz_5)
    CheckBox sp_xz_5;
    @BindView(R.id.sp_xz_6)
    CheckBox sp_xz_6;


    private int count = 0;
    private boolean isShangke = false;
    private Timer timeTimer;
    private Handler homeHander = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 326:
                    ELog.e("======HomeActivity====homeHander===326=====" + msg.obj.toString());
                    time_tv_home.setText(msg.obj.toString());
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        isShangke = false;

        tvgetTime();

    }

    private void tvgetTime() {
        stopTimeTimer();
        timeTimer = new Timer();
        timeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.obj = DateUtil.getNow();
                message.what = 326;
                homeHander.sendMessage(message);
            }
        }, 100,1000);
    }

    private void stopTimeTimer() {
        if (timeTimer != null) {
            timeTimer.cancel();
            timeTimer = null;
        }
    }

    @OnClick(R.id.spbtn_all_laoshi_diannao)
    public void spbtn_all_laoshi_diannao() {
        SerialPortUtil.sendMsg("VIDC1");
        spbtn_all_gpy.setChecked(false);
        spbtn_all_diannao.setChecked(false);
        spbtn_all_bjb_1.setChecked(false);
        spbtn_all_laoshi_diannao.setChecked(true);
    }

    @OnClick(R.id.spbtn_all_diannao)
    public void spbtn_all_diannao() {
        SerialPortUtil.sendMsg("VIDC2");
        spbtn_all_gpy.setChecked(false);
        spbtn_all_diannao.setChecked(true);
        spbtn_all_bjb_1.setChecked(false);
        spbtn_all_laoshi_diannao.setChecked(false);
    }

    @OnClick(R.id.spbtn_all_bjb_1)
    public void spbtn_all_bjb_1() {
        SerialPortUtil.sendMsg("VIDC3");
        spbtn_all_gpy.setChecked(false);
        spbtn_all_diannao.setChecked(false);
        spbtn_all_bjb_1.setChecked(true);
        spbtn_all_laoshi_diannao.setChecked(false);
    }

    @OnClick(R.id.spbtn_all_gpy)
    public void spbtn_all_gpy() {
        SerialPortUtil.sendMsg("VIDC4");
        spbtn_all_gpy.setChecked(true);
        spbtn_all_diannao.setChecked(false);
        spbtn_all_bjb_1.setChecked(false);
        spbtn_all_laoshi_diannao.setChecked(false);
    }






//    @OnClick(R.id.rbtn_fuwei)
//    public void rbtn_fuwei() {
//        SerialPortUtil.sendMsg("FWS0");
//    }


    @OnClick(R.id.rbtn_shangke)
    public void rbtn_shangke() {
        if (!isShangke) {
            SerialPortUtil.sendMsg("MBS1");
            isShangke = true;
        }
    }


    @OnClick(R.id.rbtn_xiake)
    public void rbtn_xiake() {
        SerialPortUtil.sendMsg("MBS2");
        isShangke = false;
        startActivity(new Intent(this, SplashActivity.class));
        finish();
    }


    @OnClick(R.id.rbtn_cl_open)
    public void rbtn_cl_open() {
        SerialPortUtil.sendMsg("MBS3");
    }

    @OnClick(R.id.rbtn_cl_close)
    public void rbtn_cl_close() {
        SerialPortUtil.sendMsg("MBS4");
    }

    @OnClick(R.id.rbtn_dg_open)
    public void rbtn_dg_open() {
        SerialPortUtil.sendMsg("MBS13");
    }

    @OnClick(R.id.rbtn_dg_close)
    public void rbtn_dg_close() {
        SerialPortUtil.sendMsg("MBS14");
    }

    @OnClick(R.id.btn_kt_open)
    public void btn_kt_open() {
        SerialPortUtil.sendMsg("MBS39");
    }

    @OnClick(R.id.btn_kt_close)
    public void btn_kt_close() {
        SerialPortUtil.sendMsg("MBS40");
    }

    @OnClick(R.id.btn_mj_pc)
    public void btn_mj_pc() {
        SerialPortUtil.sendMsg("MJD46");
    }

    @OnClick(R.id.rbtn_tyj_open)
    public void rbtn_tyj_open() {
        SerialPortUtil.sendMsg("MBS9");
    }

    @OnClick(R.id.rbtn_tyj_close)
    public void rbtn_tyj_close() {
        SerialPortUtil.sendMsg("MBS10");
    }


    @OnClick(R.id.lubo_luzhi_stop)
    public void lubo_luzhi_stop() {
        if (lubo_luzhi_stop.isChecked()) {
            SerialPortUtil.sendMsg("LUB1");
        } else {
            SerialPortUtil.sendMsg("LUB3");
        }
    }





    @OnClick(R.id.zhuping_fuwei)
    public void zhuping_fuwei() {
        SerialPortUtil.sendMsg("JZFFP1");
        sp_out_banshu.setChecked(false);
        sp_xz_1.setChecked(false);
        sp_xz_2.setChecked(false);
        sp_xz_3.setChecked(false);
        sp_xz_4.setChecked(false);
        sp_xz_5.setChecked(false);
        sp_xz_6.setChecked(false);
        sp_all_guangbo.setChecked(false);
    }

    @OnClick(R.id.sp_fen_ping)
    public void sp_fen_ping() {
        count = 0;
        SerialPortUtil.sendMsg("JZFFP2");
        sp_out_banshu.setChecked(false);
        sp_xz_1.setChecked(false);
        sp_xz_2.setChecked(false);
        sp_xz_3.setChecked(false);
        sp_xz_4.setChecked(false);
        sp_xz_5.setChecked(false);
        sp_xz_6.setChecked(false);
        sp_all_guangbo.setChecked(false);
    }


    @OnClick(R.id.sp_out_banshu)
    public void sp_out_banshu() {
        if (sp_fen_ping.isChecked()) {
            qiehuan(8);
        } else {
            SerialPortUtil.sendMsg("JZFAA8");
        }
        sp_out_banshu.setChecked(true);
        sp_xz_1.setChecked(false);
        sp_xz_2.setChecked(false);
        sp_xz_3.setChecked(false);
        sp_xz_4.setChecked(false);
        sp_xz_5.setChecked(false);
        sp_xz_6.setChecked(false);
        sp_all_guangbo.setChecked(false);
    }

    @OnClick(R.id.sp_xz_1)
    public void sp_xz_1() {
        if (sp_fen_ping.isChecked()) {
            qiehuan(2);
        } else {
            SerialPortUtil.sendMsg("JZFAA2");
        }
        sp_out_banshu.setChecked(false);
        sp_xz_1.setChecked(true);
        sp_xz_2.setChecked(false);
        sp_xz_3.setChecked(false);
        sp_xz_4.setChecked(false);
        sp_xz_5.setChecked(false);
        sp_xz_6.setChecked(false);
        sp_all_guangbo.setChecked(false);
    }

    @OnClick(R.id.sp_xz_2)
    public void sp_xz_2() {
        if (sp_fen_ping.isChecked()) {
            qiehuan(3);
        } else {
            SerialPortUtil.sendMsg("JZFAA3");
        }
        sp_out_banshu.setChecked(false);
        sp_xz_1.setChecked(false);
        sp_xz_2.setChecked(true);
        sp_xz_3.setChecked(false);
        sp_xz_4.setChecked(false);
        sp_xz_5.setChecked(false);
        sp_xz_6.setChecked(false);
        sp_all_guangbo.setChecked(false);
    }

    @OnClick(R.id.sp_xz_3)
    public void sp_xz_3() {
        if (sp_fen_ping.isChecked()) {
            qiehuan(4);
        } else {
            SerialPortUtil.sendMsg("JZFAA4");
        }
        sp_out_banshu.setChecked(false);
        sp_xz_1.setChecked(false);
        sp_xz_2.setChecked(false);
        sp_xz_3.setChecked(true);
        sp_xz_4.setChecked(false);
        sp_xz_5.setChecked(false);
        sp_xz_6.setChecked(false);
        sp_all_guangbo.setChecked(false);
    }

    @OnClick(R.id.sp_xz_4)
    public void sp_xz_4() {
        if (sp_fen_ping.isChecked()) {
            qiehuan(5);
        } else {
            SerialPortUtil.sendMsg("JZFAA5");
        }
        sp_out_banshu.setChecked(false);
        sp_xz_1.setChecked(false);
        sp_xz_2.setChecked(false);
        sp_xz_3.setChecked(false);
        sp_xz_4.setChecked(true);
        sp_xz_5.setChecked(false);
        sp_xz_6.setChecked(false);
        sp_all_guangbo.setChecked(false);
    }

    @OnClick(R.id.sp_xz_5)
    public void sp_xz_5() {
        if (sp_fen_ping.isChecked()) {
            qiehuan(6);
        } else {
            SerialPortUtil.sendMsg("JZFAA6");
        }
        sp_out_banshu.setChecked(false);
        sp_xz_1.setChecked(false);
        sp_xz_2.setChecked(false);
        sp_xz_3.setChecked(false);
        sp_xz_4.setChecked(false);
        sp_xz_5.setChecked(true);
        sp_xz_6.setChecked(false);
        sp_all_guangbo.setChecked(false);
    }

    @OnClick(R.id.sp_xz_6)
    public void sp_xz_6() {
        if (sp_fen_ping.isChecked()) {
            qiehuan(7);
        } else {
            SerialPortUtil.sendMsg("JZFAA7");
        }
        sp_out_banshu.setChecked(false);
        sp_xz_1.setChecked(false);
        sp_xz_2.setChecked(false);
        sp_xz_3.setChecked(false);
        sp_xz_4.setChecked(false);
        sp_xz_5.setChecked(false);
        sp_xz_6.setChecked(true);
        sp_all_guangbo.setChecked(false);

    }

    private void qiehuan(int i) {
        count++;
        sp_all_guangbo.setChecked(false);
        if (count == 1) {
            SerialPortUtil.sendMsg("JZFAA" + i);
        } else if (count == 2) {
            SerialPortUtil.sendMsg("JZFBB" + i);
        } else if (count == 3) {
            count = 0;
            SerialPortUtil.sendMsg("JZFAA" + i);
        }
    }


    @OnClick(R.id.sp_all_guangbo)
    public void sp_all_guangbo() {
        if (sp_fen_ping.isChecked()) {
            SerialPortUtil.sendMsg("JZFGB9");
        } else {
            if (sp_out_banshu.isChecked()) {
                SerialPortUtil.sendMsg("JZFGB8");
            } else if (sp_xz_1.isChecked()) {
                SerialPortUtil.sendMsg("JZFGB2");
            } else if (sp_xz_2.isChecked()) {
                SerialPortUtil.sendMsg("JZFGB3");
            } else if (sp_xz_3.isChecked()) {
                SerialPortUtil.sendMsg("JZFGB4");
            } else if (sp_xz_4.isChecked()) {
                SerialPortUtil.sendMsg("JZFGB5");
            } else if (sp_xz_5.isChecked()) {
                SerialPortUtil.sendMsg("JZFGB6");
            } else if (sp_xz_6.isChecked()) {
                SerialPortUtil.sendMsg("JZFGB7");
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopTimeTimer();
    }
}
