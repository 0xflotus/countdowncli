package de.zerox.flotus.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeConverterTest {

    private TimeConverter timeConverter;

    @Before
    public void setUp() {
        timeConverter = new TimeConverter();
    }

    @Test
    public void testZero() {
        assertEquals(0, timeConverter.getHours());
        assertEquals(0, timeConverter.getMinutes());
    }

    @Test
    public void testTwoHoursTwentyMinutes() {
        timeConverter = new TimeConverter("2:20");
        assertEquals(2, timeConverter.getHours());
        assertEquals(20, timeConverter.getMinutes());
    }


    @Test
    public void testOneHundredSixMinutes() {
        timeConverter = new TimeConverter("1:46");
        assertEquals(new Integer(106), timeConverter.convertStringToMinutes());
    }

    @Test
    public void testOneHundredFiveString() {
        assertEquals("1:45", timeConverter.convertMinutesToString(105));
    }

    @Test
    public void testNegativeMinutes(){
        assertEquals("Zeit ist abgelaufen.", timeConverter.convertMinutesToString(-3));
    }
}
