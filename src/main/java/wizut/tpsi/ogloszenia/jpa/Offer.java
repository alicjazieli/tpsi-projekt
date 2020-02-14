/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizut.tpsi.ogloszenia.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "offer")
public class Offer {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 30)
    @Column(name = "title")
    private String title;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setModel_id(CarModel model_id) {
        this.model_id = model_id;
    }

    public void setBody_style_id(BodyStyle body_style_id) {
        this.body_style_id = body_style_id;
    }

    public void setFuel_type_id(FuelType fuel_type_id) {
        this.fuel_type_id = fuel_type_id;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public void setEngine_size(Integer engine_size) {
        this.engine_size = engine_size;
    }

    public void setEngine_power(Integer engine_power) {
        this.engine_power = engine_power;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public CarModel getModel_id() {
        return model_id;
    }

    public BodyStyle getBody_style_id() {
        return body_style_id;
    }

    public FuelType getFuel_type_id() {
        return fuel_type_id;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public Integer getEngine_size() {
        return engine_size;
    }

    public Integer getEngine_power() {
        return engine_power;
    }

    public Integer getDoors() {
        return doors;
    }

    public String getColour() {
        return colour;
    }

    public String getDescription() {
        return description;
    }

    public User getUser_id() {
        return user_id;
    }

    @JoinColumn(name = "model_id", referencedColumnName = "id")
    @ManyToOne
    private CarModel model_id;
    
    @JoinColumn(name = "body_style_id", referencedColumnName = "id")
    @ManyToOne
    private BodyStyle body_style_id;
    
    @JoinColumn(name = "fuel_type_id", referencedColumnName = "id")
    @ManyToOne
    private FuelType fuel_type_id;
    
    @Column(name = "year")
    private Integer year;
    
    @Column(name = "mileage")
    private Integer mileage;
    
    @Column(name = "engine_size")
    private Integer engine_size;
    
    @Column(name = "engine_power")
    private Integer engine_power;
    
    @Column(name = "doors")
    private Integer doors;
    
    @Size(max = 30)
    @Column(name = "colour")
    private String colour;
    
    @Column(name = "description")
    private String description;
    
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User user_id;
    
}
