package JavaCore.task20.task2017;

import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/
public class Solution {


    public A getOriginalObject(ObjectInputStream objectStream) {
        A a = null;
        try {
             a = (A) objectStream.readObject();
             if (!(a instanceof A)){
                a = null;
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
