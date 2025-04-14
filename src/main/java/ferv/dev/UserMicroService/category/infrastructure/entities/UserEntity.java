package ferv.dev.UserMicroService.category.infrastructure.entities;

import ferv.dev.UserMicroService.category.domain.models.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "users")
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String firstname;
    private String lastname;
    private String identityNumber;
    private String phoneNumber;
    private LocalDate birthdate;
    private String email;
    private String password;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // se puede devolver cualquier coleccion que tenga
        // un tipo de dato que extends GrantedAuthority
        return List.of(new SimpleGrantedAuthority("ROLE_" + this.getRole())); // retorna una lista de SimpleGrantedAuthority
    }

    @Override
    public String getUsername() {
        return this.id.toString();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public String getPassword() {
        return password;
    }

}
