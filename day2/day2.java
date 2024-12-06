import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class day2 {
    public static void main(String[] args) {
        int totalSum = 0;
        int safeSum = 0;
        String filePath = "day2/input.txt";
        ArrayList<String> unsafeList = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int line_number = 0;
            while ((line = br.readLine()) != null) {
                // System.out.println(line);
                String[] words = line.split(" ");
                if(computeSafe(words)){
                    safeSum += 1;
                } else{
                    unsafeList.add(line);
                }
                line_number++;
                totalSum++;
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        System.out.println("This is the safe amount: " + safeSum);
        System.out.println("Unsafe amount:" + unsafeList.size());
        System.out.println("This is the total amount: " + totalSum);
        System.out.println("START COPUTING UNSAFE LIST TO CHECK IF THEY CAN BE MADE SAFE");
        int newSafeAmount = 0;
        for(String line : unsafeList){
            String[] words = line.split(" ");
            System.out.println(words);
            int removedLevel = 0;
            for (int i = 0; i < words.length; i++) {
                ArrayList<String> newArray = new ArrayList<>(Arrays.asList(words));
                for(String s : newArray){
                    System.out.print("+"+s);
                }
                System.out.println("-");
                String removedWord = newArray.remove(i);
                System.out.println("removed: " + removedWord);
                String[] stringArray = newArray.toArray(new String[0]);
                if(computeSafe(stringArray)){
                    newSafeAmount+=1;
                    break;
                }
            }
            System.out.println(" ");
        }
        System.out.println("THIS IS THE NEW SAFE AMOUNT: " + newSafeAmount);
        System.out.println("total safe amount:" + (safeSum + newSafeAmount));

    }

    static boolean computeSafe(String[] words){
        
        boolean isUnsafe = false;
        int unsafeLimit = 0;
        boolean increasing = false;
        boolean decreasing = false;
        if(Integer.parseInt(words[1]) > Integer.parseInt(words[2])){
            decreasing = true;
        }else{
            increasing = true;
        }
        int i = 0;
        for (String word : words) {
            System.out.print(word + ",");
            if(i < words.length-1){
                int first_number = Integer.parseInt(word);
                int second_number = Integer.parseInt(words[i+1]);
                if(decreasing){
                    if(Math.abs(first_number - second_number) > 3  || first_number == second_number || first_number < second_number){

                        isUnsafe = true;
                        return false;
                    }
                }
                if(increasing){
                    if(Math.abs(first_number - second_number) > 3  || first_number == second_number || first_number > second_number){

                        isUnsafe = true;
                        return false;
                    }
                }
                i++;
            }
        }
        System.out.println(" ");
        return true;
    }

}
