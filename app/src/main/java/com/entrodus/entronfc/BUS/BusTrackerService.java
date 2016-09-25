package com.entrodus.entronfc.BUS;
import com.entrodus.entronfc.JsonService;
import java.util.Date;

/**
 * Created by ntsok on 18/09/2016.
 */
public final class BusTrackerService {

    //http://ws.mybustracker.co.uk/?module=json&function=getTopoId.
    private static final String url = "http://ws.mybustracker.co.uk/?module=json";
    private final String APIKey;

    public BusTrackerService(String APIKey) {
        this.APIKey = APIKey;
    }

    public String NextBusData()
    {
        // ? getBusTimes
        //http://ws.mybustracker.co.uk/?module=json&key=b2bc78d58f40a6239ccfac773494ac2b&function=getBusTimes&stopId=36237356

        String requestUrl = url;
        requestUrl += "&key=" + BusTrackerHelpers.GetHash(new Date(), this.APIKey);
        requestUrl += "&function=getBusTimes";
        requestUrl += "&stopId=36237356";

        return  requestUrl;
    }
}
