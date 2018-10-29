package xxxxxx.yyyyyy.zzzzzz;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.hamcrest.Matchers.is;

public class MessageHandlerTest {
    private ConfigurableApplicationContext context;
    private WebTestClient testClient;

    @Before
    public void setUp() throws Exception {
        this.context = App.app.run();
        this.testClient = WebTestClient.bindToServer().baseUrl("http://localhost:8080").build();
    }

    @Test
    public void testMessage() throws Exception {
        this.testClient.post()
                .uri("/messages") //
                .syncBody(new Message("Hello"))
                .exchange() //
                .expectStatus().isOk() //
                .expectBody(String.class).isEqualTo("{\"text\":\"Hello\"}");

        this.testClient.get()
                .uri("/messages") //
                .exchange() //
                .expectStatus().isOk() //
                .expectBody(String.class).isEqualTo("[{\"text\":\"Hello\"}]");
    }


    @Test
    public void testInvalidMessage() throws Exception {
        this.testClient.post()
                .uri("/messages") //
                .syncBody(new Message("HelloHello"))
                .exchange() //
                .expectStatus().isBadRequest() //
                .expectBody(JsonNode.class)
                .value(n -> n.get(0).get("defaultMessage").asText(),
                        is("The size of \"text\" must be less than or equal to 8. The given size is 10"));
    }

    @After
    public void tearDown() {
        this.context.close();
    }
}
