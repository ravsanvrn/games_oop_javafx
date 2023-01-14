package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {

    @Test
    public void whenPositionIsValid() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        assertThat(bishopBlack.position()).isEqualTo(Cell.C8);
    }

    @Test
    public void whenCopyIsValid() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] rsl = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    public void whenCopyIsNotDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            bishopBlack.way(Cell.C2);
        });
        String expected = "Could not move by diagonal from C1 to C2";
        assertThat(exception.getMessage()).isEqualTo(expected);
    }
}