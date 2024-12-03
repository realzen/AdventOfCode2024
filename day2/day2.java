import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day2 {
    public static void main(String[] args) {
        int safeSum = 0;
        String filePath = "day2/input.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int line_number = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] words = line.split(" ");
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
                    if(i < words.length-1){
                        int first_number = Integer.parseInt(word);
                        int second_number = Integer.parseInt(words[i+1]);
                        if(decreasing){
                            if(Math.abs(first_number - second_number) > 3  || first_number == second_number || first_number < second_number){

                                isUnsafe = true;
                                System.out.println("this line is unsafe:" + line_number + ": number -> " + word);
                                break;
                            }
                        }
                        if(increasing){
                            if(Math.abs(first_number - second_number) > 3  || first_number == second_number || first_number > second_number){

                                isUnsafe = true;
                                System.out.println("this line is unsafe:" + line_number + ": number -> " + word);
                                break;
                            }
                        }
                        i++;
                    }
                }
                if(!isUnsafe){
                    safeSum += 1;
                }
                line_number++;
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        System.out.println("This is the safe amount: " + safeSum);
    }

}
