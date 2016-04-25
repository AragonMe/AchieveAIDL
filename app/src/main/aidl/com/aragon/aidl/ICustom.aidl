package com.aragon.aidl;
import com.aragon.aidl.Person;
interface ICustom {
	 void logPrint();
	 Person getPerson(in Person prePerson);
}
