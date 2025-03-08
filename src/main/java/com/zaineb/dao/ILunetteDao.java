package com.zaineb.dao;


import java.util.List;
import com.zaineb.entities.Lunette;

public interface ILunetteDao {
    public Lunette save(Lunette l);

    public List<Lunette> lunettesParMC(String mc);

    public Lunette getLunette(Long id);

    public Lunette updateLunette(Lunette l);

    public void deleteLunette(Long id);
}
