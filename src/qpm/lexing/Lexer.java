package qpm.lexing;

import java.util.*;
import qpm.errors.LexerException;

public class Lexer {
    private SourceLine sourceLine;
    private List<Token> tokens = new ArrayList<>();

    private Set<String> keywords = new HashSet<>(Arrays.asList(
            "public", "private", "class", "final", "change",
            "for", "in", "range", "while", "import", "package", "none"
    ));

    private Set<String> varTypes = new HashSet<>(Arrays.asList(
            "int", "float", "bool", "string" // VARTYPEs
    ));

    private Set<Character> symbols = new HashSet<>(Arrays.asList(
            '+', '-', '*', '/', '=', '<', '>', '!'
    ));

    private Set<Character> punctuation = new HashSet<>(Arrays.asList(
            '(', ')', '{', '}', '[', ']', ','
    ));

    public Lexer(String code) {
        this.sourceLine = new SourceLine(code);
    }

    public List<Token> tokenize() {
        while (!sourceLine.finished()) {
            char c = sourceLine.next();

            if (Character.isWhitespace(c)) {
                sourceLine.take();
                continue;
            }

            if (Character.isLetter(c)) {
                String ident = readIdentifier();
                String kind;
                if (keywords.contains(ident)) {
                    kind = "KEYWORD";
                } else if (varTypes.contains(ident)) {
                    kind = "VARTYPE";
                } else {
                    kind = "IDENTIFIER";
                }
                tokens.add(new Token(kind, sourceLine));
            } else if (Character.isDigit(c)) {
                readNumber();
                tokens.add(new Token("NUMBER", sourceLine));
            } else if (c == ';') {
                sourceLine.take();
                tokens.add(new Token("PUNCTUATOR", sourceLine));
            } else if (symbols.contains(c)) {
                sourceLine.take();
                tokens.add(new Token("SYMBOL", sourceLine));
            } else if (punctuation.contains(c)) {
                sourceLine.take();
                tokens.add(new Token("PUNCTUATION", sourceLine));
            } else {
                throw new LexerException("Unexpected Character: " + c, 1, sourceLine.getLocale()[1] + 1);
            }
        }

        tokens.add(new Token("EOF", sourceLine));
        return tokens;
    }

    private String readIdentifier() {
        int start = sourceLine.getLocale()[1];
        while (!sourceLine.finished() &&
                (Character.isLetterOrDigit(sourceLine.next()) || sourceLine.next() == '_')) {
            sourceLine.take();
        }
        return sourceLine.getLine().substring(start, sourceLine.getLocale()[1]);
    }

    private String readNumber() {
        int start = sourceLine.getLocale()[1];
        while (!sourceLine.finished() && Character.isDigit(sourceLine.next())) {
            sourceLine.take();
        }
        return sourceLine.getLine().substring(start, sourceLine.getLocale()[1]);
    }
}