import java.util.Scanner;

public class test1{
    public static void main(String[] args) {
        System.out.println("-- Test1 : Double Value Converter --");
        Scanner input = new Scanner(System.in);
        System.out.print("Please input a string: ");
        String str = input.nextLine();
        input.close();

        Double convertedDouble = DoubleConverter.Convert(str);
        System.out.println("Convert the String to Double: " + convertedDouble);
    }
}

/**
 * DoubleConverter
 */
class DoubleConverter {

    // such as  12.34  500.0  0.05  5e2(500)  5e-2(0.05)
    public static Double Convert(String str) {
        double doubleNumber = 0.0;

        // Regular expression to match scientific notation: 5.2e2 5e-2
        if (str.matches("^((-?\\d+.?\\d*)[Ee]{1}(-?\\d+))$")) {
            doubleNumber = Double.valueOf(str.toString());
        } else {
            // pure digital
            double tempNumber = 0.0; 
            boolean notAppearOnePoint = true;
            int pointIndex = 0;

            for (int i = 0; i < str.length(); i++) {
                if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                    tempNumber = str.charAt(i) - '0';
                    doubleNumber *= 10;
                    doubleNumber += tempNumber;
                } else if (str.charAt(i) == '.' && notAppearOnePoint && i > 0) {
                    pointIndex = i;
                    notAppearOnePoint = false;
                } else {
                    System.out.println("WARNING!!! : Exist Exception! program is ready to exit.");
                    // Stop the program
                    System.exit(0);
                }
            }
            if (pointIndex > 0) {
                doubleNumber /= Math.pow(10, str.length() - pointIndex - 1);
            }
        }

        return doubleNumber;
    }
}
