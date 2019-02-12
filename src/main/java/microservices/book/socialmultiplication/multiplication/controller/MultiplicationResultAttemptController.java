package microservices.book.socialmultiplication.multiplication.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import microservices.book.socialmultiplication.multiplication.domain.MultiplicationResultAttempt;
import microservices.book.socialmultiplication.multiplication.service.MultiplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
final class MultiplicationResultAttemptController {

    private final MultiplicationService multiplicationService;


    MultiplicationResultAttemptController(MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }

    @RequiredArgsConstructor
    @NoArgsConstructor(force = true)
    @Getter
    static final class ResultResponse {
        private final boolean correct;
    }

    @GetMapping
    ResponseEntity<List<MultiplicationResultAttempt >> getStatistics(@RequestParam("alias") String alias) {
        return ResponseEntity.ok( multiplicationService.getStatsForUser(alias)
        );
    }

    /*@GetMapping
    ResponseEntity<List<MultiplicationResultAttempt >> getAll() {
        return ResponseEntity.ok(
                multiplicationService.getAll()
        );
    }*/

    @PostMapping
    ResponseEntity<MultiplicationResultAttempt> postResult(@RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {
        boolean isCoorect = multiplicationService.checkAttempt(multiplicationResultAttempt);
        MultiplicationResultAttempt copy = new MultiplicationResultAttempt(
                multiplicationResultAttempt.getUser(),
                multiplicationResultAttempt.getMultiplication(),
                multiplicationResultAttempt.getResultAttempt(),
                isCoorect);
        return ResponseEntity.ok(copy);

        //return ResponseEntity.ok(new ResultResponse(multiplicationService.checkAttempt(multiplicationResultAttempt)));
    }

}
