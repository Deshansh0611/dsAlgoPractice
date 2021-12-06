package assignment;

import java.util.Scanner;

public class NormalisedArray {
    public static void main(String[] args) {
        int arraySize;
        System.out.println("Enter the size of the array:");
        Scanner scanner = new Scanner(System.in);
        arraySize = scanner.nextInt();

        float[] array1 = takeInputArray(scanner, arraySize, "first");
        float[] array2 = takeInputArray(scanner, arraySize, "second");

        printArray(calculateNormalisedArray(array1, array2));
    }

    private static float[] takeInputArray(Scanner scanner, int arraySize, String arrayCoount) {
        float[] array = new float[arraySize];
        System.out.println("Enter the elements of the " + arrayCoount + " array:");
        float enteredValue = 0;
        for(int i=0; i<arraySize; i++) {
            enteredValue = scanner.nextFloat();
            // Restricting user to enter only numbers between 0 to 255
            if(enteredValue < 0 || enteredValue > 255) {
                System.out.println("Incorrect value. Please enter valid value between 0 to 255!");
                i--;
                continue;
            }
            array[i] = enteredValue;
        }
        return array;
    }

    private static float[] calculateNormalisedArray(float[] array1, float[] array2) {
        float max = 0;
        for(int i = 0; i<array1.length; i++) {
            array1[i] = (array1[i] + array2[i])/2;
            if(array1[i] > max)
                max = array1[i];
        }
        float scaleFactor = 255/max;
        for (int i = 0; i<array1.length; i++){
            array1[i] *= scaleFactor;
        }
        return array1;
    }

    private static void printArray(float[] array) {
        for(float i: array){
            System.out.println(i);
        }
    }
}
