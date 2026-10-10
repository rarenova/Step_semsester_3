
import java.util.Arrays;

public class Question8 {

    public static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        int shift = (int) (k % n);
        String[] rotated = new String[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + shift) % n] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        String[] names1 = {"A", "B", "C", "D", "E"};
        String[] names2 = {"A", "B", "C", "D", "E"};

        System.out.println(Arrays.toString(rotateRoster(names1, 2)));
        System.out.println(Arrays.toString(rotateRoster(names2, 7)));
    }
}
