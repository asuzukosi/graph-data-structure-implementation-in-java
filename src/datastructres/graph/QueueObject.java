package datastructres.graph;

public class QueueObject implements Comparable<QueueObject> {

    public Vertex vertex;
    public int priority;

    public QueueObject(Vertex v, int priority){
        this.vertex = v;
        this.priority = priority;
    }

    @Override
    public int compareTo(QueueObject o) {
        if(this.priority == o.priority){
            return 0;
        }
        else if(this.priority > o.priority){
            return 1;
        } 
        else{
            return -1;
        }
    }
    
}
