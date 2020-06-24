import java.util.Random;

public class Main {
    public static void main(String[] args) {
        checkLength(1000,6,10);
        checkPower(20,3, 5);

//        Выполнен подсчет по времени выполнения. Время возрастает линейно. в возведении в степень почти не меняется.
//        Скорее всего после первой итерации цикла включается многопоточный режим
    }

    static int power(int base, int exp){
        int result = 1;
        for (int i=1; i<=exp; i++){
            result = result*base;
        }
        return result;
    }

    static int min(int[] arr) {
        var result = arr[0];
        for (int i = 0; i < arr.length;i++) {
            if (arr[i] < result) {
                result = arr[i];
            }
        }
        return result;
    }

    static long avg(int[] numbers) {
        long average = 0;
        if (numbers.length > 0)
        {
            long sum = 0;
            for (int j = 0; j < numbers.length; j++) {
                sum += numbers[j];
            }
            average = sum / numbers.length;
        }
        return average;
    }

    static int[] arrayCreate(int maxLength) {
        int[] array = new int[maxLength];

        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(maxLength);
        }

        return array;
    }

    static void printArray(int[] array) {
        System.out.print("|");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "|");
        }
        System.out.println("\n");
    }

    static void checkLength(int base, int iterations, int step)
    {
        for(int i=0;i<iterations;i++)
        {

            int[] arr = arrayCreate(base * power(step,i));
            long start,end;
            double value;

            start = System.nanoTime();
            value = min(arr);
            end= System.nanoTime();
            System.out.println((end - start)*0.0001 +" ms. Min for " + base * power(step,i)+" range. Value = " + value);

            start = System.nanoTime();
            value = avg(arr);
            end = System.nanoTime();
            System.out.println((end - start)*0.0001 +" ms. Avg for " + base*power(step,i) + " range. Value = " + value);

            System.out.println("----------------------------------------------------------------------------------");
        }
    }

    static void checkPower(int base, int exp, int iterations) {
        for(int i=0;i < iterations;i++)
        {
            long start,end;
            long value;
            start = System.nanoTime();
            value = power(base * i, exp);
            end = System.nanoTime();
            System.out.println((end - start)*0.0001 +" ms. Power for base: " + base*i + " and exp: " + exp + ". Value = " + value);
            System.out.println("----------------------------------------------------------------------------------");
        }
    }
}
