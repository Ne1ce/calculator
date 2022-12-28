/**
 * Calculator
 */
import java.util.Scanner;
 public class Main {

     private static boolean bool=true;
     static int oper1;
     static int oper2;

     static int result;

     static String operation;
    public static String calc(String inputString) {
        String[] split = inputString.split(" ");
        if (split.length !=3) {
            System.out.println("Работа завершена");
            return " ";

        }
            oper1 = convert(split[0]);
            oper2 = convert(split[2]);
        if (oper1>0 && oper2>0) {
            bool=false;
        }
        if ((oper1<0&&oper2>0)||(oper2<0&&oper1>0)) {
            System.out.println("Ошибка.\n Проверьте корректность выражения.");
            return " ";

        }
            try {
            oper1 = Integer.parseInt(split[0]);
            oper2 = Integer.parseInt(split[2]);}catch (NumberFormatException e) {
                System.out.println();}
            operation=split[1];
            switch (operation) {
                case "+" : result= Integer.parseInt(String.valueOf((oper1+oper2)));
                break;
                case "-" : result= Integer.parseInt(String.valueOf(oper1-oper2));
                break;
                case "*" : result= Integer.parseInt(String.valueOf(oper1*oper2));
                break;
                case "/" : try{ result= Integer.parseInt(String.valueOf(oper1/oper2));
                }catch (ArithmeticException e) {
                    System.out.println("Введите верное выражение " + e);
                    return " ";
                }break;
                default:
                    System.out.println("Не корректное выражение,используйте целые числа и знаки (+,-,*,/)");
                }
            return String.valueOf(result);

        }

        public static String rome (int resultIndex) {
            String[] roman = {"N", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

           try {
               return roman[resultIndex];
           }catch (ArrayIndexOutOfBoundsException e) {
               System.out.println("Ошибка.\n Проверьте корректность выражения.");
               return "h";
           }
    }

     private static int convert (String s) {

         return switch (s) {
             case "0", "N" -> 0;
             case "I" -> 1;
             case "II" -> 2;
             case "III" -> 3;
             case "IV" -> 4;
             case "V" -> 5;
             case "VI" -> 6;
             case "VII" -> 7;
             case "VIII" -> 8;
             case "IX" -> 9;
             case "X" -> 10;
             default -> -1;
         };

     }

    public static void main(String[] args) {


         Scanner scanner = new Scanner(System.in);
         System.out.println("Введите выражение через пробел(2 + 4) или (ix / v) \n" +
                                     "Операнды от 1 до 10 (I-X)");

        while (true){
            String userInput = scanner.nextLine().toUpperCase();
            if (calc(userInput).equals(" ")){
                System.out.println("Error");
                break;
            }else if (rome(result).equals("h")) {
                System.out.println("Error");
                break;
            }
         calc(userInput);
         if (oper1>10||oper2>10) {
             System.out.println("Операнды от 0 до 10(N-X)");
         break;
         }


         if(!bool) {
             System.out.println("Римские числа. \n" + " Результат: " + rome(result));
         }
        else {
             System.out.println("Арабские числа. \n" + " Результат: " + result);
         }
             System.out.println("Еще раз?");
        }


    }
 }

