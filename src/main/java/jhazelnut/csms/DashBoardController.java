package jhazelnut.csms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class DashBoardController {

  @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(
          @RequestParam(value="name",
          required=false,
          defaultValue="Haza rocks") String name,
          Model model) {
    model.addAttribute("something", name);
		return "dashboard";
	}

}
