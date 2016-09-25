package com.entrodus.entronfc.BUS.ReplyObjects;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ntsok on 18/09/2016.
 */
public class GetBusTimesReply {

    public List<BusTime> busTimes;

    public GetBusTimesReply() {
        this.busTimes =  new LinkedList<>();
    }
}
