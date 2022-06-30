package support;

import com.forlizzi.medication.entity.Reaction;
import com.forlizzi.medication.entity.ReactionSeverity;

import java.util.LinkedList;
import java.util.List;

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

        return list;
    }

}