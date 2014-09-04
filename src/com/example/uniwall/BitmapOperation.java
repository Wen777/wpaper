package com.example.uniwall;

import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

//決定把控制bitmap運算移出外面，bimapOperation.java
//計算大小、讀取圖檔
//MainActivity.java則是要依照讀出的圖檔，設定背景圖。
//不確定bimapOperation.java的運算會不會佔用內存而不消失，造成另一個out of memory

public class BitmapOperation{
	//Declare variable
	private static int picWidth;
	private static int picHeight;
	//Method for reading file
	public static  Bitmap  readBitMap(Context context, int resId){
		BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        // 獲取資源圖片
        InputStream is = context.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, null, opt);
	}
	
	//Scale the bitmap
	public BitmapFactory.Options getBitmapOptions(int scale){
	    BitmapFactory.Options options = new BitmapFactory.Options();
	    options.inPurgeable = true;
	    options.inInputShareable = true;
	    options.inSampleSize = scale;
	    return options;
	}
	
	//Method for show the information of bitmap without loading picture. 
	public static void informBitmap(String pathName){
		BitmapFactory.Options opts = new BitmapFactory.Options();    
	    // 設置inJustDecodeBounds為true    
	    opts.inJustDecodeBounds = true;    
	    // 使用decodeFile方法得到圖片的寬和高 
	    BitmapFactory.decodeFile(pathName, opts);    
	    // 列印出圖片的寬和高
	    Log.d("example", opts.outWidth + "," + opts.outHeight);
	    
		picWidth  = opts.outWidth;  
		picHeight = opts.outHeight; 
	}
	
	//Get method & set method
//	public int getWidth(){
//		return opts.outWidth;
//	}
//	public int getHeight(){
//		return opts.outHeight;
//	}
}
