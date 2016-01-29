package com.example;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/infos")
@Api(value = "users", description = "Users API", produces = "application/json")
public class UserController {

	private UsersList ul = new UsersList();

	// Add user
	@RequestMapping(value = "api/user/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Add an User", notes = "Add new user")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successfull User Added"), @ApiResponse(code = 400, message = "Impossible to add User") })
	public ResponseEntity<List<User>> addUser(@RequestBody User newUser) {
		if (ul.contains(newUser.getUserName()) == true)
			return new ResponseEntity<List<User>>(HttpStatus.BAD_REQUEST);
		else {
			ul.addUser(newUser);
			return new ResponseEntity<List<User>>(ul.getAllUsers(), HttpStatus.OK);
		}
	}

	// Update user
	@RequestMapping(value = "api/user/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update an User", notes = "Update an spesific user by Username")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successfull User Updated"), @ApiResponse(code = 400, message = "Impossible to update User") })
	public ResponseEntity<List<User>> updateUser(@RequestBody User updateUser) {
		if (ul.contains(updateUser.getUserName()) == false)
			return new ResponseEntity<List<User>>(HttpStatus.BAD_REQUEST);
		else {
			ul.updateUser(updateUser);
			return new ResponseEntity<List<User>>(ul.getAllUsers(), HttpStatus.OK);
		}
	}

	// Find By Username
	@RequestMapping(value = "api/user/findbyusername/{userName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get user by Username", notes = "Return an User with specific Username")
	@ApiResponses({ @ApiResponse(code = 200, message = "Returned existing user"), @ApiResponse(code = 400, message = "Imposible to return user") })
	public ResponseEntity<User> findByUserName(@PathVariable String userName) {
		if (ul.contains(userName) == false)
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<User>(ul.findByUserName(userName), HttpStatus.OK);
	}

	// Find By Name
	@RequestMapping(value = "api/user/findbyname/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get Users by Name", notes = "Returns all users with specific Name")
	@ApiResponses({ @ApiResponse(code = 200, message = "Returned existing users") })
	public ResponseEntity<List<User>> findByName(@PathVariable String name) {
		return new ResponseEntity<List<User>>(ul.findByName(name), HttpStatus.OK);
	}

	// Return all users
	@RequestMapping(value = "api/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get Users", notes = "Returns all users")
	@ApiResponses({ @ApiResponse(code = 200, message = "Returned existing users") })
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(ul.getAllUsers(), HttpStatus.OK);
	}

	// Delete user
	@RequestMapping(value = "api/user/delete/{userName}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete an User", notes = "Delete an spesific user by Username")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successfull User Delete"), @ApiResponse(code = 400, message = "Impossible to delete User") })
	public ResponseEntity<List<User>> deleteUser(@PathVariable String userName) {
		if (ul.contains(userName) == false)
			return new ResponseEntity<List<User>>(HttpStatus.BAD_REQUEST);
		else {
			ul.deleteUser(userName);
			return new ResponseEntity<List<User>>(ul.getAllUsers(), HttpStatus.OK);
		}
	}

}
