package com.example.resources;


import com.example.customview.CustomTextViewActivity;
import com.example.resources.drawpic.DrawActivity;
import com.example.resources.popupwin.PopupWindowActivity;
import com.example.resources.utils.Utils;
import com.example.resources.view.CustomActivity1;
import com.example.resources.view.CustomActivity2;
import com.example.resources.view.CustomActivity3;
import com.example.resources.view.CustomActivity4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onClick_Drawable(View view) {
		Intent intent = new Intent(this, ResourceActivity.class);
		startActivity(intent);
	}

	public void onClick_test(View view){
//		Utils.runRuntimeFun();
//		Utils.shuffle();
		Utils.ReadPlugIn(this, this.getClass().getClassLoader());
	}
	
	public void onClick_Animtation(View view) {
		Intent intent = new Intent(this, AnimationActivity.class);
		startActivity(intent);
	}
	public void onClick_Reflect(View view) {
		Intent intent = new Intent(this, ReflectActivity.class);
		startActivity(intent);
	}
	
	public void onClick_Main(View view)
	{
		switch (view.getId()) {
		case R.id.btn_contentprovider:
			startActivity(new Intent(this, ContentResolveActivity.class));
			break;
		case R.id.btn_popupwind:
			startActivity(new Intent(this, PopupWindowActivity.class));
			break;
		case R.id.btn_drawpic:
			startActivity(new Intent(this, DrawActivity.class));
			break;
			
		case R.id.btn_customviewgroup1:
			startActivity(new Intent(this, CustomActivity1.class));
			break;
		case R.id.btn_customviewgroup2:
			startActivity(new Intent(this, CustomActivity2.class));
			break;
		case R.id.btn_customviewgroup3:
			startActivity(new Intent(this, CustomActivity3.class));
			break;
		case R.id.btn_customview:
			startActivity(new Intent(this, CustomActivity4.class));
			break;
		case R.id.btn_customtextview:
			startActivity(new Intent(this, CustomTextViewActivity.class));
			break;
		case R.id.btn_expandlistview:
			startActivity(new Intent(this, ExpandListActivity.class));
			break;
		default:
			break;
		}
	}
}
