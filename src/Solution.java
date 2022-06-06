import Graphs.BaseRectangleGraph;
import Graphs.RectangleGraph;

import java.util.HashMap;

public class Solution {
    public static Integer getResult( String map, String creature, HashMap<String, HashMap<Character, Integer>> info) {
        BaseRectangleGraph graph = new RectangleGraph( 4, 4);
        int counter = 0;
        for( char symbol : map.toCharArray() ){
            graph.setVertex(counter / graph.getSize_y(),
                            counter % graph.getSize_y(),
                            info.get(creature).get(symbol));
            counter++;
        }
        //graph.printGraph();
        Graphs.Path path = graph.getShortestPath( graph.getVertex(0,0), graph.getVertex( 3, 3));
        //System.out.println( path.getPath());
        return path.getLength();
    }
}
