package com.chcraft.util;

import java.net.MalformedURLException;
import java.net.URL;

public class TestConsole {
	public static void main(String[] args) throws MalformedURLException {
		System.out.println("MethodViewer TEST\n");
		//test target java.net.URL
		URL url = new URL("https://www.naver.com");
		MethodViewer methodViewer = new MethodViewer(url);
		System.out.println(methodViewer.invokeAll());
	}
}
