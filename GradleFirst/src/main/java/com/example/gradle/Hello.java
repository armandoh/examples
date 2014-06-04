package com.example.gradle;

import org.apache.commons.lang3.StringUtils;

public class Hello {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Hello World");
		System.out.println(StringUtils.reverse("Hello World"));
		System.out.println(StringUtils.capitalize("hello world"));
		System.out.println(StringUtils.uncapitalize("Hello There"));
		
	}

}
