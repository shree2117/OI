package com.oi.ai.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
@Data
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"user_name","group_name"})})
public class FilterGroup {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	@Column(name="user_name")
	String userName;
	@Column(name="group_name")
	String groupName;
	@Lob
	String filterJson;

}
