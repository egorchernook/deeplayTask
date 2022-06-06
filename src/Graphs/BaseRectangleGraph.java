package Graphs;

public abstract class BaseRectangleGraph implements WeightedGraph {
    private final int size_x;
    private final int size_y;

    public int getSize_x() {
        return size_x;
    }
    public int getSize_y() {
        return size_y;
    }

    BaseRectangleGraph(int size_x, int size_y) {
        this.size_x = size_x;
        this.size_y = size_y;
    }

    public abstract void setVertex(int i, int j, Integer weight);
    public abstract Integer getVertex(int i, int j);

    public abstract void printGraph();

    public Path getShortestPath( int begin, int end){
        return PathFinder.AStar_Algorithm( this, begin, end);
    }
}
