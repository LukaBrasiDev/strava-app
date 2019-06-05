package pl.lukabrasi.stravaapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.lukabrasi.stravaapp.service.StravaService;

@RestController
public class StravaController {

    final StravaService stravaService;

    @Autowired
    public StravaController(StravaService stravaService) {
        this.stravaService = stravaService;
    }



    @GetMapping("/strava")
    @ResponseBody
    public String getStats(Model model)  {
        String authenticate = stravaService.getAuthenticate();
        model.addAttribute("auth", stravaService.getAuthenticate());

        return stravaService.getAuthenticate();
    }

    @PostMapping("/session")
    @ResponseBody
    public String logged(Model model)  {


        return "index";
    }




}
