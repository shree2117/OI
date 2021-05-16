package com.oi.ai.dashboard.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

import com.oi.ai.dashboard.service.StringToListConverter;

@Entity
@Data
@Table(uniqueConstraints={@UniqueConstraint(columnNames="user_name")})
public class UserEntity {
	@Id
	@Column(name="user_name")
	String userName;
	String password;
	String dashboardServerUserName;
	@Convert(converter = StringToListConverter.class)
	List<String> roles;
	
}
