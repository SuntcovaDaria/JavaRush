package JavaMultithreading.task22.task2207;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fis = new FileInputStream(reader.readLine() );
            reader.close();
            ArrayList <String> list = new ArrayList<>();
            BufferedReader bf = new BufferedReader(new InputStreamReader(fis, "UTF-8"));

            while (bf.ready()){
                String line = bf.readLine();
                String[] wordList = line.split(" ");
                list.addAll(Arrays.asList(wordList));
            }
            bf.close();

            for (String outer : list){
                StringBuilder stringBuilder = new StringBuilder(outer);
                String reversedString = stringBuilder.reverse().toString();
                for (String s : list){
                    if (reversedString.equals(s)|| outer.equals(s)){
                        result.add(new Pair(outer, s));
                    }
                }
            }

            for (Pair pair : result){
                System.out.println(pair);
            }

            fis.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
