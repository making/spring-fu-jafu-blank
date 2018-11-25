package xxxxxx.yyyyyy.zzzzzz;

import org.springframework.core.env.Profiles;
import org.springframework.fu.jafu.ApplicationDsl;

import static org.springframework.fu.jafu.ApplicationDsl.application;

public class App {

	static ApplicationDsl app = application(app -> app //
			.beans(beans -> beans //
					.bean(HelloHandler.class) //
					.bean(MessageHandler.class))
			.server(server -> server
					.port(app.env().acceptsProfiles(Profiles.of("test")) ? 8181 : 8080) //
					.router(router -> router //
							.add(app.ref(HelloHandler.class).routes()) //
							.add(app.ref(MessageHandler.class).routes())) //
					.codecs(codecs -> codecs.string().jackson())));

	public static void main(String[] args) {
		app.run(args);
	}
}
