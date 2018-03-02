package com.bcht.its.utils;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


public class LoadLibUtils {
	public static String loadLib(String libPathName){
		String resource = LoadLibUtils.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String dllPath = "";
		
		if(StringUtils.endsWith(resource, "bin/")){//开发环境
			dllPath = resource.substring(1,resource.lastIndexOf("bin/"))+"lib/";
		}else if(StringUtils.endsWith(resource, ".jar")){//部署环境
			dllPath = resource.replace(".jar", "_lib/").substring(1);
		}else if(StringUtils.endsWith(resource, "target/classes/")){
			dllPath = resource.substring(1,resource.lastIndexOf("target/classes/"))+"lib/";
		}
		dllPath = dllPath + libPathName;
		dllPath = dllPath.replace("/", File.separator);
		try {
			System.out.println(URLDecoder.decode(dllPath,"UTF-8"));
			return URLDecoder.decode(dllPath,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static String loadDb(String dbname){
		String resource = LoadLibUtils.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String dllPath = "";
		
		if(StringUtils.endsWith(resource, "bin/")){//开发环境
			dllPath = resource.substring(1,resource.lastIndexOf("bin/"))+"lib/";
		}else if(StringUtils.endsWith(resource, ".jar")){//部署环境
			dllPath = resource.replace(".jar", "_lib/").substring(1);
		}
		dllPath = "jdbc:sqlite:" + dllPath + dbname;
		dllPath = dllPath.replace("/", File.separator);
		try {
			return URLDecoder.decode(dllPath,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}
	public static void main(String[] args) {
		System.out.println(LoadLibUtils.loadLib("HCNetSDK\\HCNetSDK"));
	}
}
