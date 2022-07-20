package Silver.b23731.ing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Edge> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        int INF = Integer.MAX_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] dist = new long[N];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int t = Integer.parseInt(st.nextToken());


            Edge edge = new Edge(s, e, t);
            list.add(edge);
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int s = list.get(j).start;
                int e = list.get(j).end;
                int d = list.get(j).d;
                if(dist[s] != INF) {
                    if(dist[e] > dist[s] + d) {
                        dist[e] = dist[s] + d;
                        if(i == N-1) {
                            System.out.println("-1");
                            return;
                        }

                    }
                }
            }
        }

        for(int i = 1; i < N; i++) {
            if(dist[i] == INF) System.out.println("-1");
            else System.out.println(dist[i]);
        }

    }
}

class Edge {
    int start;
    int end;
    int d;

    Edge(int start, int end, int d){
        this.start = start;
        this.end = end;
        this.d = d;
    }

}
