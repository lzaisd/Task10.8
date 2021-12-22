package ru.vsu.cs.sidorovaei;

import ru.vsu.cs.sidorovaei.mains.CommandLineMain;
import ru.vsu.cs.sidorovaei.mains.JTableMain;
import ru.vsu.cs.sidorovaei.mains.testsMain;

import java.util.Locale;

public class Main {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.ROOT);

        testsMain.runTests();

        if (args.length == 0) {
            JTableMain.runInFrameMode();
        } else {
            CommandLineMain.runInCommandLineMode(args);
        }
    }
}