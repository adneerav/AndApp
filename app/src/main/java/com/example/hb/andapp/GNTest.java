package com.example.hb.andapp;

import android.util.Log;

import java.util.List;

/**
 * Created by hb on 10/3/2015.
 */
public class GNTest {
    public static <X, B, C> void printlist(X[] list, B[] intList) {
        for (X genElement : list) {
            Log.e(" printlist ", "" + genElement);
        }
        for (B genElement : intList) {
            Log.e(" intprintlist ", "" + genElement);
        }
    }

    public <S extends Student> void stdNumber(List<S> students) {
        for (S element :
                students) {
            Log.e("Number : ", "" + element.getNumber());
            Log.e("Name : ", "" + element.getName());
        }
    }

    public class Student {
        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Student(int number, String name) {
            this.number = number;
            this.name = name;
        }

        public int number;
        public String name;
    }
}
