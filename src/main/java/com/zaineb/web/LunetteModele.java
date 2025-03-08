package com.zaineb.web;


import java.util.ArrayList;
import java.util.List;

import com.zaineb.entities.Lunette;

public class LunetteModele {
    private String motCle;
    List<Lunette> lunettes = new ArrayList<>();

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }

    public List<Lunette> getLunettes() {
        return lunettes;
    }

    public void setLunettes(List<Lunette> lunettes) {
        this.lunettes = lunettes;
    }
}
