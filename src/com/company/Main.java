package com.company;
import java.math.BigDecimal;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        /*
        KUIDAS KIRJUTADA JA LIITA STRINGE MÄLUSÕBRALIKUMALT
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10000; i++){
            sb.append("a");
        }
        Stringbuilder on muudetav, näiteks:
        StringBuilder sb = new StringBuilder();
        test(sb);
        System.out.println(sb) tagastab uuendatud sb sest tegemist on sama objektiga, stringi puhul see ei tööta
         */

        /*
        System.out.println("======= EXERCISES 1-4 =========");
        excersie1();
        excersie2();
        excersie3();
        excersie4();
        System.out.println("===============================");
        */
         /*
        System.out.println("======== Lesson1MathUtil ==========");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Lesson1MathUtil lesson1MathUtil1 = new Lesson1MathUtil("test");
        Lesson1MathUtil lesson1MathUtil2 = new Lesson1MathUtil("test2");
        lesson1MathUtil1.test();
        lesson1MathUtil2.test();

        int[][] twoArray = new int[3][4];

        System.out.println("min: " + Lesson1MathUtil.min(2, 4));
        System.out.println("min: " + Lesson1MathUtil.max(2, 4));
        System.out.println("min: " + Lesson1MathUtil.abs(15));
        System.out.println("min: " + Lesson1MathUtil.isEven(15));
        System.out.println("min: " + Lesson1MathUtil.min(3, 6, 9));
        System.out.println("min: " + Lesson1MathUtil.max(3, 6, 9));
        System.out.println("===============================");
        System.out.println("======== EXERCISE 7 =========");
        //exercise7();
        */
        Lesson1MathUtil inputExercise = new Lesson1MathUtil("test");
        //inputExercise.scan();

        Lesson2 lesson2 = new Lesson2();

        /*
        System.out.println("========= exercise1 ===========");
        lesson2.exercise1();*/
        /*
        System.out.println("========= exercise2 ===========");
        lesson2.exercise2(20);*/
        /*
        System.out.println("========= exercise3 ===========");
        lesson2.exercise3(10, 10);
        System.out.println("===============================");*/
        /*
        System.out.println("========= fibonacci ===========");
        System.out.println(lesson2.fibonacci(10));
        System.out.println("===============================");*/
        /*
        System.out.println("========= exercise5 ===========");
        lesson2.exercise5(900, 1000);
        System.out.println("===============================");
        */

        /*
        System.out.println("========= exercise6 ===========");
        lesson2.exercise6("visits.txt");
        System.out.println("===============================");
        */

        /*
        System.out.println("========= exercise7 ===========");
        lesson2.exercise7();
        System.out.println("===============================");
        */

        /*
        System.out.println("========= exercise8 ===========");
        lesson2.exercise8("nums.txt");
        System.out.println("===============================");
        */

        System.out.println("========= exercise9 ===========");
        lesson2.exercise9("nums.txt");
        System.out.println("===============================");





        System.out.println("========= LESSON3 ===========");
        List<Integer> testList = new ArrayList<>();
        testList.add(4);
        testList.add(5);
        testList.add(6);
        Arrays.toString(new int[0]);
        for (Integer i : testList) {
            System.out.println(i);
        }

        System.out.print(testList);

        Lesson3 lesson3 = new Lesson3();
        System.out.println(lesson3.reverseString("Test1 Test2"));
        Map<String, String> testMap = new HashMap<>();
        lesson3.test(testMap);
        Object a;


        /*
        System.out.println("========= uusSumma ===========");
        System.out.println(lesson3.uusSumma(19, 29));
        System.out.println("==============================");
        */
        /*
        System.out.println("========= sum ===========");
        System.out.println(lesson3.sum(new int[]{1, 2, 4, 6, 57, 35, 13, 35, 3}));
        System.out.println("==============================");
        */
        /*
        System.out.println("========= factorial ===========");
        System.out.println(lesson3.factorial(5));
        System.out.println("==============================");
        */


        System.out.println("========= sort ===========");
        System.out.println(Arrays.toString(lesson3.sort(new int[]{57, 3, -4, 0, 1, 2, 4, 6, -14 , 35, 13, 35, -5, 7, 7, 9, 64, 215})));
        System.out.println("==============================");

        /*
        System.out.println("========= reverseString ===========");
        System.out.println(lesson3.reverseString("SpIdErMan!"));
        System.out.println("==============================");

         */

        /*
        System.out.println("========= isPrime ===========");
        System.out.println(lesson3.isPrime(100));
        System.out.println("==============================");

         */

        /*
        System.out.println("========= Lesson3Hard ===========");
        Lesson3Hard lesson3Hard = new Lesson3Hard();

         */

        /*
        System.out.println("========= evenFibonacci ===========");
        System.out.println(lesson3Hard.evenFibonacci(10));
        System.out.println("==============================");

         */

        /*
        System.out.println("========= randomGame ===========");
        lesson3Hard.randomGame();
        System.out.println("==============================");

         */
        /*
        System.out.println("========= test ===========");
        lesson3Hard.test();
        System.out.println("==============================");

         */

        /*
        System.out.println("========= morseCode ===========");
        System.out.println(lesson3Hard.morseCode("Hello World"));
        System.out.println("==============================");

         */

        /*
        System.out.println("========= Lesson4 ===========");
        Lesson4 accountManager = new Lesson4("2646465121345897946", "1500", "Ott Kask");
        System.out.println(accountManager.getOwner());
        System.out.println(accountManager.getAccount());
        System.out.println(accountManager.getBalance());

        // TRANSACTIONS
        System.out.println("========= Transactions ===========");
        System.out.println(accountManager.changeBalance(accountManager.getAccount(), "-250"));
        System.out.print(accountManager.getBalance());

         */
    }

    public static void excersie1(){
        // TODO
        // defineeri 3 muutujat a = 1, b = 1, c = 3
        // Prindi välja a==b ja a==c
        // Lisa rida a = c
        // Prindi välja a==b ja a==c, mis muutus???
        int a = 1;
        int b = 1;
        int c = 3;
        System.out.println(a==b);
        System.out.println(a==c);
        a = c;
        System.out.println(a==b);
        System.out.println(a==c);
    }

    public static void excersie2(){
        // TODO
        // Loo muutujad x1 = 10 ja x2 = 20, vali sobiv andmetüüp
        // Tekita muutuja y1 = ++x1, trüki välja nii x1 kui y1
        // Tekita muutuja y2 = x2++, trüki välja nii x2 ja y2
        // Analüüsi tulemusi
        int x1 = 10;
        int x2 = 20;

        // ++x1 suurendab ka muutuja y1
        int y1 = ++x1;
        System.out.println("============");
        System.out.println(x1);
        System.out.println(y1);
        System.out.println("============");
        // x2++ EI suurendab muutujat y2
        int y2 = x2++;
        System.out.println("============");
        System.out.println(x2);
        System.out.println(y2);
        System.out.println("============");
    }

    public static void excersie3(){
        // TODO
        // Loo arvulised muutujad
        // a = 18 % 3
        // b = 19 % 3
        // c = 20 % 3
        // d = 21 % 3
        // Prindi välja kõigi muutujate väärtused
        int a = 18 % 3;
        int b = 19 % 3;
        int c = 20 % 3;
        int d = 21 % 3;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

    }

    public static void excersie4(){
        // TODO
        // Defineeri String tüüpi muutuja mille sisu oleks "\"\\""
        // Trüki muutuja sisu välja
        String str = "\"\\";
        System.out.println(str);
    }
}
