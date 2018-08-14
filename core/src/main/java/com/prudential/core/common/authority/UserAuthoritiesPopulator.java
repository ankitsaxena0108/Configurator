package com.prudential.core.common.authority;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prudential.core.users.model.User;


@Service("userAuthoritiesPopulator")
public class UserAuthoritiesPopulator implements LdapAuthoritiesPopulator {
    private static final Logger logger = LoggerFactory.getLogger(UserAuthoritiesPopulator.class);

    @Autowired
    private UserRoleService userAuthorityService;

    @Transactional(readOnly=true)
    @Override
    public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations userData, String username) {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        
        try{
            User user = userAuthorityService.getUser(username);
            if (user==null)
                logger.error("Threw exception in MyAuthoritiesPopulator::getGrantedAuthorities : User doesn't exist into ATS database" );
            else{
                for(Role userRole : user.getRoles()) {
                    List<Role> hierarchicalRoles = userAuthorityService.getHierarchyForRole(userRole.getRoleName());
                    for (Role role : hierarchicalRoles) {
                        authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
                    }
                }
                
                return authorities;
            }
        }catch(Exception e){
            logger.error("Failed to get authorities for user {}", username, e); }
        return authorities;
    }
}
