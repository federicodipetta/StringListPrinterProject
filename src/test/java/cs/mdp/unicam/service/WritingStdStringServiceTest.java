package cs.mdp.unicam.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cs.mdp.unicam.console.watcher.AbstractConsoleWatcher;
import cs.mdp.unicam.console.watcher.SystemConsoleWatcher;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class WritingStdStringServiceTest extends TestCase
{
    public WritingStdStringServiceTest(String testName)
    {
        super(testName);
    }
    public static Test suite()
    {
        return new TestSuite(WritingStdStringServiceTest.class);
    }

    private AbstractWritingListService<String> getService() {
        return new WritingStdStringListService();
    }

    private AbstractConsoleWatcher getWatcher() {
        return new SystemConsoleWatcher();
    }

    private void assertOutputMatchesInput(List<String> input) {
        List<String> result = getWatcher().capture(() -> {
            getService().writeAll(input);
        });

        assertEquals("La dimensione dell'output deve coincidere con quella dell'input",
                input.size(), result.size());

        for (int i = 0; i < input.size(); i++) {
            assertEquals("Elemento diverso alla posizione " + i, input.get(i), result.get(i));
        }
    }

    public void testBasicalInput()
    {
        List<String> list = new ArrayList<>();
        list.add("Marco");
        list.add("Andrea");
        list.add("Fabio");

        assertOutputMatchesInput(list);
    }

    public void testEmptyList()
    {
        List<String> list = new ArrayList<>();

        List<String> result = getWatcher().capture(() -> {
            getService().writeAll(list);
        });

        assertNotNull("Il risultato non deve essere null", result);
        assertEquals("Una lista vuota non deve produrre output", 0, result.size());
    }

    public void testSingleElement()
    {
        List<String> list = new ArrayList<>();
        list.add("OnlyOne");

        assertOutputMatchesInput(list);
    }

    public void testDuplicateElementsArePreserved()
    {
        List<String> list = Arrays.asList(
                "Mario",
                "Mario",
                "Luigi",
                "Mario",
                "Luigi"
        );

        assertOutputMatchesInput(list);
    }

    public void testOrderIsPreserved()
    {
        List<String> list = Arrays.asList(
                "riga-1",
                "riga-2",
                "riga-3",
                "riga-4",
                "riga-5",
                "riga-6",
                "riga-7",
                "riga-8",
                "riga-9",
                "riga-10"
        );

        assertOutputMatchesInput(list);
    }

    public void testSpecialCharacters()
    {
        List<String> list = Arrays.asList(
                "!@#$%^&*()",
                "[]{}<>",
                ".,;:-_+=",
                "\"quoted\"",
                "'single-quoted'",
                "\\slash\\",
                "/forward/",
                "a=b && c!=d"
        );

        assertOutputMatchesInput(list);
    }

    public void testVeryLongString()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5000; i++) {
            sb.append("abc123");
        }

        List<String> list = Arrays.asList(
                "start",
                sb.toString(),
                "end"
        );

        assertOutputMatchesInput(list);
    }

    public void testMixedRealisticContent()
    {
        List<String> list = Arrays.asList(
                "Marco",
                "Andrea Rossi",
                "email@test.it",
                "123456",
                "riga con spazi interni",
                "Simboli: !?@#",
                "Accenti: àèìòù",
                "FINE"
        );

        assertOutputMatchesInput(list);
    }

    public void testInputListIsNotModified()
    {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        List<String> before = new ArrayList<>(list);

        getWatcher().capture(() -> {
            getService().writeAll(list);
        });

        assertEquals("La lista di input non deve essere modificata", before, list);
    }
}