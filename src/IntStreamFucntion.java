import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamFucntion {
    public static void main(String[] args) {

        //rangeClosed same with for(start->end)
        //in case start < end system will return empty
        // ** boxed required because we need to convert int to IntStream
        List<Integer> data = IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList());
        data.forEach(System.out::print);

        System.out.println();

        //rang same with for(start->end-1)
        //in case start < end system will return empty
        //** boxed required because we need to convert int io IntStream
        List<Integer> data2 = IntStream.range(6,10).boxed().collect(Collectors.toList());
        data2.forEach(System.out::print);

        System.out.println();

        //concat use for concat IntStream
        //IntStream.of() use for create IntStream and assign value to that stream
        List<Integer> data3 = IntStream.concat(IntStream.of(1,2,3), IntStream.of(4,5,6)).boxed().collect(Collectors.toList());
        data3.forEach(System.out::print);

        System.out.println();

        //generate use for generate int,if no has limit system will return empty
        IntStream.generate(() -> new Random().nextInt(5)).limit(5).boxed().collect(Collectors.toList()).forEach(System.out::print);
    }
}
