

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.introsoftware.model.Article;
import com.introsoftware.model.Order;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    public void testGetGrossTotal() {

        Article article1 = new Article("Teclado", 2, 50.0, 20);
        Article article2 = new Article("Raton", 1, 30.0, 10);

        List<Article> articles = Arrays.asList(article1, article2);

        Order order = new Order("PEDIDO-1", articles);

        double resultado = order.getGrossTotal();

        assertEquals(130.0, resultado, 0.001);
    }

    @Test
    public void testGetDiscountedTotal() {

        Article article1 = new Article("Teclado", 2, 50.0, 20);
        Article article2 = new Article("Raton", 1, 30.0, 10);

        List<Article> articles = Arrays.asList(article1, article2);

        Order order = new Order("PEDIDO-1", articles);

        double resultado = order.getDiscountedTotal();

        assertEquals(107.0, resultado, 0.001);
    }
}
    

