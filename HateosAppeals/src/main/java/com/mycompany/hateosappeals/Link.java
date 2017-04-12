/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hateosappeals;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shruthign3
 */
@XmlRootElement(name= "Link"  ,namespace = Representation.DAP_NAMESPACE)
public class Link {
    
    @XmlAttribute(name = "rel")
    private String rel;
    @XmlAttribute(name = "uri")
    private String uri;

    @XmlAttribute(name = "mediaType")
    private String mediaType;

    
    public Link(){
    }
    
    public Link(String rel , String uri, String mediatype){
    this.rel = rel;
        this.uri = uri;
        this.mediaType = mediatype;
    }
    
    public String getUri(){
    return uri;
    }

}
