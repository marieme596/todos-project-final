package sn.ept.git.seminaire.cicd.utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TestUtilTest {

    @Test
    void createByteArrayShouldReturnByteArrayWithCorrectSizeAndData() {
        // Arrange
        int size = 5;
        String data = "101010";

        // Act
        byte[] byteArray = TestUtil.createByteArray(size, data);

        // Assert
        byte[] expectedByteArray = { 42, 42, 42, 42, 42 };

        assertArrayEquals(expectedByteArray, byteArray);
    }
}
