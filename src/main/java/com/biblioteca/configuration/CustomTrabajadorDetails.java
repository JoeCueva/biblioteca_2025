package com.biblioteca.configuration;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.biblioteca.Entity.trabajador;

public class CustomTrabajadorDetails implements UserDetails{

	private final trabajador trabajador;
	
	public CustomTrabajadorDetails(trabajador trabajador) {
		this.trabajador = trabajador;
	}
	
    public trabajador getTrabajador() {
        return trabajador;
    }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.emptyList();
	}
	
	
	@Override
	public String getPassword() {
		return trabajador.getPassword();
	}
	
	@Override
	public String getUsername() {
		return trabajador.getEmail();
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
	
}
