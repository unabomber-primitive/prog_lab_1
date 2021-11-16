package com.company;

import java.util.Arrays;
import java.lang.Math;
import java.util.Locale;
import java.util.Random;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) {
	    //Создаем одномерный массив c типа long и заполняем его нечётными числами от 7 до 21 включительно в порядке убывания.
        long[] c = new long[8];
        c[0] = 21;
        for (int i = 1; i<8; i++) {
            c[i] = c[i-1] - 2;
        }

        //Создаем одномерный массив x типа double и заполняем его 12-ю случайными числами в диапазоне от -4.0 до 14.0.
        Random random = new Random();
        double[] x = random.doubles(12, -4.0, 14.0).toArray();

        //Сздаем двумерный массив b с элементами класса String размером 8х12
        String[][] b = new String[8][12];

        //Служебный массив
        long[] t = new long[] {13, 15, 17, 21};

        //Вычисляем элементы массива b и заполняем его
        for (int i = 0; i<8; i++) {
            for (int j = 0; j < 12; j++) {
                long k = c[i];
                if (c[i] == 9) {
                    b[i][j] = String.format(Locale.ROOT,"%.4f", Math.pow(Math.E, Math.pow(Math.pow(Math.E, x[j]), 2)));
                }
                else if (LongStream.of(t).anyMatch(z -> z == k)) {
                    b[i][j] = String.format(Locale.ROOT,"%.4f", Math.tan(Math.tan(Math.cos(x[j]))));
                }
                else {
                    b[i][j] = String.format(Locale.ROOT,"%.4f", Math.asin(Math.sin(Math.cbrt(Math.log(Math.pow(Math.E, x[j]))))));
                }
            }
        }
        System.out.println(Arrays.deepToString(b).replace("], ", "],\n"));
    }
}
