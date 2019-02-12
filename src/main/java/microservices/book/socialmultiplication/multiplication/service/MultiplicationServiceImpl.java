package microservices.book.socialmultiplication.multiplication.service;


import lombok.extern.log4j.Log4j2;
import microservices.book.socialmultiplication.multiplication.domain.Multiplication;
import microservices.book.socialmultiplication.multiplication.domain.MultiplicationResultAttempt;
import microservices.book.socialmultiplication.multiplication.domain.User;
import microservices.book.socialmultiplication.multiplication.repository.MultiplicationResultAttemptRepository;
import microservices.book.socialmultiplication.multiplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
class MultiplicationServiceImpl implements MultiplicationService{

    private RandomGeneratorService randomGeneratorService;
    private MultiplicationResultAttemptRepository attemptRepository;
    private UserRepository userRepository;

    @Autowired
    public MultiplicationServiceImpl(final RandomGeneratorService randomGeneratorService,
                                     final MultiplicationResultAttemptRepository attemptRepository,
                                     final UserRepository userRepository) {
        this.randomGeneratorService = randomGeneratorService;
        this.attemptRepository = attemptRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = randomGeneratorService.generateRandomFactor();
        int factorB = randomGeneratorService.generateRandomFactor();
        return new Multiplication(factorA, factorB);
    }

    @Transactional
    @Override
    public boolean checkAttempt(final MultiplicationResultAttempt resultAttempt) {

        /*Optional<User> user = userRepository.findByAlias(resultAttempt.getUser().getAlias());
        if (user.isPresent()){
            List<MultiplicationResultAttempt> db = attemptRepository.findByUser(user.get());
            for (MultiplicationResultAttempt m: db){
                if (m.getMultiplication().getFactorA() ==resultAttempt.getMultiplication().getFactorA() &&
                m.getMultiplication().getFactorB() == resultAttempt.getMultiplication().getFactorB()){
                    log.info("ada yang sama");
                }
            }
        }*/

        boolean correct = (
                resultAttempt.getResultAttempt() ==
                resultAttempt.getMultiplication().getFactorA() * resultAttempt.getMultiplication().getFactorB());
        // Avoids 'hack' attempts
        Assert.isTrue(!resultAttempt.isCorrect(), "You can't send an attempt marked as correct!!");
        // Creates a copy, now setting the 'correct' field accordingly

        MultiplicationResultAttempt checkedAttempt = new MultiplicationResultAttempt(resultAttempt.getUser(),resultAttempt.getMultiplication(),resultAttempt.getResultAttempt(),correct);
        attemptRepository.save(checkedAttempt);
        /*if (!user.isPresent()){
            log.info("user sudah ada");
        }*/

        return correct;
    }

    @Override
    public List<MultiplicationResultAttempt> getStatsForUser(String userAlias) {
        return attemptRepository.findTop5ByUserAliasOrderByIdDesc(userAlias);
    }

    @Override
    public List<MultiplicationResultAttempt> getAll() {
        return attemptRepository.findAll();
    }

}
