package com.entrodus.entronfc.BUS.ReplyObjects;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "operatorId",
        "stopId",
        "stopName",
        "refService",
        "mnemoService",
        "nameService",
        "timeDatas",
        "globalDisruption",
        "serviceDisruption",
        "busStopDisruption",
        "serviceDiversion"
})
public class BusTime {

    @JsonProperty("operatorId")
    public String operatorId;
    @JsonProperty("stopId")
    public String stopId;
    @JsonProperty("stopName")
    public String stopName;
    @JsonProperty("refService")
    public String refService;
    @JsonProperty("mnemoService")
    public String mnemoService;
    @JsonProperty("nameService")
    public String nameService;
    @JsonProperty("timeDatas")
    public List<TimeData> timeDatas = new ArrayList<TimeData>();
    @JsonProperty("globalDisruption")
    public boolean globalDisruption;
    @JsonProperty("serviceDisruption")
    public boolean serviceDisruption;
    @JsonProperty("busStopDisruption")
    public boolean busStopDisruption;
    @JsonProperty("serviceDiversion")
    public boolean serviceDiversion;
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
