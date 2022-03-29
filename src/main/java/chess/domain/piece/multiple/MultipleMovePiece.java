package chess.domain.piece.multiple;

import chess.domain.ChessBoard;
import chess.domain.Color;
import chess.domain.Position;
import chess.domain.direction.Direction;
import chess.domain.piece.AbstractPiece;
import java.util.Collections;
import java.util.List;

public abstract class MultipleMovePiece extends AbstractPiece {

    private final List<Direction> moveDirections;

    protected MultipleMovePiece(Color color, String name, List<Direction> moveDirections) {
        super(color, name);
        this.moveDirections = moveDirections;
    }

    @Override
    public final boolean isMovable(Position source, Position target, ChessBoard chessBoard) {
        List<Position> route = calculateRoute(source, target);
        if (route.isEmpty()) {
            return false;
        }
        return isEmptyRouteWithoutTargetPosition(target, chessBoard, route);
    }

    private List<Position> calculateRoute(Position source, Position target) {
        return moveDirections.stream()
                .map(direction -> direction.route(source, target))
                .filter(route -> !route.isEmpty())
                .findAny()
                .orElse(Collections.emptyList());
    }

    private boolean isEmptyRouteWithoutTargetPosition(Position target, ChessBoard chessBoard, List<Position> route) {
        return route.stream()
                .filter(position -> !position.equals(target))
                .allMatch(chessBoard::isPositionEmpty);
    }
}
