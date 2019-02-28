package JavaCore.task13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(rd.readLine())));

        String s;
        ArrayList<Integer> numbers = new ArrayList<>();
        while ((s = br.readLine()) != null) {
            int i = Integer.parseInt(s);
            numbers.add(i);
        }
        br.close();
        rd.close();

        ArrayList<Integer> even = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                even.add(numbers.get(i));
            } else
                continue;
        }

        Collections.sort(even);
        for (Integer i : even) {
            System.out.println(i);
        }
    }
}

