package com.kevin.sbtest.common.handler;

import java.lang.reflect.Method;

import com.kevin.sbtest.common.annotation.ApiVersion;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


public class ApiRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
	private int latestVersion = 1;

	@Override
	protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
		// 判断是否有@ApiVersion注解，构建基于@ApiVersion的RequestCondition
		ApiVersionRequestCondition condition = buildFrom(AnnotationUtils.findAnnotation(handlerType, ApiVersion.class));
		// 保存最大版本号
		if (condition != null && condition.getVersion() > latestVersion) {
			ApiVersionRequestCondition.setMaxVersion(condition.getVersion());
		}
		return condition;
	}

	@Override
	protected RequestCondition<?> getCustomMethodCondition(Method method) {
		// 判断是否有@ApiVersion注解，构建基于@ApiVersion的RequestCondition
		ApiVersionRequestCondition condition =  buildFrom(AnnotationUtils.findAnnotation(method, ApiVersion.class));
		// 保存最大版本号
		if (condition != null && condition.getVersion() > latestVersion) {
			ApiVersionRequestCondition.setMaxVersion(condition.getVersion());
		}
		return condition;
	}

	private ApiVersionRequestCondition buildFrom(ApiVersion apiVersion) {
		return apiVersion == null ? null : new ApiVersionRequestCondition(apiVersion.value());
	}
}
