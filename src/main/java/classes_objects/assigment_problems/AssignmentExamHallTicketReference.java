class AssignmentHallTicket {
    String studentName;
    int seatNumber;

    AssignmentHallTicket(String name, int seat) {
        studentName = name;
        seatNumber = seat;
    }
}

public class ExamHallTicketReference {
    public static void main(String[] args) {
        AssignmentHallTicket priya = new AssignmentHallTicket("Priya", 0);
        AssignmentHallTicket copy = priya;

        copy.seatNumber = 45;

        AssignmentHallTicket separate = new AssignmentHallTicket("Priya", 45);

        System.out.println("Priya's seatNumber (via first variable):");
        System.out.println(priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
    }
}