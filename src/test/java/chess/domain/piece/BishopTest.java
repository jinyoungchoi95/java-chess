package chess.domain.piece;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class BishopTest {

    @ParameterizedTest
    @EnumSource(Color.class)
    @DisplayName("비숍 기물 생성")
    void createBishop(Color color) {
        Piece bishop = new Bishop(color);
        assertThat(bishop).isInstanceOf(Bishop.class);
    }
}
