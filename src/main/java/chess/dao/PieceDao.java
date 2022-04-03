package chess.dao;

import chess.domain.Position;
import chess.domain.piece.Piece;
import java.util.Map;

public interface PieceDao {

    Map<Position, Piece> findAllPieces();

    void savePieces(Map<Position, Piece> chessBoard);

    void deletePiece(Position position);
}
