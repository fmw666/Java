import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class test2 {
    public static void main(String[] args) {
        System.out.println("-- Test2 : Letter Frequency Count --");
        System.out.println();

        LetterFrequencyCount lfc = new LetterFrequencyCount();
        if (lfc.loadFile("D:\\test2.txt")) {    
            lfc.printFrequencies();
        } else {
            System.err.println("Error in File open!");
        }
    }
}

class LetterFrequencyCount {
    private Reader fr;
    private StringBuffer sbf = null;
    private int sumnumber = 0;
    private int[] Chars = new int[26];

    public boolean loadFile(String filename) {
        try {
            fr = new FileReader(filename);
            char ch[] = new char[100];
            sbf = new StringBuffer();
            int length = fr.read(ch);
            while ((length != -1)) {
                sbf.append(ch);
                length = fr.read();
            }
            fr.close();

            for (int i = 0; i < sbf.length(); i++) {
                if ((int)(sbf.charAt(i)) >= 'A' && (int)(sbf.charAt(i)) <= 'Z') {
                    this.sumnumber++;
                    this.Chars[(int)(sbf.charAt(i) - 'A')]++;
                } else if ((int)(sbf.charAt(i)) >= 'a' && (int)(sbf.charAt(i)) <= 'z') {
                    this.sumnumber++;
                    this.Chars[(int) (sbf.charAt(i) - 'a')]++;
                }
            }
            return true;

        } catch (IOException e) {
            return false;
        }
    }

    public double getFrequency(char a) {
        if (a >= 'A' && a <= 'Z')
            return (double)this.Chars[a - 'A'] / this.sumnumber;
        else if (a >= 'a' && a <= 'z')
            return (double)this.Chars[a - 'a'] / this.sumnumber;
        else
            return 0;
    }

    public void printFrequencies() {
        for (int i = 0; i < 26; i++) {
            System.out.println((char)('A' + i) + " : " + (double)this.Chars[i] * 100 / this.sumnumber + "%");
        }
    }
}