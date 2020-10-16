package com.lapum.ethical_fishing;

import javax.swing.JOptionPane;

/**
 * A class of static functions that can be used anywhere
 **/
public class Utilities {
    private final static String TAG = "utilities";

    /** Print debug messages to console
     *
     * @param tag The file tag
     * @param message The message to log
     **/
    public static void log(String tag, String message) {
        System.out.println(tag + ": " + message);
    }

    /** Start a native terminal and execute a command
     *
     * @param command The command to execute upon starting a terminal
     **/
    public static void startTerminalWithCommand(String command) {
        // "cmd /c start cmd.exe" opens and starts the command line, /K : Carries out command specified by string
        final String START_CMD_COMMAND = "cmd /c start cmd.exe /K";

        try {
            Runtime.getRuntime().exec(START_CMD_COMMAND + " " + command);
        }
        catch (Exception e) {
            log(TAG, "something went wrong..");
            e.printStackTrace();
        }
    }

    /** Display a native dialog pop up
     *
     * @param title The message title for the dialog pop up
     * @param message The message body for the dialog pop up
     **/
    public static void displayDialog(String title, String message) {
        JOptionPane.showMessageDialog(null, message, "InfoBox: " + title, JOptionPane.INFORMATION_MESSAGE);
    }
}
