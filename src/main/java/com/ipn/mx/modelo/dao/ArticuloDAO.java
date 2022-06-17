/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.ArticuloDTO;
import com.ipn.mx.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author EMend17
 */
public class ArticuloDAO {

    public void create(ArticuloDTO dto) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();

        try {
            t.begin();
            s.persist(dto.getEntidad());
            s.merge(dto.getEntidad()); // actualizar
            s.remove(dto.getEntidad());//borrar
            t.commit();
        } catch (HibernateException he) {
            if (t != null && t.isActive()) {
                t.rollback();
            }
        }
    }

    public void update(ArticuloDTO dto) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            s.merge(dto.getEntidad()); // actualizar
            t.commit();
        } catch (HibernateException he) {
            if (t != null && t.isActive()) {
                t.rollback();
            }
        }
    }

    public void delete(ArticuloDTO dto) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();

        try {
            t.begin();
            s.remove(dto.getEntidad());//borrar
            t.commit();
        } catch (HibernateException he) {
            if (t != null && t.isActive()) {
                t.rollback();
            }
        }
    }

    public ArticuloDTO read (ArticuloDTO dto) {
      Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        
        try {
            t.begin();
            dto = (ArticuloDTO) s.get(ArticuloDTO.class, dto.getEntidad().getIdCategoria());
            t.commit();
        } catch (HibernateException he) {
            if (t != null && t.isActive()) {
                t.rollback();
            }
        }
        
        return dto;
    }

    public List readAll(){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List res = new ArrayList();

        try {
            t.begin();
            Query q = s.createQuery("from Categoria", ArticuloDTO.class);
            res = q.list();

            t.commit();
        } catch (HibernateException he) {
            if (t != null && t.isActive()) {
                t.rollback();
            }
        }
        return res;
    }
        
        
        
        
        
        
        
        
        
        
    }
    
    
