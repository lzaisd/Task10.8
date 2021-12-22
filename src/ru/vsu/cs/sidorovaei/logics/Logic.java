package ru.vsu.cs.sidorovaei.logics;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Logic {
    public static boolean checkIfListIsEmpty(ArrayList<Line> list) {
        return list.size() == 0;
    }

    public static void bubbleSort(ArrayList<Line> listOfLines) {
        boolean isSorted = false;
        Line temp;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < listOfLines.size() - 1; i++) {
                if (listOfLines.get(i).getA() > listOfLines.get(i+1).getA()) {
                    temp = listOfLines.get(i);
                    listOfLines.set(i, listOfLines.get(i+1));
                    listOfLines.set(i+1, temp);
                    isSorted = false;
                }
            }
        }
    }

    public static ArrayList<Line> getListOfMergedLines(ArrayList<Line> listOfLines) {
        bubbleSort(listOfLines);
        ArrayList<Line> finalListOfLines = new ArrayList<>();
        if (listOfLines.size() == 1) {                       //Список состоит из одного отрезка
            finalListOfLines.add(listOfLines.get(0));
        } else {
            for (int i = 1; i < listOfLines.size(); i++) {
                if (listOfLines.get(i).getA() >= listOfLines.get(i-1).getA() && listOfLines.get(i).getA() <= listOfLines.get(i-1).getB()) {
                    if (listOfLines.get(i).getB() > listOfLines.get(i-1).getB()) {
                        listOfLines.get(i).setA(listOfLines.get(i-1).getA());
                        if (i == listOfLines.size() - 1) {                     //Условие для ситуации, когда нужно совместить последний и предпоследний отрезки
                            finalListOfLines.add(listOfLines.get(i));
                        }
                    } else {
                        listOfLines.get(i).setA(listOfLines.get(i-1).getA());  //Нынешний отрезок находится внутри предыдущего
                        listOfLines.get(i).setB(listOfLines.get(i-1).getB());
                    }
                } else if (i == listOfLines.size() - 1) {
                    finalListOfLines.add(listOfLines.get(i-1));
                    finalListOfLines.add(listOfLines.get(i));
                } else {
                    finalListOfLines.add(listOfLines.get(i - 1));
                }
            }
        }
        return finalListOfLines;
    }

    public static Line stringToLine(String string) {
        String[] data = string.trim().split(" ");
        return new Line(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
    }

    public static ArrayList<Line> readListFromJTable(JTable table) {
        ArrayList<Line> listOfLines = new ArrayList<>();
        for (int i = 0; i < table.getRowCount(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < table.getColumnCount(); j++) {
                sb.append(table.getModel().getValueAt(i, j));
                sb.append(" ");
            }
            listOfLines.add(stringToLine(new String(sb)));
        }
        return listOfLines;
    }

    public static ArrayList<Line> readListFromFile(String fileName) throws Exception {
        ArrayList<Line> listOfLines = new ArrayList<>();
        Scanner scanner = new Scanner(new File(fileName), "UTF-8");
        String string;
        while (scanner.hasNext()) {
            string = scanner.nextLine();
            if (string == null) {
                break;
            } else {
                listOfLines.add(stringToLine(string));
            }
        }
        return listOfLines;
    }

    public static void writeListToFile(String fileName, ArrayList<Line> listOfLines) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (Line apart : listOfLines) {
                StringBuilder sb = new StringBuilder();
                sb.append(apart.getA());
                sb.append(" ");
                sb.append(apart.getB());
                sb.append(" ");
                String line = new String(sb);
                writer.write(line + "\n");
                writer.flush();
            }
        } catch (Exception e) {
            ru.vsu.cs.util.SwingUtils.showErrorMessageBox(e);
        }
    }
}