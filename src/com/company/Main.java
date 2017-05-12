package com.company;
import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) throws java.io.IOException {
        Scanner sc = new Scanner(new File("data.txt"));
        Scanner sc2 = new Scanner(new File("data.txt"));
        sc.nextLine();
        sc2.nextLine();
        while (sc.hasNextLine()){
            int num = sc.nextInt();
            if (getStudent(num) == null)
                namesList.add(new Student(num));
            sc.nextLine();
        }
        while (sc2.hasNextLine()){
            String line = sc2.nextLine();
            Scanner sc3 = new Scanner(line);
            int valueOf = sc3.nextInt();
            int sybs = 1;
            sc3.useDelimiter("\\t");
            double quest1 = 0;
            double quest2 = 0;

            while (sc3.hasNext()){
                String piece = sc3.next();
                if (piece.replaceAll("[^0123456789\\+]", "").matches("\\+.*\\d")) {
                    piece = removeStuff(piece);
                    piece = piece.replaceAll("[^0123456789.\\s]", "");
                    Scanner sc4 = new Scanner(piece);
                    while (sc4.hasNextDouble()) {
                        double number = sc4.nextDouble();
                        if (number != 3) {
                            if (sybs == 1)
                                quest1 = quest1 + number;
                            else
                                quest2 = quest2 + number;
                        }
                    }
                } else if (!piece.isEmpty()) {
                    if ((piece.replaceAll("[0123456789]", "").isEmpty())) {
                        if (sybs == 1) {
                            quest1 -= (Integer.parseInt(piece)) * .25;
                            if(quest1 <= 0)
                                quest1 = 0;
                            sybs++;
                        } else if(sybs == 2){
                            quest2 -= (Integer.parseInt(piece)) * .25;
                            if(quest2 <= 0)
                                quest2 = 0;
                            break;
                        }
                    }
                }
            }
            namesList.get(valueOf - 1).response1(quest1);
            namesList.get(valueOf - 1).response2(quest2);
        }
        setNames();
        /**Prints data out*/
        System.out.printf("%-10s %-15s %-20s %-15s %-15s","Name","Secret Number","Avg Total Grade","FR Q1 Grade","FR Q2 Grade");
        System.out.println();
        for (int i = 0; i < namesList.size(); i++) {
            namesList.get(i).printStuff();
            System.out.println();
        }
    }
    public static ArrayList<Student> namesList = new ArrayList<>();
    /**Removes any unnecessary info*/
    public static String removeStuff(String holder) {
        for (int i = 0; i < holder.length(); i++) {
            if (holder.substring(i, i + 1).replaceAll("[a-zA-Z]", "").isEmpty()) {
                try{
                    holder = holder.substring(0, i) + holder.substring(i + 2, holder.length());
                }catch(Exception e){}
            }
        }
        return holder;
    }
    /**Gets student*/
    public static Student getStudent(int holder) {
        int i = 0;
        while (i < namesList.size()) {
            if (namesList.get(i).secret == holder)
                return namesList.get(i);
            i++;
        }
        return null;
    }
    /**Gets student names and sets it equivalent*/
    public static void setNames() throws java.io.IOException {
        Scanner sc5 = new Scanner(new File("names.txt"));
        while (sc5.hasNextLine()) {
            String name = sc5.next();
            getStudent(sc5.nextInt()).setName(name);
            if(!sc5.hasNextLine())
                break;
            sc5.nextLine();
        }
    }
}