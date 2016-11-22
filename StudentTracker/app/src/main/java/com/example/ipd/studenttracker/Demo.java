package com.example.ipd.studenttracker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class Demo extends AppCompatActivity {

    String SrcPath = "rtsp://v5.cache1.c.youtube.com/CjYLENy73wIaLQnhycnrJQ8qmRMYESARFEIJbXYtZ29vZ2xlSARSBXdhdGNoYPj_hYjnq6uUTQw=/0/0/0/video.3gp";
    private VideoView mVideoView;
    DisplayMetrics dm;
    SurfaceView sur_View;
    MediaController media_Controller;
//    Uri video = Uri.parse("android.resource://com.cpt.sample/raw/filename");
//    Uri uri = Uri.parse("android.resource://" + getPackageName() + "Name OF Video store in raw folder");

    String path = "C:\\Users\\lenovo\\Documents\\Android\\StudentTracker\\videos\\demo.mp4";
    private static final String TAG = "VideoViewDemo";
//    Uri path = Uri.parse("android.resource://" + getPackageName() + "/"
//        + R.raw.demo); //do not add any extension
//    private String current;
//    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        VideoView myVideoView = (VideoView)findViewById(R.id.demoViewer);
        myVideoView.setVideoURI(Uri.parse(SrcPath));
        myVideoView.setMediaController(new MediaController(this));
        myVideoView.requestFocus();
        myVideoView.start();
//        mVideoView = (VideoView) findViewById(R.id.demoViewer);
//        runOnUiThread(new Runnable() {
//            public void run() {
//                playVideo(path, mVideoView);
//            }
//        });
    }

    @SuppressLint("LongLogTag")
    public static String getUrlVideoRTSP(String urlYoutube) {

        try {
            String gdy = "http://gdata.youtube.com/feeds/base/videos/-/justinbieber?orderby=published&alt=rss&client=ytapi-youtube-rss-redirect&v=2";
            DocumentBuilder documentBuilder = DocumentBuilderFactory
                    .newInstance().newDocumentBuilder();
            String id = extractYoutubeId(urlYoutube);
            URL url = new URL(gdy + id);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            Document doc = documentBuilder.parse(connection.getInputStream());
            Element el = doc.getDocumentElement();
            NodeList list = el.getElementsByTagName("media:content");// /media:content
            String cursor = urlYoutube;
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node != null) {
                    NamedNodeMap nodeMap = node.getAttributes();
                    HashMap<String, String> maps = new HashMap<String, String>();
                    for (int j = 0; j < nodeMap.getLength(); j++) {
                        Attr att = (Attr) nodeMap.item(j);
                        maps.put(att.getName(), att.getValue());
                    }
                    if (maps.containsKey("yt:format")) {
                        String f = maps.get("yt:format");
                        if (maps.containsKey("url")) {
                            cursor = maps.get("url");
                        }
                        if (f.equals("1"))
                            return cursor;
                    }
                }
            }
            return cursor;
        } catch (Exception ex) {
            Log.e("Get Url Video RTSP Exception======>>", ex.toString());
        }
        return urlYoutube;
    }

    private static String extractYoutubeId(String url) {

        return url;
    }







    public Void playVideo(String filePath, VideoView videoView) {

        Log.d(TAG, "Playing video offline");

        videoView.setVideoPath(filePath);

        MediaController mediaController = new MediaController(this);
        mediaController.setMediaPlayer(videoView);

        videoView.setMediaController(mediaController);
        videoView.requestFocus();

        videoView.start();

        return null;
    }
//    private void playVideo() {
//        try {
//            // final String path = path;
//            Log.v(TAG, "path: " + path);
////            if (path == null || path.length() == 0) {
////                Toast.makeText(Demo.this, "File URL/path is empty",
////                        Toast.LENGTH_LONG).show();
////
////            } else {
////                // If the path has not changed, just start the media player
////                if (path.equals(current) && mVideoView != null) {
////                    mVideoView.start();
////                    mVideoView.requestFocus();
////                    return;
////                }
////                current = path;
//                mVideoView.setVideoURI(path);
////                mVideoView.setVideoURI(Uri.parse(path));
////                mVideoView.setVideoPath(getDataSource(path));
//                mVideoView.start();
//                mVideoView.setMediaController(new MediaController(this));
//                mVideoView.requestFocus();
//
////            }
//        } catch (Exception e) {
//            Log.e(TAG, "error: " + e.getMessage(), e);
//            if (mVideoView != null) {
//                mVideoView.stopPlayback();
//            }
//        }
//    }

    private String getDataSource(String path) throws IOException {
        if (!URLUtil.isNetworkUrl(path)) {
            return path;
        } else {
            URL url = new URL(path);
            URLConnection cn = url.openConnection();
            cn.connect();
            InputStream stream = cn.getInputStream();
            if (stream == null)
                throw new RuntimeException("stream is null");
            File temp = File.createTempFile("mediaplayertmp", "dat");
            temp.deleteOnExit();
            String tempPath = temp.getAbsolutePath();
            FileOutputStream out = new FileOutputStream(temp);
            byte buf[] = new byte[128];
            do {
                int numread = stream.read(buf);
                if (numread <= 0)
                    break;
                out.write(buf, 0, numread);
            } while (true);
            try {
                stream.close();
            } catch (IOException ex) {
                Log.e(TAG, "error: " + ex.getMessage(), ex);
            }
            return tempPath;
        }
    }

    public void goBack(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

//    public void getInit() {
//        video_player_view = (VideoView) findViewById(R.id.demoViewer);
////        media_Controller = new MediaController(this);
////        video_player_view.setVideoPath("http://javabog.dk/filer/hej_fra_Jacob.mp4");
//        String path = "http://www.boisestatefootball.com/sites/default/files/videos/original/01%20-%20coach%20pete%20bio_4.mp4";
//        video_player_view.setVideoPath(getIntent().getStringExtra("path"));
//        dm = new DisplayMetrics();
//        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
//        int height = dm.heightPixels;
//        int width = dm.widthPixels;
////        video_player_view.setMinimumWidth(width);
////        video_player_view.setMinimumHeight(height);
//        video_player_view.setMediaController(new MediaController(this));
////        video_player_view.setVideoPath("C:\\Users\\lenovo\\Documents\\Android\\StudentTracker\\app\\src\\main\\res\\raw\\demo.mp4");
//        video_player_view.requestFocus();
//        video_player_view.start();
//    }
}