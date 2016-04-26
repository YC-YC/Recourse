/**
 * 
 */
package com.example.resources.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.util.Log;

import com.example.plug.IComm;

import dalvik.system.DexClassLoader;

/**
 * @author YC
 * @time 2016-4-21 下午3:54:11 功能函数收集
 */
public class Utils {

	private static final String TAG = "Utils";

	/**读取插件*/
	public static void ReadPlugIn(Context context, ClassLoader parent) {
		LogUtil.startTime("获取插件信息");
		Intent it = new Intent("com.example.plugin.client", null);
		PackageManager packageManager = context.getPackageManager();
		List<ResolveInfo> plugins = packageManager.queryIntentActivities(it, 0);
		ResolveInfo rinfo = plugins.get(0);
		ActivityInfo ainfo = rinfo.activityInfo;
		

		String div = System.getProperty("path.separator");
		String packageName = ainfo.packageName;
		try {
			Resources res = packageManager.getResourcesForApplication(packageName);
			int id = 0;
			id = res.getIdentifier("version", "string", packageName);
			String version = res.getString(id);
			Log.i(TAG, "get pulgin version = " + version);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String dexPath = ainfo.applicationInfo.sourceDir;
		String outDir = context.getApplicationInfo().dataDir;
		String libraryDir = ainfo.applicationInfo.nativeLibraryDir;
		
		DexClassLoader loader = new DexClassLoader(dexPath, outDir, libraryDir, parent);
	
		try {
			Class<?> clazz = loader.loadClass(packageName + ".PlugInClass");
			/*Object object = clazz.newInstance();
			Class[] parames = new Class[2];
			parames[0] = Integer.TYPE;
			parames[1] = Integer.TYPE;
			Method method = clazz.getMethod("function1", parames);
			Integer result = (Integer)method.invoke(object, 12, 34);*/
			IComm comm = (IComm)clazz.newInstance();
			int result = comm.function1(12, 45);
			Log.i(TAG, "return val = " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LogUtil.endUseTime("获取插件信息");
	}
	
	/**
	 * 洗牌算法
	 */
	public static void shuffle() {
		Vector<String> array = new Vector<String>();
		for (int i = 0; i < 52; i++) {
			array.add("string" + i);
		}
		for (int i = 0; i < 52; i++) {
			Log.i(TAG, array.get(i));
		}

		for (int i = 0; i < array.size(); i++) {
			int key = i;
			int temp = new Random().nextInt(array.size() - 1);
			String tempStr = array.get(temp);
			array.set(temp, array.get(key));
			array.set(key, tempStr);
		}
		for (int i = 0; i < 52; i++) {
			Log.i(TAG, array.get(i));
		}
	}

	/**
	 * 调用Runtime
	 */
	public static void runRuntimeFun() {
		new Thread() {
			public void run() {
				try {
					Runtime.getRuntime().exec(new String[] { "logcat", "-c" })
							.waitFor();
					Process process = Runtime.getRuntime().exec(
							new String[] { "logcat" });
					Log.i(TAG, "exec logcat");

					BufferedReader reader = new BufferedReader(
							new InputStreamReader(process.getInputStream()));

					String line;
					while ((line = reader.readLine()) != null) {
						// Log.i(TAG, "get logcat = " + line);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			};
		}.start();
	}

}
