package com.zaineb.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.zaineb.entities.Lunette;
import com.zaineb.util.JPAutil;

public class ILunetteDaoImpl implements ILunetteDao {

    private EntityManager entityManager = JPAutil.getEntityManager("LunetteDevoir04");

    @Override
    public Lunette save(Lunette l) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(l);
        tx.commit();
        return l;
    }

    @Override
    public List<Lunette> lunettesParMC(String mc) {
        List<Lunette> lun = entityManager.createQuery("select l from Lunette l where l.nomLunette like :mc").setParameter("mc", "%" + mc + "%").getResultList();
        return lun;
    }

    @Override
    public Lunette getLunette(Long id) {
        return entityManager.find(Lunette.class, id);
    }

    @Override
    public Lunette updateLunette(Lunette l) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(l);
        tx.commit();
        return l;
    }

    @Override
    public void deleteLunette(Long id) {
        Lunette lunette = entityManager.find(Lunette.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(lunette);
        entityManager.getTransaction().commit();
    }
}
