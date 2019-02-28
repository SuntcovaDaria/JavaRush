package JavaCore.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        try {
        FileInputStream file = new FileInputStream(args[0]);
        TreeMap<Character, Integer> map = new TreeMap<>();
        while (file.available() > 0){
            char i = (char)file.read();
            if (!map.containsKey(i)){
                map.put(i, 1);
            }
            else {
                map.put(i, map.get(i)+1);
            }
        } file.close();
           for (Map.Entry pair : map.entrySet()){
               System.out.println(pair.getKey()+ " " + pair.getValue());
           }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
