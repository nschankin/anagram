package de.nschankin.anagram;

import java.util.ArrayList;
import java.util.List;

public class AnagramApp {

    private static final String CHECK_MODE = "check";

    private static final String PRINT_MATCHING_MODE = "printMatching";

    public static void main(String [] args){
        if(args.length == 0){
            printUsage();
        } else if(CHECK_MODE.equals(args[0]) && args.length == 3){
            AnagramChecker checker = new AnagramChecker(args[1],args[2]);
            System.out.println(CHECK_MODE + "ing '" + args[1] + "' and '" + args[2] +"'");

            System.out.println("Result: " +  checker.isAnagram());
        } else if (PRINT_MATCHING_MODE.equals(args[0]) && args.length > 2) {

            List<String> stringList = new ArrayList<>(List.of(args));
            //remove command
            stringList.remove(0);
            String source = stringList.remove(0);
            System.out.println("Source phrase");
            System.out.println(source);

            stringList.forEach(currentString -> {
                AnagramChecker checker = new AnagramChecker(source,currentString);
                if (checker.isAnagram()){
                    System.out.println("Matching anagram:");
                    System.out.println(currentString);
                }
            });

        } else {
            printUsage();
        }

    }


    private static void printUsage(){
        System.out.println("The anagram app has two modes:");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("1.) " + CHECK_MODE);
        System.out.println("Checks if to phrases are anagrams and print 'true' or 'false'");
        System.out.println("Example:");
        System.out.println(CHECK_MODE + " 'Silent!' 'Listen!'");
        System.out.println("will print 'true'");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("2.) " + PRINT_MATCHING_MODE);
        System.out.println("prints all phrases which match the first argument (source)");
        System.out.println("Example:");
        System.out.println(PRINT_MATCHING_MODE + " printMatching 'Silent, yes' 'Listen !!!! yes' 'sey tenlis' 'No match'");
        System.out.println("will print:");
        System.out.print("Source phrase\n" +
                "Silent, yes\n" +
                "Matching Anagram:\n" +
                "Listen !!!! yes\n" +
                "Matching Anagram:\n" +
                "sey tenlis\n");
        System.out.println("-----------------------------------------------------------------------");
    }
}
