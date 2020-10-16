package com.lapum.ethical_fishing;

import static com.lapum.ethical_fishing.Utilities.*;

public class Main {
    private final static String DIALOG_TITLE = "You're a Dumb Ass";
    private final static String DIALOG_MESSAGE = "You should never open an attachment, or link, from a sender you don't know.\n\nIf " +
            "I wanted to be malicious, you just made it very easy for me to achieve that. Malware (viruses) often " +
            "infect computers due to user error. This file is 'technically' a virus because I'm running code on your " +
            "computer that was not intended to be run.\n\nNow, just to show you I'm a nice virus, press enter and " +
            "watch 'Star Wars: A New Hope' play in your terminal.\n\nBe more careful next time!";

    /**
     * The main driver of the program
     *
     * @param args Arguments passed when executing the program (unused)
     */
    public static void main(String[] args) {
        // message popup is blocking
        displayDialog(DIALOG_TITLE, DIALOG_MESSAGE);

        // start streaming star wars in terminal
        StarWars sw = new StarWars();
        sw.start();
    }
}
