package microservices.book.socialmultiplication.multiplication.service;

import microservices.book.socialmultiplication.multiplication.domain.Multiplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiplicationServiceTest {

    @MockBean
    private RandomGeneratorService randomGeneratorService;

    @Autowired
    MultiplicationService multiplicationService;

    @Test
    public void createRandomMultiplicationTest() {

        // given (our mocked Random Generator service will return first 50, then 30)
        /*given(randomGeneratorService.generateRandomFactor()).willReturn(5, 3);
        // when
        Multiplication multiplication = multiplicationService.createRandomMultiplication();
        // then
        assertThat(multiplication.getFactorA()).isEqualTo(5);
        assertThat(multiplication.getFactorB()).isEqualTo(3);
        //assertThat(multiplication.getResult()).isEqualTo(15);
        System.out.println(randomGeneratorService.generateRandomFactor());
        List<Integer> randomFactors = IntStream.range(1,5).boxed().collect(Collectors.toList());
        System.out.println(randomFactors);*/
    }

    @Test
    public void generateRandomFactorIsBetweenExpectedLimits() throws Exception {
        /*// when a good sample of randomly generated factors is generated
        List<Integer> randomFactors = IntStream.range(0, 1000)
                .map(i -> randomGeneratorService.generateRandomFactor())
                .boxed().collect(Collectors.toList());
        //System.out.println(randomFactors);
        // then all of them should be between 11 and 100 // because we want a middle-complexity calculation

        assertThat(randomFactors).containsOnlyElementsOf (IntStream.range(11, 100).boxed().collect(Collectors.toList()));*/
    }



}
