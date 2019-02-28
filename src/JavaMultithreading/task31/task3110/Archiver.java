package JavaMultithreading.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args)  {
        String zipFile = "";
        String source = "";

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Введите путь к архиву");
            zipFile = bf.readLine();
            System.out.println("Введите путь к файлу");
            source = bf.readLine();
            ZipFileManager zipFileManager = new ZipFileManager(Paths.get(zipFile));
            zipFileManager.createZip(Paths.get(source));
            ExitCommand exitCommand = new ExitCommand();
            exitCommand.execute();
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Упс! Что то пошло не так :(");
        }catch (Exception a){
            a.printStackTrace();
            System.out.println("Упс! Что то пошло не так :(");
        }

    }
}




