package productManager;

import productRepository.ProductRepository;
import products.Product;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void addProduct(Product product) {
        repository.save(product);
    }

    public void removeById (int id) {
        repository.removeById(id);
    }
    public Product[] getProducts() {
        return repository.getProducts();
    };
    public Product[] searchBy(String text) {
        Product[] result = new Product [0];
        for (Product product: repository.getProducts()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;

            }

        }
        return result;
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }
}
