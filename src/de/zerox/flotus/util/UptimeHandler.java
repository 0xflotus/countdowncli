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

    public String getUptime() throws Exception {
        return arrayOfUptimeOutput[4].equals("secs,") ? "0:00"
                : arrayOfUptimeOutput[4].equals("mins,") ? String.format("0:%02d",
                Integer.parseInt(arrayOfUptimeOutput[3]))
                : arrayOfUptimeOutput[4].substring(0, arrayOfUptimeOutput[4].length() - 1);
    }

    public void setArrayOfUptimeOutput(String[] arrayOfUptimeOutput) {
        this.arrayOfUptimeOutput = arrayOfUptimeOutput;
    }
}
