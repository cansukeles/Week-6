import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        //creating a new txt file
        File file = new File("Practice.txt");
        if (!file.exists()) {
            file.createNewFile();
        } else {
            System.out.println("The file already exists");
        }

        //Adding some string elements to file
        FileWriter fWriter = new FileWriter(file, false);
        BufferedWriter bWriter = new BufferedWriter(fWriter);
        bWriter.write("5");
        bWriter.newLine();
        bWriter.write("10");
        bWriter.newLine();
        bWriter.write("20");
        bWriter.newLine();
        bWriter.write("12");
        bWriter.newLine();
        bWriter.write("33");
        bWriter.newLine();
        bWriter.close();

        //finding the total amount of numbers
        int sum = 0;
        try {
            FileReader fReader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(fReader);
            String line;
            System.out.println("Numbers from text: ");

            while ((line = bReader.readLine()) != null) {
                //changing String type to int
                sum += Integer.parseInt(line);
                System.out.println(line);
            }
            System.out.println("-------");
            System.out.println("Total amount of numbers: " + sum);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}