package controller.reaction;

import com.forlizzi.medication.Constants;
import com.forlizzi.medication.MedDb;
import com.forlizzi.medication.entity.reaction.ReactionSeverity;
import com.forlizzi.medication.entity.reaction.Reaction;
import com.forlizzi.medication.service.reaction.ReactionService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import support.FetchReactionTestSupport;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doThrow;

class FetchReactionTest extends FetchReactionTestSupport {

    @Nested
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes={MedDb.class})
    @ActiveProfiles("test")
    @Sql(scripts = {
            "classpath:flyway/migrations/V1.0__Medication_Schema.sql",
            "classpath:flyway/migrations/V1.1__Medication_Data.sql"},
            config = @SqlConfig(encoding = "utf-8"))
    class TestsThatDoNotPolluteTheApplicationContext extends FetchReactionTestSupport {

        @Test
        void testThatAValidReactionIsReturnedWhenAValidSeverityIsSupplied() {
//        Given: a valid severity and reaction
            ReactionSeverity severity = ReactionSeverity.SEVERE;
            String reaction = "Laryngospasm";
            String uri = String.format("%s?severity=%s&reaction=%s",
                    getBaseUriForReactions(), severity, reaction);

//        When: a connection is made to the URI
            ResponseEntity<List<Reaction>> response = getRestTemplate().exchange(
                    uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                    });

//        Then: a success (OK -200) status code is returned
            assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

//        And: the actual list returned is the same as the expected list
            List<Reaction> actual = response.getBody();
            List<Reaction> expected = buildExpected();

//            assertThat(response.getBody()).isEqualTo(expected);
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        void testThatAnErrorMessageIsReturnedWhenAnUnknownReactionIsSupplied() {
//        Given: a valid severity and reaction
            ReactionSeverity severity = ReactionSeverity.SEVERE;
            String reaction = "Invalid Reaction";
            String uri = String.format("%s?severity=%s&reaction=%s",
                    getBaseUriForReactions(), severity, reaction);

//        When: a connection is made to the URI
            ResponseEntity<Map<String, Object>> response = getRestTemplate().exchange(
                    uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});

//        Then: a not found (404) status code is returned
            assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

//        And: an error message is returned
            Map<String, Object> error = response.getBody();

            assertErrorMessageValid(error, HttpStatus.NOT_FOUND);
        }

        @ParameterizedTest
        @MethodSource("package controller.reaction.FetchReactionTest#parametersForInvalidInput")
        void testThatAnErrorMessageIsReturnedWhenAnInvalidValueIsSupplied(String severity, String reaction, String reason) {
//        Given: a valid severity and reaction
            String uri = String.format("%s?severity=%s&reaction=%s",
                    getBaseUriForReactions(), severity, reaction);

//        When: a connection is made to the URI
            ResponseEntity<Map<String, Object>> response = getRestTemplate().exchange(
                    uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                    });

//        Then: a not found (404) status code is returned
            assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

//        And: an error message is returned
            Map<String, Object> error = response.getBody();

            assertErrorMessageValid(error, HttpStatus.BAD_REQUEST);
        }

    }

    static Stream<Arguments> parametersForInvalidInput() {
//          formatter:off
        return Stream.of(
                arguments("SEVERE", "@#$%%^*", "Reaction contains non-alpha-numberic characters"),
                arguments("SEVERE", "E".repeat(Constants.REACTION_MAX_LENGTH + 1), "Reaction length too long"),
                arguments("INVALID", "tardive dyskinesia", "Severity is not enum value")
//          formatter:on
        );
    }

    @Nested
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes={MedDb.class})
    @ActiveProfiles("test")
    @Sql(scripts = {
            "classpath:flyway/migrations/V1.0__Medication_Schema.sql",
            "classpath:flyway/migrations/V1.1__Medication_Data.sql"},
            config = @SqlConfig(encoding = "utf-8"))
    class TestsThatPolluteTheApplicationContext extends FetchReactionTestSupport {
        @MockBean
        private ReactionService reactionService;

        @Test
        void testThatAnUnplannedErrorResultsInA500Status() {
//        Given: a valid severity and reaction
            ReactionSeverity severity = ReactionSeverity.SEVERE;
            String reaction = "Invalid";
            String uri = String.format("%s?severity=%s&reaction=%s",
                    getBaseUriForReactions(), severity, reaction);

            doThrow(new RuntimeException("Ouch!")).when(reactionService).fetchReactions(severity, reaction);

//        When: a connection is made to the URI
            ResponseEntity<Map<String, Object>> response = getRestTemplate().exchange(
                    uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});

//        Then: an internal server error is returned
            assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);

//        And: an error message is returned
            Map<String, Object> error = response.getBody();

            assertErrorMessageValid(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}