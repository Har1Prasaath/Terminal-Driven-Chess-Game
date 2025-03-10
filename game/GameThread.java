package game;

public class GameThread extends Thread {
    private ChessBoard chessBoard;
    private boolean running;
    private Square[][] table;

    public GameThread(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
        this.running = true;
    }

    public void terminate() {
        running = false;
    }
    public boolean isGameEnded() {


        int blackPiece = 0;
        int whitePiece = 0;
        table = new Square[8][8];
        for(int i=0;i<8;i++){
            for(int j=0; j<8; j++){
                Square currentSquare = table[i][j];
                if(currentSquare.isEmpty()){
                    continue;
                }
                else{
                    blackPiece++;
                }
            }
        }
        if(blackPiece == 0 || whitePiece == 0){
            return true;
        }
        return false;
    }
    @Override
    public void run() {
        while (running) {
            
            if (chessBoard.isGameEnded()) {
                System.out.println("Game ended!");
                running = false; 
            }

            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
