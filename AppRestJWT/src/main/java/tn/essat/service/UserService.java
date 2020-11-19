package tn.essat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import tn.essat.dao.IUserDao;
import tn.essat.model.User;

public class UserService implements IUserService{

	
	@Autowired
	IUserDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u=dao.findByUsername(username);
		if(u==null) {
			throw new UsernameNotFoundException("user inexistant !!");
		}
		return u;
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findByUsername(username);
	}

	
}
