/**
 * @author Ishtukin Vlad
 * @version 1.0.0
 * @project test
 * @class Prefix
 * @since 19.04.2021 - 20.47
 */

public class Prefix {

    public static String prefix(String[] array) {
        int[] lengthOfWords = new int[array.length];
        int min = array[0].length();
        String prefix = array[0];
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            lengthOfWords[i] = array[i].length();
            if (lengthOfWords[i]<min){
                prefix = array[i];
                min = lengthOfWords[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j].startsWith(prefix)){
                    counter++;
                }
            }
            if (counter == array.length){
                break;
            }else {
                prefix = prefix.substring(0, prefix.length()-1);

            }
            counter = 0;

        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] array = {"abc", "abcd", "abfce", "abcac"};

        System.out.println(prefix(array));  // ab

        String[] array2 = {"abc", "abcd", "abce", "abcac"};

        System.out.println(prefix(array2)); // abc
    }
}