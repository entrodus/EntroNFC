
package com.entrodus.entronfc.BUS.ReplyObjects;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "refDest",
        "nameDest",
        "day",
        "time",
        "minutes",
        "equipment",
        "vehicleStatus",
        "reliability",
        "event",
        "type",
        "terminus",
        "journeyId",
        "busId"
})
public class TimeData {

    @JsonProperty("refDest")
    public String refDest;
    @JsonProperty("nameDest")
    public String nameDest;
    @JsonProperty("day")
    public int day;
    @JsonProperty("time")
    public String time;
    @JsonProperty("minutes")
    public int minutes;
    @JsonProperty("equipment")
    public String equipment;
    @JsonProperty("vehicleStatus")
    public String vehicleStatus;
    @JsonProperty("reliability")
    public String reliability;
    @JsonProperty("event")
    public String event;
    @JsonProperty("type")
    public String type;
    @JsonProperty("terminus")
    public String terminus;
    @JsonProperty("journeyId")
    public String journeyId;
    @JsonProperty("busId")
    public String busId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}