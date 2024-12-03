import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class adventOfCodeDay1 {

    public static void main(String [] args){
        
        String filePath = "day1/input.txt"; // Replace with your file path
        System.out.println("File path:" + filePath);
        ArrayList<Integer> leftSide = new ArrayList<>();
        ArrayList<Integer> rightSide = new ArrayList<>();
        int totalSumDifference = 0;
        int totalSimilarityList = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] words = line.split(" ", 2);
                leftSide.add(Integer.parseInt(words[0].strip()));
                rightSide.add(Integer.parseInt(words[1].strip()));
                // System.out.println("1:" + words[0]);
                // System.err.println("2:" + words[1].strip());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        Collections.sort(leftSide);
        Collections.sort(rightSide);
        int index = 0;
        for (Integer left : leftSide) {
            // System.out.println("total diff:" + left + "-" + rightSide.get(index) + "::" + Math.abs(left - rightSide.get(index)));
            totalSumDifference += Math.abs(left - rightSide.get(index));
            totalSimilarityList += Collections.frequency(rightSide, left) * left;
            System.out.println(String.format("Similarity for %s is %s", left, Collections.frequency(rightSide, left)));
            index++;
        }
        System.out.println("Total sum difference:" + totalSumDifference);
        System.out.println("Total sum similarity:" + totalSimilarityList);
    }
    
}
