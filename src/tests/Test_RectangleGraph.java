package tests;

import Graphs.RectangleGraph;

import java.util.ArrayList;
import java.util.Objects;

public class Test_RectangleGraph extends Test{
    public boolean test_creation(){
        RectangleGraph graph = new RectangleGraph( 2, 2);
        for( int i = 0; i < 2; ++i){
            for( int j = 0; j < 2; ++j){
                graph.setVertex(i, j, 1);
            }
        }
        boolean result1 =  Objects.equals(graph.toString(), """
                0\t1\t1\t0\t
                1\t0\t0\t1\t
                1\t0\t0\t1\t
                0\t1\t1\t0\t
                """);

        graph = new RectangleGraph( 3, 3);
        for( int i = 0; i < 3; ++i){
            for( int j = 0; j < 3; ++j){
                graph.setVertex(i, j, 1);
            }
        }
        boolean result2 = Objects.equals( graph.toString(), """
                0\t1\t0\t1\t0\t0\t0\t0\t0\t
                1\t0\t1\t0\t1\t0\t0\t0\t0\t
                0\t1\t0\t0\t0\t1\t0\t0\t0\t
                1\t0\t0\t0\t1\t0\t1\t0\t0\t
                0\t1\t0\t1\t0\t1\t0\t1\t0\t
                0\t0\t1\t0\t1\t0\t0\t0\t1\t
                0\t0\t0\t1\t0\t0\t0\t1\t0\t
                0\t0\t0\t0\t1\t0\t1\t0\t1\t
                0\t0\t0\t0\t0\t1\t0\t1\t0\t
                """);

        return result1 & result2;
    }
    public boolean test_neighbours(){
        boolean result = true;
        RectangleGraph graph = new RectangleGraph( 2, 2);
        for( int i = 0; i < 2; ++i){
            for( int j = 0; j < 2; ++j){
                graph.setVertex(i, j, 1);
            }
        }
        for( int i = 0; i < 2; ++i){
            for( int j = 0; j < 2; ++j){
                ArrayList<Integer> neighbours = new ArrayList<>();
                if( j != 0 ){
                    neighbours.add( graph.getVertex(i, j - 1));
                }
                if( i != 0 ){
                    neighbours.add( graph.getVertex(i - 1, j));
                }
                if( j != 1 ){
                    neighbours.add( graph.getVertex(i, j + 1));
                }
                if( i != 1 ){
                    neighbours.add( graph.getVertex(i + 1, j));
                }
                ArrayList<Integer> returned_neighbours = graph.getNeighbours( i * 2 + j);

                if( !neighbours.equals( returned_neighbours)){
                    result = false;
                }
            }
        }
        return result;
    }

    @Override
    public boolean do_test() {
        return this.test_creation() & this.test_neighbours();
    }
}
