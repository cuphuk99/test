import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ishtukin Vlad
 * @version 1.0.0
 * @project test
 * @class Duplicates
 * @since 19.04.2021 - 19.12
 */


public class Duplicates {
    public  static  boolean hasDuplicates(int[] array){
        Arrays.sort(array);
        boolean isTrue = false;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] == array[i+1]){
                isTrue = true;
            }
        }
        return  isTrue;
    }

    public static void main(String[] args) {
        int[] array = {1,5,3,6,2,9,33,21};
        System.out.println(hasDuplicates(array));  // false
        array[5] = 1;

        System.out.println(hasDuplicates(array)); // true
    }
}