package microservices.book.socialmultiplication.multiplication.service;

public interface RandomGeneratorService {

    /**
     *
     * @return randomly-generated factor. it always return between 11 and 99.
     */

    int generateRandomFactor();
}
