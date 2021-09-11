import java.security.SecureRandom;
import java.util.Scanner;




public class Main {

    public static void main(String[] args) throws Exception {

        if (args.length%2 == 0 || args.length <= 1) {
            System.out.println("Invalid parameter");
            System.exit(0);
        }
        HelpTable helpTable = new HelpTable();
        helpTable.helpTable(args);
        Scanner sc = new Scanner(System.in);





        while (true){
            int computerMoveInt = (int) (Math.random() * args.length);
            String computerMove = args[computerMoveInt];
            SecureRandom secureRandom = new SecureRandom();
            String hmac = HmacGenerator.getHmacAlgo(computerMove, secureRandom);
            System.out.println(hmac);


            System.out.println("Enter your move: ");

            try {


                String move = sc.nextLine();
                if (move.equals("0")) {
                    break;
                }
                if (move.equals("?")) {
                    helpTable.helpTable(args);
                    continue;
                }
                System.out.println("Your move: " + args[Integer.parseInt(move) - 1]);
                System.out.println("Computer move: " + computerMove);
                System.out.println(RuleMaker.whoWillWin(Integer.parseInt(move) - 1, computerMoveInt, args.length).equals("Draw") ? "Draw" : "You " + RuleMaker.whoWillWin(Integer.parseInt(move) - 1, computerMoveInt, args.length) + "!");
                System.out.println("Hmac key: " + HmacGenerator.getKey(secureRandom));
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid value, try again ");
            }

        }
        sc.close();
    }
}