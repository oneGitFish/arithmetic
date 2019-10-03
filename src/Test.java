import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        File fileA = new File("C:\\Users\\luoxue\\Desktop\\a.txt");
        File fileB = new File("C:\\Users\\luoxue\\Desktop\\b.txt");
        File fileC = new File("C:\\Users\\luoxue\\Desktop\\c.txt");
        String[] strs = {"a","b","c"};
        createFile(fileA, strs);
        createFile(fileB, strs);
        //createFile(fileC);

        List<String> strA = readFile(fileA);
        List<String> strB = readFile(fileB);


        FileOutputStream fileOutputStream;
        try {
            fileOutputStream  = new FileOutputStream(fileC);
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
                for (int i = 0; i < strA.size(); i++){
                    String a = strA.get(i);
                    String b = strB.get(i);
                    outputStreamWriter.write(a + b);
                }
                outputStreamWriter.close();
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 創建文件
     * @param file
     */
    private static void createFile(File file, String[] strs){
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream  = new FileOutputStream(file);
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
               // char[] chars = {'a', 'b', 'c'};
                for (int i = 0; i < strs.length; i++){
                    outputStreamWriter.write(strs[i] + "\n");
                }
                outputStreamWriter.close();
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> readFile(File file){
        FileInputStream fileInputStream;
        List<String> list = new ArrayList<>();
        try {
            fileInputStream  = new FileInputStream(file);
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
               while (inputStreamReader.ready()){
                   list.add(String.valueOf((char)inputStreamReader.read()));
               }
               inputStreamReader.close();
               fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
