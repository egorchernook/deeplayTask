package tests;

import java.util.ArrayList;
import java.util.List;

public class MainTest implements ITest {
    private ArrayList<ITest> tests_list = new ArrayList<>();

    public MainTest(ITest[] tests_list) {
        this.tests_list = new ArrayList<>(List.of(tests_list));
    }

    @Override
    public boolean do_test() {
        for( ITest test : tests_list ){
            assert test.do_test();
        }
        return true;
    }
}
