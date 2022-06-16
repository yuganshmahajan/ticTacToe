package Service.Impls;

import modals.Board;
import modals.Move;
import modals.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class IterativeStatusCheckImplTest {

    @Mock
    private Board mockBoard;
    @Mock
    private Player mockCurrPlayer;

    private IterativeStatusCheckImpl iterativeStatusCheckImplUnderTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        iterativeStatusCheckImplUnderTest = new IterativeStatusCheckImpl(mockBoard, mockCurrPlayer);
    }

    @Test
    void testCheckDiagonal_success() {
        // Setup
        int bd[][] = {{1,2,1,0,0},
                {1,1,1,0,0},
                {1,2,1,0,0},
                {1,2,1,1,0},
                {1,2,1,0,1}
        };
        when(mockBoard.getBoard()).thenReturn(bd);
        when(mockBoard.getRow()).thenReturn(5);
        when(mockBoard.getCol()).thenReturn(5);
        when(mockCurrPlayer.getPlayerId()).thenReturn(1);

        // Run the test
        final boolean result = iterativeStatusCheckImplUnderTest.checkDiagonal(new Move(0,0));

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testCheckHorizontal_success() {
        // Setup
        int bd[][] = {{1,2,1,0,0},
                {1,1,1,1,1},
                {1,2,1,0,0},
                {1,2,1,1,0},
                {2,2,1,0,2}
        };
        when(mockBoard.getBoard()).thenReturn(bd);
        when(mockBoard.getRow()).thenReturn(5);
        when(mockBoard.getCol()).thenReturn(5);
        when(mockCurrPlayer.getPlayerId()).thenReturn(1);

        // Run the test
        final boolean result = iterativeStatusCheckImplUnderTest.checkHorizontal(new Move(1,0));

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testCheckVertical_success() {
        // Setup
        int bd[][] = {{1,2,1,0,0},
                {1,1,1,1,0},
                {1,2,1,0,0},
                {1,2,1,1,0},
                {1,2,1,0,2}
        };
        when(mockBoard.getBoard()).thenReturn(bd);
        when(mockBoard.getRow()).thenReturn(5);
        when(mockBoard.getCol()).thenReturn(5);
        when(mockCurrPlayer.getPlayerId()).thenReturn(1);

        // Run the test
        final boolean result = iterativeStatusCheckImplUnderTest.checkVertical(new Move(0,0));

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testCheckInvertedDiagonal() {
        // Setup
        int bd[][] = {{1,2,1,0,1},
                {1,1,1,1,0},
                {1,2,1,0,0},
                {1,1,1,1,0},
                {1,2,1,0,2}
        };
        when(mockBoard.getBoard()).thenReturn(bd);
        when(mockBoard.getRow()).thenReturn(5);
        when(mockBoard.getCol()).thenReturn(5);
        when(mockCurrPlayer.getPlayerId()).thenReturn(1);

        // Run the test
        final boolean result = iterativeStatusCheckImplUnderTest.checkInvertedDiagonal(new Move(4,0));

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testCheckWinner() {
        // Setup
        int bd[][] = {{1,2,1,0,1},
                {1,1,1,1,0},
                {1,2,1,0,0},
                {1,1,1,1,0},
                {1,2,1,0,2}
        };
        when(mockBoard.getBoard()).thenReturn(bd);
        when(mockBoard.getRow()).thenReturn(5);
        when(mockBoard.getCol()).thenReturn(5);
        when(mockCurrPlayer.getPlayerId()).thenReturn(1);

        // Run the test
        final boolean result = iterativeStatusCheckImplUnderTest.checkWinner(new Move(4,0));

        // Verify the results
        assertTrue(result);
    }
}
