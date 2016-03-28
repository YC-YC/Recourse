package com.example.resources;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

import com.example.resources.ImgUtils.ImgUtils;
import com.example.resources.utils.LogUtil;

/**
 * @author YC
 * @time 2016-3-10 下午5:05:39
 */
public class ReflectActivity extends Activity {
	
	private static final String TAG = "ReflectActivity";
	
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
	public void corner(View view)
	{
		Bitmap bitmap = ((BitmapDrawable)mImgDvr.getDrawable()).getBitmap();
		mImgDvr.setImageBitmap(ImgUtils.getRoundedCornerBitmap(bitmap, 80));
	}
	public void round(View view)
	{
		Bitmap bitmap = ((BitmapDrawable)mImgDvr.getDrawable()).getBitmap();
		mImgDvr.setImageBitmap(ImgUtils.getRoundedCornerBitmap(bitmap));
	}
	public void blur(View view)
	{
		Bitmap bitmap = ((BitmapDrawable)mImgDvr.getDrawable()).getBitmap();
		LogUtil.startTime("高斯模糊");
		mImgDvr.setImageBitmap(ImgUtils.blurBitmap(this, bitmap));
		LogUtil.endUseTime("高斯模糊");
		mImgDvr.setOnTouchListener(new OnTouchListener() {
			
			private float mLastY;
			
			@SuppressLint("NewApi")
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					mLastY =  event.getY();
					break;
				case MotionEvent.ACTION_MOVE:
					float y = event.getY();
					float alphaDelt = (y - mLastY)/10000;
					float alpha = mImgDvr.getAlpha() + alphaDelt;
					if (alpha > 1.0f)
					{
						alpha = 1.0f;
					}
					else if (alpha < 0.0f)
					{
						alpha = 0.0f;
					}
					Log.i(TAG, "alpha = " + alpha);
					mImgDvr.setAlpha(alpha);
					break;
				case MotionEvent.ACTION_UP:

					break;
				}
				return true;
			}
		});
	}
}
