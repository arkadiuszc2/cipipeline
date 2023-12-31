package com.mwo.cipipeline;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @Value("${app.version}")
  private String appVersion;

  @GetMapping("/welcome")
  public String welcome(){
    return "Welcome to the website!";
  }

  @GetMapping("/version")
  public String version(){
    return "Application version: " + appVersion;
  }
}
