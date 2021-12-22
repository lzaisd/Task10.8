package ru.vsu.cs.sidorovaei.mains;

import ru.vsu.cs.sidorovaei.frame.FrameMain;

import java.util.Locale;

public class JTableMain {
    public static void runInFrameMode() {
        Locale.setDefault(Locale.ROOT);

        java.awt.EventQueue.invokeLater(() -> new FrameMain().setVisible(true));
    }
}
