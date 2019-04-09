package PAT.Github.PAT;

import java.util.Scanner;

//CreateTime: 2019/3/21 23:21
//Author:     月小水长(https://github.com/inspurer)
/*
    类名:首字母大写，其他单词中首字母大写，其他小写
    方法名:首字母小写，其他单词中首字母大写，其他小写
    变量:与方法名规则同
    包名:全部小写
*/
public class No_1003 {
    public static void main(String [] args){
        int maxPathLength = 66666666;
        Scanner sc = new Scanner(System.in);
        int numOfCities = sc.nextInt();
        int numOfRoads = sc.nextInt();
        int C1 = sc.nextInt();
        int C2 = sc.nextInt();
        // 城市 i 的救援队数
        int [] numOfRescue = new int[numOfCities];
        int [][] roads = new int [numOfCities][numOfCities];
        for(int i = 0; i < numOfCities; i++){
            numOfRescue[i] = sc.nextInt();
        }
        //构建无向图
        for(int i = 0; i < numOfCities; i++)
            for(int j = 0; j < numOfCities; j++)
                roads[i][j] = maxPathLength;

        int start,stop,value;
        for(int i = 0; i < numOfRoads; i++){
            start = sc.nextInt();
            stop = sc.nextInt();
            value = sc.nextInt();
            roads[start][stop] = value;
            roads[stop][start] = value;
        }

        // 标记城市 i 是否被访问过
        Boolean [] visited = new Boolean[numOfCities];
        for(int i = 0; i < numOfCities; i++){
            visited[i] = false;
        }

        // 到城市 i 的最短路径长度
        int [] lengthOfShortestPath = new int[numOfCities];
        for(int i = 0; i < numOfCities; i++){
            lengthOfShortestPath[i] = maxPathLength;
        }

        // 到城市 i 的最短路径条数
        int [] numOfShortestPath = new int[numOfCities];
        for(int i = 0; i < numOfCities; i++){
            numOfShortestPath[i] = 0;
        }

        // 到城市 i 的总救援队数
        int [] numOfTotalRescue = new int[numOfCities];
        for(int i = 0; i < numOfCities; i++){
            numOfTotalRescue[i] = 0;
        }

//        visited[C1] = true;
        lengthOfShortestPath[C1] = 0;
        numOfShortestPath[C1] = 1;
        numOfTotalRescue[C1] = numOfRescue[C1];

        for(int i = 0; i < numOfCities; i++){
            int min = maxPathLength;
            int u = -1;
            for(int j = 0; j < numOfCities; j++){
                if(!visited[j]&&lengthOfShortestPath[j]<min){
                    min = lengthOfShortestPath[j];
                    u = j;
                }
            }
            if(u == -1){
                break;
            }
            visited[u] = true;
            for(int k = 0; k < numOfCities; k++){
                if(!visited[k]&&roads[u][k]!=maxPathLength){
                    if(lengthOfShortestPath[k] > lengthOfShortestPath[u] + roads[u][k]){
                        lengthOfShortestPath[k] = lengthOfShortestPath[u] + roads[u][k];
                        numOfShortestPath[k] = numOfShortestPath[u];
                        numOfTotalRescue[k] = numOfTotalRescue[u] + numOfRescue[k];
                    }
                    else if(lengthOfShortestPath[k] == lengthOfShortestPath[u] + roads[u][k]){
                        numOfShortestPath[k] += numOfShortestPath[u];
                        if(numOfTotalRescue[u] + numOfRescue[k] > numOfTotalRescue[k]){
                            numOfTotalRescue[k] = numOfTotalRescue[u] + numOfRescue[k];
                        }
                    }
                }
            }
        }
        System.out.printf("%d %d",numOfShortestPath[C2],numOfTotalRescue[C2]);
    }
}
