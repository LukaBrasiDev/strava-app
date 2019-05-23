package pl.lukabrasi.stravaapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.lukabrasi.stravaapp.service.StravaService;

@Controller
public class StravaController {

    final StravaService stravaService;

    @Autowired
    public StravaController(StravaService stravaService) {
        this.stravaService = stravaService;
    }

    @GetMapping("/")
    public String getStats(Model model)  {
        String authenticate = stravaService.getAuthenticate();
        model.addAttribute("auth", stravaService.getAuthenticate());

        return "index";
    }






}
