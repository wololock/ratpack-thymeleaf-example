package app;

import ratpack.guice.Guice;
import ratpack.server.RatpackServer;
import ratpack.thymeleaf.ThymeleafModule;

import java.util.HashMap;

import static ratpack.thymeleaf.Template.thymeleafTemplate;

public final class RatpackApp {

    public static void main(String[] args) throws Exception {

        RatpackServer.start(server ->
                server.serverConfig(config -> config.findBaseDir())
                        .registry(Guice.registry(bindings -> bindings.module(ThymeleafModule.class)))
                        .handlers(chain -> chain.get(ctx -> ctx.render(thymeleafTemplate(new HashMap<String, Object>() {{
                            put("title", "Hello, Ratpack!");
                            put("header", "Hello, Ratpack!");
                            put("text", "This template got rendered using Thymeleaf");
                        }}, "home"))))
        );
    }
}
