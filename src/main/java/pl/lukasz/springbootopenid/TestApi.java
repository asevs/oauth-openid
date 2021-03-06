package pl.lukasz.springbootopenid;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedHashMap;

@Controller
public class TestApi {

    @GetMapping("/test1")
    public String test1(){
        return "test";
    }

    @GetMapping("/test2")
    public String test2(Model model){


      Object details =( (UsernamePasswordAuthenticationToken)((OAuth2Authentication)((SecurityContextImpl) SecurityContextHolder.getContext()).getAuthentication()).getUserAuthentication()).getDetails();
      String name = ((LinkedHashMap) details).values().toArray()[1].toString();
      String picture = ((LinkedHashMap) details).values().toArray()[5].toString();
      String email = ((LinkedHashMap) details).values().toArray()[6 ].toString();

      model.addAttribute("name", name);
      model.addAttribute("picture", picture);
      model.addAttribute("email", email);
      return  "gui";
    }
}
