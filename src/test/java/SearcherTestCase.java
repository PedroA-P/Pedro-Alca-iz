import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;

import com.introsoftware.*;
public class SearcherTestCase {
    public Searcher searcher;
    @BeforeEach
    public void setUp() {
        searcher = new Searcher();
    }
    @Test
    void searchWordExistsTest() {
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        assertEquals(true, searcher.searchWord("banana", list));
    }
    @Test 
    void searchWordNotExistsTest() {
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        assertEquals(false, searcher.searchWord("grape", list));
    }
    @Test
    void getWordByIndexValidTest() {
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        assertEquals("banana", searcher.getWordByIndex(list, 1));
    }
    @Test 
    void getWordByIndexInvalidTest() {
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        assertEquals(null, searcher.getWordByIndex(list, 5));
    }
    @Test 
    void searchByPrefixTest() {
        List<String> list = Arrays.asList("apple", "banana", "apricot", "cherry");
        List<String> expected = Arrays.asList("apple", "apricot");
        assertEquals(expected, searcher.searchByPrefix("ap", list));
    }
    @Test
    void searchByPrefixNoMatchTest() {
        List<String> list = Arrays.asList("apple", "banana", "apricot", "cherry");
        List<String> expected = Collections.emptyList();
        assertEquals(expected, searcher.searchByPrefix("gr", list));
    }
    @Test
    void filterByKeywordTest() {
        List<String> list = Arrays.asList("apple pie", "banana split", "cherry tart", "apple turnover");
        List<String> expected = Arrays.asList("apple pie", "apple turnover");
        assertEquals(expected, searcher.filterByKeyword("apple", list));
    }
    @Test
    void filterByKeywordNoMatchTest() {
        List<String> list = Arrays.asList("apple pie", "banana split", "cherry tart", "apple turnover");
        List<String> expected = Collections.emptyList();
        assertEquals(expected, searcher.filterByKeyword("grape", list));
    }
       @Test
    public void searchExactPhraseFindsFirstElement() {

        List<String> words = Arrays.asList(
                "hola mundo",
                "curso java",
                "programacion"
        );

        boolean result =
                searcher.searchExactPhrase("hola mundo", words);

        assertTrue(result);
    }
    @Test
    void searchExactPhraseNotExistsTest() {
        List<String> list = Arrays.asList("apple pie", "banana split", "cherry tart");
        assertEquals(false, searcher.searchExactPhrase("grape tart", list));
    }
}
