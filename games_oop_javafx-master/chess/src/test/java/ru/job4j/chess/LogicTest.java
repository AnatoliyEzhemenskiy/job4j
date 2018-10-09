package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
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