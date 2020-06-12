package by.epamtc.jwdmay2020.dziadkouskaya.task02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPracticeUnit07_12 {
	
	public static void main(String[] args) {
		
		String example = "This is the house that Jack built." + 
				"This is the malt that lay in the house that Jack built.";
		
		String stringWithCopyPart = copyStringPart(example, 13, 17, 47);
		System.out.println(stringWithCopyPart);
		
		int stringLength = findStringLenth(example);
		System.out.println("String Length is " + stringLength);
		
		int numberOfSubstringInString = findNumberOfSubstringInString(example, "the house");
		System.out.println("Number of substring \"the house\" is " + numberOfSubstringInString);
		
		String stringWithReverseWordSequence = creatStringWithReverseWordSequence(example);
		System.out.println(stringWithReverseWordSequence);
		
		String stringWithSpacesToStars = changeSpacesToStars(example);
		System.out.println(stringWithSpacesToStars);
		
	}


	//Копирование части строки
	public static String copyStringPart(String string, int startPositionIndexToCopy, int endPositionIndexToCopy,
			int startPositionIndexToInsert) {
		StringBuilder resultBuilder = new StringBuilder(string);
				
		String copyPart = string.substring(startPositionIndexToCopy - 1, endPositionIndexToCopy);

		resultBuilder.insert(startPositionIndexToInsert - 1, copyPart);
		
		String result = resultBuilder.toString();

		return result;

	}
	//Определение длины строки
	public static int findStringLenth(String string) {

		return string.length();
	}

	//Количество вхождений подстроки в строку
	public static int findNumberOfSubstringInString(String string, String substring) {
		int counter = 0;

		Pattern pattern = Pattern.compile(substring);
		Matcher matcher = pattern.matcher(string);

		while (matcher.find()) {
			counter += 1;
		}

		return counter;

	}

	//Вывести слова строки в обратном порядке
	public static String creatStringWithReverseWordSequence(String string) {
		String[] wordList = string.split("\\s");

		StringBuilder builder = new StringBuilder();

		for (int i = wordList.length - 1; i >= 0; i--) {
			builder.append(wordList[i]).append(" ");
		}
		String result = builder.toString();

		return result;

	}

	//Заменить пробел и группы пробелов символом "*"
	public static String changeSpacesToStars(String string) {
		String regex = " +";
		String result = string.replaceAll(regex, "*");

		return result;
	}


}
