import java.util.*;

public class Graph {
    private Map<Character, List<Character>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addEdge(char source, char destination) {
        adjList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
    }

    public List<Character> getAdjacentVertices(char vertex) {
        return adjList.getOrDefault(vertex, new ArrayList<>());
    }

    // Breadth First Search
    public void BFS(char start) {
        Queue<Character> queue = new LinkedList<>();
        Set<Character> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            char current = queue.poll();
            System.out.print(current + " ");

            for (char neighbor : getAdjacentVertices(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    // Depth First Search
    public void DFS(char start, Set<Character> visited) {
        visited.add(start);
        System.out.print(start + " ");

        for (char neighbor : getAdjacentVertices(start)) {
            if (!visited.contains(neighbor)) {
                DFS(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge('A', 'D');
        graph.addEdge('D', 'G');
        graph.addEdge('G', 'H');
        graph.addEdge('H', 'I');
        graph.addEdge('I', 'F');
        graph.addEdge('F', 'C');
        graph.addEdge('C', 'B');
        graph.addEdge('B', 'E');
        graph.addEdge('E', 'H');
        graph.addEdge('A', 'E');
        graph.addEdge('A', 'B');
        graph.addEdge('E', 'F');
        graph.addEdge('F', 'H');

        System.out.println("BFS travers :");
        graph.BFS('A');
        System.out.println("\nDFS travers :");
        Set<Character> visited = new HashSet<>();
        graph.DFS('A', visited);
    }
}
