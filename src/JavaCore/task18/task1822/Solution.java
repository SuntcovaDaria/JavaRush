package JavaCore.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String id = args[0];
        try {

            String line;
            FileInputStream file = new FileInputStream(reader.readLine());
            reader.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(file));
            while ((line = br.readLine()) != null) {
                if (line.startsWith((id)+ " ")){
                    System.out.println(line);
                }
            }
            file.close();
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
