package com.ptrollins.remoteimage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ptrollins on 10/15/14.
 */
public class AsyncTaskSample extends AsyncTask<String,Integer,Bitmap> {

    private Activity activity;

    // constructor
    public AsyncTaskSample(FragmentActivity myActivity) {
        activity = myActivity;
    }

    @Override
    protected Bitmap doInBackground(String... urls) {
        try {
            URL url = new URL(urls[0]);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

            if (httpCon.getResponseCode() != HttpURLConnection.HTTP_OK)
                throw new Exception("Failed to connect!");

            InputStream is = httpCon.getInputStream();
            return BitmapFactory.decodeStream(is);

        }catch(Exception e)

        {
            Log.e("Image", "Failed to load image", e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap img) {
        ImageView iv = (ImageView) activity.findViewById(R.id.ivRemoteImage);
        if (iv != null && img != null) {
            iv.setImageBitmap(img);
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
     //   TextView tv = (TextView) activity.findViewById(R.id.tvHello);
     //   if (values[0] == 1)
        super.onProgressUpdate();
    }

}
