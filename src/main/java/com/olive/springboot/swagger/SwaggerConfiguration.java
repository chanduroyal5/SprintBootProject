//package com.olive.springboot.swagger;
//
//import static springfox.documentation.builders.PathSelectors.regex;
//
//import java.util.Date;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.StopWatch;
//
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//
//@Configuration
//public class SwaggerConfiguration {
//
//    private final Logger log = LoggerFactory.getLogger(SwaggerConfiguration.class);
//
//    public static final String DEFAULT_INCLUDE_PATTERN = "/.*";
//    public static final String DEFAULT_INCLUDE_PATTERN_NONE = "/none";
//    private String title = "UPI API";
//
//    private String description = "UPI API documentation";
//
//    private String version = "0.0.1";
//
//    private String termsOfServiceUrl;
//
//    private String contact="bharavi";
//
//    private String license="License";
//
//    private String licenseUrl;
//    
//    @Autowired
//    Environment env;
//
//    
//    @Bean
//    Docket swaggerSpringfoxDocket() {
//        log.debug("Starting Swagger");
//        StopWatch watch = new StopWatch();
//        watch.start();
//        @SuppressWarnings("deprecation")
//		ApiInfo apiInfo = new ApiInfo(
//            title,
//            description,
//            version,
//            termsOfServiceUrl,
//            contact,
//            license,
//            licenseUrl);
//        
//        Docket docket = new Docket(DocumentationType.SWAGGER_2)
//            .apiInfo(apiInfo)
//            .genericModelSubstitutes(ResponseEntity.class)
//            .forCodeGeneration(true)
//            .genericModelSubstitutes(ResponseEntity.class)
//            .ignoredParameterTypes(Pageable.class)
//            .directModelSubstitute(java.time.LocalDate.class, String.class)
//            .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
//            .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
//            .select()
////            .paths(regex("Y".equals(env.getProperty("swagger.enable","Y")) ? DEFAULT_INCLUDE_PATTERN: DEFAULT_INCLUDE_PATTERN_NONE))
//            .build();
//        
//        watch.stop();
//        log.debug("Started Swagger in {} ms", watch.getTotalTimeMillis());
//        return docket;
//    }
//}
