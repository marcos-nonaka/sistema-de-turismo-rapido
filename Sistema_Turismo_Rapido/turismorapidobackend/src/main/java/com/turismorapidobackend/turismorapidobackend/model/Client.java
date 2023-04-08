package com.turismorapidobackend.turismorapidobackend.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Client implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    Long idClient;
    String name;
    String cpf;
    LocalDate data_nascimento;
    Long tel_number;
    String mail;
    String username;
    String password;
    // RoleName rolename;


    @ManyToMany(targetEntity = Roteiro.class, mappedBy = "client")
    List<Roteiro> roteiros;

    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
    @JoinTable(name = "client_role",
    joinColumns = @JoinColumn(name = "client_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id") )
    List<Role> roles;

    @OneToOne(targetEntity = Comentario.class, cascade = CascadeType.ALL, mappedBy = "client")
    Comentario comentarios;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    
}
