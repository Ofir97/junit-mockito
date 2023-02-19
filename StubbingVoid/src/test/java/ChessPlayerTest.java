import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.spy;

public class ChessPlayerTest {

    @Test
    public void testAssignCategorySpy() throws Exception {
        ChessPlayer chessPlayerSpy = spy(new ChessPlayer("Magnus", 30));
        doNothing().when(chessPlayerSpy).assignCategory(); // do nothing when chessPlayerSpy.assignCategory() is called
        chessPlayerSpy.assignCategory();

        assertNull(chessPlayerSpy.getCategory());
    }

    @Test
    public void testAssignCategoryMockReturnsNull() throws Exception {
        ChessPlayer chessPlayerMock = mock(ChessPlayer.class);

        when(chessPlayerMock.getAge()).thenReturn(30);
        chessPlayerMock.assignCategory();

        assertNull(chessPlayerMock.getCategory());
    }

    @Test
    public void testAssignCategoryMock() throws Exception {
        ChessPlayer chessPlayerMock = mock(ChessPlayer.class);

        when(chessPlayerMock.getAge()).thenReturn(10);
        doCallRealMethod().when(chessPlayerMock).assignCategory(); // calls real method even with mocked object
        doCallRealMethod().when(chessPlayerMock).getCategory(); // calls real method even with mocked object

        chessPlayerMock.assignCategory();

        assertEquals("Under 18's", chessPlayerMock.getCategory());
    }

    @Test
    public void testAssignCategoryMockException() throws Exception {
        ChessPlayer chessPlayerMock = mock(ChessPlayer.class);
        doThrow(Exception.class).when(chessPlayerMock).assignCategory(); // calls real method even with mocked object
        assertThrows(Exception.class, () -> chessPlayerMock.assignCategory());
    }

    @Test
    public void testAssignScoreStats() {
        ChessPlayer chessPlayerSpy = spy(new ChessPlayer("Magnus", 30));

        doAnswer((chessP) -> {
            ChessPlayer player = (ChessPlayer)chessP.getMock();
            player.setWins(3);
            player.setPoints(9);
            return null;
        }).when(chessPlayerSpy).assignScoreStats();

        chessPlayerSpy.assignScoreStats();

        assertSame(3, chessPlayerSpy.getWins());
        assertSame(9, chessPlayerSpy.getPoints());

    }

}