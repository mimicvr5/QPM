package qpm.lexing;

public class Token {
    private String kind;
    private SourceLine line;
    private int[] locale;
    private String value;

    public Token(String kind, SourceLine line) {
        this.kind = kind;
        this.line = line;

        // Capture token string and update locale
        this.value = line.takeToken();
        this.locale = new int[]{0, value.length()};

        if (this.value.isEmpty()) {
            this.value = "EOF";
        }

        mark();
    }

    public void mark() {
        line.mark(this);
    }

    public String getKind() {
        return kind;
    }

    public String getValue() {
        return value;
    }

    public int[] getLocale() {
        return locale;
    }

    @Override
    public String toString() {
        return kind.charAt(0) + "'" + value + "'";
    }

    public String treeRepr() {
        return toString();
    }
}