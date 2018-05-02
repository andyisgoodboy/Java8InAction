package lambdasinaction.stream;

import java.util.*;
import java.util.function.IntSupplier;
import java.util.stream.*;
import java.nio.charset.Charset;
import java.nio.file.*;

public class BuildingStreams {

    public static void main(String...args) throws Exception{
        
        // Stream.of
        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);
        System.out.println("------------------------");

        // Stream.empty
        Stream<String> emptyStream = Stream.empty();

        // Arrays.stream
        int[] numbers = {2, 3, 5, 7, 11, 13};
        System.out.println(Arrays.stream(numbers).sum());
        System.out.println("------------------------");

        // Stream.iterate
        Stream.iterate(0, n -> n + 2)
              .limit(10)
              .forEach(System.out::println);
        System.out.println("------------------------");

        // random stream of doubles with Stream.generate
        Stream.generate(Math::random)
              .limit(10)
              .forEach(System.out::println);
        System.out.println("------------------------");
 
        // stream of 1s with Stream.generate
        IntStream.generate(() -> 1)
                 .limit(5)
                 .forEach(System.out::println);
        System.out.println("------------------------");

        IntStream.generate(new IntSupplier(){
            public int getAsInt(){
                return 2;
            }
        }).limit(5)
          .forEach(System.out::println);
        System.out.println("------------------------");

        IntSupplier fib = new IntSupplier(){
                  private int previous = 0;
                  private int current = 1;
                  public int getAsInt(){
                      int nextValue = this.previous + this.current;
                      this.previous = this.current;
                      this.current = nextValue;
                      return this.previous;
                  }
              };
         IntStream.generate(fib).limit(10).forEach(System.out::println);
         System.out.println("------------------------");

         long uniqueWords = Files.lines(Paths.get("C:/Users/z675385/IdeaProjects/Java8InAction/src/main/resources/lambdasinaction/model/data.txt"), Charset.defaultCharset())
                                 .flatMap(line -> Arrays.stream(line.split(" ")))
                                 .distinct()
                                 .count();

         System.out.println("There are " + uniqueWords + " unique words in data.txt");

    }
}
