package com.flowertailcat.davy.drums;

public class Log {
	private static boolean mstartlog = false;
	public  static void startlog(){
		mstartlog = true;
	}
	
	public  static void stoplog(){
		mstartlog = false;
	}
	
	public static void printLog(String content) {
		if (mstartlog) {
			System.out.println(content);
		}
	}
	
}
