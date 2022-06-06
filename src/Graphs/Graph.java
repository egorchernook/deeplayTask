package Graphs;

import java.util.ArrayList;

public interface Graph {
    ArrayList<Integer> getNeighbours( int id);

    Integer getEdge(int id1, int id2);

    Integer getHeuristic( int id1, int id2);
}
