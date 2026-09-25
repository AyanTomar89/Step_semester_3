class NameTag {
    private final String first, last;

    NameTag(String name) {
        String[] x = name.split(" ");
        first = x[0];
        last = x[1];
    }

    String getNickname() {
        return first + " " + last.charAt(0) + ".";
    }
}

public class NicknameTag {
    public static void main(String[] args) {
        NameTag n = new NameTag("Maria Gomez");
        System.out.println(n.getNickname());
    }
}