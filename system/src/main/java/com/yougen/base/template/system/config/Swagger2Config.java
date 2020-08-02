package com.yougen.base.template.system.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author yyg
 */
@Configuration
@EnableSwagger2
public class Swagger2Config{

	@Bean
	public Docket ProductApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.genericModelSubstitutes(DeferredResult.class)
				.useDefaultResponseMessages(false)
				.forCodeGeneration(false)
				.pathMapping("/baseTemplate")
				.select()
				.build()
				.apiInfo(productApiInfo());
	}

	private ApiInfo productApiInfo() {
		ApiInfo apiInfo = new ApiInfo("yougenBaseTemplate系统数据接口文档",
				"文档描述。。。",
				"1.0.0",
				"API TERMS URL",
				"联系人邮箱",
				"license",
				"license url");
		return apiInfo;
	}

}
