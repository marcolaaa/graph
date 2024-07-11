import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String args[]) throws Exception
    {
        Graph graph = new Graph(new HashMap<>());
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('B', 'C');
        graph.addEdge('C', 'A');
        graph.addEdge('C', 'D');
        graph.addEdge('D', 'D');

        System.out.println("--------------------------------Print ABCD---------------------------------------------");
        List<Character> response = Optional.ofNullable(graph.findPath('A', 'D')).orElse(Collections.emptyList());
        response.forEach(System.out::println);

        System.out.println("--------------------------------Print BA-----------------------------------------------");
        response = Optional.ofNullable(graph.findPath('B', 'A')).orElse(Collections.emptyList());
        response.forEach(System.out::println);

        System.out.println("-----------------------Nothing printed in the console----------------------------------");
        response = Optional.ofNullable(graph.findPath('A', 'E')).orElse(Collections.emptyList());
        response.forEach(System.out::println);
    }
}