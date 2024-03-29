package Week1.Day1.Day39till43;

public enum AnsiColor {

    // Regular text colors
    RESET("\u001B[0m"),
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    MAGENTA("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m"),

    // Bold text colors
    BOLD_BLACK("\u001B[30;1m"),
    BOLD_RED("\u001B[31;1m"),
    BOLD_GREEN("\u001B[32;1m"),
    BOLD_YELLOW("\u001B[33;1m"),
    BOLD_BLUE("\u001B[34;1m"),
    BOLD_MAGENTA("\u001B[35;1m"),
    BOLD_CYAN("\u001B[36;1m"),
    BOLD_WHITE("\u001B[37;1m");

    private final String code;

    public static String warningDeath() {
        return BOLD_RED.toString();
    }

    AnsiColor(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
