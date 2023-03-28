package com.gaintcat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/index").setViewName("index");
		/**
		 * for product page
		 */
		//registry.addViewController("/category").setViewName("product/category");
		//registry.addViewController("/product/**").setViewName("product/product");

		/**
		 * for member page
		 */
		registry.addViewController("/signin").setViewName("member/login");
		registry.addViewController("/register").setViewName("member/register");
		registry.addViewController("/forgotten").setViewName("member/forgottenpassword");
		
		/**
		 * for shopping cart
		 */
		registry.addViewController("/cart").setViewName("cart/cart");
		registry.addViewController("/checkout").setViewName("cart/checkout");
		registry.addViewController("/shipping").setViewName("cart/shipping");
		registry.addViewController("/payment").setViewName("cart/payment");
	}
}
