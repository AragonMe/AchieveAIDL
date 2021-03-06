package com.aragon.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Project: GameCenter</p>
 * <p>Title: Person</p>
 * <p>Description: Person</p>
 * <p>Copyright (c) 2016 www.oppo.com Inc. All rights reserved.</p>
 * <p>Company: OPPO</p>
 *
 * @author HuiShuang.Wu
 * @since 2016-04-19
 */
public class Person implements Parcelable {
    private int age;
    private int gender;

    public Person(int age, int gender, String name) {
        this.age = age;
        this.gender = gender;
        this.name = name;
    }

    private String name;

    protected Person(Parcel in) {
        age = in.readInt();
        gender = in.readInt();
        name = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public int getAge() {
        return age;
    }

    public int getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(age);
        dest.writeInt(gender);
        dest.writeString(name);
    }
}
