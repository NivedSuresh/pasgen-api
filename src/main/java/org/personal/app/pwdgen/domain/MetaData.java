package org.personal.app.pwdgen.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MetaData {

    static final List<Character> specialChars;

    private static final Random random = new Random();

    static final List<Character> numbers;
    static final List<Character> lowerCaseLetters;
    static final List<Character> upperCaseLetters;

    static {
        numbers = getNumbers();
        lowerCaseLetters = getLowerCaseLetters();
        upperCaseLetters = getUpperCaseLetters();
        specialChars = List.of(
                '!', '#', '$', '%', '&', '(', ')', '*', '+', ',', '-', '.', '/',
                ':', ';', '<', '=', '>', '?', '@', '[', ']', '^', '_', '`', '{', '|', '}', '~'
        );
    }


    private static List<Character> getNumbers() {
        return IntStream.rangeClosed('0', '9')
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
    }

    private static List<Character> getUpperCaseLetters() {
        return IntStream.rangeClosed('A', 'Z')
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
    }

    private static List<Character> getLowerCaseLetters() {
        return IntStream.rangeClosed('a', 'z')
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
    }


    public static Character getRandomNumber(){
        return numbers.get(random.nextInt(0, numbers.size()));
    }

    public static Character getRandomUpperCase(){
        return upperCaseLetters.get(random.nextInt(0, numbers.size()));
    }

    public static Character getRandomLowerCase(){
        return lowerCaseLetters.get(random.nextInt(0, numbers.size()));
    }

    public static Character getRandomSpecialChar(){
        return specialChars.get(random.nextInt(0, numbers.size()));
    }

    public static int getRandomIndex(int start, int end){
        return random.nextInt(start, end);
    }
}
