package com.lh.zksocketc.utils;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import android_serialport_api.SerialPort;

public class SerialPortUtil {


    private static SerialPort serialPort;
    private static OutputStream outputStream;

    public static void open() {
        try {
            serialPort = new SerialPort(new File("/dev/ttyS1"), 9600, 0);
            //获取打开的串口中的输入输出流，以便于串口数据的收发
            //inputStream = serialPort.getInputStream();
            outputStream = serialPort.getOutputStream();
        } catch (IOException e) {
            ELog.e("======open_ck=====打开串口异常");
            e.printStackTrace();
        }
    }

    public static void sendMsg(int type, String msg) {
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



    /**
     * 单开一线程，来读数据
     */
//    private class ReadThread1 extends Thread {
//        @Override
//        public void run() {
//            super.run();
//            //判断进程是否在运行，更安全的结束进程
//            byte[] buffer = new byte[1024];
//            int size; //读取数据的大小
//            try {
//                while (true && (size = inputStream1.read(buffer, 0, 1024)) > 0) {
//                    if (size > 0) {
//                        String msg = new String(buffer, 0, size);
//                        ELog.i("=========run: 接收到了数据=======" + msg);
//                        ELog.i("=========run: 接收到了数据=======" + msg.substring(0, 1));
//                        ELog.i("=========run: 接收到了数据大小=====" + size);
//
//                        if (msg.substring(0, 1).equals("1")) {
//                            ELog.i("========串口指令======");
//                            getCKMLto2();
//
//
//                        } else if (msg.substring(0, 1).equals("2")) {
//                            ELog.i("========io口指令======");
//                        } else if (msg.substring(0, 1).equals("3")) {
//                            ELog.i("========继电器指令======");
//                        } else {
//                            ELog.i("========视频指令======");
//                            getCKMLto3();
//                        }
//                    }
//                }
//
//            } catch (IOException e) {
//                ELog.i("=========run: 数据读取异常========" + e.toString());
//            }
//        }
//    }



}
