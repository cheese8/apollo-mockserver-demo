package com.github;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.github" })
public class Bootstrap {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Bootstrap.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
