//Прочитать предварительно созданный текстовый файл и создать на его основе
// другой текстовый файл, в котором будут содержаться слова, которые содержат
// заданную с клавиатуры подстроку.

package Prog;

import java.util.*;
import java.io.*;

public class Main {
    public static final String FILE_NAME = "Text.txt";
    public static final String FILE_NAME2 = "Text2.txt";

    public static void main(String[] args) {
        File myFile = new File(FILE_NAME);
        System.out.println("Имя файла: " + myFile.getName());
        if(myFile.exists()) {
            System.out.println("Файл существует");
        } else {
            System.out.println("Файл еще не создан");
        }
        String line = null;
        String[] fulltextend = new String[1000];
        String fulltext="";
        System.out.println("Текст из файла: ");
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                fulltext=fulltext+line;
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Введите подстроку");
        String str1 = in.nextLine();
        fulltextend=fulltext.split(" ");
        int lastitem = fulltextend.length;
        for (int i=0;i<lastitem; i++) {
            fulltextend[i]=fulltextend[i]+str1;
        }

        File newFile = new File(FILE_NAME2);
        try
        {
            if(newFile.exists()) {
                System.out.println("Файл существует и будет пересоздан");
                newFile.delete();
            }

            boolean created = newFile.createNewFile();
            if(created)
                System.out.println("Файл создан");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        try(FileWriter writer = new FileWriter(FILE_NAME2, false))
        {
            for (int i=0; i<lastitem; i++){
                writer.write(fulltextend[i]+" ");
                if (i % 10==0)  {
                    writer.append(System.lineSeparator());
                }
            }

            writer.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }


    }
}
