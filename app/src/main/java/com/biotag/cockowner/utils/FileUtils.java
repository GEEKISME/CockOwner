package com.biotag.cockowner.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class FileUtils {

	public static final String ROOT_DIR = "cockowner";
	public static final String DOWNLOAD_DIR = "download";
	public static final String CACHE_DIR = "cache";
	public static final String ICON_DIR = "icon";

	//=================================一下是新加的
	private static String APP_DIR_NAME = "cockowner";
	private static String FILE_DIR_NAME = "files";
	private static String mRootDir;
	private static String mAppRootDir;
	private static String mFileDir;


	/** 判断SD卡是否挂载 */
	public static boolean isSDCardAvailable() {
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			return true;
		} else {
			return false;
		}
	}

	/** 获取下载目录 */
	public static String getDownloadDir() {
		return getDir(DOWNLOAD_DIR);
	}

	/** 获取缓存目录 */
	public static String getCacheDir() {
		return getDir(CACHE_DIR);
	}

	/** 获取icon目录 */
	public static String getIconDir() {
		return getDir(ICON_DIR);
	}

	/** 获取应用目录，当SD卡存在时，获取SD卡上的目录，当SD卡不存在时，获取应用的cache目录 */
	public static String getDir(String name) {
		StringBuilder sb = new StringBuilder();
		if (isSDCardAvailable()) {
			sb.append(getExternalStoragePath());
		} else {
			sb.append(getCachePath());
		}
		sb.append(name);
		sb.append(File.separator);
		String path = sb.toString();
		if (createDirs(path)) {
			return path;
		} else {
			return null;
		}
	}

	/** 获取SD下的应用目录 */
	public static String getExternalStoragePath() {
		StringBuilder sb = new StringBuilder();
		sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
		sb.append(File.separator);
		sb.append(ROOT_DIR);
		sb.append(File.separator);
		return sb.toString();
	}

	/** 获取应用的cache目录 */
	public static String getCachePath() {
		File f = UIUtils.getContext().getCacheDir();
		if (null == f) {
			return null;
		} else {
			return f.getAbsolutePath() + "/";
		}
	}

	/** 创建文件夹 */
	public static boolean createDirs(String dirPath) {
		File file = new File(dirPath);
		if (!file.exists() || !file.isDirectory()) {
			return file.mkdirs();
		}
		return true;
	}

	/** 复制文件，可以选择是否删除源文件 */
	public static boolean copyFile(String srcPath, String destPath, boolean deleteSrc) {
		File srcFile = new File(srcPath);
		File destFile = new File(destPath);
		return copyFile(srcFile, destFile, deleteSrc);
	}

	/** 复制文件，可以选择是否删除源文件 */
	public static boolean copyFile(File srcFile, File destFile, boolean deleteSrc) {
		if (!srcFile.exists() || !srcFile.isFile()) {
			return false;
		}
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(destFile);
			byte[] buffer = new byte[1024];
			int i = -1;
			while ((i = in.read(buffer)) > 0) {
				out.write(buffer, 0, i);
				out.flush();
			}
			if (deleteSrc) {
				srcFile.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			IOUtils.close(out);
			IOUtils.close(in);
		}
		return true;
	}

	/** 判断文件是否可写 */
	public static boolean isWriteable(String path) {
		try {
			if (TextUtils.isEmpty(path)) {
				return false;
			}
			File f = new File(path);
			return f.exists() && f.canWrite();
		} catch (Exception e) {
			//LogUtils.e(e);
			return false;
		}
	}

	/** 修改文件的权限,例如"777"等 */
	public static void chmod(String path, String mode) {
		try {
			String command = "chmod " + mode + " " + path;
			Runtime runtime = Runtime.getRuntime();
			runtime.exec(command);
		} catch (Exception e) {
			//LogUtils.e(e);
		}
	}

	/**
	 * 把数据写入文件
	 * @param is       数据流
	 * @param path     文件路径
	 * @param recreate 如果文件存在，是否需要删除重建
	 * @return 是否写入成功
	 */
	public static boolean writeFile(InputStream is, String path, boolean recreate) {
		boolean res = false;
		File f = new File(path);
		FileOutputStream fos = null;
		try {
			if (recreate && f.exists()) {
				f.delete();
			}
			if (!f.exists() && null != is) {
				File parentFile = new File(f.getParent());
				parentFile.mkdirs();
				int count = -1;
				byte[] buffer = new byte[1024];
				fos = new FileOutputStream(f);
				while ((count = is.read(buffer)) != -1) {
					fos.write(buffer, 0, count);
				}
				res = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.close(fos);
			IOUtils.close(is);
		}
		return res;
	}

	/**
	 * 把字符串数据写入文件
	 * @param content 需要写入的字符串
	 * @param path    文件路径名称
	 * @param append  是否以添加的模式写入
	 * @return 是否写入成功
	 */
	public static boolean writeFile(byte[] content, String path, boolean append) {
		boolean res = false;
		File f = new File(path);
		RandomAccessFile raf = null;
		try {
			if (f.exists()) {
				if (!append) {
					f.delete();
					f.createNewFile();
				}
			} else {
				f.createNewFile();
			}
			if (f.canWrite()) {
				raf = new RandomAccessFile(f, "rw");
				raf.seek(raf.length());
				raf.write(content);
				res = true;
			}
		} catch (Exception e) {
			//LogUtils.e(e);
		} finally {
			IOUtils.close(raf);
		}
		return res;
	}

	/**
	 * 把字符串数据写入文件
	 * @param content 需要写入的字符串
	 * @param path    文件路径名称
	 * @param append  是否以添加的模式写入
	 * @return 是否写入成功
	 */
	public static boolean writeFile(String content, String path, boolean append) {
		return writeFile(content.getBytes(), path, append);
	}

	/**
	 * 把键值对写入文件
	 * @param filePath 文件路径
	 * @param key      键
	 * @param value    值
	 * @param comment  该键值对的注释
	 */
	public static void writeProperties(String filePath, String key, String value, String comment) {
		if (TextUtils.isEmpty(key) || TextUtils.isEmpty(filePath)) {
			return;
		}
		FileInputStream fis = null;
		FileOutputStream fos = null;
		File f = new File(filePath);
		try {
			if (!f.exists() || !f.isFile()) {
				f.createNewFile();
			}
			fis = new FileInputStream(f);
			Properties p = new Properties();
			p.load(fis);// 先读取文件，再把键值对追加到后面
			p.setProperty(key, value);
			fos = new FileOutputStream(f);
			p.store(fos, comment);
		} catch (Exception e) {
			//LogUtils.e(e);
		} finally {
			IOUtils.close(fis);
			IOUtils.close(fos);
		}
	}

	/** 根据值读取 */
	public static String readProperties(String filePath, String key, String defaultValue) {
		if (TextUtils.isEmpty(key) || TextUtils.isEmpty(filePath)) {
			return null;
		}
		String value = null;
		FileInputStream fis = null;
		File f = new File(filePath);
		try {
			if (!f.exists() || !f.isFile()) {
				f.createNewFile();
			}
			fis = new FileInputStream(f);
			Properties p = new Properties();
			p.load(fis);
			value = p.getProperty(key, defaultValue);
		} catch (IOException e) {
			//LogUtils.e(e);
		} finally {
			IOUtils.close(fis);
		}
		return value;
	}

	/** 把字符串键值对的map写入文件 */
	public static void writeMap(String filePath, Map<String, String> map, boolean append, String comment) {
		if (map == null || map.size() == 0 || TextUtils.isEmpty(filePath)) {
			return;
		}
		FileInputStream fis = null;
		FileOutputStream fos = null;
		File f = new File(filePath);
		try {
			if (!f.exists() || !f.isFile()) {
				f.createNewFile();
			}
			Properties p = new Properties();
			if (append) {
				fis = new FileInputStream(f);
				p.load(fis);// 先读取文件，再把键值对追加到后面
			}
			p.putAll(map);
			fos = new FileOutputStream(f);
			p.store(fos, comment);
		} catch (Exception e) {
			//LogUtils.e(e);
		} finally {
			IOUtils.close(fis);
			IOUtils.close(fos);
		}
	}

	/** 把字符串键值对的文件读入map */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static Map<String, String> readMap(String filePath, String defaultValue) {
		if (TextUtils.isEmpty(filePath)) {
			return null;
		}
		Map<String, String> map = null;
		FileInputStream fis = null;
		File f = new File(filePath);
		try {
			if (!f.exists() || !f.isFile()) {
				f.createNewFile();
			}
			fis = new FileInputStream(f);
			Properties p = new Properties();
			p.load(fis);
			map = new HashMap<String, String>((Map) p);// 因为properties继承了map，所以直接通过p来构造一个map
		} catch (Exception e) {
			//LogUtils.e(e);
		} finally {
			IOUtils.close(fis);
		}
		return map;
	}

	/** 改名 */
	public static boolean copy(String src, String des, boolean delete) {
		File file = new File(src);
		if (!file.exists()) {
			return false;
		}
		File desFile = new File(des);
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(file);
			out = new FileOutputStream(desFile);
			byte[] buffer = new byte[1024];
			int count = -1;
			while ((count = in.read(buffer)) != -1) {
				out.write(buffer, 0, count);
				out.flush();
			}
		} catch (Exception e) {
			//LogUtils.e(e);
			return false;
		} finally {
			IOUtils.close(in);
			IOUtils.close(out);
		}
		if (delete) {
			file.delete();
		}
		return true;
	}

	//================================================================================
	//将图片转换为file
	private static final int EOF = -1;
	private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;
	public static File from(Context context, Uri uri) throws IOException {
		InputStream inputStream = context.getContentResolver().openInputStream(uri);
		String fileName = getFileName(context, uri);
		String[] splitName = splitFileName(fileName);
		File tempFile = File.createTempFile(splitName[0], splitName[1]);
		tempFile = rename(tempFile, fileName);
		tempFile.deleteOnExit();
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(tempFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (inputStream != null) {
			copy(inputStream, out);
			inputStream.close();
		}

		if (out != null) {
			out.close();
		}
		return tempFile;
	}

	private static String[] splitFileName(String fileName) {
		String name = fileName;
		String extension = "";
		int i = fileName.lastIndexOf(".");
		if (i != -1) {
			name = fileName.substring(0, i);
			extension = fileName.substring(i);
		}

		return new String[]{name, extension};
	}

	private static String getFileName(Context context, Uri uri) {
		String result = null;
		if (uri.getScheme().equals("content")) {
			Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
			try {
				if (cursor != null && cursor.moveToFirst()) {
					result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (cursor != null) {
					cursor.close();
				}
			}
		}
		if (result == null) {
			result = uri.getPath();
			int cut = result.lastIndexOf(File.separator);
			if (cut != -1) {
				result = result.substring(cut + 1);
			}
		}
		return result;
	}

	private static File rename(File file, String newName) {
		File newFile = new File(file.getParent(), newName);
		if (!newFile.equals(file)) {
			if (newFile.exists() && newFile.delete()) {
				Log.d("FileUtil", "Delete old " + newName + " file");
			}
			if (file.renameTo(newFile)) {
				Log.d("FileUtil", "Rename file to " + newName);
			}
		}
		return newFile;
	}

	private static long copy(InputStream input, OutputStream output) throws IOException {
		long count = 0;
		int n;
		byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
		while (EOF != (n = input.read(buffer))) {
			output.write(buffer, 0, n);
			count += n;
		}
		return count;
	}

	//==========================以下是针对7.0 加入的方法
	public static void init() {
		mRootDir = getRootPath();
		if (mRootDir != null && !"".equals(mRootDir)) {
			mAppRootDir = mRootDir + "/" + APP_DIR_NAME;
			mFileDir = mAppRootDir + "/" + FILE_DIR_NAME;
			File appDir = new File(mAppRootDir);
			if (!appDir.exists()) {
				appDir.mkdirs();
			}
			File fileDir = new File(mAppRootDir + "/" + FILE_DIR_NAME);
			if (!fileDir.exists()) {
				fileDir.mkdirs();
			}

		} else {
			mRootDir = "";
			mAppRootDir = "";
			mFileDir = "";
		}
	}

	public static String getFileDir(){
		return mFileDir;
	}


	public static String getRootPath() {
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			return Environment.getExternalStorageDirectory().getAbsolutePath(); // filePath:  /sdcard/
		} else {
			return Environment.getDataDirectory().getAbsolutePath() + "/data"; // filePath:  /data/data/
		}
	}

	/**
	 * 打开文件
	 * 兼容7.0
	 *
	 * @param context     activity
	 * @param file        File
	 * @param contentType 文件类型如：文本（text/html）
	 *                    当手机中没有一个app可以打开file时会抛ActivityNotFoundException
	 */
	public static void startActionFile(Context context, File file, String contentType) throws ActivityNotFoundException {
		if (context == null) {
			return;
		}
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
		intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);//增加读写权限
		intent.setDataAndType(getUriForFile(context, file), contentType);
		if (!(context instanceof Activity)) {
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		}
		context.startActivity(intent);
	}

	/**
	 * 打开相机
	 * 兼容7.0
	 *
	 * @param activity    Activity
	 * @param file        File
	 * @param requestCode result requestCode
	 */
	public static void startActionCapture(Activity activity, File file, int requestCode) {
		if (activity == null) {
			return;
		}
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, getUriForFile(activity, file));
		activity.startActivityForResult(intent, requestCode);
	}


	public static Uri getUriForFile(Context context, File file) {
		if (context == null || file == null) {
			throw new NullPointerException();
		}
		Uri uri;
		if (Build.VERSION.SDK_INT >= 24) {
			uri = FileProvider.getUriForFile(context.getApplicationContext(), "com.biotag.cockowner.fileprovider", file);
		} else {
			uri = Uri.fromFile(file);
		}
		return uri;
	}


}
