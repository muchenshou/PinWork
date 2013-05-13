package com.pin.fragment;

import java.util.ArrayList;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.pin.pinwork.R;

public class RoleFragment extends Fragment {
	private ListView mListView;
	private ArrayList<Model> mModelList = new ArrayList<Model>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_role, container, false);
		mListView = (ListView) v.findViewById(R.id.tasks_list);
		return v;
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
