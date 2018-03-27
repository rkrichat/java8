import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {

//        List<String> data = Arrays.asList("1","8","9");
//        List<Integer> x = data.stream().mapToInt(i->Integer.parseInt(i)).boxed().collect(Collectors.toList());
//        x.forEach(System.out::println);
//
//        List<Integer> data2 = Arrays.asList(1, 5, 6, 10);
//        List<String> a = data2.stream().map(i -> i.toString()).collect(Collectors.toList());
//        a.forEach(System.out::println);

        String name = Stream.of("A","B","C").collect(Collectors.joining("-"));
        System.out.println(name);

        IntStream.rangeClosed(5+1,10).boxed().collect(Collectors.toList()).forEach(System.out::println);
        Stream.concat(Stream.of("a","b","c"),Stream.of("d","e","f")).collect(Collectors.toList()).forEach(System.out::println);

    }


}

