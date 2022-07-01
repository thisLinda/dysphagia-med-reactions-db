package support;

public class CreateUserMedListTestSupport extends BaseTest {
    protected String createMedListBody() {
//        need to have foreign keys (I think)!!!!
        //    @formatter:off
        return "{\n"
                + " \"user\":\"ClaireRF\",\n"
                + " \"brand name \":\"haldol\",\n"
                + " \"brand name \":\"pylera\",\n"
                + " \"brand name \":\"coumadin\",\n"
                + "   ]\n"
                + "}";
//        @formatter:on
    }

}