package com.vetisolutions.smartcal.studentmanager.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

/**
 * @author Paulinlenasaein
 *
 */
@Service
public class UtilsService {

    public Date convertStringToDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        if (!date.isEmpty()) {
            try {
                return formatter.parse(date);
            } catch (ParseException ex) {
                Logger.getLogger(UtilsService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }

    public String convertDateToString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    public Date convertStringToDateTime(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (!date.isEmpty()) {
            try {
                return formatter.parse(date);
            } catch (ParseException ex) {
                Logger.getLogger(UtilsService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }

    public Boolean convertStringToBoolean(String bool) {
        if (!bool.isEmpty()) {
            return Boolean.parseBoolean(bool);
        }

        return null;
    }

    public HttpHeaders doHttpBasic(String username, String password) {
        HttpHeaders headers = new HttpHeaders();

        String auth = username + ":" + password;
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes());
        String authHeader = "Basic " + new String(encodedAuth);
        headers.set("Authorization", authHeader);

        return headers;
    }
    
}
