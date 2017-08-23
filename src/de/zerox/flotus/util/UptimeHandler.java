package de.zerox.flotus.util;

import java.io.IOException;

public class UptimeHandler {

    private static String UPTIME_COMMAND = "uptime";
    private String[] arrayOfUptimeOutput;

    public UptimeHandler() throws IOException {
        this(new CommandLineExecuter(UPTIME_COMMAND));
    }

    public UptimeHandler(CommandLineExecuter executer) throws IOException {
        this.arrayOfUptimeOutput = executer.executeCommand().split(" ");
    }

    public String getCurrentTime() {
        return arrayOfUptimeOutput[0];
    }

    public String getUptime() {
        return arrayOfUptimeOutput[4].substring(0, arrayOfUptimeOutput[4].length() - 1);
    }


}
