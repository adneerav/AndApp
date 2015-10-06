package com.example.hb.andapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.Window;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WSAsync extends AsyncTask<String, Integer, String> {

	private ProgressDialog mProgressDialog;
	private IResultListener mIResultListener;
	private int requestCode;
	private Context mContext;

	public WSAsync(Context ctx, IResultListener resListener, int requestCode) {
		this.mContext = ctx;
		this.mIResultListener = resListener;
		this.requestCode = requestCode;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();

		mProgressDialog = new ProgressDialog(mContext);
		mProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		mProgressDialog.setCancelable(false);
		mProgressDialog.setCanceledOnTouchOutside(false);
		mProgressDialog.setMessage("Loading...");
		mProgressDialog.show();
	}

	@Override
	protected String doInBackground(String... params) {
		URL url;
		URLConnection conn;
		InputStream stream;
		StringBuilder strBuild;
		try {

			url = new URL(params[0]);
			Log.e("doInBackground", params[0] + "");
			conn = url.openConnection();
			stream = conn.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					stream));
			strBuild = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null)
				strBuild.append(line);

			return strBuild.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		mProgressDialog.dismiss();
		mIResultListener.onResult(result, 100, requestCode);
	}

	public interface IResultListener {
		void onResult(Object obj, int responseCode, int requestCode);
	}
}
