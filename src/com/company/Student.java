package com.company;
import java.util.*;

public class Student{
    public static boolean numsNull;
    public int seceret;
    public double quest1;
    public double quest2;
    public double total;
    public String name = " ";
    public ArrayList<Double> scoresq1 = new ArrayList<>();
    public ArrayList<Double> scoresq2 = new ArrayList<>();
    public static ArrayList<Integer> seceretList = new ArrayList<Integer>();

    public Student (Integer holder){
        seceret = holder;
        seceretList.add(holder);
        if(!numsNull){
            numsNull = true;
        }
    }
    public void changeName(String store){
        name  = store;
    }
    public void addScoreQ1(double num){
        scoresq1.add(num);
    }
    public void addScoreQ2(double num){
        scoresq2.add(num);
    }

    public void totalScoreQ1() {
        for (double holder: scoresq1)
            quest1 += holder;
        quest1 =  (quest1) /2;
    }

    public void totalScoreQ2(){
        for(double holder: scoresq2)
            quest2 += holder;
        quest2 = (quest2 )/2;
    }

    public void totalAvg(){
        total = quest1 + quest2;
    }
}