package com.example.uniwall;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import net.DownloadImageTask;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

//Main View.
//When launch the app, first view was controled/setContentView

public class MainActivity extends Activity {
	// Variable to controll bitmap recycle
	private LinearLayout llBackgroundPanel = null;
	private Bitmap bmpFactImg  = null;

	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Log.e("landing", "landing is ready");
		setContentView(R.layout.activity_main);
		
		//Load image to set background.
		landSetBackground();
		Log.e("mainlog", "set background ok" );
		
		//Check folder else create
		createFolder();
		Log.e("mainlog", "Check folder, if is no exits, create");
		
		//Auto download
//		DownloadImageTask loadImage = new DownloadImageTask();
//		loadImage.execute("http://cdn.stupiddope.com/wp-content/uploads/2014/06/apple-logo1.jpg");
//		Log.e("mainlog", "Async doing");
	}
	
	protected void onDestroy(){
	    super.onDestroy();
	    
	    //從res資料夾讀取test.bmp影像，存到bmpFactImg
	    bmpFactImg = BitmapOperation.readBitMap( MainApplication.getContext(), R.drawable.flow);
//	    bmpFactImg = bitmapOperation.readBitMap( this , R.drawable.flow);
	    // 每個bmpFactImg被加到VIEW上面都會產生一個callback，所以在recycle圖片之前，必須先把callback設成null
	    // 設成null以後，背景圖片自然就會不見，就會變成黑的背景。bmpDrawImg的狀態就會是沒有被使用中。
	    llBackgroundPanel.getBackground().setCallback(null); 
	    // 先判斷bmpDrawImg 是否為null，如果不是null，且bmpDrawImg 還沒有被recycle的話就進行recycle
	    if (null != bmpFactImg && !bmpFactImg.isRecycled()){
	    	bmpFactImg.recycle();
	    }
	    System.gc();
	}
	
	//If we need to use following method (Intent) several times.
	//We can write it more abstract.
	public void  clickLis(View v){
		//click listener, response 
		switch(v.getId()){
//			case R.id.setImage:
//				pictutureIntent();
//				break;
			case R.id.landing:
				intentActivity();
				Log.e("mainlog","go to menu");
				Intent menu = new Intent();
				menu.setClass(MainActivity.this, Controller.class);
				startActivity(menu);
				Log.e("mainlog","done, menu");
				//MainActivity.this.finish();
				break;
			default:
				intentActivity();
				{
				Intent a = new Intent();
				a.setClass(MainActivity.this, Controller.class);
				startActivity(a);		
				//MainActivity.this.finish();
				}
				break;
		}
	}
	
	//landing page background image set method
	public void landSetBackground(){
		llBackgroundPanel = (LinearLayout) findViewById(R.id.mainLayout);
		bmpFactImg = BitmapOperation.readBitMap( MainApplication.getContext(), R.drawable.flow);
		Drawable draw = new BitmapDrawable(getResources(),bmpFactImg);
		llBackgroundPanel.setBackground(draw);
	}
	

	//Open "action.set wall paper"
	//寫在另一個activity會不會運算比較快? 還是不必要?
	public void pictutureIntent(){
		Log.e("mainlog","do setting image");
		//Build "WallPaper Setting" Intent
		//建立"桌布設定 Action" 的 Intent
		Intent setPic = new Intent(Intent.ACTION_SET_WALLPAPER);
		//Build "Image Selector" ( Action name, name of selectors)
		Intent selectPic = Intent.createChooser( setPic, "WallPaper Selector");
		// Go to Selector
		startActivity( selectPic );
		Log.e("mainlog","done setting image");
	}
	
	//From Landing page go to menu 
	public void intentActivity(){
		Intent intentEvent = new Intent();
		intentEvent.setClass(MainActivity.this, Controller.class);
		startActivity(intentEvent);
		Log.e("mainlog","done, menu");
		//MainActivity.this.finish();
	}
	
	public void createFolder(){
		File sd = Environment.getExternalStorageDirectory();
		Log.e("mainlog", sd.getPath());
		String path = sd.getPath() + "wparper";
		File wpaper = new File(path);
		File sd2 = Environment.getExternalStorageDirectory();
		Log.e("mainlog", sd2.getPath());
		// have the object build the directory structure, if needed.
		if(!wpaper.exists()){
			wpaper.mkdirs();
		}
		// create a File object for the output file
		//File outputFile = new File(wpaper, filename);
		// now attach the OutputStream to the file object, instead of a String representation
		//FileOutputStream fos = new FileOutputStream(outputFile);
	}
}
