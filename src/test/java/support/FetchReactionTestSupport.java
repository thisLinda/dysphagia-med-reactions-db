package support;

import com.forlizzi.medication.entity.Reaction;

import java.util.LinkedList;
import java.util.List;

public class FetchReactionTestSupport extends BaseTest {
    protected List<Reaction> buildExpected() {
        List<Reaction> list = new LinkedList<Reaction>();

//        @formatter:off
        list.add(Reaction.builder()
                .reactionId(400)
                .severity("mild")
                .reaction("xerostomia")
                .build());
        list.add(Reaction.builder()
                .reactionId(406)
                .severity("severe")
                .reaction("tardive dyskinesia")
                .build());
//        @formatter:on

        return list;
    }

}

/*
INSERT INTO adverse_reactions (reaction_id, severity, reaction) VALUES(400, 'severe', 'tardive dyskinesia');
INSERT INTO adverse_reactions (reaction_id, severity, reaction) VALUES(400, 'severe', 'laryngospasm');
 */