package com.example.uniwall;

import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

//�M�w�ⱱ��bitmap�B�Ⲿ�X�~���AbimapOperation.java
//�p��j�p�BŪ������
//MainActivity.java�h�O�n�̷�Ū�X�����ɡA�]�w�I���ϡC
//���T�wbimapOperation.java���B��|���|���Τ��s�Ӥ������A�y���t�@��out of memory

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
        // ����귽�Ϥ�
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
	    // �]�minJustDecodeBounds��true    
	    opts.inJustDecodeBounds = true;    
	    // �ϥ�decodeFile��k�o��Ϥ����e�M�� 
	    BitmapFactory.decodeFile(pathName, opts);    
	    // �C�L�X�Ϥ����e�M��
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
