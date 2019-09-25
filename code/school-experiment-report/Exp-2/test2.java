import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        System.out.println("-- Test2 : Alphabet Converter --");
        Scanner input = new Scanner(System.in);

        System.out.print("Please input a sentense: ");
        String strSen = input.nextLine();
        // match blank space number ,if > 1 then = 1
        // Example: This .is a wonderFul time,to shaRe.with yOu.
        // Output: This .is a wonderFul time,to shaRe.with yOu.
        strSen = strSen.replaceAll("\\s{1,}", " ");
        System.out.println("\nInput Sentense is:\n\"" + strSen + "\"\n (regular -> no extra more Spaces)");

        // Create a output holder, class:StringBuffer name:result
        StringBuffer result = new StringBuffer();

        // Cut by space
        // Example: "This" ".is" "a" "wonderful" "time,to" "share.with" "yOu."
        String[] splitStr = strSen.split(" ");
        for (String str : splitStr) {
            // if all is alphabet
            if (str.matches("[a-zA-Z]+")) {

                result.append(test2.Convert(str, 0, str.length()) + " ");
            } else if (str.matches("(.|,)[a-zA-Z]+")) {

                result.append(test2.Convert(str, 1, str.length()) + " ");
            } else if (str.matches("[a-zA-Z]+(.|,)")) {

                result.append(test2.Convert(str, 0, str.length()-1) + " ");
            } else if (str.matches("[a-zA-Z]+(.|,)[a-zA-Z]+")) {
                // We only consider that '.' or ',' and Each of them only appear one time
                int splitIndex1 = str.indexOf('.');
                int splitIndex2 = str.indexOf(',');

                // Match '.'
                if (splitIndex1 != -1) {
                    String splitChar = str.substring(splitIndex1, splitIndex1 + 1);
                    String []doubleStr = str.split("\\.");
                    String firstStr = doubleStr[0];
                    String secondStr = doubleStr[1];

                    // add to the result
                    result.append(test2.Convert(firstStr, 0, firstStr.length()) + splitChar);

                    // add to the result
                    result.append(test2.Convert(secondStr, 0, secondStr.length()) + " ");
                }

                // Match ',', splitIndex_2+1
                if (splitIndex2 != -1) {
                    String splitChar = str.substring(splitIndex2, splitIndex2 + 1);
                    String firstStr = str.split(",")[0];
                    String secondStr = str.split(",")[1];

                    // add to the result
                    result.append(test2.Convert(firstStr, 0, secondStr.length()) + splitChar);

                    // add to the result
                    result.append(test2.Convert(secondStr, 0, secondStr.length()) + " ");
                }
            } else {
                // Except the alphabet
                result.append(str + " ");
            }
        }

        System.out.println("\nConvert result is:\n\"" + result.toString().trim() + "\"");
    }

    // first Char convert to upper, first+1 Char to last char convert to lower
    public static String Convert(String str, int firstCharIndex, int lastCharIndex) {
        StringBuffer tempStr = new StringBuffer(str);

        // Set first char Upper
        char firstChar = str.charAt(firstCharIndex);
        String upperCase = String.valueOf(firstChar).toUpperCase();
        tempStr.replace(firstCharIndex, firstCharIndex+1, upperCase);

        // Set other chars Lower
        String lowerCase = str.substring(firstCharIndex+1, lastCharIndex).toLowerCase();
        tempStr.replace(firstCharIndex+1, lastCharIndex, lowerCase);
        
        return tempStr.toString();
    }
}