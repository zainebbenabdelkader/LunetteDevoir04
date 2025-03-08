package com.zaineb.test;


import java.util.List;

import com.zaineb.dao.ILunetteDaoImpl;
import com.zaineb.entities.Lunette;

public class LunetteTest {

    public static void main(String[] args) {
        ILunetteDaoImpl ldao = new ILunetteDaoImpl();
        Lunette lunette = ldao.save(new Lunette("versace", 200));
        System.out.println(lunette);
        List<Lunette> lunettes = ldao.lunettesParMC("n");
        for (Lunette l : lunettes)
            System.out.println(l);
    }
}
