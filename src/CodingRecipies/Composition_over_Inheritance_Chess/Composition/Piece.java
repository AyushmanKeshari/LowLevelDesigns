package CodingRecipies.Composition_over_Inheritance_Chess.Composition;

import CodingRecipies.Composition_over_Inheritance_Chess.Cell;

import java.util.List;

public class Piece {
    List<Move> allowedMoves;

    public Piece(List<Move> moveList) {
        this.allowedMoves = moveList;
    }

    public boolean canMove(Cell source, Cell destination) {
        for (Move move : allowedMoves) {
            if (move.canMove(source, destination)) {
                return true;
            }
        }
        return false;
    }
}
