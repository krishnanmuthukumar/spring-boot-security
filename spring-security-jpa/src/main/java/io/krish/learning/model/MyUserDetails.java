package io.krish.learning.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;

	public MyUserDetails(User user) {
		this.userName = user.getUsername();
		this.password = user.getPassword();
		this.active = user.isActive();
		this.authorities = buildAuthorities(user.getRoles());
	}

	public MyUserDetails() {
		super();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
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
		return active;
	}

	private List<GrantedAuthority> buildAuthorities(String roles) {
		List<GrantedAuthority> listSimpleGrantedAuthority = new ArrayList<GrantedAuthority>();
		String[] arrRoles = roles.split(",");
		for (String role : arrRoles) {
			SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role);
			listSimpleGrantedAuthority.add(simpleGrantedAuthority);
		}
		return listSimpleGrantedAuthority;
	}
}
