package JavaCore.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileReader fileReader = new FileReader(reader.readLine());
            reader.close();

            int count = 0;
            String world = "";

            while (fileReader.ready()){
                char data = (char)fileReader.read();
                if (data != 44){
                    world = world + data;
                }
                else {
                   if (world.equals("world")){
                       count ++;
                       world = "";
                   }
                   else world = "";
                }
            }
            fileReader.close();

            System.out.println(count);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
