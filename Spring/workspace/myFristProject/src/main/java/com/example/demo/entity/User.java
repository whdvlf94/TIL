package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@Entity
public class User implements Serializable{

	private static final long SerialVersionUID = 1L;

	/*
	 * 1. Auto(default) : JPA 구현체가 자동으로 생성 전략을 결정한다.
	 * 2. IDENTITY : 기본키 생성을 DB에 위임한다.
	 * 				예를 들어 MySQL의 경우 AUTO_INCREMENT를 사용해서 기본키를 생성한다.
	 * 3. SEQUENCE : DB의 특별한 Sequence 오브젝트를 사용해서 기본키를 생성한다. (Oracle)
	 * 4. TABLE : Key를 생성하는 생성 전용 테이블을 하나 만들고 이를 사용해서 기본키를 생성한다.
	 */
	
	@Id
	@GeneratedValue
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	
	@NotBlank(message = "Name을 입력하세요.")
	@Column(unique = true)
	@JacksonXmlProperty
	private String name;
	
	@Column
	@JacksonXmlProperty
	private String email;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	

}
