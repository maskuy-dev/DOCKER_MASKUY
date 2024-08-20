package msiwms.config;

import msiwms.lib.dto.DefaultDtoResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "msiwms")
public class MsismsApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MsismsApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MsismsApplication.class, args);
    }

}
