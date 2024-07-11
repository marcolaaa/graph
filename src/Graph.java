import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Graph {
    Map<Vertice, List<Vertice>> adjVertices;

    public Graph(Map<Vertice, List<Vertice>> adjVertices) {
        this.adjVertices = adjVertices;
    }

    public void addVertice(Character c) {
        if(!adjVertices.containsKey(new Vertice(c))) adjVertices.put(new Vertice(c), new ArrayList<>());
    }

    public void removeVertice(Character c) {
        Vertice v = new Vertice(c);
        adjVertices.values().forEach(e -> e.remove(v));
        adjVertices.remove(v);
    }

    public void addEdge(Character c1, Character c2) {
        Vertice v1 = new Vertice(c1);
        Vertice v2 = new Vertice(c2);

        if (adjVertices.containsKey(v1)) adjVertices.get(v1).add(v2);
        else adjVertices.put(v1, new ArrayList<>(Arrays.asList(v2)));

        if (adjVertices.containsKey(v2)) adjVertices.get(v2).add(v1);
        else adjVertices.put(v2, new ArrayList<>(Arrays.asList(v1)));

    }

    public void removeEdge(Character c1, Character c2){
        Vertice v1 = new Vertice(c1);
        Vertice v2 = new Vertice(c2);

        List<Vertice> l1 = adjVertices.get(v1);
        List<Vertice> l2 = adjVertices.get(v2);

        if (l1 != null) l1.remove(v2);
        if (l2 != null) l2.remove(v1);

    }

    public List<Vertice> getAdjVertices(Character c) {
        return adjVertices.get(new Vertice(c));
    }

    public List<Character> findPath(Character c1, Character c2) {
        int[] beingVisited = new int[this.adjVertices.size()];
        List<Character> currentPath = new ArrayList<>();
        currentPath.add(c1);

        return dfs(c1, c2, beingVisited, currentPath);
    }

    private List<Character> dfs(Character source, Character destination, int[] beingVisited, List<Character> currentPath) {
        if (source.equals(destination)) {
            return currentPath;
        }

        beingVisited[source - 'A'] = 1; // it is zero by default.

        for (Vertice v : this.adjVertices.get(new Vertice(source))) // loop over all adjacent nodes
        {
            Character currentCharacter = v.getValue();
            if (beingVisited[currentCharacter - 'A'] != 1)
            {
                currentPath.add(currentCharacter);
                List<Character> ans = dfs(currentCharacter, destination, beingVisited, currentPath);
                if (ans != null) return ans;
                currentPath.remove(currentCharacter);
            }
        }

        beingVisited[source - 'A'] = 0;

        return null;
    }

}
