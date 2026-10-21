
package com.example;

public class Calculator {

    // Défauts volontaires pour tester les analyseurs
    public int ADD(int A, int B) {
        int X = A + B;
        return X;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    // 1. Assignment dans une condition → PMD "AssignmentInOperand"
    public int checkAssignment(int a) {
        int b = 0;
        if ((a = b) != 0) {
            return 1;
        }
        return 0;
    }

    // 2. new String() au lieu de littéral → PMD "AvoidInstantiatingObjectsInLoops" / "UnnecessaryWrapperObjectCreation"
    public String badString() {
        return new String("bad");
    }

    // 3. Variable locale inutilisée → PMD "UnusedLocalVariable"
    public int unusedVar() {
        int unused = 42;
        return 0;
    }

    // 4. Paramètre inutilisé → PMD "UnusedFormalParameter"
    public int unusedParam(int a, int b) {
        return a;
    }

    // 5. Catch vide → PMD "EmptyCatchBlock"
    public void emptyCatch() {
        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            // rien → PMD détecte
        }
    }

    // 6. If imbriqués fusionnables → PMD "CollapsibleIfStatements"
    public void collapsibleIf(boolean a, boolean b) {
        if (a) {
            if (b) {
                System.out.println("both");
            }
        }
    }

    // 7. Parenthèses inutiles → PMD "UselessParentheses"
    public int uselessParen() {
        return (1) + (2);
    }

    // 8. Comparaison de String avec == → SpotBugs "ES_COMPARING_STRINGS_WITH_EQ"
    public boolean compareStrings(String a, String b) {
        return a == b;
    }

    // 9. Division par zéro constante → SpotBugs "DIV_BY_ZERO"
    public int divideByZero() {
        int b = 0;
        return 100 / b;
    }

    // 10. Champ static non final → SpotBugs "MS_SHOULD_BE_FINAL"
    public static int counter = 0;

    // 11. Champ jamais lu → SpotBugs "URF_UNREAD_FIELD"
    private int neverRead;

    // 12. Comparaison de l'objet avec lui-même → SpotBugs "SA_LOCAL_SELF_COMPARISON"
    public boolean selfCompare(int x) {
        return x == x;
    }

    // 13. Return null → SpotBugs "NP" possible selon le contexte
    public String returnNull() {
        return null;
    }

    // 14. Magic number sans constante → SpotBugs "MAGIC_NUMBER" (selon config)
    public int magic() {
        return 12345;
    }

    // 15. String.format mal utilisé → Error Prone "FormatString"
    public String badFormat() {
        return String.format("%d", "not a number");   // type mismatch
    }

// 16. Return null sur méthode @Nonnull (annotations requises)
// Nécessite une annotation, skip pour l'instant
}

