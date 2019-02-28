package JavaCore.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        Person person;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        String name;
        Date date;
        Sex sex;
        int id;
        switch (args[0]) {
            case "-c": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        name = args[i];
                        sex = (args[i+1] == "м") ? Sex.MALE : Sex.FEMALE;
                        date = sdf.parse(args[i+2]);
                        if (sex == Sex.MALE) person = Person.createMale(name, date);
                        else person = Person.createFemale(name, date);
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    }
                    break;
                }
            }
            case "-u" : {
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i += 4){
                        id = Integer.parseInt(args[i]);
                        if (args[i+2].equals("м")){
                            allPeople.set(id, Person.createMale(args[i+1], sdf.parse(args[i+3])));
                        }else allPeople.set(id, Person.createFemale(args[i+1], sdf.parse(args[i+3])));

                    }
                }
                break;
            }
            case "-d" : {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        id = Integer.parseInt(args[i]);
                        allPeople.set(id , Person.createFemale(null, null));
                        allPeople.get(id).setSex(null);
                    }
                }
                break;
            }
            case "-i" : {
                synchronized (allPeople){
                    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    for (int i = 1; i < args.length; i++){
                        id = Integer.parseInt(args[i]);
                        person = allPeople.get(id);
                        if (person.getSex() == Sex.MALE) System.out.println(person.getName() + " м " + sdf1.format(person.getBirthDate()));
                        else System.out.println(person.getName() + " ж " + sdf1.format(person.getBirthDate()));
                    }
                }
                break;
            }
            //start here - начни тут
        }
    }
}
