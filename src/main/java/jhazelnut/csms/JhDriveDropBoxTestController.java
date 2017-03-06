package jhazelnut.csms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import jhazelnut.beans.JhDriveDropBoxTestBean;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.users.FullAccount;

@RestController
public class JhDriveDropBoxTestController {
    private static final String ACCESS_TOKEN = "Q2kIvxC3egcAAAAAAAB6djAoh-nOSaV_XdvtvrkpNTMTfaZwLqHLzCQFmqeXfpUH";

    @RequestMapping(value = "/dropboxtest", method = RequestMethod.GET)
    public JhDriveDropBoxTestBean doDropBoxTest() {
        JhDriveDropBoxTestBean bean = new JhDriveDropBoxTestBean("Hello HAZA");

        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial","en_US");
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        // Get current account info
        try {
            FullAccount account = client.users().getCurrentAccount();
            String accountName = account.getName().getDisplayName();
            System.out.println(accountName);
            bean = new JhDriveDropBoxTestBean(accountName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return bean;
    }

}
