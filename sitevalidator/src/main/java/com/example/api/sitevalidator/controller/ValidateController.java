package com.example.api.sitevalidator.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.sitevalidator.model.ResultSchema;

@RestController
public class ValidateController {

    @GetMapping("/validate")
    public ResultSchema validate(@RequestParam String url) {
        try {
            URL urlobj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urlobj.openConnection();
            // conn.setRequestMethod("GET");
            conn.connect();
            if (conn.getResponseCode() / 100 == 2) {
                ResultSchema result = new ResultSchema(url, "Valid", "OK", conn.getResponseCode());
                return result;
            } else if (conn.getResponseCode() / 100 == 3) {
                ResultSchema result = new ResultSchema(url, "Invalid", "Redirect", conn.getResponseCode());
                return result;
            } else if (conn.getResponseCode() / 100 == 4) {
                ResultSchema result = new ResultSchema(url, "Invalid", "Client Error", conn.getResponseCode());
                return result;
            } else if (conn.getResponseCode() / 100 == 5) {
                ResultSchema result = new ResultSchema(url, "Invalid", "Server Error", conn.getResponseCode());
                return result;
            } else {
                ResultSchema result = new ResultSchema(url, "invalid", "Unknown Error", conn.getResponseCode());
                return result;
            }

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            ResultSchema result = new ResultSchema(url, "Invalid", "Malformed URL", 0);
            return result;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            ResultSchema result = new ResultSchema(url, "Invalid", "Site is down", 0);
            return result;
            // return "the URL is not reachable";
        }

    }

}
