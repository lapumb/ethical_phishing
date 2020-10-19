package com.lapum.ethical_fishing;

import sun.awt.OSInfo;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utilities {

    private final static String TAG = "utilities";

    public static void log(String tag, String message) {
        System.out.println(tag + ": " + message);
    }

    public static void startTerminalWithCommand(String command) {
        String start_cmd_command = "";

        if (OSInfo.getOSType() == OSInfo.OSType.WINDOWS) {
            // "cmd /c start cmd.exe" opens and starts the command line, /K : Carries out command specified by string
            start_cmd_command = "cmd /c start cmd.exe /K";
        } else {
            // https://stackoverflow.com/questions/15356405/how-to-run-a-command-at-terminal-from-java-program
            start_cmd_command = "/bin/bash -c ";
        }

        try {
            start_cmd_command += command;
            Runtime.getRuntime().exec(start_cmd_command);
        } catch (IOException e) {
            log(TAG, "Something went wrong when trying to run command: " + start_cmd_command);
            e.printStackTrace();
        }
    }

    public static void displayDialog(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static String getStringProperty(String key) {
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("strings.properties")) {
            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return "";
            }

            prop.load(input);
            return prop.getProperty(key, "");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return "";
    }
}
