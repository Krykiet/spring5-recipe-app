package com.krykiet.spring5recipeapp.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String directions;

    // Cascade on the side of the recipe
    // When we delete Notes we don't want to delete Recipe
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    @ToString.Exclude // target property for many Ingredient
    private Set<Ingredient> ingredients = new HashSet<>();

    @Lob // Binary large object - BLOB
    private byte[] image;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty; // enum

    // Need to set JoinTable to prevent H2 to create two tables: recipe_categories and category_recipes
    // Also need to set (mappedBy = "categories" on the other side)
    @ManyToMany
    @JoinTable(name = "recipe_category", // Name of table
            joinColumns = @JoinColumn(name = "recipe_id"), // Name of columns
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    @ToString.Exclude // Name of columns
    private Set<Category> categories = new HashSet<>(); // Other side mapped by this

    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Recipe recipe = (Recipe) o;
        return id != null && Objects.equals(id, recipe.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
