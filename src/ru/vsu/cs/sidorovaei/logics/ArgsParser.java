package ru.vsu.cs.sidorovaei.logics;

import java.util.Dictionary;
import java.util.Hashtable;

public class ArgsParser {
    public final Dictionary<String, String> argsDict = new Hashtable<>();

    public ArgsParser(String[] args) {
        parse(args);
    }

    private void parse(String[] args) {
        String argName = null;

        for (String arg : args) {
            if (arg.startsWith("-") && arg.length() == 2 || arg.startsWith("--")) {
                argName = arg;
            } else {
                if (argName != null) {
                    argsDict.put(argName, arg);
                }
            }
        }
    }

    public String getArgumentValue(String shortName, String longName) {
        String value = argsDict.get(shortName);

        if (value == null) {
            value = argsDict.get(longName);
        }

        return value;
    }

}