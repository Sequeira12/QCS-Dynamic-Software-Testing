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
        graph.addEdge(0,2,1);
        graph.addEdge(0,1,10);
        graph.addEdge(2,4,5);
        graph.addEdge(2,3,10);
        graph.addEdge(3,4,3);
        int[][] distance = dijkstra(graph, 0);
        for(int i = 0; i < distance.length; i++){
            System.out.printf("%d - %d\n",distance[i][0],distance[i][1]);
        }
    }
    public static int count = 0;
    public static int[][] dijkstra(Graph graph, int source) {
        if(count == 0)System.out.println("State 1");
        int numVertices = graph.adjacencyList.size();
        boolean[] visited = new boolean[numVertices];
        
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>(numVertices, Comparator.comparingInt(v -> v.distance));
        Vertex[] vertices = new Vertex[numVertices];
        if(count == 0)System.out.println("State 2");
        if(count == 0)System.out.println("State 3");
        for (int i = 0; i < numVertices; i++) {
            
            vertices[i] = new Vertex(i);
            if(count == 0)System.out.println("State 4");
            if(count == 0)System.out.println("State 6");
            if (i == source) {
                if(count == 0)System.out.println("State 7");
                vertices[i].distance = 0;
            }
            if(count == 0)System.out.println("State 8");
            priorityQueue.add(vertices[i]);
            if(count == 0)System.out.println("State 3");
            count++;

        }
        count = 0;
        if(count == 0)System.out.println("State 5");
        while (!priorityQueue.isEmpty()) {
            if(count == 0)System.out.println("State 9");
            Vertex currentVertex = priorityQueue.poll();
            visited[currentVertex.id] = true;

            List<Edge> edges = graph.getEdges(currentVertex.id);
            if(count == 0)System.out.println("State 10");
            for (Edge edge : edges) {
                if(count == 0)System.out.println("State 13");
               // if(count == 0)System.out.printf("%d %d\n",edge.source,edge.weight);
                if (!visited[edge.destination]) {
                    if(count == 0)System.out.println("State 14");
                    int newDistance = currentVertex.distance + edge.weight;
                    if(count == 0)System.out.println("State 15");
                    System.out.printf("%d   %d\n", newDistance, vertices[edge.destination].distance);
                    if (newDistance < vertices[edge.destination].distance) {
                        if(count == 0)System.out.println("State 16");
                        priorityQueue.remove(vertices[edge.destination]);
                        vertices[edge.destination].distance = newDistance;
                        priorityQueue.add(vertices[edge.destination]);
                    }

                }
                

                if(count == 0)System.out.println("State 10");
                
                count++;
            }
            if(count <= 1)System.out.println("State 5");
            
        }
        System.out.println("State 5");
        System.out.println("State 11");
        int[][] distance = distancesV(vertices);
        System.out.println("State END");
        
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
