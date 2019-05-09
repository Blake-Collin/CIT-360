import java.util.*;

public class Collections {

  /**
   * General main function for collection testing/showing purposes
   *
   * @author Collin Blake
   * @verison 1.1.0
   * @param args
   */
  public static void main(String[] args) {

    // listTesting
    listTesting();

    // MapTesting
    mapTesting();

    // Trees Testing
    treeTesting();

    // Sets
    setTesting();

  }

  private static void setTesting() {
    Set<String> set = new HashSet<String>(populateList());
    Set<String> set2 = populateSet();

    System.out.println("\nSet Testing");

    //Basic Setup of Set
    System.out.println("Basic Sets: \n" + set + "\n" + set2);

    //Union
    Set<String> union = new HashSet<String>(set);
    union.addAll(set2);
    System.out.println("Union of Sets: " + union);

    //Intersection
    Set<String> intersection = new HashSet<String>(set);
    intersection.retainAll(set2);
    System.out.println("Intersection of Sets: " + intersection);

    //Difference
    Set<String> difference = new HashSet<String>(set);
    difference.removeAll(set2);
    System.out.println("Difference of Sets: " + difference);

  }

  private static Set<String> populateSet() {
    Set<String> newSet = new HashSet<>();

    newSet.add("Charlie");

    newSet.add("Bob");
    newSet.add("Steve");
    newSet.add("Gorilla");
    newSet.add("Cat");
    newSet.add("Dos");

    return newSet;
  }

  private static void treeTesting() {
    TreeSet<String> tree = populateTreeSet();

    //Which auto sorts due to how binary trees work
    System.out.println("\nBeginning Tree Testing");
    System.out.println(tree);


    //You cannot add more then one copy
    tree.addAll(populateList());
    System.out.println(tree);

    //Add Value not on the list
    tree.add("Hawks");
    System.out.println(tree);

    //Remove a value
    tree.remove("Tiger");
    System.out.println(tree);

    //Re add all will add only the missing values
    tree.addAll(populateList());
    System.out.println(tree);


  }

  private static TreeSet<String> populateTreeSet() {
    TreeSet<String> newTree = new TreeSet<>(populateList());

    return newTree;
  }

  private static void mapTesting() {
    Map<String, Integer> map = populateMap();

    System.out.println("\nBeginning Map Testing");

    // Add only if missing.
    map.putIfAbsent("Cats", 5125);
    map.putIfAbsent("Raven", 324);

    System.out.println(map);

    // Pull Specific tasks
    System.out.println("There is " + map.get("Raven") + " Ravens");
    System.out.println("There is " + map.get("Monkeys") + " Monkeys");
    System.out.println("There is " + map.get("Lions") + " Lions");
    System.out.println("There is " + map.get("Cats") + " Cats");

    // Lets convert and get these in order by count
    Map<String, Integer> sortedMap = new LinkedHashMap<>();

    // Sort by value instead of key
    map.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

    System.out.println("Reverse Sorted LinkedHashMap by Value\n" + sortedMap);

    // Clear and copy to resort the map in normal sort
    sortedMap.clear();
    map.entrySet().stream()
        .sorted(Map.Entry.comparingByValue())
        .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

    System.out.println("Sorted LinkedHashMap by Value\n" + sortedMap);

    // Clear and Sort by key instead of value
    sortedMap.clear();

    map.entrySet().stream()
        .sorted(Map.Entry.comparingByKey())
        .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

    System.out.println("Sorted LinkedHashMap by key\n" + sortedMap);

    // Iterate and increase each by 100
    map.forEach(
        (creature, count) -> {
          map.replace(creature, count + 100);
        });

    System.out.println("HashMap with increased values\n" + map);

    // Do the same for LinkedHashMap
    sortedMap.forEach(
        (creature, count) -> {
          sortedMap.replace(creature, count + 100);
        });

    System.out.println("LinkedHashMap with increased values\n" + sortedMap);
  }

  private static Map<String, Integer> populateMap() {
    Map<String, Integer> newMap = new HashMap();

    newMap.put("Cats", 25);
    newMap.put("Dogs", 13);
    newMap.put("Monkeys", 16);
    newMap.put("Lions", 7);
    newMap.put("Bears", 9);
    newMap.put("Donkeys", 5);
    newMap.put("Tigers", 3);
    newMap.put("Owls", 2);
    newMap.put("Gorilla", 1);

    return newMap;
  }

  private static void listTesting() {
    // Create our new list
    List list = populateList();

    // Output our List
    System.out.println("Starting List:");
    printList(list);

    // Sort List
    list.sort(Comparator.naturalOrder());
    System.out.println("Ordered List:");
    printList(list);

    // Random List
    java.util.Collections.shuffle(list);
    System.out.println("Randomized List:");
    printList(list);

    // Reserve List
    list.sort(Comparator.reverseOrder());
    System.out.println("Reverse Ordered List:");
    printList(list);

    // Add an s to the end of each
    for (int i = 0; i < list.size(); i++) {
      list.set(i, list.get(i) + "s");
    }
    System.out.println("Add \"s\" List:");
    printList(list);

    // Remove anything with o in it.
    list.removeIf(item -> item.toString().toLowerCase().contains("o"));
    System.out.println("Removed \"o\" List:");
    printList(list);
  }

  private static List<String> populateList() {

    List<String> newList = new ArrayList<>();
    newList.addAll(
        Arrays.asList(
            "Cat",
            "Dog",
            "Monkey",
            "Parrot",
            "Gorilla",
            "Bat",
            "Cow",
            "Scorpion",
            "Spider",
            "Tiger",
            "Lion",
            "Bear"));

    return newList;
  }

  private static void printList(List<String> printList) {
    StringJoiner joiner = new StringJoiner(", ");
    for (String item : printList) {
      joiner.add(item);
    }
    System.out.println(joiner.toString());
  }
}
