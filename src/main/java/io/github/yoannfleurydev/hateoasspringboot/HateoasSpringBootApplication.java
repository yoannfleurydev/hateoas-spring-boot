package io.github.yoannfleurydev.hateoasspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@PropertySource("classpath:META-INF/build-info.properties")
@EnableHypermediaSupport(type = {EnableHypermediaSupport.HypermediaType.HAL})
public class HateoasSpringBootApplication {
    public static void main(String[] args) {
		SpringApplication.run(HateoasSpringBootApplication.class, args);
	}
}
