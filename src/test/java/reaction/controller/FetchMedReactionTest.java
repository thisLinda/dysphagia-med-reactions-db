package reaction.controller;

import com.forlizzi.medication.MedDb;
import com.forlizzi.medication.entity.AdverseReaction;
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
import support.FetchMedReactionTestSupport;

import java.lang.reflect.Type;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes={MedDb.class})
class FetchMedReactionTest extends FetchMedReactionTestSupport {

    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private int serverPort;

    @Test
    void testThatAValidReactionsIsReturnedWhenAValidSeverityIsSupplied() {
//        Given: a valid severity and reaction
        AdverseReaction severity = AdverseReaction.SEVERE;
        String reaction = "Laryngospasm";
        String uri = String.format("%s?severity=%s&reaction=%s", serverPort, severity, reaction);

//        When: a connection is made to the URI
        ResponseEntity<List<Reaction>> response = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Reaction>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });

//        Then: a success (OK -200) status code is returned
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}