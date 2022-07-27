package CodingRecipies.Composition_over_Inheritance_Chess.Inheritance;

import CodingRecipies.Composition_over_Inheritance_Chess.Cell;

public class Rook extends Piece {
    @Override
    public boolean canMove(Cell source, Cell destination) {
        //Check if source and destination are vertical to each other.
        //Check if source and destination are horizontal to each other.
        return false;
    }
}
