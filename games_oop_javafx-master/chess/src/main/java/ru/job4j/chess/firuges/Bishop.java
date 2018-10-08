package ru.job4j.chess.firuges;

import ru.job4j.chess.ImpossibleMoveException;

public abstract class Bishop implements Figure {
    /**
     *
     * Проверка на корректность ходов слона
     *
     * @param source исходная позиция
     * @param dest конечная позиция
     * @return boolean
     */
    public boolean isDiagonal (Cell source, Cell dest) {
        if (!(Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y))) {
            throw new ImpossibleMoveException("No Way");
        }
        return true;
    }

    /**
     *
     * Получение массива шагов
     *
     * @param source исходная позиция
     * @param dest конечная позиция
     * @return Cell[]
     */
    public Cell[] getSteps(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (isDiagonal(source, dest)) {
            int deltaX = source.x > dest.x ? -1 : 1;
            int deltaY = source.y > dest.y ? -1 : 1;
            int size = (dest.x - source.x) * deltaX;
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
