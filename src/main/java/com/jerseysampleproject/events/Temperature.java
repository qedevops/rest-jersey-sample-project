package com.jerseysampleproject.events;


import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "temperature")
/*@JsonRootName(value = "temperature")*/
public class Temperature {

    @JsonProperty("scale")
    String measure;

    @JsonProperty("units")
    Double value;

    public Temperature(String measure, Double value) {
        this.measure = measure;
        this.value = value;
    }

    public Temperature() {
    }

    public String getMeasure() {
        return measure;
    }

    @XmlElement
    public void setMeasure(String measure) {
        this.measure = measure;
    }

    @XmlElement
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
