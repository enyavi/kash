package es.enyavi.kash.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CATEGORY")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;        // "food", "fuel", "cleaning"...

    private String icon;        // Bootstrap icon: "bi-cart3"
    private String color;       // hex: "#FF6384"

    public CategoryEntity() {}

    public CategoryEntity(String name, String icon, String color) {
        this.name = name;
        this.icon = icon;
        this.color = color;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getIcon() { return icon; }
    public String getColor() { return color; }
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setIcon(String icon) { this.icon = icon; }
    public void setColor(String color) { this.color = color; }
}
