package com.lh.zksocketc.utils;

import android.os.Handler;
import android.os.Message;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.data.DbDao.BtnStatusDataDao;
import com.lh.zksocketc.data.DbDao.WsdDataDao;
import com.lh.zksocketc.data.model.BtnStatusData;
import com.lh.zksocketc.data.model.WsdData;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android_serialport_api.SerialPort;

public class SerialPortUtil {


    private static SerialPort serialPort;
    private static OutputStream outputStream;
    private static InputStream inputStream;

    private static boolean isReadWsd;
    private static SerialPort serialPort1;
    private static InputStream inputStream1;
    private static boolean isReadCard;
    private static Handler myHander;
    private static BtnStatusDataDao btnStatusDataDao;

    public static void open() {
        try {
            serialPort = new SerialPort(new File("/dev/ttyS0"), 9600, 0);//中控
            //获取打开的串口中的输入输出流，以便于串口数据的收发
            inputStream = serialPort.getInputStream();
            outputStream = serialPort.getOutputStream();
        } catch (IOException e) {
            ELog.e("======open_ck=====打开串口异常");
            e.printStackTrace();
        }
    }

    public synchronized static void sendMsg(String msg) {
        ELog.d("===========串口数据发送=============" + msg);
        byte[] data = msg.getBytes();
        try {
            if (data.length > 0) {
                outputStream.write(data);
                outputStream.flush();
                ELog.e("====sendSerialPort: 串口数据发送成功");
            }
        } catch (IOException e) {
            ELog.e("====sendSerialPort: 串口数据发送失败：" + e.toString());
        }


    }

    public static void readSerialPortData() {
        getBtnstatus();
        new Thread() {
            @Override
            public void run() {
                super.run();
                //判断进程是否在运行，更安全的结束进程
                isReadWsd = true;
                byte[] buffer = new byte[64];
                int size; //读取数据的大小
                try {
                    while (isReadWsd && (size = inputStream.read(buffer, 0, 64)) > 0) {
                        if (size > 0) {
                            String msg = new String(buffer, 0, size);
                            ELog.i("=====接收到了数据=======" + msg);
                            String[] msglist = msg.split(";");
                            try {
                                if (msglist[0].equals("WSD")) {
                                    WsdData wsd = new WsdData(msglist[1], msglist[2], msglist[3]);
                                    WsdDataDao wsdDataDao = MyApplication.getDaoSession().getWsdDataDao();
                                    wsdDataDao.deleteAll();
                                    wsdDataDao.insert(wsd);
                                } else if (msglist[0].equals("KZQ")) {
                                    if (msglist[1].equals("0101")) {
                                        btnStatusDataDao.update(new BtnStatusData("窗帘", 3, "1"));
                                    } else if (msglist[1].equals("0100")) {
                                        btnStatusDataDao.update(new BtnStatusData("窗帘", 3, "0"));
                                    } else if (msglist[1].equals("0401")) {
                                        btnStatusDataDao.update(new BtnStatusData("黑板灯", 13, "1"));
                                    } else if (msglist[1].equals("0400")) {
                                        btnStatusDataDao.update(new BtnStatusData("黑板灯", 14, "0"));
                                    } else if (msglist[1].equals("0201")) {
                                        btnStatusDataDao.update(new BtnStatusData("教室灯", 15, "1"));
                                    } else if (msglist[1].equals("0200")) {
                                        btnStatusDataDao.update(new BtnStatusData("教室灯", 15, "0"));
                                    } else if (msglist[1].equals("0301")) {
                                        btnStatusDataDao.update(new BtnStatusData("场景", 66, "1"));
                                    } else if (msglist[1].equals("0300")) {
                                        btnStatusDataDao.update(new BtnStatusData("场景", 66, "0"));
                                    }
                                    if (myHander != null) {
                                        Message message = new Message();
                                        message.obj = msglist[1];
                                        message.what = 234;
                                        myHander.sendMessage(message);
                                    }
                                } else if (msglist[0].equals("SKJ")) {
                                    if (myHander != null) {
                                        Message message = new Message();
                                        message.obj = msg;
                                        message.what = 444;
                                        myHander.sendMessage(message);
                                    }
                                }
                            } catch (Exception e) {
                                ELog.i("========接收到了数据====异常========" + e.toString());
                            }


                        }
                    }

                } catch (IOException e) {
                    ELog.i("=========run: 数据读取异常========" + e.toString());
                }

            }
        }.start();


    }

    private static void getBtnstatus() {
        btnStatusDataDao = MyApplication.getDaoSession().getBtnStatusDataDao();
        if (btnStatusDataDao.loadAll().size() == 0) {
            btnStatusDataDao.insert(new BtnStatusData("窗帘", 3, "0"));
            btnStatusDataDao.insert(new BtnStatusData("黑板灯", 13, "0"));
            btnStatusDataDao.insert(new BtnStatusData("教室灯", 15, "0"));
            btnStatusDataDao.insert(new BtnStatusData("场景", 66, "0"));
        }

    }


    public static void stopReadWsd() {
        if (isReadWsd) {
            isReadWsd = false;
        }
        try {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (IOException e) {
            // Ignore.
        }
        serialPort.close();
    }


    public static void readCardnumer(Handler hander) {
        myHander = hander;

        try {
            serialPort1 = new SerialPort(new File("/dev/ttyS1"), 9600, 0);
            inputStream1 = serialPort1.getInputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread() {
            @Override
            public void run() {
                super.run();
                isReadCard = true;
                byte[] buffer = new byte[64];
                int size; //读取数据的大小
                try {
                    while (isReadCard && (size = inputStream1.read(buffer, 0, 64)) > 0) {
                        if (isReadCard && size > 0) {
                            ELog.i("=========size======" + size);
                            byte[] bs = new byte[4];
                            System.arraycopy(buffer, 1, bs, 0, 4);
                            String ret = "";
                            for (int i = 0; i < bs.length; i++) {
                                String hex = Integer.toHexString(bs[i] & 0xFF);
                                if (hex.length() == 1) {
                                    hex = "0" + hex;
                                }
                                ret += hex.toUpperCase();
                            }
                            String msg = Long.parseLong(ret, 16) + "";
                            ELog.i("=========run: 接收到了卡号=======" + msg);
                            ELog.i("=========run: 接收到了卡号大小=======" + msg.length());
                            if (msg.length() == 9) {
                                msg = "0" + msg;
                            } else if (msg.length() == 8) {
                                msg = "00" + msg;
                            } else if (msg.length() == 7) {
                                msg = "000" + msg;
                            } else if (msg.length() == 6) {
                                msg = "0000" + msg;
                            } else if (msg.length() == 5) {
                                msg = "00000" + msg;
                            } else if (msg.length() == 4) {
                                msg = "000000" + msg;
                            } else if (msg.length() == 3) {
                                msg = "0000000" + msg;
                            } else if (msg.length() == 2) {
                                msg = "00000000" + msg;
                            } else if (msg.length() == 1) {
                                msg = "000000000" + msg;
                            }

                            Message message = new Message();
                            message.obj = msg;
                            message.what = 333;
                            myHander.sendMessage(message);

                            sleep(500);
                        }
                    }

                } catch (IOException e) {
                    ELog.i("=========run: 数据读取异常========" + e.toString());
                } catch (InterruptedException e) {
                    ELog.i("=========run: 数据读取异常========" + e.toString());
                }

            }
        }.start();


    }


    public static void stopReadCard() {
        isReadCard = false;
        try {
            if (inputStream1 != null) {
                inputStream1.close();
            }
        } catch (IOException e) {
            // Ignore.
        }
        serialPort1.close();
        myHander = null;
        ELog.i("========stopReadCard=============");
    }

    public static void readBtnStatus(Handler sfHander) {
        myHander = sfHander;
    }


    public static void stopReadBtnStatus() {
        myHander = null;
    }
}
