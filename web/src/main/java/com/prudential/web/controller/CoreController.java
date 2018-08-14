package com.prudential.web.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.prudential.core.common.authority.RoleDTO;
import com.prudential.core.users.UserService;


@RestController
public class CoreController {
	
	@Autowired
    private UserService userService;

	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("/index.html");
	}
	
	@RequestMapping("/authenticate")
    public UserPrincipal user(Principal principal) {
        UserPrincipal userPrincipal = new UserPrincipal(principal);
        List<RoleDTO> allRoles = userService.getAllUserRoles(principal.getName());
        
        for (RoleDTO role : allRoles) {
			userPrincipal.addRolePermissions(role);
		}
        
        return userPrincipal;
    }
}
