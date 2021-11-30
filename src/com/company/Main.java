import java.util.Arrays;
import java.lang.Math;
import java.util.Locale;
import java.util.Random;
import java.util.stream.*;

public class Main {

    public static long[] generateDescendingArrayWithStep(int fromTop, int toBottom, int step) {
        int length = (fromTop - toBottom)/step + 1;
        long[] arr = new long[length];
        arr[0] = fromTop;
        for (int i = 1; i < length; i++) {
            arr[i] = arr[i-1] - step;
        }
        return(arr);
    }

    public static void main(String[] args) {

        long[] c = generateDescendingArrayWithStep(21, 7, 2);

        //Создаем одномерный массив x типа double и заполняем его 12-ю случайными числами в диапазоне от -4.0 до 14.0.
        Random random = new Random();
        double[] x = random.doubles(12, -4.0, 14.0).toArray();
        
        //Сздаем двумерный массив b с элементами класса Double размером 8х12
        double[][] b = new double[8][12];
        
        //Служебный массив
        long[] t = new long[] {13, 15, 17, 21};
        
        //Вычисляем элементы массива b и заполняем его
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                long k = c[i];
                if (k == 9) {
                    b[i][j] = Math.pow(Math.E, Math.pow(Math.pow(Math.E, x[j]), 2));
                }
                else if (LongStream.of(t).anyMatch(z -> z == k)) {
                    b[i][j] = Math.tan(Math.tan(Math.cos(x[j])));
                }
                else {
                    b[i][j] = Math.asin(Math.sin(Math.cbrt(Math.log(Math.pow(Math.E, x[j])))));
                }
            }
        }
        for (int i = 0; i < b.length; i++) {
            System.out.print('[');
            for (int j = 0; j < b[0].length; j++) {
            	System.out.print(String.format(Locale.ROOT, j == b[0].length-1 ? "%.4f],\n" : "%.4f, ", b[i][j]));
            }
        }
    }
}
