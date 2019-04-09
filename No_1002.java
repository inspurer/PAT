package PAT.Github.PAT;

import java.util.*;

//CreateTime: 2019/3/21 23:21
//Author:     月小水长(https://github.com/inspurer)
/*
    类名:首字母大写，其他单词中首字母大写，其他小写
    方法名:首字母小写，其他单词中首字母大写，其他小写
    变量:与方法名规则同
    包名:全部小写
*/
public class No_1002 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String aLine = null;
        String [] l = null;
        HashMap<Integer,Float> [] hm = new HashMap[2];
        for(int i = 0; i < 2; i++){
            aLine = sc.nextLine();
            l = aLine.split(" ");
            hm[i] = new HashMap<Integer, Float>(Integer.parseInt(l[0]));
            for(int j = 1; j < l.length; j += 2){
                hm[i].put(Integer.parseInt(l[j]),Float.parseFloat(l[j+1]));
            }
        }
        sc.close();
        HashSet<Integer> setKeys = new HashSet<>(hm[0].keySet());
        setKeys.addAll(hm[1].keySet());
        ArrayList<Integer> sumKeys = new ArrayList<>(setKeys);
        HashMap<Integer,Float> res = new HashMap<Integer,Float>();
        // 排除掉系数为 0
        for(int i = 0; i < sumKeys.size(); i++){
            int key = sumKeys.get(i);
            float value = hm[0].getOrDefault(key,0.0f)+hm[1].getOrDefault(key,0.0f);
            if(value == 0.0f)
                continue;
            res.put(key,value);
        }
        ArrayList resultKeys = new ArrayList(res.keySet());
        Collections.sort(resultKeys, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        // 如果项数为0，只把0输出就可以了
        if(res.size() == 0) {
            System.out.print(0);
            return;
        }
        System.out.print(res.size());
        System.out.print(" ");
        for(int i = 0; i < resultKeys.size(); i++){
            int key = (int)resultKeys.get(i);
            System.out.print(key);
            System.out.print(" ");
            System.out.printf("%.1f",res.get(key));
            if(i == resultKeys.size() - 1)
                break;
            System.out.print(" ");
        }
    }
}
/*
    格式错误，要求跟输入一样，浮点数保留一位小数，最后不能有空格
    没有考虑到如果两个多项式相加，会出现系数为0的情况，此时不再记录（多虑的是demo分明有0输出了么，但是它是指数不是系数）
    数据的类型，一定尽量开始就合适
*/