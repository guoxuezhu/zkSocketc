package com.lh.zksocketc.utils;

import com.lh.zksocketc.MyApplication;
import com.lh.zksocketc.data.DbDao.WsdDataDao;
import com.lh.zksocketc.data.model.WsdData;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android_serialport_api.SerialPort;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;

public class SerialPortUtil {


    private static SerialPort serialPort;
    private static OutputStream outputStream;
    private static InputStream inputStream;

    private static boolean isReadWsd;

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

    public static void sendMsg(String msg) {
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
                                WsdDataDao wsdDataDao = MyApplication.getDaoSession().getWsdDataDao();
                                wsdDataDao.deleteAll();
                                wsdDataDao.insert(new WsdData(msglist[1], msglist[2], "0"));
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
    }

    private static final String DEVICE_PATH = "/dev/ttyS1";
    private static final int BAUDRATE = 9600;
    private static volatile boolean isReadCard = false;
    private static FlowableEmitter<String> cardEmitter;

    public static Flowable<String> flowReadCard() {
        return Flowable.fromCallable(() -> new SerialPort(new File(DEVICE_PATH), BAUDRATE, 0).getInputStream())
                .flatMap(fileInputStream -> Flowable.create((emitter) -> {
                            final InputStream in = fileInputStream;

                            isReadCard = true;
                            cardEmitter = emitter;
                            new Thread() {
                                @Override
                                public void run() {
                                    int len;
                                    byte[] buffer = new byte[64];
                                    try {
                                        while (isReadCard && (len = in.read(buffer, 0, 64)) > 0) {
                                            if (len > 0) {
                                                ELog.i("=========len======" + len);
                                                byte[] bs = new byte[4];
                                                System.arraycopy(buffer, 1, bs, 0, 4);
                                                String ret = "";
                                                for (int i = 0; i < bs.length; i++) {
                                                    String hex = Integer.toHexString(bs[i] & 0xFF);
                                                    if (hex.length() == 1) {
                                                        hex = "0" + hex;
                                                    }
                                                    ret += hex.toUpperCase();
                                                    ELog.i("=========hex=======" + ret);
                                                }
                                                String msg = Long.parseLong(ret, 16) + "";
                                                ELog.i("=========run: 接收到了卡号=======" + msg);
                                                ELog.i("=========run: 接收到了卡号大小=======" + msg.length());
                                                if (msg.length() == 10) {
                                                    cardEmitter.onNext(msg);
                                                } else if (msg.length() == 9) {
                                                    cardEmitter.onNext("0" + msg);
                                                } else if (msg.length() == 8) {
                                                    cardEmitter.onNext("00" + msg);
                                                } else if (msg.length() == 7) {
                                                    cardEmitter.onNext("000" + msg);
                                                } else if (msg.length() == 6) {
                                                    cardEmitter.onNext("0000" + msg);
                                                } else if (msg.length() == 5) {
                                                    cardEmitter.onNext("00000" + msg);
                                                } else if (msg.length() == 4) {
                                                    cardEmitter.onNext("000000" + msg);
                                                } else if (msg.length() == 3) {
                                                    cardEmitter.onNext("0000000" + msg);
                                                } else if (msg.length() == 2) {
                                                    cardEmitter.onNext("00000000" + msg);
                                                } else if (msg.length() == 1) {
                                                    cardEmitter.onNext("000000000" + msg);
                                                }
                                                sleep(500);
                                            }
                                        }
                                    } catch (IOException e) {
                                        cardEmitter.onError(e);
                                    } catch (InterruptedException e) {
                                        cardEmitter.onError(e);
                                    } finally {
                                        closeQuietly(in);
                                        isReadCard = false;
                                        cardEmitter.onComplete();
                                    }
                                }
                            }.start();
                        }
                        , BackpressureStrategy.BUFFER));
    }

    public static void closeQuietly(Closeable stream) {
        try {
            if (stream != null) {
                stream.close();
            }
        } catch (IOException e) {
            // Ignore.
        }
    }


    public static void stopReadCard() {
        isReadCard = false;
        if (cardEmitter != null) {
            cardEmitter.onComplete();
        }
    }
}
