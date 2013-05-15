package com.pin.pinwork;

import java.util.HashMap;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.pin.fragment.ExchangeFragment;
import com.pin.fragment.MeFragment;
import com.pin.fragment.RoleFragment;

public class MainActivity extends FragmentActivity implements OnClickListener {
	TabManager mTabManager;
	TabHost mTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTabHost = (TabHost)findViewById(android.R.id.tabhost);
		mTabHost.setup();
		mTabManager = new TabManager(this, mTabHost, R.id.realtabcontent);
		Button btn = new Button(this);
		btn.setBackgroundResource(R.drawable.tab_role);
		mTabManager.addTab(mTabHost.newTabSpec("role").setIndicator(btn), RoleFragment.class, null);
		
		btn = new Button(this);
		btn.setBackgroundResource(R.drawable.tab_exchange);
		mTabManager.addTab(mTabHost.newTabSpec("ranking").setIndicator(btn), ExchangeFragment.class, null);
		btn = new Button(this);
		btn.setBackgroundResource(R.drawable.tab_me);
		mTabManager.addTab(mTabHost.newTabSpec("me").setIndicator(btn), MeFragment.class, null);
		
		btn = new Button(this);
		btn.setBackgroundResource(R.drawable.tab_more);
		mTabManager.addTab(mTabHost.newTabSpec("main3").setIndicator(btn), ExchangeFragment.class, null);
		
		TabWidget tabwidget = mTabHost.getTabWidget();
		tabwidget.setEnabled(true);
		tabwidget.focusCurrentTab(0);
		//tabwidget.set
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public static class TabManager implements TabHost.OnTabChangeListener {
		private final FragmentActivity mFragmentActivity;
		private final TabHost mTabHost;
		private final int mContainerId;
		private HashMap<String, TabInfo> mTabs = new HashMap<String, TabInfo>();
		private TabInfo mLastTab;

		public static class TabInfo {
			private final String tag;
			private final Class<?> cls;
			private final Bundle args;
			private Fragment fragment;

			public TabInfo(String tag, Class<?> cls, Bundle args) {
				this.tag = tag;
				this.cls = cls;
				this.args = args;
			}
		}

		public TabManager(FragmentActivity activity, TabHost tabhost, int id) {
			mFragmentActivity = activity;
			mTabHost = tabhost;
			mContainerId = id;
			mTabHost.setOnTabChangedListener(this);
		}

		@Override
		public void onTabChanged(String tabId) {
			TabInfo newTab = mTabs.get(tabId);
			
			if (newTab != mLastTab) {
				FragmentTransaction ft = mFragmentActivity
						.getSupportFragmentManager().beginTransaction();
				if (mLastTab != null) {
					
					if (mLastTab.fragment != null) {
						ft.detach(mLastTab.fragment);
					}
				}
				if (newTab != null) {
					if (newTab.fragment == null) {
						newTab.fragment = Fragment.instantiate(
								mFragmentActivity, newTab.cls.getName(),
								newTab.args);
						ft.add(mContainerId, newTab.fragment, newTab.tag);
					} else {
						ft.attach(newTab.fragment);
					}
				}
				mLastTab = newTab;
				ft.commit();
				mFragmentActivity.getSupportFragmentManager()
						.executePendingTransactions();
			}
		}

		public void addTab(TabHost.TabSpec spec, Class<?> cls, Bundle bundle) {
			spec.setContent(new DummyTabFactory(mFragmentActivity));
			String tag = spec.getTag();
			TabInfo tabinfo = new TabInfo(tag, cls, bundle);

			tabinfo.fragment = mFragmentActivity.getSupportFragmentManager()
					.findFragmentByTag(tag);
			if (tabinfo.fragment != null && tabinfo.fragment.isDetached()) {
				FragmentTransaction ft = mFragmentActivity
						.getSupportFragmentManager().beginTransaction();
				ft.detach(tabinfo.fragment);
				ft.commit();
			}
			mTabs.put(tag, tabinfo);
			mTabHost.addTab(spec);
		}
	}

	public static class DummyTabFactory implements TabHost.TabContentFactory {
		private final Context mContext;

		public DummyTabFactory(Context con) {
			mContext = con;
		}

		@Override
		public View createTabContent(String tag) {
			View v = new View(mContext);
			v.setMinimumHeight(0);
			v.setMinimumWidth(0);
			return v;
		}

	}

	@Override
	public void onClick(View v) {
		v.setFocusable(true);
		v.requestFocus();
		v.setFocusableInTouchMode(true);
		v.requestFocusFromTouch();
	}
}
