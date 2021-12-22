package ru.vsu.cs.sidorovaei.mains;

import ru.vsu.cs.sidorovaei.logics.Line;
import ru.vsu.cs.sidorovaei.logics.Logic;

import java.util.ArrayList;

public class testsMain {
    public static void runTests() throws Exception {
        ArrayList<Line> listOfLines1 = Logic.readListFromFile("input1.txt");
        ArrayList<Line> answer1 = Logic.readListFromFile("answer1.txt");
        test(Logic.getListOfMergedLines(listOfLines1), answer1);
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