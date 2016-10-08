package com.entrodus.entronfc;

import com.entrodus.entronfc.BUS.BusTrackerHelpers;
import com.entrodus.entronfc.BUS.ReplyObjects.GetBusTimesReply;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testBusTrackerHelpers_extractBusTimesMessage() throws IOException {
        final GetBusTimesReply reply = retrieveDummyGetBusTimesReply();
        final String busTimesMessage = BusTrackerHelpers.extractBusTimesSchedule(reply);

        assertTrue(busTimesMessage.length() > 0);
    }

    @Test
    public void testJsonDeserialiseGetBusTimesReply() throws IOException {
        final GetBusTimesReply reply = retrieveDummyGetBusTimesReply();
        assertTrue(true);
    }

    private GetBusTimesReply retrieveDummyGetBusTimesReply() throws IOException {
        final String jsonReply = "src\\test\\java\\com\\entrodus\\entronfc\\getBusTimesJsonReply.json";
        final String currentPath = System.getProperty("user.dir");
        final File jsonFile = new File(currentPath, jsonReply);

        final ObjectMapper mapper = new ObjectMapper();
        final GetBusTimesReply reply = mapper.readValue(jsonFile, GetBusTimesReply.class);
        return reply;
    }

    @Test
    public void testAPIHashKeyGeneration() throws Exception {

        String string = "1834, 27/04/2011";
        DateFormat format = new SimpleDateFormat("hhmm, dd/MM/yyyy");
        final Date checkDate = format.parse(string);

        final String hash = BusTrackerHelpers.GetHash(checkDate, "ABCDEFGHIJKLMNOPQRSTUVWXY");
        assertEquals(hash, "149e15ab76beb9cf3cb195468e0c75ae");

        /*
        The timestamp string is YYYYMMDDHH, where:
         YYYY is 4 digits year
         MM is 2 digit month
         DD is 2 digit day
         HH is 2 digit hour (24h format)
        For instance, if the application key is ABCDEFGHIJKLMNOPQRSTUVWXY and the request is made at
        18h34, April 27th, 2011, the MD5 hash of the application key that developers have to transmit is:
        md5(ABCDEFGHIJKLMNOPQRSTUVWXY2011042718) = 149e15ab76beb9cf3cb195468e0c75ae
        */
    }
}