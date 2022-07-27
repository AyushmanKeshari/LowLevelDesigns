package CodingRecipies.Composition_over_Inheritance_Chess.Inheritance;

import CodingRecipies.Composition_over_Inheritance_Chess.Cell;

public abstract class Piece {

    public abstract boolean canMove(Cell source, Cell destination);
}
