package microservices.book.socialmultiplication.multiplication.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public final class Multiplication {

    @Id
    @GeneratedValue
    @Column(name = "multiplication_id")
    private Long id;

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
