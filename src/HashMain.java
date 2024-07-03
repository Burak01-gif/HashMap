import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class HashMain {

    public static void main(String[] args) throws IOException {
        Map<String, LinkedList<Integer>> table = new HashMap<>();
        Scanner scn = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            String x = Integer.toString(i);
            String[] temp = Files.readString(Path.of("C:\\Users\\ezero\\java_projects\\java_entry\\COMP2102 Data Structure\\Project2.2\\Project2.2\\src\\" + x + ".txt")).toLowerCase().split(" ");

            for (String s : temp) {
                LinkedList<Integer> tempIndex = table.getOrDefault(s, new LinkedList<>());
                tempIndex.add(i);
                table.put(s, tempIndex);
            }
        }

        System.out.println("Words in files: " + table.keySet());
        System.out.println("Occurrences in files: " + table.values());

        System.out.println("Enter a word:");
        String a = scn.next();

        while (table.containsKey(a)) {
            System.out.print("Found in files: ");
            for (int n = 0; n < table.get(a).size(); n++) {
                System.out.print(table.get(a).get(n) + ".txt, ");
            }
            System.out.println();
            System.out.println("Enter a word:");
            a = scn.next();
        }

        System.out.println("No text files include this word.");
    }
}
