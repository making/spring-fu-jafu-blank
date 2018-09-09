package xxxxxx.yyyyyy.zzzzzz;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.hamcrest.Matchers.is;

public class AppTest {
    private WebTestClient testClient;

    @Before
    public void setUp() throws Exception {
        RouterFunction<?> routes = App.routes();
        this.testClient = WebTestClient.bindToRouterFunction(routes).build();
    }

    @Test
    public void testHello() throws Exception {
        this.testClient.get()
                .uri("/") //
                .exchange() //
                .expectStatus().isOk() //
                .expectBody(String.class).isEqualTo("Hello World!");
    }

    @Test
    public void testMessage() throws Exception {
        this.testClient.post()
                .uri("/messages") //
                .syncBody(new Message("Hello"))
                .exchange() //
                .expectStatus().isOk() //
                .expectBody(String.class).isEqualTo("{\"text\":\"Hello\"}");
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
}
