package com.pin.fragment;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.pin.pinwork.R;

/**
 * @author songzhentao
 * ืฌรื
 */
public class RoleFragment extends Fragment {
	private ListView mListView;
	private ArrayList<Model> mModelList = new ArrayList<Model>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i("hello","onCreateView");
		View v = inflater.inflate(R.layout.fragment_role, container, false);
		mListView = (ListView) v.findViewById(R.id.tasks_list);
		return v;
	}

	@Override
	public void onAttach(Activity activity) {
		Log.i("hello","onAttach");
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i("hello","onCreate");
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onDestroy() {
		Log.i("hello","onDestroy");
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		Log.i("hello","onDetach");
		super.onDetach();
	}

	@Override
	public void onPause() {
		Log.i("hello","onPause");
		super.onPause();
	}

	@Override
	public void onStart() {
		Log.i("hello","onStart");
		super.onStart();
	}

	@Override
	public void onStop() {
		Log.i("hello","onStop");
		super.onStop();
	}

	class ViewHolder {
		ImageView app_icon;
		ImageView arrow;
		TextView task_name;
		TextView task_summary;
		TextView amount;
	}

	class Model {
		Drawable app_icon;
		Drawable arrow;
		String task_name;
		String task_summary;
		String amount;
	}

	class MyAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			return null;
		}

	}
}
