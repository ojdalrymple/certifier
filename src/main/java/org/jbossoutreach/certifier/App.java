package org.jbossoutreach.certifier;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import java.awt.Desktop;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URI;
import java.net.URISyntaxException;

public class App extends AbstractVerticle {

    @Override
    public void start(Future<Void> future) throws Exception {

        // Create a router object.
        Router router = Router.router(vertx);

        // Serve static resources from the /assets directory
        router.route("/*").handler(StaticHandler.create("assets"));



        ServerSocket sock = new ServerSocket(0);
        int port = sock.getLocalPort();
        sock.close();

        vertx
                .createHttpServer()
                .requestHandler(router::accept)
                .listen(
                        config().getInteger("http.port", port),
                        result -> {
                            if (result.succeeded()) {
                                if(Desktop.isDesktopSupported())
                                {
                                    try {
                                        Desktop.getDesktop().browse(new URI("http://localhost:"+port));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    } catch (URISyntaxException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                );

    }

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new App());
    }

}