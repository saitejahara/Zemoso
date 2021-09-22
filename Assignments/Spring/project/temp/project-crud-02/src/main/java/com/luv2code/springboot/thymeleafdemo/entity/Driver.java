package com.luv2code.springboot.thymeleafdemo.entity;

import javax.persistence.*;

@Entity
@Table(name="driver")
public class Driver {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="driver_name")
    private String driverName;

    @Column(name="track_name")
    private String trackName;

    @Column(name="crime")
    private String crime;

    @Column(name="sentence")
    private String sentence;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="car_id")
    private Car car;

    public Driver() {

    }

    public Driver(String driverName, String trackName, String crime, String sentence) {
        this.driverName = driverName;
        this.trackName = trackName;
        this.crime = crime;
        this.sentence = sentence;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", driverName='" + driverName + '\'' +
                ", trackName='" + trackName + '\'' +
                ", crime='" + crime + '\'' +
                ", sentence='" + sentence + '\'' +
                ", cars=" + car +
                '}';
    }
}