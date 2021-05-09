
package com.example.demo.model.jaxb;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for trkType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="trkType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="trkseg" type="{http://www.topografix.com/GPX/1/1}trksegType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trkType", propOrder = {
    "name",
    "desc",
    "trkseg"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class TrkType {

    @XmlElement(required = false)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String name;
    @XmlElement(required = false)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String desc;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected TrksegType trkseg;

    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getName() {
        return name;
    }

    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getDesc() {
        return desc;
    }

    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Gets the value of the trkseg property.
     * 
     * @return
     *     possible object is
     *     {@link TrksegType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public TrksegType getTrkseg() {
        return trkseg;
    }

    /**
     * Sets the value of the trkseg property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrksegType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setTrkseg(TrksegType value) {
        this.trkseg = value;
    }

}
