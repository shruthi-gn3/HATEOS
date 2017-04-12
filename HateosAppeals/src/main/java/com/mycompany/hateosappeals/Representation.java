/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hateosappeals;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author shruthign3
 */
public abstract class Representation {
    public static final String APPEALS_NAMESPACE = "http://appeals.com";
    public static final String DAP_NAMESPACE = APPEALS_NAMESPACE + "/dap";
    public static final String APPEALS_MEDIA_TYPE = "application/vnd-cse564-appeals+xml";
    public static final String SELF_REL_VALUE = "self"; 
    
    @XmlElement(name = "link", namespace = DAP_NAMESPACE)
    protected List<Link> links;

    protected List<Link> getLinkByName(String uriName) {
        if (links == null) {
            return null;
        }
        else{ return links;}
    }
}
