package mx.nic.service;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;

@OpenAPIDefinition(
    info = @Info(
            title = "mx-gradle-skel",
            version = "0.0"
    )
)
public class Application {

    @SuppressWarnings("resource")
	public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
