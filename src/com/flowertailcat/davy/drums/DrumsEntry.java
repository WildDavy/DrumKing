package com.flowertailcat.davy.drums;

import java.util.Arrays;
import java.util.HashMap;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.Event;
import net.java.games.input.EventQueue;


public class DrumsEntry {

	private static Controller[] mctlList = null;
	private static Controller[] mController = new Controller[6];
	private static Component[] mCp = null;
	private static Component[] mLastCp = null;
	private static HashMap<Integer,String>  mKeyBoardName = new HashMap();
	
	public static void main(String[] args) {
		mctlList = ControllerEnvironment.getDefaultEnvironment().getControllers();
		System.out.println(Arrays.toString(mctlList)+"okkkkk");
		for(int i=0; i<mctlList.length; i++) {
			System.out.println("name:      "+mctlList[i].toString());
			System.out.println("type :    "+mctlList[i].getType());
			if (mctlList[i].getType() == Controller.Type.KEYBOARD) {
				mController[i] = mctlList[i];
				mKeyBoardName.put(i, mctlList[i].toString());
			}
		}
		while(true) {
			for(int a = 0; a < mController.length; a++) {
				if (mController[a] == null) {
					break;
				}
				mController[a].poll();
				mCp = mController[a].getComponents();
				for (int i = 0 ; i < mCp.length; i++) {
					Log.startlog();
					if (!"Unknown".equals(mCp[i].getName()) && 0.0 != mCp[i].getPollData() &&  -1.0 != mCp[i].getPollData()) {
						Log.printLog("DrumsEntry  "+mCp[i].getName()+"   "+mCp[i].getPollData()+"   "+a+"   "+mKeyBoardName.get(a));
					}
					
					Log.stoplog();
				}
			}
			
			
			
			
//			EventQueue queue = mController.getEventQueue();
//			Event event = new Event();
//			System.out.println("queue.getNextEvent(event)   "+queue.getNextEvent(event));
//			while(queue.getNextEvent(event)) {
//				Component com = event.getComponent();
//				float value = event.getValue();
//				System.out.println(value);
//			}
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
