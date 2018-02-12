package edu.kit.informatik;


import org.junit.Test;

//import static org.junit.Assert.*; Für JUnit4

import edu.kit.informatik.Terminal;
import edu.kit.informatik.input.parsing.InputParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class BoardTest {

    private void testFromFile(final String input, final String expectedOutput) {
        try {
            String[] in = Terminal.readFile(input);
			
            if (!in[in.length - 1].equals("quit")) {
                PrintWriter out = new PrintWriter(new FileWriter(input, true), true);
                out.println("quit");
                out.close();
            }
            Terminal.setReader(input);
			String type = Terminal.readLine();
            String dimension = Terminal.readLine();
            String playerCount = Terminal.readLine();
			
            InputParser.main(new String[]{type, dimension, playerCount});//Hier durch eigene Main methode ersetzen

            String[] got = Terminal.readFile("output.txt");
            String[] expected = Terminal.readFile(expectedOutput);
            Assertions.assertArrayEquals(expected, got); // assertArrayEquals(expected, got); für JUnit4
        } catch (AssertionError | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                PrintWriter writer = new PrintWriter("output.txt");
                writer.print("");
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test1() {
        testFromFile("InputTest.txt", "outTest1.txt");
    }

    @Test
    public void test2() {
        TestFromFile("Test2.txt", "outTest2.txt");
    }
}
