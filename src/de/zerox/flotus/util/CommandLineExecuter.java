package de.zerox.flotus.util;

import java.io.IOException;
import java.util.Scanner;

public class CommandLineExecuter {

    private String command;

    public CommandLineExecuter(String command) {
        this.command = command;
    }

    public String executeCommand() throws IOException {
        return executeCommand(this.command);
    }

    public String executeCommand(String command) throws IOException {
        Scanner scanner = new Scanner(Runtime.getRuntime().exec(command).getInputStream()).useDelimiter("\\A");
        return scanner.hasNext() ? scanner.next().trim() : "No output";
    }
}
