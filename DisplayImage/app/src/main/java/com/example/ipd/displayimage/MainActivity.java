package com.example.ipd.displayimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;


    public DownloadImageTask(ImageView bmImage) {
        this.bmImage = bmImage;
    }


    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }


    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv = (ImageView) findViewById(R.id.imgview);
        DownloadImageTask dit = new DownloadImageTask(iv);
        dit.execute("http://i.dailymail.co.uk/i/pix/2011/07/22/article-2017556-0D19A66B00000578-401_634x415.jpg");
        ImageView iv2 = (ImageView) findViewById(R.id.imgview);
        DownloadImageTask dit2 = new DownloadImageTask(iv2);
        dit2.execute("http://www.weirdhut.com/wp-content/uploads/2011/10/super-baby-animals-5.jpg");
        ImageView iv3 = (ImageView) findViewById(R.id.imgview);
        DownloadImageTask dit3 = new DownloadImageTask(iv3);
        dit3.execute("https://www.muveszhaz.com/wp-content/uploads/2013/03/119481285.jpg");
        ImageView iv4 = (ImageView) findViewById(R.id.imgview);
        DownloadImageTask dit4 = new DownloadImageTask(iv4);
        dit4.execute("http://www.awesomelycute.com/gallery/2013/09/baby-cute-animals-2350.jpg");
    }
}
