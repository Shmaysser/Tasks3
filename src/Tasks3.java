import java.util.HashSet;
import java.util.Set;

public class Tasks3 {
    public static void main(String[] args){
        System.out.println("Задача 1");
        System.out.println("solutions(1, 0, -1) = " + solutions(1, 0, -1));
        System.out.println("solutions(1, 0, 0) = " + solutions(1, 0, 0));
        System.out.println("solutions(1, 0, 1) = " + solutions(1, 0, 1));
        System.out.println("\nЗадача 2");
        System.out.println("findZip(\"all zip files are zipped\") = " + findZip("all zip files are zipped"));
        System.out.println("findZip(\"all zip files are compressed\") = " + findZip("all zip files are compressed"));
        System.out.println("\nЗадача 3");
        System.out.println("checkPerfect(6) = " + checkPerfect(6));
        System.out.println("checkPerfect(28) = " + checkPerfect(28));
        System.out.println("checkPerfect(496) = " + checkPerfect(496));
        System.out.println("checkPerfect(12) = " + checkPerfect(12));
        System.out.println("checkPerfect(97) = " + checkPerfect(97));
        System.out.println("\nЗадача 4");
        System.out.println("flipEndChars(\"Cat, dog, and mouse.\") = " + flipEndChars("Cat, dog, and mouse."));
        System.out.println("flipEndChars(\"ada\") = " + flipEndChars("ada"));
        System.out.println("flipEndChars(\"Ada\") = " + flipEndChars("Ada"));
        System.out.println("flipEndChars(\"z\") = " + flipEndChars("z"));
        System.out.println("\nЗадача 5");
        System.out.println("isValidHexCode(\"#CD5C5C\") = " + isValidHexCode("#CD5C5C"));
        System.out.println("isValidHexCode(\"#EAECEE\") = " + isValidHexCode("#EAECEE"));
        System.out.println("isValidHexCode(\"#eaecee\") = " + isValidHexCode("#eaecee"));
        System.out.println("isValidHexCode(\"#CD5C58C\") = " + isValidHexCode("#CD5C58C"));
        System.out.println("isValidHexCode(\"#CD5C5Z\") = " + isValidHexCode("#CD5C5Z"));
        System.out.println("isValidHexCode(\"#CD5C&C\") = " + isValidHexCode("#CD5C&C"));
        System.out.println("isValidHexCode(\"#CD5C5\") = " + isValidHexCode("#CD5C5"));
        System.out.println("\nЗадача 6");
        System.out.println("same(new int[]{1, 3, 4, 4, 4}, new int[]{2, 5, 7}) = " + same(new int[]{1, 3, 4, 4, 4}, new int[]{2, 5, 7}));
        System.out.println("same(new int[]{9, 8, 7, 6}, new int[]{4, 4, 3, 1}) = " + same(new int[]{9, 8, 7, 6}, new int[]{4, 4, 3, 1}));
        System.out.println("same(new int[]{2}, new int[]{3, 3, 3, 3, 3}) = " + same(new int[]{2}, new int[]{3, 3, 3, 3, 3}));
        System.out.println("\nЗадача 7");
        System.out.println("isKaprekar(3) = " + isKaprekar(3));
        System.out.println("isKaprekar(5) = " + isKaprekar(5));
        System.out.println("isKaprekar(297) = " + isKaprekar(297));
        System.out.println("\nЗадача 8");
        System.out.println("longestZero(\"01100001011000\") = " + longestZero("01100001011000"));
        System.out.println("longestZero(\"100100100\") = " + longestZero("100100100"));
        System.out.println("longestZero(\"11111\") = " + longestZero("11111"));
        System.out.println("\nЗадача 9");
        System.out.println("nextPrime(12) = " + nextPrime(12));
        System.out.println("nextPrime(24) = " + nextPrime(24));
        System.out.println("nextPrime(11) = " + nextPrime(11));
        System.out.println("\nЗадача 10");
        System.out.println("rightTriangle(3, 4, 5) = " + rightTriangle(3, 4, 5));
        System.out.println("rightTriangle(145, 105, 100) = " + rightTriangle(145, 105, 100));
        System.out.println("rightTriangle(70, 130, 110) = " + rightTriangle(70, 130, 110));

    } // фун-ция для подсчета кол-ва корней квадратного уравнения
    public static int solutions(int a, int b, int c){
        int d = b*b - 4*a*c;
        if(d<0)return 0;
        if(d == 0)return 1;
        return 2;
    }

    public static int findZip(String str){
        int first = str.indexOf("zip");
        if(first == -1)return -1;
        return str.indexOf("zip", first+1);
    }
    // поиск идеального числа
    public static boolean checkPerfect(int n){
        int sum = 0;
        for(int i = 1; i < n / 2 + 1; i++){
            if(n % i == 0)sum += i;
        }
        return sum == n;
    }
    //замена двух символов
    public static String flipEndChars(String str){
        if(str.length() < 2)return "Incompatible.";
        if(str.charAt(0) == str.charAt(str.length()-1))return "Two's a pair.";
        return str.charAt(str.length()-1) + str.substring(1, str.length()-1) + str.charAt(0);
    }

    public static boolean isValidHexCode(String str){
        String symbols = "0123456789ABCDEFabcdef";
        if(str.length() != 7)return false;
        if(str.charAt(0) != '#')return false; //перебираем символы начиная со 2го и смотрим есть ли они в строке symbols если нет то срзау не валидна
        for(int i = 1; i < str.length(); i++){
            if(symbols.indexOf(str.charAt(i)) == -1)return false;
        }
        return true;
    }

    public static boolean same(int[] arr1, int[] arr2){
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int elem : arr1) set1.add(elem);
        for(int elem : arr2) set2.add(elem);
        return set1.size() == set2.size();
    }

    public static boolean isKaprekar(int n){ // возводим число в квадрат
        int square = n*n;
        String str = String.valueOf(square); // переводим число в строку
        String left = str.substring(0, str.length()/2); // разбиваем число пополам так, что если оно четное пополам, а если нечетное то правая часть на 1 длиннее
        String right = str.substring(str.length()/2);
        try{
            return Integer.parseInt(left) + Integer.parseInt(right) == n; // сложение 2х чисел, если их сумма равна исходному то это число Капрекара
        } catch (NumberFormatException e){
            return false;
        }
    }

    public static String longestZero(String str) {
        String[] arr = str.split("1"); // разбиваем строку чтобы в ней остались только последовательности 0
        String res = "";
        int max = 0;
        for (int i = 0; i < arr.length; i++) { //используем простейший алгоритм чтобы найти последовательность макс длины
            if (arr[i].length() > max) {
                max = arr[i].length();
                res = arr[i];
            }
        }
        return res;
    }

    public static int nextPrime(int n){
        for(int i = n+1; true; i++){ // перебираем все числа от n+1 пока не найдем простое число
            boolean flag = true;
            for(int j = 2; j < i; j++){ // ищем делители на промежутке от 2 до половины этого числа если они есть то число непростое и мы идем дальше
                if(i % j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag)return i; // как только находится простое число то функция завершается
        }
    }

    //прямоугольный треугольник
    public static boolean rightTriangle(int a, int b, int c){
        if(a*a + b*b == c*c)return true;
        if(a*a + c*c == b*b)return true;
        if(b*b + c*c == a*a)return true;
        return false;
    }


}