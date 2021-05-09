
package com.example.demo.model.jaxb;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wptType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wptType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sym">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="/static/wpt/Waypoint"/>
 *               &lt;enumeration value="/static/wpt/panoramic.png"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="lat" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="lon" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wptType", propOrder = {
    "name",
    "sym"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class WptType {

    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String name;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String sym;
    @XmlAttribute(name = "lat")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String lat;
    @XmlAttribute(name = "lon")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String lon;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the sym property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getSym() {
        return sym;
    }

    /**
     * Sets the value of the sym property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setSym(String value) {
        this.sym = value;
    }

    /**
     * Gets the value of the lat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getLat() {
        return lat;
    }

    /**
     * Sets the value of the lat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setLat(String value) {
        this.lat = value;
    }

    /**
     * Gets the value of the lon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getLon() {
        return lon;
    }

    /**
     * Sets the value of the lon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setLon(String value) {
        this.lon = value;
    }

}
