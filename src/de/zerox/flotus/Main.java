package de.zerox.flotus;

import de.zerox.flotus.util.TimeConverter;
import de.zerox.flotus.util.UptimeHandler;
import org.apache.commons.cli.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
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

        List<String> list = new ArrayList<String>();
        if (cmd.hasOption("d")) {
            list.add(uh.getUptime());
        }
        if (cmd.hasOption("c")) {
            list.add(uh.getCurrentTime());
        }
        if (cmd.hasOption("h")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("countdown", options);
        } else {
            int uptime = tc.convertStringToMinutes(uh.getUptime());
            int difference = tc.convertStringToMinutes("8:30") - uptime;
            list.add(tc.convertMinutesToString(difference));
        }
        for (String str : list) {
            System.out.println(str);
        }
    }
}
