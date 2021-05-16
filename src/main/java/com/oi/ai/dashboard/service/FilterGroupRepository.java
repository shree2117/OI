package com.oi.ai.dashboard.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oi.ai.dashboard.model.FilterGroup;

@Repository
public interface FilterGroupRepository extends JpaRepository<FilterGroup, Long> {

	List<FilterGroup> findByUserName(String userName);
	FilterGroup findByUserNameAndGroupName(String userName,String groupName);
}
