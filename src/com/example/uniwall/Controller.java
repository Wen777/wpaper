package com.example.uniwall;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

//Second view in this app.
//We can choose different function to do what we want to do.
//It's just a simple menu.

public class Controller extends Activity {
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Log.e("landing", "landing is ready");
		setContentView(R.layout.controlman);
		intViewPager();
			}
	public void  clickLis2(View v){
		//click listener, response 
		switch(v.getId()){
			case R.id.setImage:
				Log.e("mainlog","do setting image");
				//Build "WallPaper Setting" Intent
				//建立"桌布設定 Action" 的 Intent
				Intent setPic = new Intent(Intent.ACTION_SET_WALLPAPER);
				//Build "Image Selector" ( Action name, name of selectors)
				Intent selectPic = Intent.createChooser( setPic, "WallPaper Selector");
				// Go to Selector
				startActivity( selectPic );
				Log.e("mainlog","done setting image");
				break;
			default:
				break;
		}
	}
	protected void onDestroy(){
	    super.onDestroy();
	    System.gc();
	}
	
	//Following method will implement the function 
	//what's sliding screen and change view.
	private void intViewPager(){
		ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);
		
		View view1 = LayoutInflater.from(this).inflate(R.layout.setimage, null);
		View view2 = LayoutInflater.from(this).inflate(R.layout.unifrom_map, null);
		
		ArrayList<View> arrayList = new ArrayList<View>();
		arrayList.add(view1);
		arrayList.add(view2);
		
		CoViewPagerAdapter adapter = new CoViewPagerAdapter();
	    adapter.setViews(arrayList);
	    viewPager.setAdapter(adapter);
	}
	

}
