package com.ap.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ap.dao.UserDao;
import com.ap.model.User;

@Path("/userservice")
public class UserService {
	
	UserDao userDao = new UserDao();
	
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getUsers(){
		
		return userDao.getAllUser();
	}

}
