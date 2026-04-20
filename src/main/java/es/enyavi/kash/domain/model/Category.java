package es.enyavi.kash.domain.model;

public class Category {
    private Long id;
    private String name;
    private String icon;
    private String color;

    public Category() {}

    public Category(String name, String icon, String color) {
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
