package by.epamtc.jwdmay2020.dziadkouskaya.task02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPracticeUnit01_06 {
	public static void main(String[] args) {
		String example = "THIS is the house that JACK built.";

		String evenString = makeEvenCharecterString(example);
		String oddString = makeOddCharecterString(example);

		System.out.println("String of even symbols is" + evenString + "\nString of odd symbols is " + oddString);

		double upperCaseLettersPercent = findPercentageUppercaseLetter(example);
		double lowercaseLettersPercent = 100 - upperCaseLettersPercent;

		System.out.println("Percent of Uppercase letters is " + upperCaseLettersPercent
				+ "\nPercent of lowercase letters is " + lowercaseLettersPercent);
		
		
		String stringWithoutSimilarSymbols = findStringWithoutSimilarSymbols(example);
		
		System.out.println("String without sam symbols is " + stringWithoutSimilarSymbols);

		int frequancyOfSymbol = findCharFrequancyInString(example, 't');
		System.out.println("Number of letter \"t\" in string is " + frequancyOfSymbol);
		
		String reverseString = createReverseString(example);
		System.out.println("Reverse String " + reverseString);
		

		String stringWithInsertString = addToStringNewPart(example, "MAMA", 13);
		System.out.println("String With Insert Substring " + stringWithInsertString);
		
		
		String stringWithDeletePart = deleteStringPart(example, 9, 11);
		System.out.println("String With delete part " + stringWithDeletePart);

	}

	// Четные и нечетные символы разделить по разным строкам

	public static String makeEvenCharecterString(String string) {
		StringBuilder evenString = new StringBuilder();

		for (int i = 1; i <= string.length(); i++) {
			if ((i) % 2 == 0) {
				evenString.append(string.charAt(i - 1));
			}
		}

		String result = evenString.toString();

		return result;
	}

	public static String makeOddCharecterString(String string) {
		StringBuilder oddString = new StringBuilder();

		for (int i = 1; i <= string.length(); i++) {
			if ((i) % 2 != 0) {
				oddString.append(string.charAt(i - 1));
			}
		}

		String result = oddString.toString();

		return result;
	}

	// Процентное соотношение строчных и прописных букв
	public static double findPercentageUppercaseLetter(String string) {

		String spacelessString = string.replaceAll("[^a-zA-Z]", "");

		String upperSpacelessString = spacelessString.toUpperCase();

		int upperLetterCounter = 0;

		for (int i = 0; i < spacelessString.length(); i++) {
			if (string.charAt(i) == upperSpacelessString.charAt(i)) {
				upperLetterCounter += 1;
			}
		}

		double percent = upperLetterCounter * 100 / (spacelessString.length() * 1.0);

		return percent;

	}

	// Удаление одинаковых символов
	public static String findStringWithoutSimilarSymbols(String string) {
		StringBuilder builderForResult = new StringBuilder();

		int indexOfRepeatedSymbol;

		for (int i = 0; i < string.length(); i++) {
			char symbol = string.charAt(i);

			indexOfRepeatedSymbol = string.indexOf(symbol, i + 1);

			if (indexOfRepeatedSymbol == -1) {
				builderForResult.append(symbol);
			}
		}
		String stringWithoutSimilarSymbols = builderForResult.toString();

		return stringWithoutSimilarSymbols;

	}

	// Частота встречаемости символа в строке
	public static int findCharFrequancyInString(String string, char symbolForCompare) {
		int counter = 0;

		for (int i = 0; i < string.length(); i++) {
			char symbol = string.charAt(i);

			if (symbol == symbolForCompare) {
				counter += 1;
			}
		}

		return counter;
	}

	// Переворот строки
	public static String createReverseString(String string) {
		StringBuilder stringBuilder = new StringBuilder(string);

		String resultString = stringBuilder.reverse().toString();

		return resultString;

	}

	// Вставка подстроки
	public static String addToStringNewPart(String string, String newPart, int startPosition) {
		String fistPart = string.substring(0, startPosition - 1);
		String lastPart = string.substring(startPosition - 1);

		String result = fistPart + newPart + lastPart;

		return result;

	}

	// Удаление подстроки
	public static String deleteStringPart(String string, int startIndexForDelete, int endIndexForDelete) {
		String fistPart = string.substring(0, startIndexForDelete - 1);
		String lastPart = string.substring(endIndexForDelete);

		String result = fistPart + lastPart;

		return result;
	}

}
