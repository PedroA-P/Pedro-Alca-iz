

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.introsoftware.model.Article;
import org.junit.jupiter.api.Test;

public class ArticleTest {

    @Test
    public void testGetGrossAmount() {
        Article article = new Article("Teclado", 2, 50.0, 20);

        double resultado = article.getGrossAmount();

        assertEquals(100.0, resultado, 0.001);
    }

    @Test
    public void testGetDiscountedAmount() {
        Article article = new Article("Teclado", 2, 50.0, 20);

        double resultado = article.getDiscountedAmount();

        assertEquals(80.0, resultado, 0.001);
    }
    
}