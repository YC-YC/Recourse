package com.example.resources;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.resources.ImgUtils.ImgUtils;

/**
 * @author YC
 * @time 2016-3-10 下午5:05:39
 */
public class ReflectActivity extends Activity {
	
	private ImageView mImgDvr;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reflect_main);
		mImgDvr = (ImageView) findViewById(R.id.img_dvr);
	}
	
	public void reflect(View view)
	{
		Bitmap bitmap = ((BitmapDrawable)mImgDvr.getDrawable()).getBitmap();
		mImgDvr.setImageBitmap(ImgUtils.getReflectBitmapWithOrigin(bitmap));
	}
	public void scale(View view)
	{
		Bitmap bitmap = ((BitmapDrawable)mImgDvr.getDrawable()).getBitmap();
		mImgDvr.setImageBitmap(ImgUtils.zoomBitmap(bitmap, 100, 100));
	}
	public void round(View view)
	{
		Bitmap bitmap = ((BitmapDrawable)mImgDvr.getDrawable()).getBitmap();
		mImgDvr.setImageBitmap(ImgUtils.getRoundedCornerBitmap(bitmap, 80));
	}
}
