package chess.domain.turn;

import chess.domain.ChessBoard;
import chess.domain.Color;

public class RunningTurn implements GameTurn {

    private final ChessBoard chessBoard;
    private final Color color;

    public RunningTurn(ChessBoard chessBoard, Color color) {
        this.chessBoard = chessBoard;
        this.color = color;
    }

    @Override
    public GameTurn nextTurn() {
        if (chessBoard.isPromotionStatus(color)) {
            return this;
        }
        if (chessBoard.isFinished()) {
            return new EndTurn(color);
        }
        return new RunningTurn(chessBoard, color.reverseColor());
    }

    @Override
    public Color color() {
        return color;
    }

    @Override
    public boolean isEnd() {
        return false;
    }
}
