package com.pin.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.pin.pinwork.R;

public class TitalBar extends RelativeLayout {
	Context mContext;
	private Drawable mLeftDrawable;
	private String mLeftText;
	private Drawable mRightDrawable;
	private String mRightText;
	private Drawable mMidDrawable;
	private String mMidText;
	private boolean mLeftShow;
	private boolean mRightShow;
	private boolean mMidShow;
	public static final int LEFT_VIEW = 0;
	public static final int RIGHT_VIEW = 1;
	public static final int MID_VIEW = 2;

	public TitalBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		Resources res = context.getResources();
		TypedArray a = res.obtainAttributes(attrs, R.styleable.TitleBar);
		mLeftDrawable = a.getDrawable(R.styleable.TitleBar_left_backgroud);
		mRightDrawable = a.getDrawable(R.styleable.TitleBar_right_backgroud);
		mMidDrawable = a.getDrawable(R.styleable.TitleBar_mid_backgroud);
		mLeftText = (String) a.getText(R.styleable.TitleBar_left_text);
		mRightText = (String) a.getText(R.styleable.TitleBar_right_text);
		mMidText = (String) a.getText(R.styleable.TitleBar_mid_text);
		mLeftShow = a.getBoolean(R.styleable.TitleBar_left_show, false);
		mRightShow = a.getBoolean(R.styleable.TitleBar_right_show, false);
		mMidShow = a.getBoolean(R.styleable.TitleBar_mid_show, false);
		a.recycle();
		init();
	}

	private void init() {
		LayoutParams params = new LayoutParams(
				android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
				android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
		params.addRule(ALIGN_PARENT_LEFT);
		params.addRule(CENTER_VERTICAL);
		Button btn = new Button(mContext);
		btn.setText(mLeftText);
		btn.setBackgroundDrawable(mLeftDrawable);
		btn.setLayoutParams(params);
		btn.setVisibility(mLeftShow ? View.VISIBLE : View.INVISIBLE);
		addView(btn);

		// Right
		params = new LayoutParams(
				android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
				android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
		params.addRule(ALIGN_PARENT_RIGHT);
		params.addRule(CENTER_VERTICAL);
		btn = new Button(mContext);
		btn.setText(mRightText);
		btn.setBackgroundDrawable(mRightDrawable);
		btn.setLayoutParams(params);
		btn.setVisibility(mRightShow ? View.VISIBLE : View.INVISIBLE);
		addView(btn);

		// Middle
		params = new LayoutParams(
				android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
				android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
		params.addRule(CENTER_IN_PARENT);
		params.addRule(CENTER_VERTICAL);
		btn = new Button(mContext);
		btn.setText(mMidText);
		btn.setBackgroundDrawable(mMidDrawable);
		btn.setLayoutParams(params);
		btn.setVisibility(mMidShow ? View.VISIBLE : View.INVISIBLE);
		addView(btn);
	}

	public void showLeftView(int show) {
		getChildAt(0).setVisibility(show);
	}

	public void showRightView(int show) {
		getChildAt(1).setVisibility(show);
	}

	public void showMiddleView(int show) {
		getChildAt(2).setVisibility(show);
	}

	public View getOperView(int index) {
		return this.getChildAt(index);
	}
}
