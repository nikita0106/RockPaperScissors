import java.util.Arrays;
import java.util.List;


public class HelpTable {

    public void helpTable(String[] args) {
        List<String> strings = Arrays.asList(args);
        int largest = takeLargest(strings);
        String result = tableCreator(largest, args.length, args);
        System.out.format(result);
        String available = availableTable(args.length, args);
        System.out.format(available);
    }

    public static String availableTable(int length, String[] args){
        StringBuilder result = new StringBuilder();
        result.append("Available moves\n");
        for (int i = 0; i < length; i++) {
            result.append(i+1 + " - " + args[i] + '\n');
        }
        result.append("0 - exit\n" + "? - help\n");
        return result.toString();
    }

    private String tableCreator(int largest, int length, String[] args){
        String template1 = "WIN";
        String template2 = "LOSE";
        String template3 = "DRAW";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append("+");
            result.append(("-".repeat(largest<9? 9 : largest + 2) + "+").repeat(length+1));
            result.append('\n');
            result.append(args[i] + " ".repeat(largest<9? 9 - args[i].length() : largest - args[i].length() + 2) + " |");
            for (int j = 0; j < length; j++) {
                result.append(RuleMaker.whoWillWin(i+1, j+1, length) + " ".repeat(largest < 9 ? 9 - (RuleMaker.whoWillWin(i+1, j+1, length)).length():largest - (RuleMaker.whoWillWin(i+1, j+1, length)).length() + 2) + "|");
            }
            result.append('\n');

        }

        StringBuilder startOfResult = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            if (i == 0){
                startOfResult.append("+");
                startOfResult.append(("-".repeat(largest<9? 9 : largest + 2) + "+").repeat(length+1));
                startOfResult.append('\n');
            }
            else if (i == 1) {
                startOfResult.append((largest < 9?"  \\ User " : "  \\ User" + " ".repeat(largest - 6)) + " |");
                for (int j = 0; j < length; j++) {
                    startOfResult.append(" ".repeat(largest<9 ? 9 : largest + 2) + "|");
                }
                startOfResult.append('\n');
            } else {
                startOfResult.append((largest < 9? "PC \\     " : "PC \\    " + " ".repeat(largest - 6)) + " |");
                for (int j = 0; j < length; j++) {
                    startOfResult.append(args[j] + " ".repeat(largest<9? 9 - args[j].length()  : largest - args[j].length() + 2) + "|");

                }
                startOfResult.append('\n');
            }
        }


        return startOfResult.append(result).toString();
    }



    private int takeLargest(List<String> strings) {
        return strings.stream().map(String::length).max(Integer::compareTo).get();
    }

}
