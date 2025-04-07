package edu.mondragon.aperez.store.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString(exclude = "password")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(
        mappedBy = "user", 
        cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, // cascade persist to persist the address when the user is persisted
        orphanRemoval = true // remove the address when the user is removed
    )
    @Builder.Default  // tell the builder to include this field
    private List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address) {
        addresses.add(address);
        address.setUser(this);
    }

    public void removeAddress(Address address) {
        addresses.remove(address);
        address.setUser(null);
    }

    @ManyToMany
    @JoinTable(name = "user_tags",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @Builder.Default
    private Set<Tag> tags = new HashSet<>();

    public void addTag(String tagName) {
        Tag tag = Tag.builder()
                .name(tagName)
                .build();
        tags.add(tag);
        tag.getUsers().add(this);
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
        tag.getUsers().remove(this);
    }

    // Eager by default, when user is loaded, profile is also loaded.
    // Lazy cannot be used as it is not the owner of the relationship
    @OneToOne(mappedBy = "user")  
    private Profile profile;

    @ManyToMany
    @JoinTable(name = "wishlist",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    @Builder.Default
    private Set<Product> wishlist = new HashSet<>();

    public void addProductToWishlist(Product product) {
        wishlist.add(product);
    }

}
