package ru.job4j.chess.firuges;

import ru.job4j.chess.ImpossibleMoveException;

public abstract class Knight implements Figure {
    public Cell[] getSteps(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (!((Math.abs(source.x - dest.x) == 2 && Math.abs(source.y - dest.y) == 1) ||
                (Math.abs(source.y - dest.y) == 2 && Math.abs(source.x - dest.x) == 1))) {
            throw new ImpossibleMoveException("No Way");
        }
        steps = new Cell[]{dest};
        return steps;
    }
}
