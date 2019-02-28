package JavaCore.task17.task1710;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        SimpleDateFormat sf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sf2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        int id;

        if (args[0].equals("-c")){
            if (args[2].equals("м")){
                try {
                    allPeople.add(Person.createMale(args[1], sf1.parse(args[3])));
                    System.out.println(allPeople.size()-1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    allPeople.add(Person.createFemale(args[1], sf1.parse(args[3])));
                    System.out.println(allPeople.size()-1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        if (args[0].equals("-u")){
            id = Integer.parseInt(args[1]);
            if (args[3].equals("м")){
                try {
                    allPeople.set(id, Person.createMale(args[2], sf1.parse(args[4])));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    allPeople.set(id, Person.createFemale(args[2], sf1.parse(args[4])));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        if (args[0].equals("-d")){
            id = Integer.parseInt(args[1]);
            allPeople.get(id).setName(null);
            allPeople.get(id).setSex(null);
            allPeople.get(id).setBirthDate(null);

        }
        if (args[0].equals("-i")){
            id = Integer.parseInt(args[1]);
            String name = allPeople.get(id).getName();
            String sex = allPeople.get(id).getSex().equals(Sex.MALE) ? "м" : "ж";
            System.out.printf("%s %s %s", name, sex, sf2.format(allPeople.get(id).getBirthDate()));

        }
        //start here - начни тут
    }
}
