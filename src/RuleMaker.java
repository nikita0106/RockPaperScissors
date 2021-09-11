public class RuleMaker {

    public static String whoWillWin(int value, int elementForCompare, int length) {

        if (value < elementForCompare) {
            if (elementForCompare - value <= length / 2) {
                return "Win";
            } else return "Lose";
        }
        else if (value > elementForCompare) {
            if (value - elementForCompare > length / 2) {
                return "Win";
            } else return "Lose";

        } else return "Draw ";
    }




}
