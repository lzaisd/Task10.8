package ru.vsu.cs.sidorovaei.mains;

import ru.vsu.cs.sidorovaei.logics.Line;
import ru.vsu.cs.sidorovaei.logics.Logic;

import java.util.ArrayList;

public class testsMain {
    public static void runTests() throws Exception {
        ArrayList<Line> listOfLines1 = Logic.readListFromFile("input1.txt");
        ArrayList<Line> answer1 = Logic.readListFromFile("answer1.txt");
        test(Logic.getListOfMergedLines(listOfLines1), answer1);
        ArrayList<Line> listOfLines2 = Logic.readListFromFile("input2.txt");
        ArrayList<Line> answer2 = Logic.readListFromFile("answer2.txt");
        test(Logic.getListOfMergedLines(listOfLines2), answer2);
        ArrayList<Line> listOfLines3 = Logic.readListFromFile("input3.txt");
        ArrayList<Line> answer3 = Logic.readListFromFile("answer3.txt");
        test(Logic.getListOfMergedLines(listOfLines3), answer3);
        ArrayList<Line> listOfLines4 = Logic.readListFromFile("input4.txt");
        ArrayList<Line> answer4 = Logic.readListFromFile("answer4.txt");
        test(Logic.getListOfMergedLines(listOfLines4), answer4);
    }
    public static void test(ArrayList<Line> listOfLines, ArrayList<Line> answer) {
        System.out.print("Полученный ответ: ");
        for (Line i: listOfLines) {
            System.out.printf("%s %s; ", i.getA(), i.getB());
        }
        System.out.println();
        System.out.print("Верный ответ: ");
        for (Line i: answer) {
            System.out.printf("%s %s; ", i.getA(), i.getB());
        }
        System.out.println();
        System.out.println();
    }
}