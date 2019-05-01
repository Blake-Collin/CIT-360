import java.util.*;

public class Collections {

  /**
   * General main function for collection testing/showing purposes
   *
   * @author Collin Blake
   * @verison 1.0.0
   * @param args
   */
  public static void main(String[] args) {
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

    List<String> newList = new ArrayList<String>();
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
