package com.example.uniwall;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;


//This is a adapter
public class CoViewPagerAdapter extends PagerAdapter{
	
	private ArrayList<View> arrayList;
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arrayList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}
	
	public void setViews(ArrayList<View> arrayList){
		this.arrayList = arrayList;
	}

	@Override
	public void destroyItem(View container, int position, Object object){
		((ViewPager)container).removeView(arrayList.get(position));
	}
	
	@Override
	public  Object instantiateItem(View container, int position){
		((ViewPager)container).addView(arrayList.get(position));
		return arrayList.get(position);
	}
}
