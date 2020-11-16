package mandrews.magnificent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        String version = "";
        String termsOfServiceUrl = "";
        Contact contact = null;
        String license = "";
        String licenseUrl = "";
        List<VendorExtension> vendorExtensions = new ArrayList<>();

        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("mandrews.magnificent"))
                .paths(PathSelectors.any()).build()
                .pathMapping("/")
                .apiInfo(new ApiInfo("Magnificent API",
                        "API for Magnificent project created by Michael Andrews",
                        version, termsOfServiceUrl, contact, license, licenseUrl, vendorExtensions));
    }
}
