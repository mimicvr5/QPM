package qpm.lexing;

public class SourceLine {
    public String line;
    public int[] locale = {0, 0}; // start, current
    private int[] marked;

    public SourceLine(String line) {
        this.line = line;
        this.marked = new int[]{line.length(), -1};
    }

    public boolean finished() {
        return locale[1] >= line.length();
    }

    public char next() {
        return finished() ? '\0' : line.charAt(locale[1]);
    }

    public char take() {
        char c = next();
        if (!finished()) locale[1]++;
        return c;
    }

    public void ignore() {
        locale[0] = locale[1];
    }

    public String taken() {
        return line.substring(locale[0], locale[1]);
    }

    public String takeToken() {
        int start = locale[0];
        int end = locale[1];
        locale[0] = locale[1];
        return line.substring(start, end);
    }

    public void mark(Token token) {
        int[] tokLoc = token.getLocale();
        marked[0] = Math.min(tokLoc[0], marked[0]);
        marked[1] = Math.min(tokLoc[1], marked[1]);
    }

    public String getMarks() {
        StringBuilder sb = new StringBuilder("  ");
        for (int i = 0; i <= line.length(); i++) {
            boolean between = marked[0] <= i && i < marked[1];
            sb.append(between || marked[0] == i ? '^' : ' ');
        }
        return sb.toString();
    }

    public int[] getLocale() {
        return locale.clone();
    }

    public String getLine() {
        return line;
    }
}
