package com.ll.exam;

import java.lang.reflect.Method;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class RouteInfo {
	private String path;
	private String actionPath;
	@Getter
	private Class controllerCls;
	@Getter
	private Method method;


}