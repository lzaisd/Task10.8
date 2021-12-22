package ru.vsu.cs.sidorovaei.mains;

import ru.vsu.cs.sidorovaei.logics.ArgsParser;
import ru.vsu.cs.sidorovaei.logics.Line;
import ru.vsu.cs.sidorovaei.logics.Logic;

import java.util.ArrayList;

public class CommandLineMain {
    public static void runInCommandLineMode(String[] args) throws Exception {
        ArgsParser argsParser = new ArgsParser(args);

        String inputFile = argsParser.getArgumentValue("-i", "--input-file");
        String outputFile = argsParser.getArgumentValue("-o", "--output-file");

        ArrayList<Line> listOfLines = new ArrayList<>(Logic.readListFromFile(inputFile));
        if (Logic.checkIfListIsEmpty(listOfLines)) {
            System.out.println("Список пустой");
            System.err.println(1);
        }
        ArrayList<Line> finalList = Logic.getListOfMergedLines(listOfLines);
        Logic.writeListToFile(outputFile, finalList);
    }
}
