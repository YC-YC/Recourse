package com.example.resources;


import com.example.resources.popupwin.PopupWindowActivity;

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
		default:
			break;
		}
	}
}
