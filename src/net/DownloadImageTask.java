package net;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;



public class DownloadImageTask extends AsyncTask<String, Void, Bitmap>{

	@Override
	protected Bitmap doInBackground(String... urls) {
		// TODO Auto-generated method stub
		Bitmap bm = null;
		String urlstring = urls[0];
		DownloadMethod BMDownload = new DownloadMethod();
		bm = BMDownload.DownloadImage(urlstring);
		return bm;
	}
}
