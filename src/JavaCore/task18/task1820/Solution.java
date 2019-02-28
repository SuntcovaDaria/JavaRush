package JavaCore.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader readBuff = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = readBuff.readLine();
            String fileName2 = readBuff.readLine();

            BufferedReader reader = new BufferedReader(new FileReader(new File(fileName1)));
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName2)));

            String line;

            while((line = reader.readLine()) != null) {
                String[] numbers = line.split(" ");

                for (String num : numbers)
                {int res = (int) Math.round(Double.parseDouble(num));
                writer.write(res + " ");}

            }
            reader.close();
            writer.close();
            readBuff.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
