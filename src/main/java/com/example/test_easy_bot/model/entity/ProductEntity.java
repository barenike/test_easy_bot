package com.example.test_easy_bot.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String type;

    @Column(nullable = false, length = 50)
    private String serialNumber;

    @Column(nullable = false, length = 50)
    private String manufacturer;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private Integer amount;

    @Column(length = 50)
    private String pcFormFactor;

    @Column(length = 50)
    private String laptopScreenSize;

    @Column(length = 50)
    private String screenSize;

    @Column(length = 50)
    private String hardDiskSize;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductEntity that = (ProductEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
