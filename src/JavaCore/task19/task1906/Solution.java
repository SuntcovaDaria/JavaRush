package JavaCore.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution  {
    public static void main(String[] args) {
        try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            FileReader reader1 = new FileReader(reader.readLine());
            FileWriter writer = new FileWriter(reader.readLine());
            int count = 0;
            while (reader1.ready()){
                int data = reader1.read();
                count ++;
                if (count%2==0){
                    writer.write(data);
                }
            }
            reader.close();
            reader1.close();
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
