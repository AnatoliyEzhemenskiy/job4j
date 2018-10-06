package ru.job4j.chess.firuges;

public abstract class Figure {
    public abstract Cell position();

    public abstract Cell[] way(Cell source, Cell dest);

    public String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    public abstract Figure copy(Cell dest);

    /**
     *
     * Проверка на корректность ходов слона
     *
     * @param source исходная позиция
     * @param dest конечная позиция
     * @return boolean
     */
    protected boolean IsDiagonal (Cell source, Cell dest) {
        int size = Math.abs(source.x - dest.x);
        return ((source.x + source.y == dest.x + dest.y) ||
                (source.x == dest.x - size && source.y == dest.y - size) ||
                (source.x == dest.x + size && source.y == dest.y + size)
        );
    }

    /**
     *
     * Получение массива шагов слона
     *
     * @param source исходная позиция
     * @param dest конечная позиция
     * @return Cell[]
     */
    protected Cell[] getBishopSteps(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        int size = Math.abs(source.x - dest.x);
        if (IsDiagonal(source, dest)) {
            int deltaX = source.x > dest.x ? -1 : 1;
            int deltaY = source.y > dest.y ? -1 : 1;
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
