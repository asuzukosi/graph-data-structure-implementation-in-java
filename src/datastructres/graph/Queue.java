package datastructres.graph;

import java.util.ArrayList;

class Queue { 
    private ArrayList<Vertex> queue; 
   
    Queue() { 
        queue = new ArrayList<Vertex>(); 
    } 
    
    public boolean isEmpty(){
        return queue.size() == 0;
    }

    // insert an element into the queue
    void queueEnqueue(Vertex item)  { 
        queue.add(item);
        return; 
    } 
   
    //remove an element from the queue
    Vertex queueDequeue()  { 
        int lastIndex = queue.size() -1;
        return queue.remove(lastIndex);
    } 
   
    // print queue elements 
    void queueDisplay() 
    { 
        if (this.queue.size() == 0) { 
            System.out.printf("Queue is Empty\n"); 
            return; 
        } 
        // traverse front to rear and print elements 
        for (Vertex v: this.queue) { 
            System.out.printf(" %d = ", v.getData()); 
        } 
        return; 
    } 
   
    // print front of queue 
    void queueFront() 
    { 
        if (this.queue.size() == 0) { 
            System.out.printf("Queue is Empty\n"); 
            return; 
        } 
        System.out.printf("\nFront Element of the queue: %d", queue.get(0)); 
        return; 
    } 
} 
 