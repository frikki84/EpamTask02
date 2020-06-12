package by.epamtc.jwdmay2020.dziadkouskaya.task02;

public class StringPracticeUnit13_18 {
	public static void main(String[] args) {
		String example = "Cook pasta according to package-directions. Meanwhile, in a large skillet, cook bacon until crisp.";
				
		String stringWithLetterAtoBInLongestWord = changeLetterAtoBInLongestWord(example);
		System.out.println(stringWithLetterAtoBInLongestWord);
		
		int shortestWordLength = findShortestWordLength(example);
		System.out.println("shortestWordLength is " +  shortestWordLength);
		
		int wordsNumberInString = findWordsNumberInString(example);
		System.out.println("wordsNumberInString is " + wordsNumberInString);
		
		String stringWithSwapWords = swapWordsInString(example, 1, 9);
		System.out.println(stringWithSwapWords);
		
		String stringWithDeletedLastWord = deleteLastWordInString(example);
		System.out.println(stringWithDeletedLastWord);
		
		String stringWithAdditionalSpaces = addSpacesToString(example, 5, 10);
		System.out.println(stringWithAdditionalSpaces);
	
		
		
	}
	

	// Заменить в самом длинном слове строки буквы 'a' на 'b'
	public static String changeLetterAtoBInLongestWord(String string) {
		String[] wordList = string.split(" ");

		int longestWordIndex = 0;
		int maxWordLength = wordList[longestWordIndex].length();

		for (int i = 1; i < wordList.length; i++) {
			if (wordList[i].length() > maxWordLength) {
				longestWordIndex = i;
				maxWordLength = wordList[i].length();
			}
		}

		String changedWord = wordList[longestWordIndex].replaceAll("a", "b");

		wordList[longestWordIndex] = changedWord;

		String result = String.join(" ", wordList);

		return result;
	}

	// Определить длину самого короткого слова в строке
	public static int findShortestWordLength(String string) {
		String[] wordList = string.split("\\s+");

		int minWordLength = wordList[0].length();

		for (String word : wordList) {
			if (word.length() < minWordLength) {
				minWordLength = word.length();
			}
		}

		return minWordLength;
	}

	// Подсчет количества слов в строке
	public static int findWordsNumberInString(String string) {
		String[] wordList = string.split(" +");

		int wordsCounter = wordList.length;

		return wordsCounter;

	}

	// Поменять слова местами
	public static String swapWordsInString(String string, int numberOfFirstWord, int numberOfSecondWord) {

		String[] wordList = string.split("\\s+");

		String middleresult = wordList[numberOfFirstWord - 1];

		wordList[numberOfFirstWord - 1] = wordList[numberOfSecondWord - 1];

		wordList[numberOfSecondWord - 1] = middleresult;

		String result = String.join(" ", wordList);

		return result;

	}

	// Удаление последнего слова в строке
	public static String deleteLastWordInString(String string) {
		String[] wordList = string.split("\\s+");

		wordList[wordList.length - 1] = "";

		String result = String.join(" ", wordList);

		return result;
	}

	// Добавление пробелов в строку
	public static String addSpacesToString(String string, int indexOfPlaceToAddSpace, int numberOfSpaces) {
		StringBuilder lineOfSpaces = new StringBuilder();

		for (int i = 0; i < numberOfSpaces; i++) {
			lineOfSpaces.append(" ");
		}

		String spacesline = lineOfSpaces.toString();

		String result = StringPracticeUnit01_06.addToStringNewPart(string, spacesline, indexOfPlaceToAddSpace);

		return result;

	}



}
