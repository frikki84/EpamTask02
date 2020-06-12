package by.epamtc.jwdmay2020.dziadkouskaya.task02;

public class StringPracticeUnit19_24 {
	public static void main(String[] args) {
		
		String experimentString = "   A New Year is like a blank book, and the pen is in your hands.  ";

		boolean isWordPalindrome = isPalindrom(experimentString);
		System.out.println("Is the word a palindrome? - " + isWordPalindrome);

		String summOfLongNumbers = findSummOfLongNumbers(8949993999945495469L, 2943878678678688888L);
		System.out.println(summOfLongNumbers);

		String stringWithChangedSubstrings = changeSubstringToAnotherSubstring(experimentString, "a blank book",
				"the pen");
		System.out.println(stringWithChangedSubstrings);

		String stringWithoutWordsOfCertainLength = deleteWordsOfCertainLength(experimentString, 3);
		System.out.println(stringWithoutWordsOfCertainLength);

		String stringWithoutOddSpaces = deleteOddSpaces(experimentString);
		System.out.println(stringWithoutOddSpaces);

		String[] wordsList = findWordsArray(experimentString);
		for (String i : wordsList) {
			System.out.print(i + " ");
		}

	}

	//Является ли строка палиндром?
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

	//Замена подстроки в строке
	public static String changeSubstringToAnotherSubstring(String string, String oldSubstring, String newSubstring) {

		return string.replaceFirst(oldSubstring, newSubstring);

	}

	//Сложение очень длинных целых чисел
	public static String findSummOfLongNumbers(long number1, long number2) {
		long lastSymbolFromNumber1 = 0;
		long number1WithoutLastSymbol = number1;

		long lastSymbolFromNumber2 = 0;
		long number2WithoutLastSymbol = number2;

		long lastSymbolsSumm = 1;
		long additionalOne = 0;

		StringBuilder resultStringBuilder = new StringBuilder();

		while (number1WithoutLastSymbol != 0 || number2WithoutLastSymbol != 0) {
			
			lastSymbolFromNumber1 = number1WithoutLastSymbol % 10;
			number1WithoutLastSymbol /= 10;
			
			lastSymbolFromNumber2 = number2WithoutLastSymbol % 10;
			number2WithoutLastSymbol /= 10;
						
			lastSymbolsSumm = lastSymbolFromNumber1 + lastSymbolFromNumber2 + additionalOne;

			additionalOne = 0;

			if (lastSymbolsSumm > 9) {
				lastSymbolsSumm %= 10;
				additionalOne = 1;
			}

			resultStringBuilder.append(lastSymbolsSumm);
		}
		if (additionalOne == 1) {
			resultStringBuilder.append(additionalOne);
		}

		String result = resultStringBuilder.reverse().toString();

		return result;
}

	
	//Удаление из строки слов заданной длины
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

	//Удаление лишних пробелов
	public static String deleteOddSpaces(String string) {
		return string.replaceAll(" +", " ").trim();

	}

	//Выделение слов из строки
	public static String[] findWordsArray(String string) {
		String[] wordList = string.split("\\W+");
		return wordList;
	}

}
