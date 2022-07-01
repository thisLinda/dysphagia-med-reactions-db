package support;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

public class BaseTest {
    @LocalServerPort
    private int serverPort;

    @Autowired
    @Getter
    private TestRestTemplate restTemplate;

    protected String getBaseUriForUserMedList() {
        return String.format("http://localhost:%d/usermedlist", serverPort);
    }

    protected String getBaseUriForReactions() {
        return String.format("http://localhost:%d/reactions", serverPort);
    }
}