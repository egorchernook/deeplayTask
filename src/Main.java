import Graphs.RectangleGraph;
import tests.MainTest;
import tests.Test;
import tests.Test_RectangleGraph;
import tests.Text_Solution;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

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

        /*
        for( String creature : info.keySet()){
            System.out.println( creature + "\t" + info.get(creature));
        }
        */
        System.out.println( Solution.getResult("STWSWTPPTPTTPWPP", "Human", info));

        MainTest test = new MainTest(new Test[]{new Test_RectangleGraph(), new Text_Solution()});
        assert test.do_test();
        //System.out.println( Solution.getResult("SPPPSSSPSSSPSSSP", "Human", info));
    }
}
