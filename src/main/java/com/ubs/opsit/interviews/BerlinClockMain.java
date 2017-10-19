package com.ubs.opsit.interviews;

/**
 * Main class to convert the given time (hh:mm:ss) into Berlin Clock format and
 * print the same. Each line of output represent the respective Berlin Clock
 * row.
 * 
 * Berlin Clock :
 * 
 * The top two rows of lamps are red. These indicate the hours of a day. In the
 * top row there are 4 red lamps. Every lamp represents 5 hours. In the lower
 * row of red lamps every lamp represents 1 hour. So if two lamps of the first
 * row and three of the second row are switched on that indicates 5+5+3=13h or 1
 * pm.
 * 
 * The two rows of lamps at the bottom count the minutes. The first of these
 * rows has 11 lamps, the second 4. In the first row every lamp represents 5
 * minutes. In this first row the 3rd, 6th and 9th lamp are red and indicate the
 * first quarter, half and last quarter of an hour. The other lamps are yellow.
 * In the last row with 4 lamps every lamp represents 1 minute.
 * 
 * Example : 
 * Input -: 17:00:00 
 * Output : 
 * Y 
 * RRRO 
 * RROO 
 * OOOOOOOOOOO 
 * OOOO
 */
public class BerlinClockMain {

	public static void main(String[] args) {

		TimeConverter berlinClkConverter = new TimeConverterImpl();
		System.out.println(berlinClkConverter.convertTime("19:40:50"));
		System.out.println(berlinClkConverter.convertTime("15:00"));

	}

}
