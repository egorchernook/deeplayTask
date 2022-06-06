package Graphs;

import java.util.ArrayList;

public class Path {
    private final ArrayList<Integer> data;
    private final Integer length;

    public Path(ArrayList<Integer> data, Integer length) {
        this.data = data;
        this.length = length;
    }

    public ArrayList<Integer> getPath() {
        return data;
    }
    public Integer getLength(){
        return length;
    };
}
