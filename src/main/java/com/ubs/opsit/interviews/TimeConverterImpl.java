package com.ubs.opsit.interviews;

import java.util.Collections;

/*
 * TimeConverter Implementation class . 
 * Validate the input time for required format HH:MM:SS
 * Split the input time to get the value for HH , MM & SS . 
 * Convert the respective part of input time to corresponding Berlin time clock format.
 * Append all converted time format to build Berlin clock for given input.
 * 
 * @author Vikas Mishra
 *
 */
public class TimeConverterImpl implements TimeConverter {

	final static String LMP_OFF = "O";
	final static String YELLOW = "Y";
	final static String RED = "R";
	final static String NEW_LINE = System.lineSeparator();

	@Override
	public String convertTime(String aTime) {

		StringBuffer berlinClk = new StringBuffer();
		/*
		 * validate the input
		 */
		if (!validateInput(aTime))
			return "Invalid input Time format. Check the format HH:MM:SS ";

		String[] intime = aTime.split(":");
		int inHours = Integer.parseInt(intime[0]);
		int inMminutes = Integer.parseInt(intime[1]);
		int inseconds = Integer.parseInt(intime[2]);

		berlinClk.append(getSecRowStatus(inseconds)).append(NEW_LINE).append(getFirstHrRowStatus(inHours))
				.append(NEW_LINE).append(getSecondHrRowStatus(inHours)).append(NEW_LINE)
				.append(getFirstMinRowStatus(inMminutes)).append(NEW_LINE).append(getSecondMinRowStatus(inMminutes));

		return berlinClk.toString();
	}

	/*
	 * getFirstHrRowStatus : Method to return the status for first row for hours
	 * . First hour row has five lamps each represent 5 hours.
	 * 
	 * @param Hr : hours in number
	 * 
	 * @return : combination of R ( red ) and/or O ( off )
	 */
	String getFirstHrRowStatus(int hr) {

		int redLamp = hr / 5;
		int offLamp = 4 - hr / 5;
		String redL = String.join("", Collections.nCopies(redLamp, RED));
		String offL = String.join("", Collections.nCopies(offLamp, LMP_OFF));
		return redL + offL;
	}

	/*
	 * getFirstMinRowStatus : Method to return the status for first row for
	 * Minutes . First hour row has five lamps each represent 5 minute and 3/6/9
	 * row represent quarter ( in Red color )
	 * 
	 * @param mins : mins in number
	 * 
	 * @return : combination of Y ( yellow ) and/or O ( off )
	 */
	String getFirstMinRowStatus(int mins) {

		int yellowLmp = mins / 5;
		int offLamp = 11 - mins / 5;
		String yellowL = String.join("", Collections.nCopies(yellowLmp, YELLOW));
		String offL = String.join("", Collections.nCopies(offLamp, LMP_OFF));
		String row = yellowL + offL;
		/*
		 * check and replace all Y (Yellow) at 3/6/9 position to R ( Red ) 
		 * check char at respective index and replace
		 */
		char[] arryStatus = row.toCharArray();
		if (arryStatus[2] == 'Y')
			arryStatus[2] = 'R';

		if (arryStatus[5] == 'Y')
			arryStatus[5] = 'R';

		if (arryStatus[8] == 'Y')
			arryStatus[8] = 'R';

		return new String(arryStatus);
	}

	/*
	 * getSecondMinRowStatus : Method to return the status for second row for
	 * Minutes . Second hour row has five lamps each represent 1 minute.
	 * 
	 * @param mins : mins in number
	 * 
	 * @return : combination of Y ( yellow ) and/or O ( off )
	 */
	String getSecondMinRowStatus(int mins) {

		int yellowLmp = mins % 5;
		int offLamp = 4 - mins % 5;
		String yellowL = String.join("", Collections.nCopies(yellowLmp, YELLOW));
		String offL = String.join("", Collections.nCopies(offLamp, LMP_OFF));
		return yellowL + offL;
	}

	/*
	 * getSecondHrRowStatus : Method to return the status for second row for
	 * hours . Second hour row has five lamps each represent 1 hours.
	 * 
	 * @param hr : hours in number
	 * 
	 * @return : combination of R ( red ) and/or O ( off )
	 */
	String getSecondHrRowStatus(int hr) {

		int redLamp = hr % 5;
		int offLamp = 4 - hr % 5;
		String redL = String.join("", Collections.nCopies(redLamp, RED));
		String offL = String.join("", Collections.nCopies(offLamp, LMP_OFF));
		return redL + offL;
	}

	/*
	 * getSecRowStatus : Method to return the status of first row of Berlin
	 * Clock ( Yellow or Off )
	 * 
	 * @param secs : seconds in number
	 * 
	 * @return : Y ( yellow ) or O ( off )
	 */
	String getSecRowStatus(int secs) {

		if (secs % 2 == 0)
			return YELLOW;
		return LMP_OFF;
	}

	/*
	 * Validation method : Method to validate the input time , time should be in
	 * HH:MM:SS format .
	 * 
	 * @param inTime : Input time to validate
	 * 
	 * @return : True or False
	 */
	boolean validateInput(String inTime) {

		if (inTime == null)
			return false;
		/*
		 * get the three parts of input time
		 */
		String[] timeParts = inTime.split(":");
		if (timeParts.length != 3)
			return false;

		return true;
	}
}
