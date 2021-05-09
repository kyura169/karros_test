
package com.example.demo.model.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for gpxType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="gpxType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="metadata" type="{http://www.topografix.com/GPX/1/1}metadataType"/>
 *         &lt;element name="wpt" type="{http://www.topografix.com/GPX/1/1}wptType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="trk" type="{http://www.topografix.com/GPX/1/1}trkType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="creator" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gpxType", propOrder = {
    "metadata",
    "wpt",
    "trk"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class GpxType {

    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected MetadataType metadata;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<WptType> wpt;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected TrkType trk;
    @XmlAttribute(name = "version")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String version;
    @XmlAttribute(name = "creator")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String creator;

    /**
     * Gets the value of the metadata property.
     * 
     * @return
     *     possible object is
     *     {@link MetadataType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public MetadataType getMetadata() {
        return metadata;
    }

    /**
     * Sets the value of the metadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link MetadataType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setMetadata(MetadataType value) {
        this.metadata = value;
    }

    /**
     * Gets the value of the wpt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wpt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWpt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WptType }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<WptType> getWpt() {
        if (wpt == null) {
            wpt = new ArrayList<WptType>();
        }
        return this.wpt;
    }

    /**
     * Gets the value of the trk property.
     * 
     * @return
     *     possible object is
     *     {@link TrkType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public TrkType getTrk() {
        return trk;
    }

    /**
     * Sets the value of the trk property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrkType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setTrk(TrkType value) {
        this.trk = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the creator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getCreator() {
        return creator;
    }

    /**
     * Sets the value of the creator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2021-05-01T09:01:19+07:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setCreator(String value) {
        this.creator = value;
    }

}
