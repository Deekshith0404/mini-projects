package com.project.registrationpage.repo;

import com.project.registrationpage.entity.RegistrationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Repository
public class RegistrationRepoImpl implements RegistrationRepo{

     @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public boolean save(RegistrationEntity registration) {
        EntityManager em=entityManagerFactory.createEntityManager();
        try {
            if (registration!=null) {
                em.getTransaction().begin();
                em.persist(registration);
                em.getTransaction().commit();
                return true;
            }
            return false;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    @Override
    public boolean Update(RegistrationEntity registration) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();

            // Step 1: Find the existing entity in the database
            RegistrationEntity ent = em.find(RegistrationEntity.class, registration.getId());

            if (ent != null) {
                // Step 2: Update only non-null fields from registration into ent
                if (registration.getName() != null) ent.setName(registration.getName());
                if (registration.getEmail() != null) ent.setEmail(registration.getEmail());
                if (registration.getGender() != null) ent.setGender(registration.getGender());
                if (registration.getMobile() != null) ent.setMobile(registration.getMobile());
                if (registration.getCity() != null) ent.setCity(registration.getCity());

                // Step 3: Merge the managed entity (ent), NOT registration
                em.merge(ent);

                em.getTransaction().commit();
                return true;
            }

            em.getTransaction().rollback(); // Rollback if entity not found
            return false;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) { // Ensure transaction is active before rollback
                em.getTransaction().rollback();
            }
            System.out.println("Error updating registration: " + e.getMessage());
            return false;
        } finally {
            em.close(); // Ensure EntityManager is closed
        }
    }





    @Override
    public List<RegistrationEntity> getall() {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createNamedQuery("getall");
            List<RegistrationEntity> list = query.getResultList();
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public RegistrationEntity getbyid(int idd) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createNamedQuery("getbyid");
            query.setParameter("id",idd);
            RegistrationEntity list =(RegistrationEntity) query.getSingleResult();
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
