package com.example.webservice;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.FormParam;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.example.custom.annotations.COPY;
import com.example.custom.annotations.LINK;
import com.example.custom.annotations.PATCH;
import com.example.custom.annotations.PURGE;
import com.example.custom.annotations.UNLINK;
import com.example.dto.Person;

@Service("MyService")
public class MyService {

	private static Logger log = Logger.getLogger(MyService.class);

	@POST
	@Path("/personPost")
	@Consumes("application/json")
	@Produces("application/json")
	public Person getPersonPOST(Person person) {
		try {
			log.debug("A call was received to retrieve a Person: "
					+ person.getName());
			log.debug("Http Method used: POST, consumes and produces:  application/json ");

		} catch (Exception e) {
			String errMsg = "There was an error when testing POST method with JSON request "
					+ e.getMessage();
			log.error(errMsg, e);

		}
		return person;
	}

	@GET
	@Path("/personGet")
	@Produces("application/json")
	public Person getPersonGET(@QueryParam("name") String name) {
		Person person = new Person();
		try {
			log.debug("A call was received to get Person with GET method: "
					+ name);
			person.setName(name);
			person.setLastname("GET");
			log.debug("Http Method used: GET, produces:  application/json, receives query parameters ");
		} catch (Exception e) {
			String msg = "There was an error when testing GET method with query parameters "
					+ e.getMessage();
			log.error(msg, e);
		}
		return person;
	}

	@COPY
	@Path("/personCopy")
	@Produces("application/json")
	public Person getPersonCOPY(@QueryParam("name") String name) {
		Person person = new Person();
		try {
			log.debug("A call was received to get a Person object with COPY method. ");

			person.setName(name);
			person.setLastname("COPY");
			log.debug("Http Method used: COPY, produces:  application/json, receives query parameters ");

		} catch (Exception e) {
			String msg = "There was an error when testing COPY method with query parameters "
					+ e.getMessage();
			log.error(msg, e);
		}
		return person;
	}

	@PURGE
	@Path("/personPurge")
	@Produces("application/json")
	public Person getPersonPURGE(@QueryParam("name") String name) {
		Person person = new Person();
		try {
			log.debug("A call was received to get a Person object with PURGE method. ");

			person.setName(name);
			person.setLastname("@PURGE");
			log.debug("Http Method used: PURGE, produces:  application/json, receives query parameters ");

		} catch (Exception e) {
			String msg = "There was an error when testing PURGE method with query parameters "
					+ e.getMessage();
			log.error(msg, e);
		}
		return person;
	}

	@PUT
	@Path("/personPut")
	@Produces("application/json")
	public Person getPersonPUT(@QueryParam("name") String name) {
		Person person = new Person();
		try {
			log.debug("A call was received to get a Person object with PUT method. ");
			log.debug("Http Method used: PUT, produces:  application/json, receives query parameters ");
			person.setName(name);
			person.setLastname("@PUT");

		} catch (Exception e) {
			String msg = "There was an error when testing PUT method with query parameters "
					+ e.getMessage();
			log.error(msg, e);
		}
		return person;
	}

	@PUT
	@Path("/personPutJson")
	@Consumes("application/json")
	@Produces("application/json")
	public Person getPersonPUT2(Person person) {

		try {
			log.debug("A call was received to retrieve a Person: "
					+ person.getName());

			log.debug("Http Method used: PUT, consumes and produces:  application/json ");

		} catch (Exception e) {
			String errMsg = "There was an error when testing PUT method with JSON request "
					+ e.getMessage();
			log.error(errMsg, e);

		}
		return person;
	}

	@HEAD
	@Path("/personHead")
	@Produces("application/json")
	public Person getPersonHEAD(@QueryParam("name") String name) {
		Person person = new Person();
		try {
			log.debug("A call was received to get a Person object with HEAD method. ");
			log.debug("Http Method used: HEAD, produces:  application/json, receives query parameters ");
			person.setName(name);
			person.setLastname("@HEAD");

		} catch (Exception e) {
			String msg = "There was an error when testing HEAD method with query parameters "
					+ e.getMessage();
			log.error(msg, e);
		}
		return person;
	}

	@HEAD
	@Path("/personHeadJson")
	@Consumes("application/json")
	@Produces("application/json")
	public Person testHead2(Person person) {
		try {
			log.debug("A call was received with HEAD method accepting JSON format. ");
			log.debug("A call was received to get a Person: "
					+ person.getName());

			log.debug("Http Method used: HEAD, consumes and produces:  application/json ");

		} catch (Exception e) {
			String errMsg = "There was an error when testing HEAD method with JSON request "
					+ e.getMessage();
			log.error(errMsg, e);

		}
		return person;
	}

	@OPTIONS
	@Path("/personOptions")
	@Produces("application/json")
	public Person testOptions(@QueryParam("name") String name) {
		Person person = new Person();
		try {
			log.debug("A call was received to get a Person object with OPTIONS method. ");
			log.debug("Http Method used: OPTIONS, produces:  application/json, receives query parameters ");
			person.setName(name);
			person.setLastname("@OPTIONS");

		} catch (Exception e) {
			String msg = "There was an error when testing OPTIONS method with query parameters "
					+ e.getMessage();
			log.error(msg, e);
		}
		return person;
	}

	@OPTIONS
	@Path("/personOptionsJson")
	@Consumes("application/json")
	@Produces("application/json")
	public Person testOptions2(Person person) {
		try {
			log.debug("A call was received with OPTIONS method accepting JSON format. ");
			log.debug("A call was received to retrieve a Person: "
					+ person.getName());

			log.debug("Http Method used: OPTIONS, consumes and produces:  application/json ");

		} catch (Exception e) {
			String errMsg = "There was an error when testing OPTIONS method with JSON request"
					+ e.getMessage();
			log.error(errMsg, e);

		}
		return person;
	}

	@DELETE
	@Path("/personDelete")
	@Consumes("application/json")
	@Produces("application/json")
	public Person testDelete(Person person) {

		try {
			log.debug("A call was received to get a Person object with DELETE method. ");
			log.debug("Http Method used: DELETE, consumes and produces:  application/json  ");

		} catch (Exception e) {
			log.error(
					"There was an error when testing DELETE method with JSON request",
					e);
		}
		return person;
	}

	@LINK
	@Path("/personLink")
	@Consumes("application/json")
	@Produces("application/json")
	public Person testLink(Person person) {

		try {
			log.debug("A call was received to get a Person object with LINK method. ");

			log.debug("Http Method used: LINK, consumes and produces:  application/json ");

		} catch (Exception e) {
			log.error(
					"There was an error when testing LINK method with JSON request",
					e);

		}
		return person;
	}

	@LINK
	@Path("/personLinkParam")
	public String testLinkParams(@FormParam("name") String name) {
		String message = "A call was received to get a Person: " + name
				+ "  with LINK method ";
		log.debug(message);
		try {

			message = message
					+ ". -> LINK method with FORM PARAMS has been completed successfully.";

			log.debug("Http Method used: LINK, receives form parameters ");

		} catch (Exception e) {
			message = "There was an error when testing LINK method with form parameters. "
					+ e.getMessage();
			log.error(message);
		}

		return message;
	}

	@UNLINK
	@Path("/personUnlink")
	@Consumes("application/json")
	@Produces("application/json")
	public Person testUnlink(Person person) {

		try {
			log.debug("A call was received to get a Person with UNLINK method. ");

			log.debug("Http Method used: UNLINK, consumes and produces:  application/json ");

		} catch (Exception e) {
			log.error(
					"There was an error when testing UNLINK method with JSON request",
					e);

		}
		return person;
	}

	@UNLINK
	@Path("/personUnlinkParam")
	public String testUnlinkParams(@FormParam("name") String name) {
		String message = "A call was received to get a Person: " + name
				+ "  with UNLINK method ";
		log.debug(message);
		try {

			message = message
					+ ". -> UNLINK method with FORM PARAMS has been completed successfully.";

			log.debug("Http Method used: UNLINK, receives form parameters ");

		} catch (Exception e) {
			message = "There was an error when testing UNLINK method with form parameters. "
					+ e.getMessage();
			log.error(message);
		}

		return message;
	}

	@PATCH
	@Path("/personPatch")
	@Consumes("application/json")
	@Produces("application/json")
	public Person testPatch(Person person) {

		try {
			log.debug("An Action Pack was received with PATCH method. ");

			log.debug("Http Method used: PATCH, consumes and produces:  application/json ");

		} catch (Exception e) {
			log.error(
					"There was an error when testing PATCH method with JSON request",
					e);

		}
		return person;
	}

	@PATCH
	@Path("/personPatchParam")
	public String testPatchParams(@FormParam("name") String name) {

		String message = "A call was received to get a Person: " + name
				+ "  with PATCH method using form params ";
		log.debug(message);
		try {

			message = message
					+ ". --> PATCH method with FORM PARAMS has been issued successfully.";

			log.debug("Http Method used: PATCH, receives form parameters ");

		} catch (Exception e) {
			message = "There was an error when testing PATCH method with form parameters"
					+ e.getMessage();
			log.error(message);
		}

		return message;
	}

	@PUT
	@Path("/personPutParam")
	public String testPutParams(@FormParam("name") String name) {

		String message = "A call was received to get a Person: " + name
				+ "  with PUT method ";
		log.debug(message);
		try {

			message = message
					+ ". --> PUT method with FORM PARAMS has been issued successfully.";

			log.debug("Http Method used: PUT, receives form parameters ");

		} catch (Exception e) {
			message = "There was an error when testing PUT method with form parameters"
					+ e.getMessage();
			log.error(message);
		}

		return message;
	}

	/**
	 * @RolesAllowed annotation for securing a web service
	 * 
	 *               Security needs to be set in the deployment descriptor
	 * 
	 *               In this case only ADMIN role is allowed to call the service
	 * */
	@GET
	@Path("hello")
	@Produces("text/plain")
	@RolesAllowed("ADMIN")
	public String sayHello() {
		return "Hello World!";
	}

}
