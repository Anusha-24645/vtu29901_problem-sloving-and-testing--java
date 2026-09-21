import java.util.*;

public class ThroneInheritance {

    private String king;
    private Map<String, List<String>> family;   // parent -> list of children
    private Set<String> dead;                   // people who have died

    public ThroneInheritance(String kingName) {
        this.king = kingName;
        this.family = new HashMap<>();
        this.dead = new HashSet<>();
        family.put(kingName, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {
        family.putIfAbsent(parentName, new ArrayList<>());
        family.get(parentName).add(childName);
        family.put(childName, new ArrayList<>());
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }

    // Pre-order traversal (Successor order)
    private void dfs(String person, List<String> order) {
        if (!dead.contains(person)) {
            order.add(person);
        }
        for (String child : family.getOrDefault(person, new ArrayList<>())) {
            dfs(child, order);
        }
    }

    // ==================== Test Code ====================
    public static void main(String[] args) {
        ThroneInheritance t = new ThroneInheritance("king");

        t.birth("king", "andy");
        t.birth("king", "bob");
        t.birth("king", "catherine");
        t.birth("andy", "matthew");
        t.birth("bob", "alex");
        t.birth("bob", "asha");

        System.out.println(t.getInheritanceOrder());
        // [king, andy, matthew, bob, alex, asha, catherine]

        t.death("bob");

        System.out.println(t.getInheritanceOrder());
        // [king, andy, matthew, alex, asha, catherine]
    }
}