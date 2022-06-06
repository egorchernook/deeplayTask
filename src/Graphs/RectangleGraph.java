package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class RectangleGraph extends BaseRectangleGraph {
    private Integer[][] data;

    public RectangleGraph(int size_x, int size_y) {
        super(size_x, size_y);
        this.data = new Integer[size_x*size_y][size_x*size_y];
        for( int i = 0; i < size_x*size_y; ++i){
            for( int j = 0; j < size_x*size_y; ++j){
                data[i][j] = 0;
            }
        }
    }

    @Override
    public void setVertex(int i, int j, Integer weight) {
        int x = i * getSize_y() + j;
        if( j != 0 ){
            this.data[x - 1][x] = weight;
            this.data[x][x - 1] = weight;
        }
        if( i != 0 ){
            this.data[x - getSize_y()][x] = weight;
            this.data[x][x - getSize_y()] = weight;
        }
        if( j != getSize_y() - 1 ){
            this.data[x + 1][x] = weight;
            this.data[x][x + 1] = weight;
        }
        if( i != getSize_y() - 1 ){
            this.data[x + getSize_y()][x] = weight;
            this.data[x][x + getSize_y()] = weight;
        }
    }

    @Override
    public ArrayList<Integer> getNeighbours(int id) {
        ArrayList<Integer> result = new ArrayList<>();
        for( int i = 0; i < getSize_x()*getSize_y(); ++i){
            if( data[id][i] != 0){
                result.add(i);
            }
        }
        return result;
    }

    @Override
    public Integer getVertex(int i, int j) {
        return i * getSize_y() + j;
    }

    @Override
    public void setEdge(int id1, int id2, int weight) {
        if( id1 + 1 != id2 || id1 - 1 != id2 || id1 - getSize_y() != id2 || id1 + getSize_y() != id2){
            throw new RuntimeException("Trying to set wrong edge in RectangleGraph");
        }
        data[id1][id2] = weight;
    }

    @Override
    public Integer getEdge(int id1, int id2) {
        if( id1 > getSize_y() * getSize_x() || id2 > getSize_y() * getSize_x() || id1 < 0 || id2 < 0){
            throw new RuntimeException("Trying to get wrong edge in RectangleGraph");
        }
        return data[id1][id2];
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for( int i = 0; i < getSize_x()*getSize_y(); ++i){
            for( int j = 0; j < getSize_x()*getSize_y(); ++j){
                result.append(this.data[i][j]).append("\t");
            }
            result.append("\n");
        }
        return "RectangleGraph{\n" + result + '}';
    }

    public void printGraph(){
        for( int i = 0; i < getSize_x()*getSize_y(); ++i){
            for( int j = 0; j < getSize_x()*getSize_y(); ++j){
                System.out.print(this.data[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println(this);
    }

    @Override
    public Integer getHeuristic(int id1, int id2) {
        return Math.abs( id1 / getSize_y() - id2 / getSize_y())
                + Math.abs( id1 % getSize_y() - id2 % getSize_y());
    }
}
