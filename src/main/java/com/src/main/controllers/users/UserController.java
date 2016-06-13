package com.src.main.controllers.users;

import com.src.main.command.TestClass;
import com.src.main.constants.URLConstants;
import com.src.main.dto.RequestResponseDTO;
import com.src.main.exceptions.classes.InvalidUserException;
import com.src.main.services.interfaces.users.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by mj on 26/5/16.
 */

@RestController
@RequestMapping(value = {URLConstants.USER})
public class UserController {

    @Autowired
    private UserService userService;
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = {URLConstants.DUMMY + "/test"}, method = {RequestMethod.GET})
    public RequestResponseDTO fetchUserBankDetails() {
        logger.debug("Debug Logger test succesful");
        RequestResponseDTO requestResponseDTO = new RequestResponseDTO(true);
        requestResponseDTO.setData("Received request at test url");
        return requestResponseDTO;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public RequestResponseDTO authenticateUser(@RequestBody final TestClass testClass,
                                               @RequestHeader(value = "userId") final String userID) throws InvalidUserException {
        RequestResponseDTO requestResponseDTO = new RequestResponseDTO(true);
        requestResponseDTO.setData("user Id Found! it is " + userID + "...testclass.a = " + testClass.getA());
        return requestResponseDTO;
    }

}
