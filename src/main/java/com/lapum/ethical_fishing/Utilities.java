package com.lapum.ethical_fishing;

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
        // "cmd /c start cmd.exe" opens and starts the command line, /K : Carries out command specified by string
        final String START_CMD_COMMAND = "cmd /c start cmd.exe /K";

        try {
            Runtime.getRuntime().exec(START_CMD_COMMAND + " " + command);
        }
        catch (Exception e) {
            log(TAG, "something went wrong.. failed to start terminal with command");
            e.printStackTrace();
        }
    }

    public static void displayDialog(String title, String message) {
        JOptionPane.showMessageDialog(null, message, "InfoBox: " + title, JOptionPane.INFORMATION_MESSAGE);
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
