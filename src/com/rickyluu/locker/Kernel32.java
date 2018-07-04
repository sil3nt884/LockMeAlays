package com.rickyluu.locker;

import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.platform.win32.WinNT.HANDLE;



public interface Kernel32 extends StdCallLibrary {

	
	 Kernel32 INSTANCE = (Kernel32)Native.loadLibrary("kernel32", Kernel32.class);
	 public boolean SetProcessAffinityMask (HANDLE proccess, int mask);
	 public HANDLE GetCurrentProcess ();
	 public int GetProcessId(HANDLE procces);
    
	 public static boolean setProccessAffinity (HANDLE handle, int cpu) {
		 return INSTANCE.SetProcessAffinityMask(handle, cpu);
	 }
	 
	 
	public static int getProccessID(HANDLE procces) {
		return INSTANCE.GetProcessId(procces);
	}
	 
	public static HANDLE GetCurrentProcessHandle () {
		return INSTANCE.GetCurrentProcess();
	}
	 
     public int GetTickCount();
	
}
