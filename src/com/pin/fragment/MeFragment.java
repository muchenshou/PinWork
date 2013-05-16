package com.pin.fragment;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.pin.pinwork.R;

public class MeFragment extends Fragment {
	WebView mWebView;
	String data = "<table border=\"1\"> " + "<tr>" + "<th>Month</th>"
			+ "<th id=\"testid\"><a href='x'>Savings</a></th>" + "</tr> "
			+ "<tr>" + "<td>January</td>" + "<td>$100</td>" + "</tr>"
			+ "</table>";
	final String mimeType = "text/html";
	final String encoding = "utf-8";
	private Handler mHandler = new Handler();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_me, container, false);
		mWebView = (WebView) v.findViewById(R.id.table);
		mWebView.getSettings().setJavaScriptEnabled(true);
		//mWebView.loadData(data, mimeType, encoding);
		// mWebView.addJavascriptInterface(new Object() {
		// public void clickOnAndroid() {
		// mHandler.post(new Runnable() {
		// public void run() {
		// Log.i("hello", "wave");
		// mWebView.loadUrl("javascript:wave()");
		// }
		// });
		// }
		// }, "demo");
		// mWebView.loadUrl("file:///android_asset/me.html");
		
		//mWebView.addJavascriptInterface(new PersonService(), "personService");
		mWebView.addJavascriptInterface(new MeService(), "meService");
		mWebView.loadUrl("file:///android_asset/me.html");
		mWebView.setWebChromeClient(new WebChromeClient() {

			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				// TODO Auto-generated method stub
				Log.i("hello", "nihao");
			}

		});
		return v;
	}
	class MeService {
		public void getDetails() {
			List<Person> list = getPersonDao();
			final JSONArray array = new JSONArray();
			for (Person p : list) {
				try {
					JSONObject obj = new JSONObject();
					obj.put("name", p.getName());
					obj.put("age", p.getAge());
					obj.put("phone", p.getPhone());
					array.put(obj);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			mHandler.post(new Runnable() {
				@Override
				public void run() {
					mWebView.loadUrl("javascript:show('" + array.toString() + "')");
				}
			});
		}
		public void taskList(String list) {
			Log.i("hello", "tasklist");
		}
		private List<Person> getPersonDao() {
			List<Person> list = new ArrayList<Person>();
			list.add(new Person("aa", 32, "ÄÐ", "13675574545"));
			list.add(new Person("bb", 33, "Å®", "13698874545"));
			list.add(new Person("cc", 34, "ÄÐ", "13644464545"));
			list.add(new Person("dd", 35, "ÄÐ", "13908978877"));
			list.add(new Person("ee", 36, "Å®", "15908989898"));
			return list;
		}
	}
	
	class Person {
		private String name;
		private int age;
		private String sex;
		private String phone;

		public Person(String name, int age, String sex, String phone) {
			this.name = name;
			this.age = age;
			this.sex = sex;
			this.phone = phone;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

	}
}
