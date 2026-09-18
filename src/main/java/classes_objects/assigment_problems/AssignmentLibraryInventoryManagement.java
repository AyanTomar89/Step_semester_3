class AssignmentBookInventory {
    String title, author;
    int copiesAvailable;

    AssignmentBookInventory(String t, String a, int c) {
        title = t;
        author = a;
        copiesAvailable = c;
    }

    void printEntry() {
        System.out.println(title + " by " + author + " - " + copiesAvailable + " copies available");
    }
}

public class AssignmentLibraryInventoryManagement {
    public static void main(String[] args) {
        AssignmentBookInventory[] books = {
                new AssignmentBookInventory("Clean Code", "Robert C. Martin", 3),
                new AssignmentBookInventory("Effective Java", "Joshua Bloch", 5),
                new AssignmentBookInventory("Refactoring", "Martin Fowler", 0),
                new AssignmentBookInventory("Design Patterns", "GoF", 2)
        };

        for (AssignmentBookInventory b : books)
            b.printEntry();
    }
}