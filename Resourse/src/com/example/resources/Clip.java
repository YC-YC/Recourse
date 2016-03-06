package com.example.resources;

import android.app.Activity;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.widget.ImageView;

/**
 *@Author Administrator
 *@Time 2016-3-6 下午9:08:58
 */
public class Clip extends Activity {
	private ImageView ivLamp;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clip);
        ImageView imageview = (ImageView) findViewById(R.id.image);
        ClipDrawable drawable = (ClipDrawable) imageview.getBackground();
        drawable.setLevel(5000);
	} 
}
