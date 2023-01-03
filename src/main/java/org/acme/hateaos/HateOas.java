package org.acme.hateaos;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


public class HateOas {

    @Getter
    Map<String, String> links;

    public HateOas() {
        links = new HashMap<>();
    }

    public void addLinks(String key, String link){
        links.put(key, link);
    }
}
