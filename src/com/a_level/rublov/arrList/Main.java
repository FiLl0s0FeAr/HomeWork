package com.a_level.rublov.arrList;

public class Main {

    public static void main(String[] args) {

        MyArrayList<String> mr = new MyArrayList<>();

        mr.add("Shaper");
        mr.add("Elder");
        mr.add("Zana");

        System.out.println(mr.get(0));

        System.out.printf("ArrayList has %d elements \n", mr.size());

    }
}


