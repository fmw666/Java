import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Random;

public class test1 {
    public static void main(String[] args) {
        System.out.println("-- Test1 : Read/Write Spend Time --");

        final long DATACOUNT = 100;
        System.out.println();

        // FileWriter 写
        try {
            // 获得当前系统时间
            long t = System.currentTimeMillis();
            // 创建一个FileWriter对象
            FileWriter fw = new FileWriter("D:\\test.txt");
            // 写入信息
            for (int i = 0; i < DATACOUNT; i++) {
                Random r = new Random();
                int k = r.nextInt(10);
                fw.write(k);
                // 刷新缓冲区
                fw.flush(); 
            }
            fw.close();
            System.out.println("FileWriter write spend time: " + (System.currentTimeMillis() - t) + "ms");
        } catch (IOException e) {
            System.out.println("FileWriter Error!");
        }

        // BufferedWriter 写
        try {
            // 获得当前系统时间
            long t = System.currentTimeMillis();
            // 创建一个FileWriter对象
            FileWriter fw = new FileWriter("D:\\test1.txt");
            // 创建一个BufferedWriter对象
            BufferedWriter bw = new BufferedWriter(fw);
            // 写入信息
            for (int i = 0; i < DATACOUNT; i++) {
                Random r = new Random();
                int k = r.nextInt(10);
                bw.write(k);
                // 刷新缓冲区
                bw.flush(); 
            }
            fw.close();
            System.out.println("BufferedWriter write spend time: " + (System.currentTimeMillis() - t) + "ms");
        } catch (IOException e) {
            System.out.println("BufferedWriter Error!");
        }

        System.out.println();
        // FileReader 读
        Reader fr = null;
        StringBuffer sbf = null;
        try {
            // 获得当前系统时间
            long t = System.currentTimeMillis();
            // 创建一个FileReader对象
            fr = new FileReader("D:\\test.txt");
            // 创建字符数组作为中转站
            char ch[] = new char[100]; 
            sbf = new StringBuffer();
            // 将字符读入数组
            int length = fr.read(ch); 
            while (length != -1) {
                sbf.append(ch);
                length = fr.read();
            }
            fr.close();
            System.out.println("FileReader read spend time: " + (System.currentTimeMillis() - t) + "ms");
        } catch (IOException e) {
            System.out.println("FileReader Error!");
        }

        // FileReader 读
        try {
            // 获得当前系统时间
            long t = System.currentTimeMillis();
            // 创建一个FileReader对象
            fr = new FileReader("D:\\test.txt");
            BufferedReader br = new BufferedReader(fr);
            // 创建字符数组作为中转站
            char ch[] = new char[100]; 
            sbf = new StringBuffer();
            int length = br.read(ch); 
            while ((length != -1)) {
                sbf.append(ch); 
                length = br.read();
            }
            br.close();
            fr.close();
            System.out.println("BufferedReader read spend time: " + (System.currentTimeMillis() - t) + "ms");
        } catch (IOException e) {
            System.out.println("BufferedReader Error!");
        }
    }
}
