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
}
