package Service.Impls;

import Service.BoardService;
import Service.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IterativeStatusCheckImplTest {

    private IterativeStatusCheckImpl iterativeStatusCheckImplUnderTest;

    @BeforeEach
    void setUp() {
        iterativeStatusCheckImplUnderTest = new IterativeStatusCheckImpl();
        iterativeStatusCheckImplUnderTest.boardService = mock(BoardService.class);
        iterativeStatusCheckImplUnderTest.playerService = mock(PlayerService.class);
    }

    @Test
    void testCheckHorizontal() {
        // Setup
        int bd[][] = {{1,1,1,1,1},
                {1,1,1,0,0},
                {1,2,1,0,0},
                {1,2,1,1,0},
                {2,2,1,0,1}
        };
        for(int i = 0; i < 5; i++) {
            when(iterativeStatusCheckImplUnderTest.boardService.getVal(0, i)).thenReturn(bd[0][i]);
        }
        when(iterativeStatusCheckImplUnderTest.playerService.getCurrPlayerId()).thenReturn(1);

        // Run the test
        final boolean result = iterativeStatusCheckImplUnderTest.checkHorizontal(0, 0);

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testCheckVertical() {
        // Setup
        int bd[][] = {{1,2,1,0,0},
                {1,1,1,0,0},
                {1,2,1,0,0},
                {1,2,1,1,0},
                {1,2,1,0,1}
        };
        for(int i = 0; i < 5; i++) {
            when(iterativeStatusCheckImplUnderTest.boardService.getVal(i, 0)).thenReturn(bd[i][0]);
        }
        when(iterativeStatusCheckImplUnderTest.playerService.getCurrPlayerId()).thenReturn(1);

        // Run the test
        final boolean result = iterativeStatusCheckImplUnderTest.checkVertical(0, 0);

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testCheckDiagonal() {
        // Setup
        int bd[][] = {{1,2,1,0,0},
                {1,1,1,0,0},
                {1,2,1,0,0},
                {1,2,1,1,0},
                {1,2,1,0,1}
        };
        for(int i = 0; i < 5; i++) {
            when(iterativeStatusCheckImplUnderTest.boardService.getVal(i, i)).thenReturn(bd[i][i]);
        }
        when(iterativeStatusCheckImplUnderTest.playerService.getCurrPlayerId()).thenReturn(1);

        // Run the test
        final boolean result = iterativeStatusCheckImplUnderTest.checkDiagonal(0, 0);

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testCheckInvertedDiagonal() {
        // Setup
        int bd[][] = {  {1,2,1,0,1},
                        {1,1,1,1,0},
                        {1,2,1,0,0},
                        {1,1,1,1,0},
                        {1,2,1,0,1}
        };
        int x = 4;
        int y = 0;
        for(int i = 1; i < 5; i++){
            when(iterativeStatusCheckImplUnderTest.boardService.getVal(x-i, y+i)).thenReturn(bd[x-i][y+1]);
        }
        when(iterativeStatusCheckImplUnderTest.playerService.getCurrPlayerId()).thenReturn(1);

        // Run the test
        final boolean result = iterativeStatusCheckImplUnderTest.checkInvertedDiagonal(4, 0);

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testCheckWinner() {
        // Setup
        int bd[][] = {{1,2,1,0,0},
                {1,1,1,0,0},
                {1,2,1,0,0},
                {1,2,1,1,0},
                {1,2,1,0,1}
        };
        for(int i = 0; i < 5; i++) {
            when(iterativeStatusCheckImplUnderTest.boardService.getVal(i, i)).thenReturn(bd[i][i]);
        }
        when(iterativeStatusCheckImplUnderTest.playerService.getCurrPlayerId()).thenReturn(1);

        // Run the test
        final boolean result = iterativeStatusCheckImplUnderTest.checkWinner(0, 0);

        // Verify the results
        assertTrue(result);
    }

}
