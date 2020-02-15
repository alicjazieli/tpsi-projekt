/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizut.tpsi.ogloszenia.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import wizut.tpsi.ogloszenia.jpa.BodyStyle;
import wizut.tpsi.ogloszenia.jpa.CarManufacturer;
import wizut.tpsi.ogloszenia.jpa.CarModel;
import wizut.tpsi.ogloszenia.jpa.FuelType;
import wizut.tpsi.ogloszenia.jpa.Offer;

@Service
public class OffersService {
    @PersistenceContext
    private EntityManager em;
    
    public CarManufacturer getManufacturer(int id) {
        return em.find(CarManufacturer.class, id);
    }

    public CarModel getModel(int id) {
        return em.find(CarModel.class, id);
    }
    
    public List<CarManufacturer> getCarManufacturers() {
        String jpql = "select cm from CarManufacturer cm order by cm.name";
        TypedQuery<CarManufacturer> query = em.createQuery(jpql, CarManufacturer.class);
        List<CarManufacturer> result = query.getResultList();
        return result;
    }
    
    public List<BodyStyle> getBodyStyles() {
        String jpql = "select bs from BodyStyle bs order by bs.name";
        TypedQuery<BodyStyle> query = em.createQuery(jpql, BodyStyle.class);
        List<BodyStyle> result = query.getResultList();
        return result;
    }
    
    public List<FuelType> getFuelTypes() {
        String jpql = "select ft from FuelType ft order by ft.name";
        TypedQuery<FuelType> query = em.createQuery(jpql, FuelType.class);
        List<FuelType> result = query.getResultList();
        return result;
    }
    
//    public List<CarModel> getCarModels() {
//        String jpql = "select ca from CarModel ca order by ca.name";
//        TypedQuery<CarModel> query = em.createQuery(jpql, CarModel.class);
//        List<CarModel> result = query.getResultList();
//        return result;
//    }
    
    public List<CarModel> getCarModels(int manufacturerId) {
        String jpql = "select cm from CarModel cm where cm.manufacturer.id = :id order by cm.name";
        TypedQuery<CarModel> query = em.createQuery(jpql, CarModel.class);
        query.setParameter("id", manufacturerId);
        return query.getResultList();
    }
    
        public List<Offer> getOffers() {
        String jpql = "select ofr from Offer ofr order by ofr.title";
        TypedQuery<Offer> query = em.createQuery(jpql, Offer.class);
        List<Offer> result = query.getResultList();
        return result;
    }
        
    public List<Offer> getOffersByModel(int modelId) {
        String jpql = "select ofe from Offer ofe where ofe.model.id = :id order by ofe.title";
        TypedQuery<Offer> query = em.createQuery(jpql, Offer.class);
        query.setParameter("id", modelId);
        return query.getResultList();
    }
    
//    public List<Offer> getOffersByManufacturer(int manufacturerId) {
//        String jpql = "select ofm from Offer ofm where ofm.model.id = :id order by ofm.title";
//        TypedQuery<Offer> query = em.createQuery(jpql, Offer.class);
//        query.setParameter("id", modelId);
//        return query.getResultList();
//    }
    
    public Offer getOffer(int id) {
        return em.find(Offer.class, id);
    }
    
}


