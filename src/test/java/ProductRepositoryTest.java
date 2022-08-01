import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import productRepository.AlreadyExistsException;
import productRepository.NotFoundException;
import productRepository.ProductRepository;
import products.Book;
import products.Product;
import products.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    Product product1 = new Book(1, "Метель", 100, "Гоголь");
    Product product2 = new Book(2, "Цветы", 200, "Некрасов");
    Product product3 = new Smartphone(3, "Iphone12", 400, "Apple");
    Product product4 = new Smartphone(4, "Iphone13", 800, "Apple");

    @Test
    public void rememberAddedProductstest() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repo.getProducts();

        assertArrayEquals(expected, actual);
    }

   @Test
    public void deletById() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.removeById(2);

        Product[] expected = {product1, product3, product4};
        Product[] actual = repo.getProducts();

        assertArrayEquals(expected, actual);
    }
    @Test
    public void deletByNonexistentId() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);

        Product[] actual = repo.getProducts();

        assertThrows(NotFoundException.class, () -> {
            repo.removeById(8);
        });
    }

    @Test
    public void saveProductSameId() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(product1);
        });
    }

    @Test
    public void removeNonExistentById () {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(5);
        });
    }

}
