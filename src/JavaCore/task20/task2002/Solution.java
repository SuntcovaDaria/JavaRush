package JavaCore.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("D:/JavaRushTasks/2.JavaCore/src/1.txt");  //"D:/JavaRushTasks/2.JavaCore/src/1.txt"
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            System.out.println(javaRush.equals(loadedObject));
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();



        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter pw = new PrintWriter(outputStream);
            String isUser = users != null ? "yes" : "no";
            pw.println(isUser);
//            implement this method - реализуйте этот метод
            if (users != null) {
                for (User user : users) {

                    for (int i = 0; i < users.size(); i++) {
                        pw.println(users.get(i).getFirstName());
                        pw.println(users.get(i).getLastName());

                        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");   // ормат в который  будет переводить строку
                        String str = sdf.format(users.get(i).getBirthDate());   //  в строку str записываем запарсиную по формату дату
                        pw.println(str);


                        pw.println(users.get(i).isMale());
                        pw.println(users.get(i).getCountry());

                    }
                }
            }
            pw.close();
        }

        public void load(InputStream inputStream) throws Exception {

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isUser = reader.readLine();
            if (isUser.equals("yes")) {
                this.users = new ArrayList<>();
                while (reader.ready()) {
                    User user = new User();
                    String str1 = reader.readLine();
                    if (!str1.equals("null")) user.setFirstName(str1);
                    String str2 = reader.readLine();
                    if (!str2.equals("null")) user.setLastName(str2);
                    String str3 = reader.readLine();
                    if (!str3.equals("null")) user.setBirthDate(new Date(Long.parseLong(str3)));
                    user.setMale(Boolean.parseBoolean(reader.readLine()));
                    String cntry = reader.readLine();
                    if (cntry.equals("Ukraine")) {
                        user.setCountry(User.Country.UKRAINE);
                    }
                    if (cntry.equals("Russia")) {
                        user.setCountry(User.Country.RUSSIA);
                    }
                    if (cntry.equals("Other")) {
                        user.setCountry(User.Country.OTHER);
                    }
                    this.users.add(user);

                }

                reader.close();

            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}