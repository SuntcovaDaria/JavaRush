package JavaCore.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("file.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            FileOutputStream fos = new FileOutputStream("file.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            Solution savedObject = new Solution(23);

            oos.writeObject(savedObject);

            Solution loadedObject = (Solution) ois.readObject();

            if (savedObject.equals(loadedObject)){
                System.out.println("it's ok!");
            }


        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e ){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }


        System.out.println(new Solution(4));
    }



    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
