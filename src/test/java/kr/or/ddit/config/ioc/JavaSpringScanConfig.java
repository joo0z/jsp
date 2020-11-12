package kr.or.ddit.config.ioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"kr.or.ddit.board"}) // member쪽 service나 dao를 만들지 않게
public class JavaSpringScanConfig {

}
