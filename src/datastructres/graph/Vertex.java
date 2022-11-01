package datastructres.graph;

import java.util.ArrayList;

public class Vertex {
    private String data;
    private ArrayList<Edge> edges;
    
    public Vertex(String inputData){
        this.data = inputData;
        this.edges = new ArrayList<Edge>();
    }

    public String getData(){
        return this.data;
    }

    public ArrayList<Edge> getEdges(){
        return this.edges;
    }

    /*
     * Method to add new edge to vertex
     */
    public void addEdge(Vertex endVertex, Integer weight) {
        Edge newEdge = new Edge(weight, this, endVertex);
        this.edges.add(newEdge);
    }

    /*
     * Method to remove an edge using predicate by providing the 
     * vertex
     */
    public void removeEdge(Vertex endVertex){
        this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
    }


    public void print(Boolean showWeight){
        String message = "";

        if(this.edges.size() == 0){
            System.out.println(this.data + " -->");
            return;
        }

        for (int index = 0; index < this.edges.size(); index++) {
            if(index==0){
                message += this.edges.get(index).getStart().getData() + " -";
            }else{
                message += "-";
            }
            
            if(showWeight){
                message += "("+this.edges.get(index).getWeight()+")";
            }
            
            message += "-> " + this.edges.get(index).getEnd().getData();

            if(index != this.edges.size() -1){
                message += ", ";
            }
        }
        System.out.println(message);
    }
}
