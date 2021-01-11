package com.hfxt.test;

import io.jsonwebtoken.*;
import io.jsonwebtoken.lang.Strings;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Test test=new Test();
        test.t1();
    }

    public void test1() {
        ArrayList<Integer> b = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String s1[] = s.split(",");
        for (int i = 0; i < s1.length; i++) {
            b.add(Integer.valueOf(s1[i]));
        }

        for (int l = 0; l < b.size(); l++) {
            for (int i = 0; i < b.size() - 1; i++) {
                int k = 0;
                if (b.get(i) > b.get(i + 1)) {
                    k = b.get(i);
                    b.set(i, b.get(i + 1));
                    b.set(i + 1, k);
                }
            }
        }


        for (int i = 0; i < b.size(); i++) {
            System.out.println(b.get(i));
        }

    }

    public void t1(){
        int a=1;
        double b=1.111;
        System.out.println(b/a);
    }
}
