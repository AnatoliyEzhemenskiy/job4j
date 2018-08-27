package ru.job4j.tictactoe;

import java.util.function.Predicate;

/**
 * Проверка логики для определения победителя
 */
public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * @return true, если победили крестики
     */
    public boolean isWinnerX() {
        for (int i = 0; i < this.table.length; i++) {
            if (this.fillBy(Figure3T::hasMarkX, i, 0, 0, 1) || this.fillBy(Figure3T::hasMarkX, 0, i, 1, 0)) {
                return true;

            }
        }
        return this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 1) || this.fillBy(Figure3T::hasMarkO, this.table.length - 1, 0, -1, 1);
    }

    /**
     * @return true, если победили нолики
     */
    public boolean isWinnerO() {
        for (int i = 0; i < this.table.length; i++) {
            if (this.fillBy(Figure3T::hasMarkO, i, 0, 0, 1) || this.fillBy(Figure3T::hasMarkO, 0, i, 1, 0)) {
                return true;

            }
        }
        return this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 1) || this.fillBy(Figure3T::hasMarkO, this.table.length - 1, 0, -1, 1);
     }

    /**
     *
     * @return true, если есть еще место для игры
     */
    public boolean hasGap() {
        for (int i = 0; i != this.table.length; i++) {
            for (int j = 0; j != this.table.length; j++) {
               if (!(this.table[i][j].hasMarkO() || this.table[i][j].hasMarkX())) {
                   return true;
               }
            }
        }
        return false;
    }

    /**
     * Проверка на заполнение линии с началом координат startX, startY, с шагом deltaX, deltaY
     * @param predicate
     * @param startX
     * @param startY
     * @param deltaX
     * @param deltaY
     * @return true, если выполнено условие predicate, по всей линии
     */
    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
           if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }
}