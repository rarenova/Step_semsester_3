public class Ass2Q4 {

    static String normalizeCode(String raw) {

        raw = raw.trim();

        if (raw.length() < 3) {
            return raw;
        }

        String publisher =
            raw.substring(0, 3).toUpperCase();

        String remaining = raw.substring(3);

        return publisher + remaining;
    }

    static String validateAndFormat(String code) {

        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Check remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String publisher = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder sb = new StringBuilder();

        sb.append("[")
          .append(publisher)
          .append("] YEAR: ")
          .append(year)
          .append(" | CATALOG: ")
          .append(catalog);

        return sb.toString();
    }

    public static void main(String[] args) {

        String raw = " pen2026004251 ";

        String normalized = normalizeCode(raw);

        System.out.println(
            validateAndFormat(normalized)
        );
    }
}

