import java.util.Scanner;

public class RPS extends RPSAbstract {
    // Messages for the game.
    protected static final String GAME_NOT_IMPLEMENTED =
            "Game not yet implemented.";
    /**
     * Construct a new instance of RPS with the given possible moves.
     *
     * @param moves all possible moves in the game.
     */
    public RPS(String[] moves) {
        this.possibleMoves = moves;
        this.playerMoves = new String[MAX_GAMES];
        this.cpuMoves = new String[MAX_GAMES];
    }

    public static void main(String[] args) {
        // If command line args are provided use those as the possible moves
        String[] moves = new String[args.length];
        if (args.length >= MIN_POSSIBLE_MOVES) {
            System.arraycopy(args, 0, moves, 0, args.length);
        } else {
            moves = RPS.DEFAULT_MOVES;
        }
        // Create new game and scanner
        RPS game = new RPS(moves);
        Scanner in = new Scanner(System.in);

        // While user does not input "q", play game

        // TODO: Insert the code to play the game.
        String input = "";
        String cpuMove = "";
        while (!input.equals("q")){ //runs as long input isnt q
            System.out.println(PROMPT_MOVE); //prompt message
            input = in.nextLine(); //user input
            if (input.equals("q")){break;} //stop loop if input is q
            cpuMove = game.genCPUMove(); //generate cpu move
            if(!game.isValidMove(input)){ //prints invalid input message and skips to next iteration of loop
                System.out.println(INVALID_INPUT);
                continue;
            }
            System.out.printf(CPU_MOVE, cpuMove); //print cpu move
            game.playRPS(input, cpuMove); //print who wins, plus adds to stats
        }
        game.displayStats(); //display stats

        // See the writeup for an example of the game play.
        // Hint: call the methods we/you have already written
        // to do most of the work! And don't forget Javadoc.

        in.close();
    }

    @Override
    public int determineWinner(String playerMove, String cpuMove) {
        // TODO
        int playerInd = -1;
        int cpuInd = -1;
        for (int i = 0; i < possibleMoves.length; i++){
            if (possibleMoves[i].equals(playerMove)){playerInd = i;}
            if (possibleMoves[i].equals(cpuMove)){cpuInd = i;}
        }
        if (!isValidMove(playerMove) || !isValidMove(cpuMove)){return INVALID_INPUT_OUTCOME;}
        else if ((playerInd == 0 && cpuInd == possibleMoves.length-1) || cpuInd+1 == playerInd){
            return CPU_WIN_OUTCOME;
        }
        else if ((cpuInd == 0 && playerInd == possibleMoves.length-1) || playerInd+1 == cpuInd){
            return PLAYER_WIN_OUTCOME;
        }
        else {return TIE_OUTCOME;}
    }
}
