package JavaCore.task20.task2025;



import java.util.ArrayList;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        ArrayList<Long> preResult = new ArrayList();

        while (N != 0) {
            N = N / 10;       // убираем крайнюю правую (она отбравывается потому что становится после запятой)

        }

        long[] result = null;
        ArrayList<Long> list = new ArrayList(); // для цифр взятого числа
        long value = 1;

        while (value < N) {
            int i = 0; // колличество чисел в числе
            long valueTemp = value;
            while (valueTemp > 0) {  // находим цыфры взятого числа
                list.add(valueTemp % 10);
                valueTemp /= 10;
                i++;
            }

            valueTemp = 0;
            for (long l : list) {
                valueTemp += Math.pow(l, i);
            }
            if (value == valueTemp) {
                preResult.add(valueTemp);
                list.clear();
                i = 0;
            } else list.clear();
            i = 0;
        }
        value = preResult.size();
        result = new long[(int) value];

        for (int r = 0; r < value; r++) {
            result[r] = list.get(r);
        }
        return result;
    }


    public static void main(String[] args) {


    }
}


