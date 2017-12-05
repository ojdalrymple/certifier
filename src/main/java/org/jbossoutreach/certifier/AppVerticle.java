package org.jbossoutreach.certifier;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import org.jbossoutreach.certifier.route.Route;

import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class AppVerticle extends AbstractVerticle {
    private final List<Route> routes;

    public AppVerticle(List<Route> routes) {
        this.routes = routes;
    }

    @Override
    public void start() throws Exception {
        final Router router = Router.router(vertx);
        routes.forEach(route -> route.setup(router));

        final ServerSocket sock = new ServerSocket(0);
        final int port = sock.getLocalPort();
        sock.close();

        vertx.createHttpServer()
                .requestHandler(router::accept)
                .listen(
                        config().getInteger("http.port", port),
                        result -> {
                            if (!result.succeeded()
                                    || !Desktop.isDesktopSupported()) {
                                return;
                            }
                            try {
                                final URI uri = new URI("http://localhost:" + port);
                                Desktop.getDesktop().browse(uri);
                            } catch (URISyntaxException | IOException e) {
                                e.printStackTrace();
                            }
                        }
                );
    }
}
