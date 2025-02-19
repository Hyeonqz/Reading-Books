package org.hyeonqz.dddstart.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

@Table(name = "member")
@Getter
@Entity
public class Member {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String memberId;

	private String password;

	@OneToMany(mappedBy = "member", cascade = { CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
	private List<Product> products = new ArrayList<>();
}
