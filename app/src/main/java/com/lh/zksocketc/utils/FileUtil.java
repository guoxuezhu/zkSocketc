package com.lh.zksocketc.utils;

import android.os.Environment;

import java.io.File;

public class FileUtil {


    public static void createFile() {
        String path = Environment.getExternalStorageDirectory() + "/lhzk/img";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

    }
}
