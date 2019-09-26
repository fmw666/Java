import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        System.out.println("-- Test1 : Bank deposits Problem --");
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please input the deposit : ");
        double deposit = input.nextDouble();
        while (deposit <= 0) {
            System.out.print("->Input Data Range Error! Please re-input(deposit>0) : ");
            deposit = input.nextDouble();
        }

        System.out.print("Please input the interest rate(eg:0.58) : ");
        float rate = input.nextFloat();
        while (rate <= 0 || rate >= 1) {
            System.out.print("->Input Data Range Error! Please re-input(0<rate<1) : ");
            rate = input.nextFloat();
        }

        System.out.print("Please input the deposit period : ");
        int year;
        while (true) {
            try {
                year = input.nextInt();
                if (year > 0) {
                    break;   
                }
                System.out.print("->Input Data Range Error! Please re-input(year>0) : ");
            } catch (Exception e) {
                System.out.print("->Input Data Type Error! Please re-input(year is <int> type) : ");
                input.next();
            }    
        }
        
        input.close();
        System.out.println("\n(deposit=" + deposit + ", rate=" + rate + ", year=" + year + ")");

        Double totalDeposit = deposit * Math.pow((1.0f + rate), year);
        System.out.println("Total deposit is : " + totalDeposit);
    }
}
