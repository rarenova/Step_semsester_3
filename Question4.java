class HallTicket {

    String studentName;
    int seatNumber;

    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class Question4 {

    public static void main(String[] args) {

        HallTicket priya = new HallTicket("Priya", 0);

        // Both variables refer to the same object
        HallTicket copy = priya;

        copy.seatNumber = 45;

        System.out.println("Priya's seatNumber (via first variable):");
        System.out.println(priya.seatNumber);

        System.out.println("copy == priya: " + (copy == priya));

        // A separate object with identical values
        HallTicket separate = new HallTicket("Priya", 45);

        System.out.println("separate == priya: "
                + (separate == priya));
    }
}