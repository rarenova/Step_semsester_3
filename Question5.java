class AttendanceSheet {

    private String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxStudents) {
        presentStudents = new String[maxStudents];
        count = 0;
    }

    public void markPresent(String name) {

        if (isPresent(name)) {
            System.out.println(name + " is already marked present");
            return;
        }

        if (count < presentStudents.length) {
            presentStudents[count] = name;
            count++;
            System.out.println(name + " marked present");
        } else {
            System.out.println("Attendance sheet is full");
        }
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {

        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }

        return false;
    }
}

public class Question5 {
    public static void main(String[] args) {

        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("Ben present: " + sheet.isPresent("Ben"));
        System.out.println("Chen present: " + sheet.isPresent("Chen"));
    }
}