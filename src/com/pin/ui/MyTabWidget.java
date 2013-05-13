package com.pin.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TabWidget;

public class MyTabWidget extends TabWidget {

	public MyTabWidget(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
	
		Log.i("hello","onfocuschange");
		//super.onFocusChange(v, hasFocus);
	}
}
