package reaction.controller;

import com.forlizzi.medication.MedDb;
import com.forlizzi.medication.entity.ReactionSeverity;
import com.forlizzi.medication.entity.Reaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import support.FetchReactionTestSupport;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes={MedDb.class})
@ActiveProfiles("test")
@Sql(scripts = {
        "classpath:flyway/migrations/V1.0__Medication_Schema.sql",
        "classpath:flyway/migrations/V1.1__Medication_Data.sql"},
        config = @SqlConfig(encoding = "utf-8"))
class FetchReactionTest extends FetchReactionTestSupport {

    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private int serverPort;

    @Test
    void testThatAValidReactionsIsReturnedWhenAValidSeverityIsSupplied() {
//        Given: a valid severity and reaction
        ReactionSeverity severity = ReactionSeverity.SEVERE;
        String reaction = "Laryngospasm";
        String uri = String.format(
                "http://localhost:%d/reactions?severity=%s&reaction=%s", serverPort, severity, reaction);

//        When: a connection is made to the URI
        ResponseEntity<Reaction> response = restTemplate.exchange(
                uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});

//        Then: a success (OK -200) status code is returned
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

//        And: the actual list returned is the same as the expected list
//        List<Reaction> actual = response.getBody();
        List<Reaction> expected = buildExpected();

        assertThat(response.getBody()).isEqualTo(expected);
    }

}