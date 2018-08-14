package com.prudential.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prudential.core.common.menu.MenuItem;
import com.prudential.core.users.UserService;

/**
 * Serves menu requests.
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/application", method = RequestMethod.GET)
	public ResponseEntity<List<MenuItem>> getAgencyList(Principal principal) {
		List<MenuItem> restrictedMenuItems = userService.getUserMenu(principal.getName());

		return new ResponseEntity<>(restrictedMenuItems, HttpStatus.OK);
	}

}
