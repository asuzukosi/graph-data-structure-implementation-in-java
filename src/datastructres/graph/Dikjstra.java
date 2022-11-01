package datastructres.graph;
import java.util.*;

/*
 * Used for finding shortest distance between 
 * graph vertices
 */
public class Dikjstra {


    public static Dictionary[] dijkstra(Graph g, Vertex start){
        Dictionary<String, Integer> distances = new Hashtable<>();
        Dictionary<String, Vertex> previous = new Hashtable<>();

        PriorityQueue<QueueObject> queue = new PriorityQueue<QueueObject>();

        queue.add(new QueueObject(start, 0));
        for(Vertex v: g.getVertices()){
            if(v != start){
                distances.put(v.getData(), Integer.MAX_VALUE);
            }
            previous.put(v.getData(), new Vertex("Null"));
        }
        distances.put(start.getData(), 0);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll().vertex;
            for(Edge e: currentVertex.getEdges()){
                Integer alternative = distances.get(currentVertex.getData()) + e.getWeight();
                String neighborValue = e.getEnd().getData();
                if(alternative < distances.get(neighborValue)){
                    distances.put(neighborValue, alternative);
                    previous.put(neighborValue, currentVertex);
                    queue.add(new QueueObject(e.getEnd(), distances.get(neighborValue)));
                }
            }
        }
        return new Dictionary[] {distances, previous};
    }

    public static void dikjstraResultPrinter(Dictionary[] d){
        System.out.println("Distances: \n");
        for(Enumeration keys = d[0].keys(); keys.hasMoreElements();){
            String nextKey =  keys.nextElement().toString();
            System.out.println(nextKey + ": "+ d[0].get(nextKey));
        }
        System.out.println("\n Previous \n");
        for(Enumeration keys = d[1].keys(); keys.hasMoreElements();){
            String nextKey = keys.nextElement().toString();
            Vertex nextVertex = (Vertex) d[1].get(nextKey);
            System.out.println(nextKey + ": " + nextVertex.getData());
        }
    }

    public static void shortestPathBetween(Graph g, Vertex start, Vertex end){
        Dictionary[] dikjstraDictionaries = Dikjstra.dijkstra(g, start);
        Dictionary<String, Integer> distances = dikjstraDictionaries[0];

        Integer shortest =  distances.get(end.getData());
        System.out.println("Shortest distance between " + start.getData() + "and end "+ end.getData()+ " is "+ shortest);
        System.out.println(distances);


        ArrayList<Vertex> path = new ArrayList<Vertex>();
        Vertex v = end;
        while(v.getData() != "Null"){
            path.add(0, v);
            v = (Vertex)dikjstraDictionaries[1].get(v.getData());
        }
        System.out.println("Shortest path");
        for(Vertex pv: path){
            System.out.println(pv.getData());
        }
    }

    public static void main(String[] args) {
        Graph testGraph = new Graph(true, true);
        Vertex a = testGraph.addVertex("A");
        Vertex b = testGraph.addVertex("B");
        Vertex c = testGraph.addVertex("C");
        Vertex d = testGraph.addVertex("D");
        Vertex e = testGraph.addVertex("E");
        Vertex f = testGraph.addVertex("F");
        Vertex g = testGraph.addVertex("G");


        testGraph.addEdge(a, c, 100);
        testGraph.addEdge(a, b, 3);
        testGraph.addEdge(a, d, 4);
        testGraph.addEdge(d, c, 3);
        testGraph.addEdge(d, e, 8);
        testGraph.addEdge(e, b, -2);
        testGraph.addEdge(e, f, 10);
        testGraph.addEdge(b, g, 9);
        testGraph.addEdge(e, g, -50);


        Dictionary[] results = Dikjstra.dijkstra(testGraph, a);
        Dikjstra.dikjstraResultPrinter(results);
        Dikjstra.shortestPathBetween(testGraph, a, g);
    }   
}
