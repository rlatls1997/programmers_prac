package programmers_prac;

//Summer/Winter Coding(~2018)
//배달

public class lessons12978 {
    public static int solution(int N, int[][] road, int K) {
        int[] distance = new int[N];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = -1;
        }
        boolean[] visited = new boolean[N];
        distance[0] = 0;
        visited[0] = true;
        dijkstra(1, road, distance, visited);
        return getNumOfVillagesCanDelivery(distance, K);
    }

    public static void dijkstra(int vertex, int[][] road, int[] distance, boolean[] visited) {

        for (int i = 0; i < road.length; i++) {
            if (road[i][0] == vertex || road[i][1] == vertex) {
                int nextVertex = (road[i][0] == vertex) ? road[i][1] : road[i][0];
                int distanceToNextVertex = distance[vertex - 1] + road[i][2];

                if (distance[nextVertex - 1] == -1 || distance[nextVertex - 1] > distanceToNextVertex) {
                    distance[nextVertex - 1] = distanceToNextVertex;
                }
            }
        }

        int nextVertex = 0;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && distance[i] != -1 && distance[i] < minDistance) {
                nextVertex = i + 1;
                minDistance = distance[i];
            }
        }
        if (nextVertex == 0) {
            return;
        }
        visited[nextVertex - 1] = true;
        dijkstra(nextVertex, road, distance, visited);
    }

    public static int getNumOfVillagesCanDelivery(int[] distance, int K) {
        int count = 0;
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] <= K) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        solution(5, a, 3);
    }
}
