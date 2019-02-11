package microservices.book.socialmultiplication.multiplication.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public final class Multiplication {

    private final int factorA;
    private final int factorB;

    Multiplication() { this(0, 0);
    }

    /*private final int result;

    public Multiplication(int factorA,int factorB){
        this.factorA = factorA;
        this.factorB = factorB;
        this.result = factorA * factorB;
    }

    public int getFactorA() {
        return factorA;
    }

    public int getFactorB() {
        return factorB;
    }

    public int getResult() {
        return result;
    }

    @Override
    public String toString(){
        return "Multiplication{" +
                "factorA= "+factorA +
                ",factorB= "+factorB +
                ",result(A*B)= "+result +
                '}';

    }*/

}
