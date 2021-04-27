package com.chcraft.util;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/***
 *
 * @author 박찬하
 *
 */
public class MethodViewer {
	private Object target;

	public MethodViewer() {
	}

	public MethodViewer(Object target) {
		this.target = target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public Object getTarget() {
		return target;
	}

	public Method[] getMethods() {
		return target.getClass().getMethods();
	}

	/***
	 * invoke all methods(with no parameter) in target and return result.
	 * @return
	 */
	public String invokeAll() {
		StringBuilder parameterResult = new StringBuilder("-Methods with parameters(it will not invoke)\n");
		StringBuilder noParameterResult = new StringBuilder("-No parameter methods\n");

		Method[] methods = getMethods();
		int length = methods.length;
		for(int i = 0; i < length; i++) {
			Method method = methods[i];
			try {
				if(method.getParameterCount() != 0) {
					parameterResult.append(method.getName() + " : ");
					Parameter[] parameters = method.getParameters();
					int parameterLength = parameters.length;
					for(int j = 0; j < parameterLength; j++) {
						Parameter parameter = parameters[j];
						parameterResult.append(parameter.getType().getName() + " ");
					}

					parameterResult.append('\n');
				} else {
					noParameterResult.append(method.getName() + " : " + method.invoke(target, null));
					noParameterResult.append('\n');
				}
			} catch (Exception e) {
				//ignore Exceptions
				noParameterResult.append(method.getName() + " : " + "ERROR");
				noParameterResult.append('\n');
			}
		}

		parameterResult.append('\n');
		parameterResult.append(noParameterResult);

		return parameterResult.toString();
	}



}
