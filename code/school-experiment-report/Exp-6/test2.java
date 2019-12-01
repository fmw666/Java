import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Random;

public class test2 {
    public static void main(String[] args) {
        System.out.println("-- Test2 : Lottery Guessing --");

        int number;
        int leastMatchCount;

        Scanner input = new Scanner(System.in);
        List<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(3, 4, 5, 6, 7, 8, 9));
        System.out.print("How many lottery Numbers(3<=n<=9): ");
        number = input.nextInt();
        number = inputCheck(number, arr1, false, "Please re-input(3<=n<=9): ");
        
        List<Integer> arr2 = new ArrayList<Integer>();
        for (int i = 1; i <= number; i++) {
            arr2.add(i);
        }
        System.out.print("Minimum number of get award(1<=m<=" + number + "): ");
        leastMatchCount = input.nextInt();
        leastMatchCount = inputCheck(leastMatchCount, arr2, false, "Please re-input(1<=m<=" + number + "): ");
        
        Lottery lottery = new Lottery(number, leastMatchCount);
        int guessNum;
        List<Integer> arr3 = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        System.out.println("======");
        for (int i = 0; i < number; ) {
            System.out.print("Please input the guess number: ");
            guessNum = input.nextInt();
            guessNum = inputCheck(guessNum, arr3, false, "re-input(0<=number<=9): ");
            if(lottery.addGuess(guessNum, i)) {
                i++;
            } else {
                System.out.println("Number " + guessNum + " is already guessed!");
            }
            System.out.println("---");
        }

        System.out.print("\nThe Lottery numbers are: ( ");
        for (Integer num : lottery.numbers) {
            System.out.print(num + " ");
        }
        System.out.print(")\nYou Guess the numbers are: ( ");
        for (Integer num : lottery.guessNums) {
            System.out.print(num + " ");
        }
        System.out.println(")\nTotal " + lottery.matchCount + " is right");
        System.out.println("Finally, you get the award is: " + lottery.getAward() + "$.");
    }

    public static int inputCheck(int input, List<Integer> arr, boolean in_or_out, String tips) {
        Scanner sc = new Scanner(System.in);
        // if input must in arr
        if (in_or_out) {
            while (arr.contains(input)) {
                if (tips != "") {
                    System.out.print(tips);
                }
                input = sc.nextInt();
            }
        } else {
            while (!arr.contains(input)) {
                if (tips != "") {
                    System.out.print(tips);
                }
                input = sc.nextInt();
            }
        }
        return input;
    }
}


/**
 * Lottery
 */
class Lottery {
    private int number;
    private int leastMatchCount;
    public List<Integer> numbers = new ArrayList<Integer>(number);
    public List<Integer> guessNums = new ArrayList<Integer>(number);
    public int matchCount = 0;
    public boolean same = true;

    public Lottery(int number, int leastMatchCount) {
        this.number = number;
        this.leastMatchCount = leastMatchCount;
        guessNums = new ArrayList<Integer>(number);
        matchCount = 0;
        same = true;

        // Random numbers[number]
        Set set = new HashSet();
        Random random = new Random();
        while (set.size() < number) {
            set.add(random.nextInt(10));
        }
        numbers = new ArrayList<>(set);
    }

    public boolean addGuess(int guessNum, int pos) {
        if (guessNums.contains(guessNum) == false) {
            guessNums.add(guessNum);
            if (numbers.contains(guessNum)) {
                matchCount++;
                if (numbers.get(pos) != guessNum) {
                    same = false;     
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public double getAward() {
        if (matchCount >= leastMatchCount) {
            if (same) {
                return 100 * Math.pow(8, number);
            } else if(matchCount == number) {
                return Math.pow(6, number);
            } else {
                return 100 * Math.pow(2, number);
            }
        } else {
            return 0;
        }
    }
    
}
