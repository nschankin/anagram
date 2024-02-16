package de.nschankin.anagram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramCheckerTest {



    @Test
    void shouldRemoveSpecialChars(){

        String result = AnagramChecker.cleanPhrase("!\"§$%&/()=?´´{}[]~'#*+.-;,|² ");
        assertEquals("", result);

    }

    @Test
    void shouldRemoveNumberChars(){
        String result = AnagramChecker.cleanPhrase("0123456789");
        assertEquals("",result);
    }

    @Test
    void shouldLowerCase(){
        String result = AnagramChecker.cleanPhrase("Well done!");
        assertEquals("welldone",result);
    }

    @Test
    void shouldFindSimpleAnagram(){
        AnagramChecker checker = new AnagramChecker("Listen","Silent");
        assertTrue(checker.isAnagram());
    }

    @Test
    void shouldFindPhraseAnagram(){
        AnagramChecker checker = new AnagramChecker("Hello world?","hold, Orwell!");
        assertTrue(checker.isAnagram());
    }

    @Test
    void shouldNotFindAnagram(){
        AnagramChecker checker = new AnagramChecker("Listen please!","Silent!");
        assertFalse(checker.isAnagram());
    }

}
