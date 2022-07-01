package support;

import com.forlizzi.medication.entity.Reaction;
import com.forlizzi.medication.entity.ReactionSeverity;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class FetchReactionTestSupport extends BaseTest {
    protected List<Reaction> buildExpected() {
        List<Reaction> list = new LinkedList<Reaction>();

//        @formatter:off
        list.add(Reaction.builder()
                .severity(ReactionSeverity.MILD)
                .reaction("xerostomia")
                .build());
        list.add(Reaction.builder()
                .severity(ReactionSeverity.SEVERE)
                .reaction("tardive dyskinesia")
                .build());
//        @formatter:on

        Collections.sort(list);
        return list;
    }

    protected void assertErrorMessageValid(Map<String, Object> error, HttpStatus status) {
        // @formatter:off
        assertThat(error)
                .containsKey("message")
                .containsEntry("status code", status.value())
                .containsEntry("uri", "/reactions")
                .containsKey("timestamp")
                .containsEntry("reason", status.getReasonPhrase());
        // @formatter:on
    }

}