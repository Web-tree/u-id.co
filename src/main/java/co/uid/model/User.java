package co.uid.model;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Maxim Levicky
 */
@NodeEntity
public class User implements Model, UserDetails {
    @GraphId
    private Long id;

    @Indexed
    private String username;

    @Indexed
    private String password;

    private int roleId;

    private ROLE role;

    public static enum ROLE {
        ANONYMOUS(0), USER(1), EDITOR(2), ADMIN(3);
        private int id;

        private ROLE(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public String getRoleName() {
            return "ROLE_" + toString();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> auth = new ArrayList<>();
        auth.add(() -> {
            String authority;
            switch (roleId) {
                case 1:
                    authority = "ROLE_USER";
                    break;
                case 2:
                    authority = "ROLE_MODER";
                    break;
                default:
                    authority = "ROLE_ANONYMOUS";
            }
            return authority;
        });
        return auth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }
}
