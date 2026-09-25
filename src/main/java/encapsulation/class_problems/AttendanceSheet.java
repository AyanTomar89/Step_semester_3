class Attendance {
    private String[] names;
    private int count;

    Attendance(int n) {
        names = new String[n];
    }

    void markPresent(String name) {
        if (isPresent(name) || count == names.length) return;
        names[count++] = name;
    }

    int getPresentCount() {
        return count;
    }

    boolean isPresent(String name) {
        for (int i = 0; i < count; i++)
            if (names[i].equals(name)) return true;
        return false;
    }
}

public class AttendanceSheet {
    public static void main(String[] args) {
        Attendance a = new Attendance(30);
        a.markPresent("Ana");
        a.markPresent("Ben");
        a.markPresent("Ana");

        System.out.println(a.getPresentCount());
        System.out.println(a.isPresent("Ben"));
        System.out.println(a.isPresent("Chen"));
    }
}