package com.rickyluu.locker;

import java.util.Arrays;
import java.util.List;
import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.win32.StdCallLibrary;

public interface User32 extends StdCallLibrary {

	User32 user32 = (User32) Native.loadLibrary("user32", User32.class);

	public boolean GetLastInputInfo(LASTINPUTINFO result);
	public boolean LockWorkStation();

	public static long GetInactiveTime() {
		User32.LASTINPUTINFO lastInputInfo = new User32.LASTINPUTINFO();
		lastInputInfo.cbSize = 8;
		if(user32.GetLastInputInfo(lastInputInfo)) {
			return (Kernel32.INSTANCE.GetTickCount() - lastInputInfo.dwTime) /1000;
		}
		return 0;

	}
	
	public static boolean lockUser () {
		boolean locked = user32.LockWorkStation();
		return locked;
	}
	
	
	
	public class LASTINPUTINFO extends Structure {
		public int cbSize;
		public int dwTime;

		@Override
		protected List<String> getFieldOrder() {
			return Arrays.asList(new String[] { "cbSize", "dwTime" });
		}

	}

}
