import defoult.SpaceMarine;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.TreeMap;

public class Main {
     public static void main(String[] args){
         String filename;

//         try{
//             filename=args[0];
//         } catch (Exception e) {
//             System.out.println("Не выбран файл");
//             return;
//         }
//         try{
//             FileInputStream inputStream = new FileInputStream(filename);
//         } catch (FileNotFoundException e) {
//             System.out.println("Файл не существует");
//             return;
//         }
//
         Map<Integer, SpaceMarine> kek = new TreeMap<Integer, SpaceMarine>();
         kek.put(123, new SpaceMarine());
         Scanner scanner=new Scanner(System.in);
         String s;
         s = scanner.nextLine();
         
    }
}
