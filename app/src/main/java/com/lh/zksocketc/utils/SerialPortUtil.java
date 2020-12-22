package com.lh.zksocketc.utils;

import android.os.Handler;
import android.os.Message;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.data.DbDao.WsdDataDao;
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
    private static OutputStream outputStream1;

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
                            ELog.i("=====接收到了数据==温湿度=====" + msg);
                            String[] msglist = msg.split(";");
                            if (msglist[0].equals("WSD")) {
                                try {
                                    WsdData wsd = new WsdData(msglist[1], msglist[2], msglist[3]);
                                    WsdDataDao wsdDataDao = MyApplication.getDaoSession().getWsdDataDao();
                                    wsdDataDao.deleteAll();
                                    wsdDataDao.insert(wsd);
                                } catch (Exception e) {
                                    ELog.i("=========温湿度====WsdDataDao====异常========" + e.toString());
                                }
                            } else if (msglist[0].equals("SKJ")) {
                                if (myHander != null) {
                                    Message message = new Message();
                                    message.obj = msg;
                                    message.what = 444;
                                    myHander.sendMessage(message);
                                }
                            }
                        }
                    }

                } catch (IOException e) {
                    ELog.i("=========run: 数据读取异常========" + e.toString());
                }

            }
        }.start();


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
            outputStream1 = serialPort1.getOutputStream();

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
                            String kahao = Long.parseLong(new String(buffer, 0, size).substring(3), 16) + "";
                            if (kahao.length() == 9) {
                                kahao = "0" + kahao;
                            } else if (kahao.length() == 8) {
                                kahao = "00" + kahao;
                            } else if (kahao.length() == 7) {
                                kahao = "000" + kahao;
                            } else if (kahao.length() == 6) {
                                kahao = "0000" + kahao;
                            } else if (kahao.length() == 5) {
                                kahao = "00000" + kahao;
                            } else if (kahao.length() == 4) {
                                kahao = "000000" + kahao;
                            } else if (kahao.length() == 3) {
                                kahao = "0000000" + kahao;
                            } else if (kahao.length() == 2) {
                                kahao = "00000000" + kahao;
                            } else if (kahao.length() == 1) {
                                kahao = "000000000" + kahao;
                            }
                            ELog.d("=====接收到了卡号=======" + kahao);
                            if (kahao.length() == 10) {
                                Message message = new Message();
                                message.obj = kahao;
                                message.what = 333;
                                myHander.sendMessage(message);
                            }
                            sendMsgIc("ICKERROR");
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

    private synchronized static void sendMsgIc(String msg) {
        byte[] data = msg.getBytes();
        try {
            if (data.length > 0) {
                outputStream1.write(data);
                outputStream1.flush();
                ELog.e("====sendMsgIc: 串口数据发送成功");
            }
        } catch (IOException e) {
            ELog.e("====sendMsgIc: 串口数据发送失败：" + e.toString());
        }


    }

    public static void stopReadCard() {
        isReadCard = false;
        try {
            if (inputStream1 != null) {
                inputStream1.close();
            }
            if (outputStream1 != null) {
                outputStream1.close();
            }
        } catch (IOException e) {
            // Ignore.
        }
        serialPort1.close();
        myHander = null;
        ELog.i("========stopReadCard=============");
    }
}
