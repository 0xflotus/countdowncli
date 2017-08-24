package de.zerox.flotus.util;

import org.junit.Test;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class UptimeHandlerTest {
    @Test
    public void testClock() throws IOException {
        UptimeHandler uptimeHandler = new UptimeHandler();
        assertEquals(DateFormat.getTimeInstance(DateFormat.SHORT).format(new Date()), uptimeHandler.getCurrentTime());
    }

    @Test
    public void testMidnightHour() throws Exception {
        String output = " 0:06  up 34 mins, 2 users, load averages: 2,64 2,20 1,94".trim();
        UptimeHandler uh = new UptimeHandler();
        uh.setArrayOfUptimeOutput(output.split(" "));
        assertEquals("0:06", uh.getCurrentTime());
        assertEquals("0:34", uh.getUptime());
    }

    @Test
    public void testFourteenSeconds() throws Exception {
        String output = " 0:06  up 34 secs, 2 users, load averages: 2,64 2,20 1,94".trim();
        UptimeHandler uh = new UptimeHandler();
        uh.setArrayOfUptimeOutput(output.split(" "));
        assertEquals("0:00", uh.getUptime());
    }
}
