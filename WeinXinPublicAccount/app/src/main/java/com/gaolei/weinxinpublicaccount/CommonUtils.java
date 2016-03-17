package com.gaolei.weinxinpublicaccount;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {
	public static CommonUtils util;
	public static InputMethodManager imm;

	public CommonUtils(Context context) {
		imm = (InputMethodManager) context
				.getSystemService(Context.INPUT_METHOD_SERVICE);
	}

	public CommonUtils() {
	}

	public static CommonUtils getUtilInstance() {
		if (util == null) {

			util = new CommonUtils();
		}
		return util;
	}


	public void getViewHeight(View view, View view2) {
		int w = View.MeasureSpec.makeMeasureSpec(0,
				View.MeasureSpec.UNSPECIFIED);
		int h = View.MeasureSpec.makeMeasureSpec(0,
				View.MeasureSpec.UNSPECIFIED);
		view.measure(w, h);
		int height = view.getMeasuredHeight();
		int width = view.getMeasuredWidth();
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT, height);
		params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		view2.setLayoutParams(params);
	}

	public int getPhoneAndroidSDK() {
		// TODO Auto-generated method stub
		int version = 0;
		try {
			version = Integer.valueOf(android.os.Build.VERSION.SDK);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return version;
	}

	public String transformMillisToDate(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd",
		 Locale.CHINA);
//		SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm",
//				Locale.CHINA);
		return format.format(calendar.getTime());
	}

	public String msToMS(long ms) {
		Integer s = 1000;
		Integer m = s * 60;
		Long minute = ms / m;
		Long second = (ms - minute) / s;
		StringBuilder sb = new StringBuilder();
		if (minute > 0) {
			if (minute < 10) {
				sb.append("0" + minute + ":");
			} else {
				sb.append(minute + ":");
			}
		} else {
			sb.append("00:");
		}
		if (second > 0) {
			if (second < 10) {
				sb.append("0" + second);
			} else {
				sb.append(second);
			}
		} else {
			sb.append("00");
		}
		return sb.toString();
	}


	public boolean isHanZi(Context context, String text) {
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(text);
		m = p.matcher(text);
		return m.matches();
	}

	public boolean isConnectingToInternet(Context context) {

		ConnectivityManager manager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (manager != null) {
			NetworkInfo[] info = manager.getAllNetworkInfo();
			if (info != null)
				for (int i = 0; i < info.length; i++) {
					System.out.println(info[i].getState());
					if (info[i].getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}
				}
		}
		return false;
	}

	public boolean isWifiConnected(Context context) {
		ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo wifi = connectivityManager
				.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		return wifi.isConnected();

	}

	public void hideIMM() {
		imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,
				InputMethodManager.HIDE_NOT_ALWAYS);
	}

	public void showIMM() {
		imm.toggleSoftInput(0, InputMethodManager.RESULT_SHOWN);
	}

	public void deleteFile(Context context, File file) {
		if (file.exists()) {
			if (file.isFile()) {
				file.delete();
			} else if (file.isDirectory()) {
				for (File files : file.listFiles()) {
					if (files.isFile()) {
						files.delete();
					} else if (files.isDirectory()) {
						deleteFile(context, files);
					}
				}
				file.delete();
			}

		}
	}

	public boolean isAppExit(Context context, String packageName) {
		if (packageName == null || "".equals(packageName))
			return false;
		try {
			ApplicationInfo info = context.getPackageManager()
					.getApplicationInfo(packageName,
							PackageManager.GET_UNINSTALLED_PACKAGES);
			return true;
		} catch (NameNotFoundException e) {
			return false;
		}
	}


	public int dp2px(Context context, int dp) {
		float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dp * scale + 0.5f);
	}

	public int px2dp(Context context, int px) {
		float scale = context.getResources().getDisplayMetrics().density;
		return (int) (px / scale + 0.5f);
	}

	public boolean isMobileNum(String mobiles) {
		Pattern p = Pattern
				.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		System.out.println(m.matches() + "---");
		return m.matches();

	}
	public static int getScreenWidth(Context context)
	{
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		return outMetrics.widthPixels;
	}

	/**
	 * 获得屏幕宽度
	 *
	 * @param context
	 * @return
	 */
	public static int getScreenHeight(Context context)
	{
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		return outMetrics.heightPixels;
	}

}