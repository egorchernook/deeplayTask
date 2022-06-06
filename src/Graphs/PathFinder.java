package Graphs;

import java.util.*;

public class PathFinder {

    public static class Vertex implements Comparable<Vertex> {
        public final int id;
        public Vertex parent;
        public Integer weight;
        public Integer predictedWeight;

        public Vertex(int id, Vertex parent, Integer weight, Integer predictedWeight) {
            this.id = id;
            this.parent = parent;
            this.weight = weight;
            this.predictedWeight = predictedWeight;
        }

        public Vertex(int id) {
            this(id, null, Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.predictedWeight, o.predictedWeight);
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "id=" + id +
                    ", parent=" + parent +
                    ", weight=" + weight +
                    ", predictedWeight=" + predictedWeight +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Vertex)) return false;
            Vertex vertex = (Vertex) o;
            return id == vertex.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public static Path AStar_Algorithm(Graph graph, int begin, int end){
        Vertex start = new Vertex( begin);

        PriorityQueue<Vertex> open = new PriorityQueue<>();
        HashMap<Integer, Vertex> visited = new HashMap<>();

        start.weight = 0;
        start.predictedWeight = graph.getHeuristic( start.id, end);
        open.add(start);
        visited.put(begin, start);
        while( !open.isEmpty()){
            Vertex current = open.poll();
            if( current.id == end){
                int length = 0;
                ArrayList<Integer> path = new ArrayList<>();
                path.add(current.id);
                while( current.parent != null){
                    length += graph.getEdge( current.id, current.parent.id);
                    current = current.parent;
                    path.add(current.id);
                }
                Collections.reverse(path);
                return new Path( path, length);
            }

            for( Integer i : graph.getNeighbours(current.id) ){
                Vertex next = visited.getOrDefault( i, new Vertex(i));
                int new_weight = current.weight +
                        graph.getEdge( current.id, next.id);
                visited.put( next.id, current);
                if( new_weight < next.weight ){
                    next.weight = new_weight;
                    next.predictedWeight = new_weight + graph.getHeuristic( next.id, end);
                    next.parent = current;
                    open.add(next);
                }
            }
        }
        return null;
    }
}
