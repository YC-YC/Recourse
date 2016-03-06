package com.example.resources;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onClick_Layer(View view)
    {
    	Intent intent = new Intent(this, Layer.class);
    	startActivity(intent);
    	
    }
    public void onClick_ButtonState(View view)
    {
    	Intent intent = new Intent(this, ButtonState.class);
    	startActivity(intent);
    	
    }
    public void onClick_Level(View view)
    {
    	Intent intent = new Intent(this, Level.class);
    	startActivity(intent);
    	
    }
    public void onClick_CrossFade(View view)
    {
    	Intent intent = new Intent(this, CrossFade.class);
    	startActivity(intent);
    	
    }
    public void onClick_Inset(View view)
    {
    	Intent intent = new Intent(this, Inset.class);
    	startActivity(intent);
    	
    }
    public void onClick_Clip(View view)
    {
    	Intent intent = new Intent(this, Clip.class);
    	startActivity(intent);
    	
    }
    public void onClick_Shape(View view)
    {
    	Intent intent = new Intent(this, Shape.class);
    	startActivity(intent);
    	
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
