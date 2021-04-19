import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * @author Ishtukin Vlad
 * @version 1.0.0
 * @project test
 * @class Main
 * @since 19.04.2021 - 19.21
 */

public class Main {

    public static void main(String[] args) throws IOException {

        String text = new String(Files.readAllBytes(Paths.get("D:\\BestBrain\\Java kurs\\harry.txt")));
        text = text.toLowerCase().replaceAll("[^A-Za-z ]","");
        String[] array = text.split(" +");
        List<String> list = Arrays.stream(array).collect(Collectors.toList());

        Map<String, Integer> map = new HashMap<>();
        Integer value = 0;
        for (int i = 0; i < array.length; i++) {
            if(!map.containsKey(array[i])){
                map.put(array[i], 1);
            }else {
                value = map.get(array[i]);
                map.put(array[i], value + 1 );
            }
        }


        Map<String, Integer> sorted = new LinkedHashMap<>();


        map.entrySet().stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                .forEachOrdered(entry -> sorted.put(entry.getKey(), entry.getValue()));

        sorted.entrySet().stream().limit(20).forEach(System.out::println);

        String sorted20 = "----------------------------" + System.lineSeparator()
                + " HEAD for the task 1" + System.lineSeparator()
                + "-----------------------------------" + System.lineSeparator();
        int counter = 0;
        for (Map.Entry<String,Integer> entry : sorted.entrySet()){
            counter++;
            sorted20 += entry.getKey() + " " + entry.getValue() + System.lineSeparator();
            if (counter == 20) break;
        }
        String sortedToString = sorted.toString();
        Files.write(Paths.get("D:\\BestBrain\\Java kurs\\output.txt"),
                sorted20.getBytes(StandardCharsets.UTF_8));


        String newText = new String(Files.readAllBytes(Paths.get("D:\\BestBrain\\Java kurs\\harry.txt")));
        newText = newText.replaceAll("[^A-Za-z ]","");
        String[] newArray = newText.split(" +");

       String[] properNames = new String[newArray.length];
        int counterForNames = 0;

        for (int i = 0; i < newArray.length; i++) {
            if((Character.isUpperCase(newArray[i].charAt(0)))){
                properNames[counterForNames] = newArray[i];
                counterForNames++;
                //System.out.println(properNames[counterForNames]);
            }

        }
        String[] names20 = new String[20];

        for (int i = 0; i < 20; i++) {
            names20[i] = properNames[i];
            System.out.println(names20[i]);
        }


        List<String> newList = Arrays.stream(properNames).collect(Collectors.toList());
        newList.stream().limit(20).forEach(System.out::println);

        String output = "D:\\BestBrain\\Java kurs\\outputNames.txt";

        Files.write(Paths.get(output), Arrays.toString(names20).getBytes(StandardCharsets.UTF_8));
    }
}