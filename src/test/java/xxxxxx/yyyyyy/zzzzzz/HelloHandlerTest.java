package xxxxxx.yyyyyy.zzzzzz;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.web.reactive.server.WebTestClient;

public class HelloHandlerTest {
    private ConfigurableApplicationContext context;
    private WebTestClient testClient;

    @Before
    public void setUp() throws Exception {
        this.context = App.app.run();
        this.testClient = WebTestClient.bindToServer().baseUrl("http://localhost:8080").build();
    }

    @Test
    public void testHello() throws Exception {
        this.testClient.get()
                .uri("/") //
                .exchange() //
                .expectStatus().isOk() //
                .expectBody(String.class).isEqualTo("Hello World!");
    }

    @After
    public void tearDown() {
        this.context.close();
    }
}
