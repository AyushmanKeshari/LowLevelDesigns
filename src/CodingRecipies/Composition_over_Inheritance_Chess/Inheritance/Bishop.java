package CodingRecipies.Composition_over_Inheritance_Chess.Inheritance;

import CodingRecipies.Composition_over_Inheritance_Chess.Cell;

public class Bishop extends Piece {

    @Override
    public boolean canMove(Cell source, Cell destination) {
        //Check if source and destination are diagonal to each other.
        return false;
    }
}
