package user.controller;

import com.forlizzi.medication.MedDb;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import support.FetchUserTestSupport;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes={MedDb.class})
public class FetchUserTest extends FetchUserTestSupport {

    @Test
    void testThatUserIsReturnedWhenAValidPseudoNameIsSupplied() {
//        Given: a valid pseudoName and URI



//        When: a connection is made to the URI

//        Then: a success (OK -200) status code is returned
    }
}