package JavaCore.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter(reader.readLine()));

        while (true){
            String x = reader.readLine();
            if (!x.equals("exit"))
            {

                bw.write(x+"\n");
            }
            else
            {
                bw.write(x);
                break;
            }
        }
        bw.close();

    }
}
