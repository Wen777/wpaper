package net;

import java.io.InputStream;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class DownloadMethod {
	
	public DownloadMethod(){
		
	}
	
	public Bitmap DownloadImage(String urlstring){
		Bitmap image2bm = null;
		/*String urlstring = urls[0];*/
		try{
			InputStream in = new java.net.URL(urlstring).openStream();
			image2bm = BitmapFactory.decodeStream(in);

			//Bitmap picture2bm = BitmapFactory.decodeStream(url.openConnection().getInputStream());
			//Different method to open picture and download it------------------->>
			/*URL url = new URL("http://cdn.stupiddope.com/wp-content/uploads/2014/06/apple-logo1.jpg");
			Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());*/
			//imageView.setImageBitmap(bmp);
			
		}catch(Exception e){
			Log.e("Error", e.getMessage());
	        e.printStackTrace();
		}
		//上面的操作似乎有錯，不能放在同一個doInBackground
		return image2bm;
	}
}
