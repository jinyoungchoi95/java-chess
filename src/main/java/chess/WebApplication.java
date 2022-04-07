package chess;

import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

import chess.controller.ChessGameController;
import chess.dao.PieceDao;
import chess.dao.TurnDao;
import chess.service.ChessGameService;

public class WebApplication {
    public static void main(String[] args) {
        port(8080);
        staticFileLocation("/static");

        new ChessGameController(new ChessGameService(new PieceDao(), new TurnDao())).run();
    }
}
