package ir.shop.online.commons.infrastructure.config;


import ir.shop.online.commons.domain.annotation.DomainMapper;
import ir.shop.online.commons.domain.annotation.UseCaseService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author Davood Akbari - 1404
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Configuration
@ComponentScan(
        basePackages = "ir.shop.online",
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        classes = {DomainMapper.class, UseCaseService.class}
                )
        }
)
public class AppConfig {
}
