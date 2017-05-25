package com.binbin.demo.imagineview.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 陈锡滨 on 2017/3/15.
 */

public class GetImgUtil {
    public static Bitmap getImage(String picturepath){
        URL wantUrl;
        Bitmap bitmap = null;
        try{
            wantUrl = new URL(picturepath);
            HttpURLConnection conn = (HttpURLConnection) wantUrl.openConnection();
            conn.setConnectTimeout(5*1000);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            InputStream in = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(in);
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bitmap;
    }
}
