package CodingRecipies.Composition_over_Inheritance_Chess.Composition;

import CodingRecipies.Composition_over_Inheritance_Chess.Cell;

public interface Move {
    boolean canMove(Cell source, Cell destination);
}
