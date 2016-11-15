package com.example.ipd.displayrandomimages;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.util.Random;

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

    ImageView iv;
    DownloadImageTask dit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.imgview);
        dit = new DownloadImageTask(iv);
        dit.execute("http://i.dailymail.co.uk/i/pix/2011/07/22/article-2017556-0D19A66B00000578-401_634x415.jpg");
    }

    public void mainClick(View view) {
        String img1 = "http://www.weirdhut.com/wp-content/uploads/2011/10/super-baby-animals-5.jpg";
        String img2 = "https://www.muveszhaz.com/wp-content/uploads/2013/03/119481285.jpg";
        String img3 = "http://www.awesomelycute.com/gallery/2013/09/baby-cute-animals-2350.jpg";
        String img4 = "http://s1.favim.com/orig/24/animals-cute-polarbear-small-white-Favim.com-218832.jpg";
        String img5 = "https://s-media-cache-ak0.pinimg.com/736x/5e/01/8b/5e018b165411f557f1d7d15a0f45438c.jpg";
        String[] images={img1, img2, img3, img4, img5};
        Random r = new Random();
        int n=r.nextInt(5);
        dit.execute(images[n]);
    }

}
