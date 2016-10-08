package com.entrodus.entronfc.BUS;

import com.entrodus.entronfc.BUS.ReplyObjects.BusTime;
import com.entrodus.entronfc.BUS.ReplyObjects.GetBusTimesReply;
import com.entrodus.entronfc.BUS.ReplyObjects.TimeData;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public final class BusTrackerHelpers {

    public static String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String GetHash(final Date date, final String key) {
        final SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHH");
        final String finalKey = key + df.format(date);

        final String hash = md5(finalKey);
        return hash;

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

    public static String extractBusTimesSchedule(GetBusTimesReply busTimesReply) {
        final StringBuilder builder = new StringBuilder();

        for (BusTime bustime : busTimesReply.busTimes) {
            final LinkedList<Integer> times = new LinkedList<>();
            for (TimeData timeData : bustime.timeDatas) {
                times.add(timeData.minutes);
            }

            final String reportLine = String.format("%s in %s minutes",
                    bustime.mnemoService, StringUtils.join(times, ", "));

            builder.append(reportLine).append("\n");
        }

        return builder.toString();
    }
}
