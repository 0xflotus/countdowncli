package de.zerox.flotus;

import de.zerox.flotus.util.TimeConverter;
import de.zerox.flotus.util.UptimeHandler;
import org.apache.commons.cli.*;

import java.io.IOException;

public class Main {


    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("h", "show help");
        options.addOption("d", "show how many time left");
        options.addOption("c", "show current time");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println("There is no argument!\nUSAGE: countdown -h for more.");
            return;
        }

        UptimeHandler uh = null;
        try {
            uh = new UptimeHandler();
        } catch (IOException e) {
            System.out.println("IOException");
        }
        TimeConverter tc = new TimeConverter();

        if (cmd.hasOption("d")) {
            int uptime = tc.convertStringToMinutes(uh.getUptime());
            int difference = tc.convertStringToMinutes("8:30") - uptime;
            System.out.println(tc.convertMinutesToString(difference));
        } else if (cmd.hasOption("c")) {
            System.out.println(uh.getCurrentTime());
        } else if (cmd.hasOption("h")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("countdown", options);
        } else {
            System.out.println(uh.getUptime());
        }


    }
}
