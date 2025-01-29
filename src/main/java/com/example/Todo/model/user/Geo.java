package com.example.Todo.model.user;

import jakarta.persistence.*;

@Entity
@Table(name = "geo")
public class Geo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lat")
    private String lat;

    @Column(name = "lng")
    private String lng;

    @OneToOne(mappedBy = "geo")
    private Address address;

    public Geo() {
    }

    public Geo(Long id, String lat, String lng, Address address) {
        this.id = id;
        this.lat = lat;
        this.lng = lng;
        this.address = address;
    }
}
