package by.epamtc.jwdmay2020.dziadkouskaya.task02;

public class StringPracticeUnit19_24 {
	public static void main(String[] args) {
		String experimentString = "   A New Year is like a blank book, and the pen is in your hands.  ";
		
		boolean isWordPalindrome = isPalindrom(experimentString);
		System.out.println("Is the word a palindrome? - " + isWordPalindrome);
		
		
		String summOfLongNumbers = findSummOfLongNumbers(120785L, 109124799300156565L);
		System.out.println(summOfLongNumbers);
		
		String stringWithChangedSubstrings = changeSubstringToAnotherSubstring(experimentString, "a blank book", "the pen");
		System.out.println(stringWithChangedSubstrings);
		
	
		String stringWithoutWordsOfCertainLength = deleteWordsOfCertainLength(experimentString, 3);
		System.out.println(stringWithoutWordsOfCertainLength);
		
		String stringWithoutOddSpaces = deleteOddSpaces(experimentString);
		System.out.println(stringWithoutOddSpaces);
		
		String [] wordsList = findWordsArray(experimentString);
		for (String i : wordsList) {
			System.out.print(i + " ");
		}

	}

	// Является ли строка палиндром?
	public static boolean isPalindrom(String string) {
		boolean result = true;

		StringBuilder builder = new StringBuilder(string);

		String reverseString = builder.reverse().toString();

		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) != reverseString.charAt(i)) {
				result = false;
				break;
			}
		}

		return result;

	}

	// Замена подстроки в строке
	public static String changeSubstringToAnotherSubstring(String string, String oldSubstring, String newSubstring) {

		return string.replaceFirst(oldSubstring, newSubstring);

	}

	// Сложение очень длинных целых чисел
	public static String findSummOfLongNumbers(long number1, long number2) {
		StringBuilder number1String = new StringBuilder(String.valueOf(number1));

		StringBuilder number2String = new StringBuilder(String.valueOf(number2));

		int lenthDifference = number1String.length() - number2String.length();

		if (lenthDifference != 0) {

			StringBuilder zeroString = new StringBuilder();

			for (int i = 0; i < Math.abs(lenthDifference); i++) {
				zeroString.append(0);
			}

			if (lenthDifference > 0) {
				number2String.insert(0, zeroString);
			} else {
				number1String.insert(0, zeroString);
			}
		}
		StringBuilder resultStringBuilder = new StringBuilder();

		int additionalOne = 0;

		for (int i = number1String.length() - 1; i >= 0; i--) {
			int middleResult = Character.digit(number1String.charAt(i), 10)
					+ Character.digit(number2String.charAt(i), 10);

			middleResult += additionalOne;

			if (middleResult > 9) {

				middleResult %= 10;
				additionalOne = 1;

			} else {
				additionalOne = 0;
			}
			resultStringBuilder.append(middleResult);
		}
		if (additionalOne == 1) {
			resultStringBuilder.append(additionalOne);
		}

		String result = resultStringBuilder.reverse().toString();

		return result;
	}

	// Удаление из строки слов заданной длины
	public static String deleteWordsOfCertainLength(String string, int wordsLenth) {
		String[] wordList = string.split("\\s+");

		for (int i = 0; i < wordList.length; i++) {
			if (wordList[i].length() == wordsLenth) {
				wordList[i] = "";
			}
		}
		String result = String.join(" ", wordList);
		result = result.replaceAll(" +", " ").trim();

		return result;

	}

	// Удаление лишних пробелов
	public static String deleteOddSpaces(String string) {
		return string.replaceAll(" +", " ").trim();

	}

	// Выделение слов из строки
	public static String[] findWordsArray(String string) {
		String[] wordList = string.split("\\W+");
		return wordList;
	}

}
