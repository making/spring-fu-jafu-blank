package xxxxxx.yyyyyy.zzzzzz;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.codec.CodecCustomizer;
import org.springframework.fu.jafu.Jafu;
import org.springframework.http.codec.ServerSentEventHttpMessageWriter;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

public class App {
    static SpringApplication app = Jafu.application(app -> {
        app.beans(beans -> {
            beans.bean(HelloHandler.class);
            beans.bean(MessageHandler.class);
            beans.bean(ObjectMapper.class, () -> Jackson2ObjectMapperBuilder.json().build());
            beans.bean(CodecCustomizer.class, () -> configurer -> {
                // TODO should be provided as a part of DSL
                ObjectMapper mapper = app.ref(ObjectMapper.class);
                configurer.customCodecs().decoder(new Jackson2JsonDecoder(mapper));
                Jackson2JsonEncoder encoder = new Jackson2JsonEncoder(mapper);
                configurer.customCodecs().encoder(encoder);
                configurer.customCodecs().writer(new ServerSentEventHttpMessageWriter(encoder));
            });
        });
        app.server(server -> server.router(router -> {
            router //
                    .add(app.ref(HelloHandler.class).routes()) //
                    .add(app.ref(MessageHandler.class).routes());
        }));
    });

    public static void main(String[] args) {
        app.run(args);
    }
}
