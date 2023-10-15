import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        //Creating a new file
        File file = new File("src/Practice.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

        //checking if the file is empty or not
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine()) != null){
            System.out.println("Existing text from file: " + line);
        }
            Scanner input = new Scanner(System.in);
            System.out.print("Write a text: ");
            String text = input.nextLine();

            //write a text to file
            try {
                FileWriter fWriter = new FileWriter(file, true);
                PrintWriter pWriter = new PrintWriter(fWriter);
                pWriter.print(text);
                pWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //reading the text from file
            try {
                FileReader fReader = new FileReader(file);
                BufferedReader bReader = new BufferedReader(fReader);
                String readingText = bReader.readLine();
                System.out.println("This is your text from file: " + readingText);
                bReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
