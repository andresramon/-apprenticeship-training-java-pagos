package org.cokaido.training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RoverTest{

    private static Stream<Arguments> argumentsMoveForward(){
        return Stream.of(
                Arguments.of("5 5\n0 1 N\nA\n", "0 2 N"),
                Arguments.of("5 5\n0 2 N\nA\n", "0 3 N")
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsMoveForward")
    public void shouldMoveForward(String command, String expectedPosition){
        final Rover rover = new Rover();

        String position = rover.execute(command);

        Assertions.assertEquals(expectedPosition, position);
    }
}
