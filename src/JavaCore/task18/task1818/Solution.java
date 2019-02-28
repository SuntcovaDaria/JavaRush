package JavaCore.task18.task1818;

/* 
Два в одном
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            FileOutputStream file1 = new FileOutputStream(reader.readLine());
            FileInputStream file2 = new FileInputStream(reader.readLine());
            FileInputStream file3 = new FileInputStream(reader.readLine());

            while (file2.available() > 0){
                file1.write(file2.read());
            }
            while (file3.available() > 0){
                file1.write(file3.read());
            }

            file1.close();
            file2.close();
            file3.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
