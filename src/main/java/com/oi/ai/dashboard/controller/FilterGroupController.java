package com.oi.ai.dashboard.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oi.ai.dashboard.model.FilterGroup;
import com.oi.ai.dashboard.service.FilterGroupService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class FilterGroupController {
	public static final Logger logger = LoggerFactory
			.getLogger(FilterGroupController.class);
	@Autowired
	FilterGroupService filterGroupService;

	@PostMapping("/filterGroups")
	private FilterGroup saveFilterGroup(@RequestBody FilterGroup filterGroup) {
		return filterGroupService.saveGroup(filterGroup);

	}

	@GetMapping("/filterGroups")
	private List<FilterGroup> findAllFilterGroups(
			@RequestParam(value = "userName", required = true) String userName) {
		return filterGroupService.findAllGroups(userName);

	}

	@GetMapping("/filterGroups/{groupName}")
	private FilterGroup findAllFilterGroups(
			@RequestParam(value = "userName", required = true) String userName,
			@PathVariable(value = "groupName", required = true) String groupName) {
		return filterGroupService.findGroup(userName, groupName);

	}
	@DeleteMapping("/filterGroups/{groupName}")
	private void deleteFilterGroup(
			@RequestParam(value = "userName", required = true) String userName,
			@PathVariable(value = "groupName", required = true) String groupName) {
		 filterGroupService.delete(userName, groupName);

	}
	@PutMapping("/filterGroups/{groupName}")
	private FilterGroup updateFilterGroup(@RequestBody FilterGroup filterGroup,
			@RequestParam(value = "userName", required = true) String userName,
			@PathVariable(value = "groupName", required = true) String groupName) {
			return filterGroupService.updateGroup(filterGroup, userName, groupName); }


}
