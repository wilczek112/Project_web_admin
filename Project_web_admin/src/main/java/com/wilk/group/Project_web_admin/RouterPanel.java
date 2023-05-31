package com.wilk.group.Project_web_admin;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class RouterPanel {
    int id;
    String nazwa;
    String url;
    public RouterPanel(int id, String nazwa, String url){
        this.id=id;
        this.nazwa=nazwa;
        this.url=url;
    }
    public static String getStatus(String url) throws IOException {
        String result = "";
        int code = 200;
        try {
            URL siteURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(3000);
            connection.connect();
            code = connection.getResponseCode();
            if (code == 200) {
                result = "-> Green <-\t" + "Code: " + code;
                ;
            } else {
                result = "-> Yellow <-\t" + "Code: " + code;
            }
        } catch (Exception e) {
            result = "-> Red <-\t" + "Wrong domain - Exception: " + e.getMessage();
        }
        //System.out.println(url + "\t\tStatus:" + result);
        return result;
    }


    // restart huawei EMUI.RebootController.rebootExe()


}

