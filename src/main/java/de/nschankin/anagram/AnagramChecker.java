package de.nschankin.anagram;

import java.util.ArrayList;
import java.util.List;

public class AnagramChecker {

    private String firstPhrase;

    private String secondPhrase;


    public AnagramChecker(String firstPhrase, String secondPhrase) {
        this.firstPhrase = firstPhrase;
        this.secondPhrase = secondPhrase;
    }

    public boolean isAnagram(){
        String cleanedFirst = cleanPhrase(firstPhrase);
        String cleanedSecond = cleanPhrase(secondPhrase);
        if (cleanedFirst != null && cleanedSecond != null
                && cleanedFirst.length() >0 && cleanedSecond.length() > 0
                && cleanedFirst.length() == cleanedSecond.length()){

            List<Character> firstPhraseChars = new ArrayList<>(cleanedFirst.chars().mapToObj(c -> (char) c).toList());

            cleanedSecond.chars().mapToObj(c -> (char) c).forEach(firstPhraseChars::remove);
            return firstPhraseChars.isEmpty();
        } else {
            return false;
        }

    }

    static String cleanPhrase(String phrase) {
        return phrase != null ? phrase.toLowerCase().replaceAll("\\d","").replaceAll("\\W", "") : null;
    }

}
