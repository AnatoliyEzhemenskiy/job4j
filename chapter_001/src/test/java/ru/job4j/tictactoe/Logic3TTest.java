package ru.job4j.tictactoe;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Logic3TTest {
    @Test
    public void whenHasXWinner() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(false), new Figure3T(false)},
                {new Figure3T(false), new Figure3T(true), new Figure3T(false)},
                {new Figure3T(false), new Figure3T(false), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(true));
    }
    @Test
    public void whenHasXHorizontalWinner() {
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(false), new Figure3T(false)},
                {new Figure3T(true), new Figure3T(true), new Figure3T(true)},
                {new Figure3T(false), new Figure3T(false), new Figure3T(false)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(true));
    }
    @Test
    public void whenHasXXHorizontalWinner() {
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(false), new Figure3T(false)},
                {new Figure3T(false), new Figure3T(false), new Figure3T(false)},
                {new Figure3T(true), new Figure3T(true), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(true));
    }


    @Test
    public void whenHasXVerticalWinner() {
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(true), new Figure3T(false)},
                {new Figure3T(false), new Figure3T(true), new Figure3T(false)},
                {new Figure3T(false), new Figure3T(true), new Figure3T(false)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(true));
    }

    @Test
    public void whenHasXBackDiagonalWinner() {
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(false), new Figure3T(true)},
                {new Figure3T(false), new Figure3T(true), new Figure3T(false)},
                {new Figure3T(true), new Figure3T(false), new Figure3T(false)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(true));
    }



}