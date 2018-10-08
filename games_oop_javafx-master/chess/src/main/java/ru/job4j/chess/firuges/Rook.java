package ru.job4j.chess.firuges;

import ru.job4j.chess.ImpossibleMoveException;

public abstract class Rook implements Figure {
    public boolean isStraightLine (Cell source, Cell dest) {
        if(!((source.x == dest.x) || (source.y == dest.y))) {
            throw new ImpossibleMoveException("No Way");
        }
        return true;
    }

    public Cell[] getSteps(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (isStraightLine(source, dest)) {
            int deltaX = (source.x == dest.x) ? 0 : (source.x > dest.x ? -1 : 1);
            int deltaY = (source.y == dest.y) ? 0 : (source.y > dest.y ? -1 : 1);
            int size = deltaX == 0 ? (dest.y - source.y) * deltaY : (dest.x - source.x) * deltaX;
            steps = new Cell[size];
            for (int i = 0; i < size; i++) {
                int x = source.x + (i + 1) * deltaX;
                int y = source.y + (i + 1) * deltaY;
                steps[i] = Cell.values()[8 * x + y];
            }
        }
        return steps;
    }
}
