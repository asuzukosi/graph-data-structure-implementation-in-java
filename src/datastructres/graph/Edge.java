package datastructres.graph;

public class Edge {

    private Integer weight;
    private Vertex start;
    private Vertex end;

    public Edge(Integer weight, Vertex start, Vertex end) {
        this.weight = weight;
        this.start = start;
        this.end = end;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public Vertex getStart() {
        return this.start;
    }

    public Vertex getEnd() {
        return this.end;
    }

    public static void main(String[] args) {
        System.out.println("Hello from edge");
    }
}
