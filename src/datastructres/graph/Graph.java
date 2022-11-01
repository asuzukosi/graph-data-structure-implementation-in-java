package datastructres.graph;
import java.util.ArrayList;
/*
 * Depth first search
 * Breath first search
 * Dijktra's Algorithm
 */
public class Graph {

    private ArrayList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph(boolean isWeighted, boolean isDirected){
        this.isWeighted = isWeighted;
        this.isDirected = isDirected;
        this.vertices = new ArrayList<Vertex>();
    }


    public Vertex addVertex(String data){
        Vertex newVertex =  new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }

    public void addEdge(Vertex start, Vertex end, Integer weight){
        if(!this.isWeighted){
            weight = null;
        }
        start.addEdge(end, weight);

        /*
         * If not directed add end for both start and end
         */
        if(!this.isDirected){
            end.addEdge(start, weight);
        }
    }

    public void removeEdge(Vertex start, Vertex end){
        start.removeEdge(end);
        if(!this.isDirected){
            end.removeEdge(end);
        }
    }

    public void removeVertex(Vertex vertex) {
        this.vertices.remove(vertex);
    }

    public void print(){
        for(Vertex v: this.vertices){
            v.print(isWeighted);
        }
    }

    public ArrayList<Vertex> getVertices(){
        return this.vertices;
    }

    public boolean getIsWeighted(){
        return this.isWeighted;
    }


    public boolean getIsDirected(){
        return this.isDirected;
    }

    public Vertex getVertexByValue(String data){
        for(Vertex v:this.vertices){
            if(v.getData().equals(data)){
                return v;
            }
        }
        return null;
    }

    public Vertex getStartingVertex(){
        return this.getVertices().get(0);
    }


    public static void main(String[] args){
        System.out.println("Hello world from graph");
        Graph busNetwork = new Graph(true, true);
        Vertex cliftonStation = busNetwork.addVertex("Clifton");
        Vertex capeMayStation = busNetwork.addVertex("Cape May");


        busNetwork.addEdge(cliftonStation, capeMayStation, 23);

        busNetwork.print();
    }
}