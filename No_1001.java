package PAT.Github.PAT;

import java.util.LinkedList;
import java.util.Scanner;

//CreateTime: 2019/3/21 23:21
//Author:     月小水长(https://github.com/)
/*
    类名:首字母大写，其他单词中首字母大写，其他小写
    方法名:首字母小写，其他单词中首字母大写，其他小写
    变量:与方法名规则同
    包名:全部小写
*/
public class No_1001 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.next());
        int num2 = Integer.parseInt(scanner.next());
        scanner.close();
        num1 += num2;
        int flag = num1>=0?1:0;
        num1 = num1>0?num1:-num1;
        if(String.valueOf(num1).length()<4) {
            if (flag == 0) {
                System.out.print(-num1);
            } else {
                System.out.print(num1);
            }
            return;
        }
        LinkedList<String> result = new LinkedList<String>();
        do{
            result.add(String.valueOf(num1%10));
            num1 /= 10;
            if((result.size()+1)%4==0&&num1>0){
                result.add(",");
            }
        }while (num1>0);
        if(flag==0){
            result.add("-");
        }
        for(int i = result.size()-1;i>=0;i--)
            System.out.print(result.get(i));
    }
}
