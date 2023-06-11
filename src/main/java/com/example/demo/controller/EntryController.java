package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EntryController {

	@GetMapping("/home")
	public String getName() {
		String HTML = "<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "  <title>Animate Me!</title>\r\n"
				+ "  <style>\r\n"
				+ "    body {\r\n"
				+ "      margin: 0;\r\n"
				+ "      padding: 0;\r\n"
				+ "      font-family: Arial, sans-serif;\r\n"
				+ "      background-color: #f2f2f2;\r\n"
				+ "    }\r\n"
				+ "    .container {\r\n"
				+ "      display: flex;\r\n"
				+ "      justify-content: center;\r\n"
				+ "      align-items: center;\r\n"
				+ "      height: 100vh;\r\n"
				+ "    }\r\n"
				+ "    .content {\r\n"
				+ "      text-align: center;\r\n"
				+ "    }\r\n"
				+ "    .heading {\r\n"
				+ "      font-size: 48px;\r\n"
				+ "      font-weight: bold;\r\n"
				+ "      color: #333;\r\n"
				+ "      animation: slideInFromLeft 1s ease-out;\r\n"
				+ "    }\r\n"
				+ "    .subheading {\r\n"
				+ "      font-size: 24px;\r\n"
				+ "      color: #777;\r\n"
				+ "      animation: fadeIn 1.5s ease-out;\r\n"
				+ "      animation-delay: 0.5s;\r\n"
				+ "    }\r\n"
				+ "    .cta-button {\r\n"
				+ "      display: inline-block;\r\n"
				+ "      padding: 12px 24px;\r\n"
				+ "      background-color: #555;\r\n"
				+ "      color: #fff;\r\n"
				+ "      font-size: 18px;\r\n"
				+ "      font-weight: bold;\r\n"
				+ "      text-decoration: none;\r\n"
				+ "      border-radius: 5px;\r\n"
				+ "      margin-top: 20px;\r\n"
				+ "      animation: bounce 1s infinite;\r\n"
				+ "      animation-delay: 1s;\r\n"
				+ "    }\r\n"
				+ "    @keyframes slideInFromLeft {\r\n"
				+ "      0% {\r\n"
				+ "        transform: translateX(-100%);\r\n"
				+ "      }\r\n"
				+ "      100% {\r\n"
				+ "        transform: translateX(0);\r\n"
				+ "      }\r\n"
				+ "    }\r\n"
				+ "    @keyframes fadeIn {\r\n"
				+ "      0% {\r\n"
				+ "        opacity: 0;\r\n"
				+ "      }\r\n"
				+ "      100% {\r\n"
				+ "        opacity: 1;\r\n"
				+ "      }\r\n"
				+ "    }\r\n"
				+ "    @keyframes bounce {\r\n"
				+ "      0%, 100% {\r\n"
				+ "        transform: scale(1);\r\n"
				+ "      }\r\n"
				+ "      50% {\r\n"
				+ "        transform: scale(1.1);\r\n"
				+ "      }\r\n"
				+ "    }\r\n"
				+ "  </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "  <div class=\"container\">\r\n"
				+ "    <div class=\"content\">\r\n"
				+ "      <h1 class=\"heading\">Welcome to my Animated Web Page!</h1>\r\n"
				+ "      <p class=\"subheading\">Experience the magic of animations.</p>\r\n"
				+ "      <a class=\"cta-button\" href=\"#\">Get Started</a>\r\n"
				+ "    </div>\r\n"
				+ "  </div>\r\n"
				+ "</body>\r\n"
				+ "</html>\r\n"
				+ "";
		return HTML;
	}
	
}
