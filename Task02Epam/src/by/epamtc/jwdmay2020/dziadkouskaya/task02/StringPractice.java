package by.epamtc.jwdmay2020.dziadkouskaya.task02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPractice {
	public static void main(String[] args) {
		String example = "WAKING_UP and GETTING_UP are two entirely different negotiations";

		String evenString = makeEvenCharecterString(example);
		String oddString = makeOddCharecterString(example);

		double upperCaseLettersPercent = findPercentageUppercaseLetter(example);
		double lowercaseLettersPercent = 100 - upperCaseLettersPercent;

		String stringWithoutSimilarSymbols = returnStringWithoutSimilarSymbols(example);
		
		int frequancyOfSymbol = findCharFrequancyInString(example, 'a');
		
		/*
		 * System.out.println(evenString + "\n" + oddString + "\n" +
		 * upperCaseLettersPercent + "\n" + lowercaseLettersPercent + "\n" +
		 * stringWithoutSimilarSymbols + "\n" + frequancyOfSymbol);
		 * 
		 */		
		
		String string = "qwerty";
		
		String reverseString = createReverseString(string);
		
		System.out.println(reverseString);
		
	
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
	public static String returnStringWithoutSimilarSymbols(String string) {
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
	
	//Переворот строки
	public static String createReverseString(String string) {
		StringBuilder stringBuilder = new StringBuilder(string);
		
		String resultString = stringBuilder.reverse().toString();
		
		return resultString;
		
	}
	
	//Вставка подстроки
	
		
	
	

}
