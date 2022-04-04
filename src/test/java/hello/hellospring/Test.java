package hello.hellospring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String args[]){

        Map<String, String> map = new HashMap<>();
        map.put("1", "num");
        map.put("2", "two");

        List<String> list = new ArrayList<>(map.values());

        for(String n: list){
            System.out.println(n);
        }
    }
}
