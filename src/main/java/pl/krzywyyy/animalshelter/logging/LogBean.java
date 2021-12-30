package pl.krzywyyy.animalshelter.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LogBean {
    @Bean
    public Logger logger(InjectionPoint injectionPoint) {
        return LogManager.getLogger(
                injectionPoint
                        .getMember()
                        .getDeclaringClass()
                        .getName()
        );
    }
}
