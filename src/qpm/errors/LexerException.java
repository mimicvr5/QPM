package qpm.errors;

public class LexerException extends RuntimeException {
    private int lineNumber;
    private int column;

    public LexerException(String message, int lineNumber, int column) {
        super(String.format("Lexer Error at line %d, column %d: %s", lineNumber, column, message));
        this.lineNumber = lineNumber;
        this.column = column;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getColumn() {
        return column;
    }
}