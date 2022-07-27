package CodingRecipies.Composition_over_Inheritance_Chess.Composition;

import CodingRecipies.Composition_over_Inheritance_Chess.Cell;

public class VerticalMove implements Move {
    @Override
    public boolean canMove(Cell source, Cell destination) {
        // Check if source and destination in vertical
        return false;
    }
}
