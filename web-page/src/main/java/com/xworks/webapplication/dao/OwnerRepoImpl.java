package com.xworks.webapplication.dao;

import com.xworks.webapplication.dto.AllCustomerDataDto;
import com.xworks.webapplication.dto.OwnerRegDto;
import com.xworks.webapplication.dto.RegFormDto;

import javax.persistence.*;

import java.util.Collections;
import java.util.List;

public class OwnerRepoImpl implements OwnerRepo{
    private EntityManagerFactory emf= Persistence.createEntityManagerFactory("web");
    @Override
    public int login(String email,String password) {
        EntityManager em=null;
        try {
            em= emf.createEntityManager();
            Query query=em.createNamedQuery("getByemailall");
            query.setParameter("email",email);
            OwnerRegDto reg= null;
            try {
                reg = (OwnerRegDto) query.getSingleResult();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            if (reg!=null){
                String pass = reg.getPassword();
                if(password.equals(pass)){
                    return 2;
                }else {
                    return 0;
                }
            }
            return 1;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 1;
        }finally {
            if (em!=null){
                em.close();
            }
        }
    }

    @Override
    public int register(OwnerRegDto ownerRegDto) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Query query = em.createNamedQuery("getemailbyname");
            query.setParameter("name", ownerRegDto.getName());
            OwnerRegDto reg=null;
            try {
                reg =(OwnerRegDto)query.getSingleResult();
            } catch (NoResultException e) {
                System.out.println(e.getMessage());
            }
            if (reg ==null) {
                em.getTransaction().begin();
                em.persist(ownerRegDto);
                em.getTransaction().commit();
                return 1;
            }
            return 2;
        } catch (Exception e) {
            System.err.println("error while registration :"+e.getMessage());
            em.getTransaction().rollback();
            return 0;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<String> userNames() {
        EntityManager em=null;
        try {
            em= emf.createEntityManager();
            Query query=em.createNamedQuery("customername");
            List<String> list=query.getResultList();
            return list;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int dailyEntry(AllCustomerDataDto allCustomerDataDto) {
        EntityManager em=null;
        try {
            em=emf.createEntityManager();
            if (allCustomerDataDto!=null) {
                em.getTransaction().begin();
                em.persist(allCustomerDataDto);
                em.getTransaction().commit();
                return 1;
            }
            return 2;
        }catch (Exception e){
            System.err.println(e.getMessage());
            em.getTransaction().rollback();
            return 0;
        }finally {
            if (em!=null){
                em.close();
            }
        }
    }

    @Override
    public List<AllCustomerDataDto> allData() {
        EntityManager em=null;
        try {
            em=emf.createEntityManager();
            Query query=em.createNamedQuery("alldatas");
            List<AllCustomerDataDto> list=query.getResultList();
            return list;
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
