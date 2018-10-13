package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void whenBishopInDiagonalWayThenTrue() {
        Logic logic = new Logic();
        logic.add(new BishopWhite((Cell.C1)));
        boolean result = logic.move(Cell.C1,Cell.D2);
        assertThat(result, is(true));
    }

    @Test
    public void bishopUpRight() {
        BishopBlack bishop = new BishopBlack(Cell.A1);
        Cell[] actual = bishop.way(bishop.position(), Cell.H8);
        Cell[] expected = {Cell.B2, Cell.C3, Cell.D4, Cell.E5, Cell.F6, Cell.G7, Cell.H8};
        assertThat(actual, is(expected));
    }

    @Test
    public void bishopUpLeft() {
        BishopBlack bishop = new BishopBlack(Cell.H1);
        Cell[] actual = bishop.way(bishop.position(), Cell.A8);
        Cell[] expected = {Cell.G2, Cell.F3, Cell.E4, Cell.D5, Cell.C6, Cell.B7, Cell.A8};
        assertThat(actual, is(expected));
    }

    @Test
    public void bishopDownRight() {
        BishopBlack bishop = new BishopBlack(Cell.A8);
        Cell[] actual = bishop.way(bishop.position(), Cell.H1);
        Cell[] expected = {Cell.B7, Cell.C6, Cell.D5, Cell.E4, Cell.F3, Cell.G2, Cell.H1};
        assertThat(actual, is(expected));
    }

    @Test
    public void bishopDownLeft() {
        BishopBlack bishop = new BishopBlack(Cell.H8);
        Cell[] actual = bishop.way(bishop.position(), Cell.A1);
        Cell[] expected = {Cell.G7, Cell.F6, Cell.E5, Cell.D4, Cell.C3, Cell.B2, Cell.A1};
        assertThat(actual, is(expected));
    }


    @Test
    public void whenRookInLineThenTrue() {
        Logic logic = new Logic();
        logic.add(new RookWhite(Cell.A1));
        boolean result = logic.move(Cell.A1,Cell.A4);
        assertThat(result, is(true));
    }

    @Test
    public void whenPawnInOneVerticalStepThenTrue() {
        Logic logic = new Logic();
        logic.add(new PawnWhite(Cell.B2));
        boolean result = logic.move(Cell.B2,Cell.B3);
        assertThat(result, is(true));
    }

    @Test
    public void whenQueenInDiagonalOrStraightWayThenTrue() {
        Logic logic = new Logic();
        logic.add(new QeenWhite(Cell.B2));
        boolean result = logic.move(Cell.B2,Cell.B5) && logic.move(Cell.B5,Cell.D7);
        assertThat(result, is(true));
    }

    @Test
    public void whenKingInOneStepThenTrue() {
        Logic logic = new Logic();
        logic.add(new KingWhite(Cell.E1));
        boolean result = logic.move(Cell.E1,Cell.E2) && logic.move(Cell.E2,Cell.F1);
        assertThat(result, is(true));
    }

    @Test
    public void whenKnightInKnigthWayThenTrue() {
        Logic logic = new Logic();
        logic.add(new KnightWhite(Cell.B1));
        boolean result = logic.move(Cell.B1,Cell.D2);
        assertThat(result, is(true));
    }


}