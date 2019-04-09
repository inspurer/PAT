package PAT.Github.PAT;

import java.util.HashMap;
import java.util.Scanner;

//CreateTime: 2019/3/21 23:21
//Author:     月小水长(https://github.com/inspurer)
/*
    类名:首字母大写，其他单词中首字母大写，其他小写
    方法名:首字母小写，其他单词中首字母大写，其他小写
    变量:与方法名规则同
    包名:全部小写
*/
public class No_1005 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        scanner.close();
        int count = 0;
        for(int i = 0; i < input.length(); i++){
            count += Integer.parseInt(input.substring(i,i+1));
        }
        HashMap<String,String> hm = new HashMap<String, String>();
        hm.put("0","zero");
        hm.put("1","one");
        hm.put("2","two");
        hm.put("3","three");
        hm.put("4","four");
        hm.put("5","five");
        hm.put("6","six");
        hm.put("7","seven");
        hm.put("8","eight");
        hm.put("9","nine");
        String res = String.valueOf(count);
        System.out.printf("%s",hm.get(res.substring(0,1)));
        for(int i = 1; i < res.length(); i++){
            System.out.printf(" %s",hm.get(res.substring(i,i+1)));
        }
    }
}
