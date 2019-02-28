package JavaCore.task18.task1819;

/*

Объединение файлов
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String f1 = reader.readLine();
            String f2 = reader.readLine();

            FileInputStream file1 = new FileInputStream(f1);
            byte[] buff = new byte[file1.available()];
            while (file1.available() > 0){
                int count = file1.read(buff);
            }
            file1.close();

            FileInputStream file2 = new FileInputStream(f2);
            FileOutputStream fileOutputStream1 = new FileOutputStream(f1);
            while (file2.available() > 0){
                fileOutputStream1.write(file2.read());
            }
            file2.close();
            fileOutputStream1.close();

            FileOutputStream fileOutput1 = new FileOutputStream(f1,true);
            fileOutput1.write(buff);
            fileOutput1.close();

            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
