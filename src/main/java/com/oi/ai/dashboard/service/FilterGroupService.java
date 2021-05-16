package com.oi.ai.dashboard.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oi.ai.dashboard.model.FilterGroup;
@Service
public class FilterGroupService {

	@Autowired
	FilterGroupRepository filterGroupRepository;

	public FilterGroup saveGroup(FilterGroup filterGroup) {
		return filterGroupRepository.save(filterGroup);

	}

	public List<FilterGroup> findAllGroups(String userName) {
		return filterGroupRepository.findByUserName(userName);

	}

	public FilterGroup findGroup(String userName, String groupName) {
		FilterGroup filterGroup= filterGroupRepository.findByUserNameAndGroupName(userName, groupName);
		if(filterGroup!=null){
			return filterGroup;
		}else{
			throw new EntityNotFoundException(); 
		}
	}

	public void delete(String userName, String groupName) {
		FilterGroup filterGroup=	filterGroupRepository.findByUserNameAndGroupName(userName, groupName);
		if(filterGroup==null){
			throw new EntityNotFoundException();
		}else
		{
			filterGroupRepository.deleteById(filterGroup.getId());
		}
	}

}
