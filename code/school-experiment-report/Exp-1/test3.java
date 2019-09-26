import java.util.Scanner;

public class test3{
    public static void main(String[] args) {
        System.out.println("-- Test3 : * print Problem --");
        Scanner input = new Scanner(System.in);

        System.out.print("Please input the first layer's <*> quantity : ");
        int start;
        while (true) {
            try {
                start = input.nextInt();
                if (start > 0) {
                    break;
                }
                System.out.print("->Input Data Range Error! Please re-input(quantity>0) : ");
            } catch (Exception e) {
                System.out.print("->Input Data Type Error! Please re-input(quantity is <int> type) : ");
                input.next();
            }
        }
        
        System.out.print("Please input the layer number of size : ");
        int layer;
        while (true) {
            try {
                layer = input.nextInt();
                if (layer > 0) {
                    break;
                }
                System.out.print("->Input Data Range Error! Please re-input(layer>0) : ");
            } catch (Exception e) {
                System.out.print("->Input Data Type Error! Please re-input(layer is <int> type) : ");
                input.next();
            }
        }
        
        input.close();
        System.out.println("(" + start + ", " + layer + ")");

        int end = start + (layer - 1) * 2;

        System.out.println("\n--print--\n");
        for (int i = 0; i < layer; i++) {
            int spaces = (end - (start + i * 2)) / 2;
            int points = start + i * 2;
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < points; k++) {
                System.out.print("*");
            }
            for (int m = 0; m < spaces; m++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
