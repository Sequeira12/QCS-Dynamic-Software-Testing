package Code;
import java.util.*;

class Vertex {
    public int id;
    public int distance;

    public Vertex(int id) {
        this.id = id;
        this.distance = Integer.MAX_VALUE;
    }
}

class Edge {
    public int source;
    public int destination;
    public int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class Graph {
    public Map<Integer, List<Edge>> adjacencyList;

    public Graph(int numVertices) {
        this.adjacencyList = new HashMap<>();
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
    }
    
    public void addEdge(int source, int destination, int weight) {
        List<Edge> edges = adjacencyList.get(source);
        edges.add(new Edge(source, destination, weight));
    }

    public List<Edge> getEdges(int vertex) {
        return adjacencyList.get(vertex);
    }
}

public class Dijkstra {
    public static void main(String[] args) {
        int numVertices = 5;
        Graph graph = new Graph(numVertices);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 5);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 1, 3);
        graph.addEdge(2, 3, 9);
        graph.addEdge(2, 4, 2);
        graph.addEdge(3, 4, 4);
        graph.addEdge(4, 0, 7);

        
        int[][] distance =  dijkstra(graph, 0);
        for(int i = 0; i < distance.length; i++){
            System.out.printf("%d - %d\n",distance[i][0],distance[i][1]);
        }
    }

    public static int[][] dijkstra(Graph graph, int source) {
        
        int numVertices = graph.adjacencyList.size();
        boolean[] visited = new boolean[numVertices];
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>(numVertices, Comparator.comparingInt(v -> v.distance));
        Vertex[] vertices = new Vertex[numVertices];

        for (int i = 0; i < numVertices; i++) {
            vertices[i] = new Vertex(i);
            if (i == source) {
                vertices[i].distance = 0;
            }
            priorityQueue.add(vertices[i]);
        }

        while (!priorityQueue.isEmpty()) {
            Vertex currentVertex = priorityQueue.poll();
            visited[currentVertex.id] = true;

            List<Edge> edges = graph.getEdges(currentVertex.id);
            for (Edge edge : edges) {
                if (!visited[edge.destination]) {
                    int newDistance = currentVertex.distance + edge.weight;
                    if (newDistance < vertices[edge.destination].distance) {
                        priorityQueue.remove(vertices[edge.destination]);
                        vertices[edge.destination].distance = newDistance;
                        priorityQueue.add(vertices[edge.destination]);
                    }
                }
            }
        }
    
        int[][] distance = distancesV(vertices);
       
        
        return distance;
    }
    public static int[][] distancesV(Vertex[] Vertex ){
        int[][] distance = new int[Vertex.length][2];
        int count = 0;
        for (Vertex vertex2 : Vertex ) {
            distance[count][0] = vertex2.id;
            distance[count][1] = vertex2.distance;
            count++;
           // System.out.println(vertex.id + " \t\t " + vertex.distance);
        }
        return distance;
    }
    public static void printSolution(Vertex[] vertices) {
        System.out.println("Vertex \t Distance from Source");
        for (Vertex vertex : vertices) {
            System.out.println(vertex.id + " \t\t " + vertex.distance);
        }
    }
}
