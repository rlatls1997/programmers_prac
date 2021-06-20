package programmers_prac;
//그래프
//가장 먼 노드

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class lessons49189 {
    public static int solution(int n, int[][] edge) {
        Set<Integer> visitedEdge = new HashSet<>();
        visitedEdge.add(1);

        List<Set<Integer>> verticesWithDepth = new LinkedList<>();
        Set<Integer> zero = new HashSet<>();
        zero.add(1);
        verticesWithDepth.add(zero);
        int depth = 0;

        while (visitedEdge.size() != n) {
            Set<Integer> vertices = new HashSet<>();
            for (int vertex : verticesWithDepth.get(depth)) {
                for (int[] e : edge) {
                    if (e[0] == vertex) {
                        setVertex(visitedEdge, vertices, e[1]);
                    }
                    if (e[1] == vertex) {
                        setVertex(visitedEdge, vertices, e[0]);
                    }
                }
            }
            verticesWithDepth.add(vertices);
            depth++;
        }
        return verticesWithDepth.get(depth).size();
    }
    public static void setVertex(Set<Integer> visitedEdge, Set<Integer> vertices, int vertex){
        if (!visitedEdge.contains(vertex)) {
            visitedEdge.add(vertex);
            vertices.add(vertex);
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        solution(6, arr);
    }
}
