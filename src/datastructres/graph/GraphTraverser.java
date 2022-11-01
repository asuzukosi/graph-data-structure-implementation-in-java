package datastructres.graph;
import java.util.ArrayList;

public class GraphTraverser {
    public static void main(String[] args) {
        
    }

    public static void depthFirstTraversal(Vertex startVertex, ArrayList<Vertex> visited){
        for(Edge e:startVertex.getEdges()){
            Vertex neighbor = e.getEnd();
            if(!visited.contains(neighbor)){
                visited.add(neighbor);
                GraphTraverser.depthFirstTraversal(neighbor, visited);
            }
        }

        
    }


    public static ArrayList<Vertex> breathFirstTraversal(Vertex startVertex){
        Queue visitQueue = new Queue();
        ArrayList<Vertex> visited = new ArrayList<Vertex>();
        visitQueue.queueEnqueue(startVertex);


        while(!visitQueue.isEmpty()){
            Vertex current = visitQueue.queueDequeue();
            System.out.println(current.getData());

            for(Edge e: current.getEdges()){
                Vertex neighbor = e.getEnd();
                if(!visited.contains(neighbor)){
                    visited.add(current);
                    visitQueue.queueEnqueue(neighbor);
                }
            }
        }

        return visited;
    }
}
