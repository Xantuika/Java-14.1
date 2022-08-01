package productRepository;

public class NotFoundException extends RuntimeException {

    public NotFoundException (String msg) {
        super(msg);
    }
}

