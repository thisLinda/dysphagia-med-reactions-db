package support;

public class CreateUserMedListTestSupport extends BaseTest {
    protected String createUserMedListBody() {
        //    @formatter:off
        return "{\n"
                + " \"user\":\"ClaireRF\",\n "
                + " \"brand name\":\"haldol\"\n"
                + " ]\n"
                + "}";
//        @formatter:on
    }

}