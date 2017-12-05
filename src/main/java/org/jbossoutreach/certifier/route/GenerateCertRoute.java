package org.jbossoutreach.certifier.route;

import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import org.jbossoutreach.certifier.model.Student;
import org.jbossoutreach.certifier.service.CertManager;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class GenerateCertRoute implements Route {
    private final CertManager certManager;

    public GenerateCertRoute(CertManager certManager) {
        this.certManager = certManager;
    }

    @Override
    public void setup(Router router) {
        router.route("/generateCert*").handler(BodyHandler.create());
        router.post("/generateCert").handler(this::generateCert);
    }

    private void generateCert(RoutingContext routingContext) {
        final Map<String, String> params = parseQuery(routingContext.getBodyAsString());
        final Student student = new Student(
                params.get("name"),
                params.get("email"),
                params.get("title")
        );

        final String outPath = certManager.generateCert(student);
        routingContext.response().sendFile(outPath);
    }

    private static Map<String, String> parseQuery(String query) {
        final String[] parameters = query.split("&");
        return Arrays.stream(parameters)
                .map(pair -> pair.split("="))
                .collect(Collectors.toMap(input -> input[0], input -> input[1]));
    }
}
