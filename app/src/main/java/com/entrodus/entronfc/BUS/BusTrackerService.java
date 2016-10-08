package com.entrodus.entronfc.BUS;

import com.entrodus.entronfc.BUS.ReplyObjects.GetBusTimesReply;
import com.entrodus.entronfc.JsonService;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public final class BusTrackerService {

    private final String APIKey;

    public BusTrackerService(String APIKey) {
        this.APIKey = APIKey;
    }

    public String getNextBusSchedule() {
        final URL url = getRequestUrl();

        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();

            try {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                final String response = in.toString();

                final GetBusTimesReply replyObject = JsonService.DeserialiseFromJson(response, GetBusTimesReply.class);
                return BusTrackerHelpers.extractBusTimesSchedule(replyObject);
            } catch (Exception e)
            {
                e.printStackTrace();
                return e.toString();
            } finally {
                urlConnection.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    private URL getRequestUrl() {
        // ? getBusTimes
        //http://ws.mybustracker.co.uk/?module=json&key=b2bc78d58f40a6239ccfac773494ac2b&function=getBusTimes&stopId=36237356

        final StringBuilder builder = new StringBuilder();
        builder.append("http://ws.mybustracker.co.uk/?module=json");
        builder.append("&key=").append(BusTrackerHelpers.GetHash(new Date(), this.APIKey));
        builder.append("&function=getBusTimes");
        builder.append("&stopId=36237356");

        URL returnUrl = null;
        try {
            returnUrl = new URL(builder.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return returnUrl;
    }
}
