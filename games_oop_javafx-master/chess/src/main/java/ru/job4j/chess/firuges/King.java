package ru.job4j.chess.firuges;

import ru.job4j.chess.ImpossibleMoveException;

public abstract class King implements Figure {
    public boolean isKingWay (Cell source, Cell dest) {
        if (Math.abs(source.x - dest.x) > 1 || Math.abs(source.y - dest.y) > 1) {
            throw new ImpossibleMoveException("No Way");
        }
        return true;
    }

    public Cell[] getSteps(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (isKingWay(source, dest)) {
            steps = new Cell[]{dest};
        }
        return steps;
    }
}

