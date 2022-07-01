package controller.user;

import static org.assertj.core.api.Assertions.assertThat;
import com.forlizzi.medication.MedDb;
import com.forlizzi.medication.entity.user.UserMedList;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import support.CreateUserMedListTestSupport;

@Nested
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes={MedDb.class})
@ActiveProfiles("test")
@Sql(scripts = {
        "classpath:flyway/migrations/V1.0__Medication_Schema.sql",
        "classpath:flyway/migrations/V1.1__Medication_Data.sql"},
        config = @SqlConfig(encoding = "utf-8"))
public class CreateUserMedListTest extends CreateUserMedListTestSupport {

    @Test
    void testCreateUserReturnsSuccess201() {
//        Given: a med list as JSON
        String body = createMedListBody();
        String uri = getBaseUriForUserMedList();
        HttpEntity<String> bodyEntity = new HttpEntity<>(body);

//        When: the med list is sent
        ResponseEntity<userMedList> = getRestTemplate().exchange(uri, HttpMethod.POST, bodyEntity, UserMedList.class);

//        Then: a 201 status is returned
    assertThat(response.getStatusCode()), isEqualTo(HttpStatus.CREATED);

//        And: the returned med list

    }

}
