package com.binbin.demo.imagineview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.binbin.demo.imagineview.utils.GetImgUtil;

import static android.R.attr.handle;

/**
 * Created by 陈锡滨 on 2017/3/15.
 */
public class PictureActivity extends Activity{

    String url = "http://cdn.duitang.com/uploads/item/201510/01/20151001210700_zYkhB.jpeg";
    private EditText edtUrl;
    private Button btnGetpic;
    private ImageView imgPic;

    private Bitmap bmp;

    protected void onCreate(Bundle saveInstanceStare){
        super.onCreate(saveInstanceStare);
        setContentView(R.layout.activity_picture);
        edtUrl = (EditText) findViewById(R.id.edt_url);
        btnGetpic = (Button) findViewById(R.id.btn_getpic);
        imgPic = (ImageView) findViewById(R.id.img_show);
        edtUrl.setText(url);

        btnGetpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(getPicByUrl).start();
            }
        });
    }

    Runnable getPicByUrl = new Runnable() {
        @Override
        public void run() {
            String picturepath = edtUrl.getText().toString();
            try {
                bmp = GetImgUtil.getImage(picturepath);
                sendMsg(0);
            }catch (Exception e){
                Log.i("ggggg",e.getMessage());
                sendMsg(1);
            }
        }
    };
    private void sendMsg(int i){
        Message msg = new Message();
        msg.what = i;
        handler.sendMessage(msg);
    }
    public Handler handler = new Handler(){
        public void handleMessage(Message msg){
            if(msg.what == 0){
                imgPic.setImageBitmap(bmp);
            }else if(msg.what == 1){
                Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();

            }
        }
    };

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.picture, menu);
        return true;
    }

}
