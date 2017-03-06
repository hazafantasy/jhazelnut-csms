package jhazelnut.csms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import jhazelnut.beans.JhDriveDropBoxTestBean;

@RestController
public class JhDriveDropBoxTestController {

    @RequestMapping(value = "/dropboxtest", method = RequestMethod.GET)
    public JhDriveDropBoxTestBean doDropBoxTest() {
        JhDriveDropBoxTestBean bean = new JhDriveDropBoxTestBean("Hello HAZA");


















        return bean;
    }

}
