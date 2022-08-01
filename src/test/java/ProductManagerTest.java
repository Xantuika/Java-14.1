
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import productManager.ProductManager;
import productRepository.ProductRepository;
import products.Book;
import products.Product;
import products.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product product1 = new Book(1, "Метель", 100, "Гоголь");
    Product product2 = new Book(2, "Цветы", 200, "Некрасов");
    Product product3 = new Smartphone(3, "Iphone12", 400, "Apple");
    Product product4 = new Smartphone(4, "Iphone13", 800, "Apple");


    @Test
    public void addNewProduct() {
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = manager.getProducts();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void deleteProduct() {
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.removeById(2);
        Product[] expected = {product1, product3, product4};
        Product[] actual = manager.getProducts();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void searchProduct() {
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);

        Product[] expected = {product3};
        Product[] actual = manager.searchBy("Iphone12");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchТonexistentProduct() {
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Руслан и Людмила");
        assertArrayEquals(expected, actual);
    }

   @Test
           public void searchSimilarTitles (){
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product product1 = new Book(1, "Метель", 100, "Гоголь");
    Product product2 = new Book(2, "Метель", 200, "Некрасов");
    Product product3 = new Smartphone(3, "Iphone12", 400, "Apple");
    Product product4 = new Smartphone(4, "Iphone13", 800, "Apple");

           manager.addProduct(product1);
           manager.addProduct(product2);
           manager.addProduct(product3);
           manager.addProduct(product4);
           Product[] expected = {product1, product2};
           Product[] actual = manager.searchBy("Метель");
           assertArrayEquals(expected, actual);
       }
}