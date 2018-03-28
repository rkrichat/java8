import java.util.*;
import java.util.stream.*;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

public class IntStreamFucntion {
    public static void main(String[] args) {

        //rangeClosed same with for(start->end)
        //in case start < end system will return empty
        // ** boxed required because we need to convert int to IntStream
        List<Integer> data = IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList());
        data.forEach(System.out::print); //output: 1,2,3,4,5

        System.out.println();

        //rang same with for(start->end-1)
        //in case start < end system will return empty
        //** boxed required because we need to convert int io IntStream
        List<Integer> data2 = IntStream.range(6,10).boxed().collect(Collectors.toList());
        data2.forEach(System.out::print); //output: 5,6,7,8,9,10

        System.out.println();

        //concat use for concat IntStream
        //IntStream.of() use for create IntStream and assign value to that stream
        List<Integer> data3 = IntStream.concat(IntStream.of(1,2,3), IntStream.of(4,5,6)).boxed().collect(Collectors.toList());
        data3.forEach(System.out::print); //output: 1,2,3,4,5,6

        System.out.println();

        //generate use for generate int,if no has limit system will return empty
        //output: random integer from 0 to 4 and return five value
        IntStream.generate(() -> new Random().nextInt(5)).limit(5).boxed().collect(Collectors.toList()).forEach(System.out::print);

        System.out.println();

        System.out.println("SUM : " +IntStream.range(1, 10).boxed().mapToInt(i -> i.intValue()).sum());

       // System.out.println("SUM : " +DoubleStream.of(1.2,1.6).boxed().mapToDouble(i->i.doubleValue()).sum());

        System.out.println(IntStream.of(1, 2, 3, 4, 5, 6).max().getAsInt());

        //IntStream
       // IntStream.of(1,2,3).filter(i->i>1).collect(Collectors.);
        //Stream
        Stream.of(1,2,3).filter(i->i>1).collect(Collectors.toList());

        //<Reduce>
        // This function use for increase value, we can initial default value following below.
        /**
         * int total = 5;
         * for(int i=1;i<4;i++) total+=i;
         * System.out.println(total);
         */
        System.out.println(IntStream.of(1, 2, 3).reduce(5, (i, j) -> i + j));
        System.out.println(Stream.of("A", "B", "C").reduce((i, j) -> i + "," + j).get());
    }
}
