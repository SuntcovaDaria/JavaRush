package JavaCore.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName = reader.readLine();
            while (!fileName.equals("exit")) {
                ReadThread readThread = new ReadThread(fileName);
                readThread.start();
                readThread.join();
                fileName = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName = null;
        ArrayList<Integer> list = new ArrayList<>();

        public ReadThread(String fileName) throws IOException {
            this.fileName = fileName;
            FileInputStream inputStream = new FileInputStream(fileName);
            while (inputStream.available() > 0) list.add(inputStream.read());
            inputStream.close();
        }

        public void run() {
            int element = list.get(0);
            for (Integer x : list)
                if (Collections.frequency(list, x) > Collections.frequency(list, element)) element = x;
            resultMap.put(fileName, element);
        }
    }
}