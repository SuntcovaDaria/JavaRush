package JavaCore.task15.task1527;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String url = reader.readLine();
        int symbol = url.indexOf("?");
        url = url.substring(symbol+1);
        String[] param = url.split("&");

        ArrayList <String> list = new ArrayList<>();
        for (String s : param){
            if (s.indexOf("=") != -1){
                list.add(s.substring(0, s.indexOf("=")));
            }
            else list.add(s);
        }
        for (String string : list){
            System.out.print(string + " ");
        }

        for (int i = 0; i < list.size(); i++){
            if (list.get(i).equals("obj")){
                System.out.println("");
                String s = param[i].substring(param[i].indexOf("=")+1);
                try {
                    double d = Double.parseDouble(s);
                    alert(d);
                }catch (Exception e){
                    alert(s);
                }
            }
        }


        reader.close();


        //add your code here
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
