package com.example.demo.auth;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.Entity.Account;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRoot implements UserDetails {
	private Account user;
	private Collection<? extends GrantedAuthority> authorities;
	private Map<String, Object> attributes;

	public static UserRoot create(Account user) {
		// Tạo danh sách quyền cho người dùng
		List<GrantedAuthority> authorities = List.of(user.getIsAdmin().name()).stream()
				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());

		// Tạo đối tượng UserRoot từ đối tượng Account
		return UserRoot.builder().user(user).authorities(authorities).build();
	}

	public static UserRoot create(Account user, Map<String, Object> attributes) {
		UserRoot userRoot = UserRoot.create(user);
		userRoot.setAttributes(attributes);
		return userRoot;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.user.getPass();
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
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
