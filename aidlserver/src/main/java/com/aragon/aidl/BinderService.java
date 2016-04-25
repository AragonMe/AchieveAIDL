package com.aragon.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class BinderService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return new StubBinder();
	}

	@Override
	public void onCreate() {
		super.onCreate();
	}
	
	private static class StubBinder extends ICustom.Stub{

		@Override
		public void logPrint() {
		}

		@Override
		public Person getPerson(Person prePerson) throws RemoteException {
			String name = "Aragon";
			if (null != prePerson){
				name = name + prePerson.getName();
			}
			return new Person(12, 1, name);
		}

	}
}
