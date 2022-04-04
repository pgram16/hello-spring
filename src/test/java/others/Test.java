package others;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {

        String[] strArrays = {"first", "sec", "third"};
        List<String> strList = Arrays.asList(strArrays);
/*
        Arrays.sort(strArrays);
        Collections.sort(strList);
        for(String str: strList) {
            System.out.println(str);
        }
*/
        Stream<String> strStream1 = Arrays.stream(strArrays);
        Stream<String> strStream2 = strList.stream();

        strStream1.sorted().forEach(System.out::println);
        strStream2.sorted().forEach(System.out::println);

    }
}
