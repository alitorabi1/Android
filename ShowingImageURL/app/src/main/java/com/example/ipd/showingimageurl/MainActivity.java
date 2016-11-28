package com.example.ipd.showingimageurl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText et;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }        et = (EditText) findViewById(R.id.editText);
        iv = (ImageView) findViewById(R.id.imageView);
    }

    public void onClick(View view) throws IOException {
//        URL url = new URL(et.getText().toString());
//        URL url = new URL("https://s-media-cache-ak0.pinimg.com/236x/40/94/59/40945913943345b2803855b161e860cb.jpg");
//        Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//        iv.setImageBitmap(bmp);
        URL url;
        Bitmap bmp;
        try {
//            url = new URL("http://www.tanmonkey.com/images/monkey/Funny-MonkeyReaction%20small.jpg");
            url = new URL(et.getText().toString());
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            iv.setImageBitmap(bmp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
