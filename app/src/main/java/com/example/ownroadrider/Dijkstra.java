package com.example.ownroadrider;



public class Dijkstra {
    private int n;
    private int[][] weight;
    private String[] saveRoute;
    private String[] vertex = {"진주", "사천", "산청", "마산", "창원"};

    public Dijkstra(int n, int[][] matrix) {
        super();
        this.n = n;
        this.weight = matrix;
        saveRoute = new String[n];
    }



    public int stringToInt(String s) {
        int x = 0;
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i] == s) x = i;
        }
        return x;
    }

    public String[] algorithm(String a, String b) {
        boolean[] visited = new boolean[n];
        int distance[] = new int[n];

        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        int x = stringToInt(a);
        distance[x] = 0;
        visited[x] = true;
        saveRoute[x] = vertex[x];

        for (int i = 0; i < n; i++) {
            if (!visited[i] && weight[x][i] != 0) {
                distance[i] = weight[x][i];
                saveRoute[i] = vertex[x];
            }
        }


        for(int i = 0; i < n-1; i++) {
            int minDistance = Integer.MAX_VALUE;
            int minVertex = -1;
            for(int j = 0; j < n; j++) {
                if(!visited[j] && distance[j]!=Integer.MAX_VALUE) {
                    if(distance[j] < minDistance) {
                        minDistance = distance[j];
                        minVertex = j;
                    }
                }
            }
            visited[minVertex] = true;
            for(int j = 0; j < n; j++) {
                if(!visited[j] && weight[minVertex][j] != Integer.MAX_VALUE) {
                    if(distance[j] > distance[minVertex]+weight[minVertex][j]) {
                        distance[j] = distance[minVertex]+weight[minVertex][j];
                        saveRoute[j] = vertex[minVertex];
                    }
                }
            }
        }


        String route = "";
        String prev = b;
        while(true) {
            route += vertex[stringToInt(prev)];
            route += " ";
            prev = saveRoute[stringToInt(prev)];
            if(prev == a) {
                route += prev;
                break;
            }
        }
        String[] strArray = route.split(" ");


        return strArray;
    }
}
