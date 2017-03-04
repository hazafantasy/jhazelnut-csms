package jhazelnut.csms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jhazelnut.beans.JhlStatusRestResponseBean;

@RestController
public class LoginValidationController {

	@RequestMapping(value = "/loginvalidation", method = RequestMethod.POST)
	public JhlStatusRestResponseBean loginValidation(
    		@RequestParam(value="user", required=true)String name,
    		@RequestParam(value="pass", required=true)String pass
			) {

		JhlStatusRestResponseBean bean;

		if(name.equals("hmojica") && pass.equals("123")) {
			bean = new JhlStatusRestResponseBean("OK");
		} else {
			bean = new JhlStatusRestResponseBean("ERROR");
		}

		return bean;
	}

}
