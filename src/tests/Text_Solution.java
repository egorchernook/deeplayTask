package tests;

import Graphs.BaseRectangleGraph;
import Graphs.RectangleGraph;

import java.util.HashMap;

public class Text_Solution extends Test {

    public boolean test_length(){
        HashMap<String, HashMap<Character, Integer>> info = new HashMap<>();
        HashMap<Character, Integer> temp1 = new HashMap<>();
        HashMap<Character, Integer> temp2 = new HashMap<>();
        HashMap<Character, Integer> temp3 = new HashMap<>();

        temp1.put('S', 5);
        temp1.put('W', 2);
        temp1.put('T', 3);
        temp1.put('P', 1);
        info.put( "Human", temp1);

        temp2.put('S', 2);
        temp2.put('W', 2);
        temp2.put('T', 5);
        temp2.put('P', 2);
        info.put( "Swamper", temp2);

        temp3.put('S', 3);
        temp3.put('W', 3);
        temp3.put('T', 2);
        temp3.put('P', 2);
        info.put( "Woodman", temp3);

        boolean result = false;

        BaseRectangleGraph graph = new RectangleGraph( 4, 4);
        String map = "STWSWTPPTPTTPWPP";
        String creature = "Human";
        int counter = 0;
        for( char symbol : map.toCharArray() ){
            graph.setVertex(counter / graph.getSize_y(),
                            counter % graph.getSize_y(),
                                info.get(creature).get(symbol));
            counter++;
        }
        Graphs.Path path = graph.getShortestPath( graph.getVertex(0,0), graph.getVertex( 3, 3));
        if( path.getLength() == 10){
            result = true;
        }

        map = "SPPPSSSPSSSPSSSP";
        creature = "Human";
        counter = 0;
        for( char symbol : map.toCharArray() ){
            graph.setVertex(counter / graph.getSize_y(),
                    counter % graph.getSize_y(),
                    info.get(creature).get(symbol));
            counter++;
        }
        path = graph.getShortestPath( graph.getVertex(0,0), graph.getVertex( 3, 3));
        if( !(path.getLength() == 6)){
            result = false;
        }

        return result;
    }
    @Override
    public boolean do_test() {
        return this.test_length();
    }
}
