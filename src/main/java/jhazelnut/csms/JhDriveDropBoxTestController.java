package jhazelnut.csms;

import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import jhazelnut.beans.JhDriveDropBoxTestBean;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.users.FullAccount;

import java.io.*;

@RestController
public class JhDriveDropBoxTestController {
    private static final String ACCESS_TOKEN = "Q2kIvxC3egcAAAAAAAB6djAoh-nOSaV_XdvtvrkpNTMTfaZwLqHLzCQFmqeXfpUH";
    private static final String newFilePattern = "test";
    private static final String newFileExt = ".txt";

    @RequestMapping(value = "/dropboxtest", method = RequestMethod.GET)
    public JhDriveDropBoxTestBean doDropBoxTest() {
        JhDriveDropBoxTestBean bean;
        String beanMsg = "";

        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial","en_US");
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        // Get current account info
        try {
            FullAccount account = client.users().getCurrentAccount();
            beanMsg = account.getName().getDisplayName();
            System.out.println(beanMsg);


            // Get files and folder metadata from Dropbox root directory
            ListFolderResult result = client.files().listFolder("");
            while (true) {
                for (Metadata metadata : result.getEntries()) {
                    String item = metadata.getPathLower();
                    beanMsg += " & " + item;
                    System.out.println(beanMsg);

                    if(item.startsWith(newFilePattern)) {
                        //This is one of the test files
                    }
                }

                if (!result.getHasMore()) {
                    break;
                }

                result = client.files().listFolderContinue(result.getCursor());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        bean = new JhDriveDropBoxTestBean(beanMsg);
        return bean;
    }

//    private void tryToCreateaNewTestFile() {
//
//        int i = 0;
//        String newFileName;
//        File f;
//
//        do {//Find a new File name
//            i++;
//            newFileName = newFilePattern + i + newFileExt;
//            f = new File(newFileName);
//
//            if(i>)
//
//        }while(f.exists() && !f.isDirectory());
//
//
//        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
//                new FileOutputStream("filename.txt"), "utf-8"))) {
//
//            writer.write("This is a Test File");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }

}
