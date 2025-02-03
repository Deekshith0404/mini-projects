package com.xworks.webapplication.dao;

import com.xworks.webapplication.dto.AllCustomerDataDto;
import com.xworks.webapplication.dto.RegFormDto;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class RegFormRepoImpl implements RegFormRepo{
    private EntityManagerFactory emf=Persistence.createEntityManagerFactory("web");
    @Override
    public boolean save(RegFormDto regFormDto) {
        EntityManager em=null;
        try {
            em= emf.createEntityManager();
           if (regFormDto != null) {
               em.getTransaction().begin();
               em.persist(regFormDto);
               em.getTransaction().commit();
               return true;

           }
       }catch (Exception e){
           e.getMessage();
           return false;
       }finally {
            if (em!=null){
                em.close();
            }
        }
        return false;
    }

    @Override
    public List<AllCustomerDataDto> login(String email,String password) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Query query = em.createNamedQuery("getByemail");
            query.setParameter("email", email);
            RegFormDto reg = null;
            try {
                reg = (RegFormDto) query.getSingleResult();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            if (reg != null) {
                String pass = reg.getPassword();
                if (password.equals(pass)) {
                    String name = reg.getUserName();
                    Query query1=em.createNamedQuery("datas");
                    query1.setParameter("name",name);
                    List<AllCustomerDataDto> list=query1.getResultList();
                    return list;
                } else {
                    return null;
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Double> grandTotal(String email) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Query query = em.createNamedQuery("getByemail");
            query.setParameter("email", email);
            RegFormDto reg =(RegFormDto) query.getSingleResult();
            if (reg != null) {
                    String name = reg.getUserName();
                    Query query1=em.createNamedQuery("grandtotal");
                    query1.setParameter("name",name);
                    List<Double> list=query1.getResultList();
                    return list;
                } else {
                    return null;
                }
            }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            if (em!=null){
                em.close();
            }
        }

    }
}
