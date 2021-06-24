package com.android.camera2demo.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {
    private static final String TAG = FileUtil.class.getSimpleName();

    public static  File generateJpegFile(Context context){
        if(context == null){
            return null;
        }

        ContextWrapper cw = new ContextWrapper(context);
        File directory = cw.getExternalFilesDir(Environment.DIRECTORY_DCIM);
        long recordingStartTime = System.currentTimeMillis();
        Date date = new Date(recordingStartTime);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss_SSS");
        String title = format.format(date);
        SimpleDateFormat data_format = new SimpleDateFormat(
                "yyyyMMdd");
        String datefolder = data_format.format(date);

        String videoFileName = title + ".jpeg";

        String parent = directory.getAbsolutePath() + '/' + "Picture" + '/' + datefolder + '/';

        Log.v(TAG,"---- JPEG filePath:"+parent);
        File folder = new File(parent);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String path = parent + videoFileName;
        if(!TextUtils.isEmpty(path)){
            return new File(path);
        }
        return null;
    }

    public static File getYuvFilePath(Context context){
        ContextWrapper cw = new ContextWrapper(context);
        File directory = cw.getExternalFilesDir(Environment.DIRECTORY_DCIM);


        long recordingStartTime = System.currentTimeMillis();
        Date date = new Date(recordingStartTime);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss_SSS");
        String title = format.format(date);
        SimpleDateFormat data_format = new SimpleDateFormat(
                "yyyyMMdd");
        String datefolder = data_format.format(date);

        String videoFileName = title + ".yuv";

        String parent =  directory.getAbsolutePath() + "/" + "Yuv" + '/' + datefolder + '/';

        File folder = new File(parent);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String path = parent + videoFileName;
        Log.v(TAG,"path:"+path);

        if(!TextUtils.isEmpty(path)){
            return new File(path);
        }
        return null;
    }
}
