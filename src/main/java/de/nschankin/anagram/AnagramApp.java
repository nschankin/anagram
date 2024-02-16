package de.nschankin.anagram;

public class AnagramApp {

    public static void main(String [] args){
        if(args.length == 0){
            printUsage();
        } else if("check".equals(args[0]) && args.length == 3){
            AnagramChecker checker = new AnagramChecker(args[1],args[2]);
            System.out.println("checking '" + args[1] + "' and '" + args[2] +"'");

            System.out.println("Result: " +  checker.isAnagram());
        }

    }


    private static void printUsage(){
        System.out.println("The anagram app has two modes:");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("1.) check");
        System.out.println("check if to phrases are anagrams and print 'true' or 'false'");
        System.out.println("Example:");
        System.out.println("check 'Silent!' 'Listen!'");
        System.out.println("will print 'true'");


        System.out.println("-----------------------------------------------------------------------");
    }
}
