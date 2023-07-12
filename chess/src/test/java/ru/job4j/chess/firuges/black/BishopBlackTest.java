package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack test = new BishopBlack(Cell.A3);
        Cell expected = Cell.A3;
        assertThat(test.position()).isEqualTo(expected);
    }

    @Test
    public void copy() {
        BishopBlack test = new BishopBlack(Cell.A2);
        Cell expected = Cell.A3;
        Figure test2 = test.copy(Cell.A3);
        assertThat(test2.position()).isEqualTo(expected);
    }

    @Test
    public void testWay() {
        BishopBlack test = new BishopBlack(Cell.C1);
        Cell[] testArray = test.way(Cell.G5);
        Cell[] expectedArray = {Cell.D2, Cell.E3, Cell.F4, Cell.G5 };
        for (int i = 0; i < testArray.length; i++) {
            assertEquals(expectedArray[i], testArray[i]);
        }
    }

    @Test
    public void testWay2() throws ImpossibleMoveException {
        BishopBlack test = new BishopBlack(Cell.C1);
        try {
            test.way(Cell.G4);
            fail("Expected ImpossibleMoveException");
        } catch (ImpossibleMoveException thrown) {
            assertNotEquals("", thrown.getMessage());
        }
    }
}