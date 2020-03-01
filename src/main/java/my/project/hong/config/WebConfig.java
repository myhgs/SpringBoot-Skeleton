package my.project.hong.config;

import my.project.hong.model.code.CommonConst;
import my.project.hong.web.interceptor.AccessInterceptor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Validator;
import java.io.IOException;


@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final Logger LOG = LoggerFactory.getLogger(WebConfig.class);

    private final AccessInterceptor accessInterceptor;

    @Autowired
    public WebConfig(AccessInterceptor accessInterceptor) {
        this.accessInterceptor = accessInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessInterceptor).addPathPatterns(CommonConst.URL_ROOT);
    }

    @Bean
    public Validator validator(){
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor(){
        MethodValidationPostProcessor processor = new MethodValidationPostProcessor();
        processor.setValidator(validator());
        return processor;
    }

    @Bean
    public Document getJsoup(){
        String URL = "https://eomisae.co.kr/index.php?mid=os&page=1";
        try {
            return Jsoup.connect(URL).get();
        } catch (IOException e) {

            return null;
        }
    }
}
