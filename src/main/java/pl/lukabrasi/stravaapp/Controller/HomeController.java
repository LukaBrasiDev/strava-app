package pl.lukabrasi.stravaapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.lukabrasi.stravaapp.service.StravaService;

@Controller
public class HomeController {

    final StravaService stravaService;

    @Autowired
    public HomeController(StravaService stravaService) {
        this.stravaService = stravaService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }


}
