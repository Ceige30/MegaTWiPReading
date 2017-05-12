package com.company;
public class Student {
    public final int secret;
    public String name = "";
    public double quest1 = -1;
    public double quest2 = -1;

    public Student(int holder){
        secret = holder;
    }
    public void response1(double holder1){
        if(quest1 == -1)
            quest1 = holder1;
        else
            quest1 = (quest1 + holder1) / 2;
    }
    public void response2(double holder2){
        if(quest2 == -1)
            quest2 = holder2;
        else
            quest2 = (quest2 + holder2) / 2;
    }
    public void setName(String holder){
        name = holder;
    }
    public void printStuff(){
        System.out.printf("%-10s %-15s %-20s %-15s %-15s", name, secret, quest1 + quest2, quest1, quest2);
    }
}