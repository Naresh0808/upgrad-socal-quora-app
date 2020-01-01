package com.upgrad.quora.api.controller;

import com.upgrad.quora.api.component.AuthorizationHeaderComponent;
import com.upgrad.quora.api.converter.ModelMapperEntityToResponse;
import com.upgrad.quora.api.model.UserDetailsResponse;
import com.upgrad.quora.service.business.CommonService;
import com.upgrad.quora.service.entity.UserEntity;
import com.upgrad.quora.service.exception.AuthorizationFailedException;
import com.upgrad.quora.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @Autowired
    private AuthorizationHeaderComponent authorizationHeaderComponent;

    @RequestMapping(method = RequestMethod.GET,path = "/userprofile/{userId}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserDetailsResponse> userProfile(@RequestHeader("authorization") final String bearerToken,
                                                           @PathVariable("userId") final String userUuid) throws AuthorizationFailedException, UserNotFoundException {
        String jwtToken = authorizationHeaderComponent.getBearerToken(bearerToken);
        UserEntity userEntity = this.commonService.getUserEntity(jwtToken,userUuid);
        UserDetailsResponse userDetailsResponse = ModelMapperEntityToResponse.getUserDetailsResponse(userEntity);
        return new ResponseEntity<UserDetailsResponse>(userDetailsResponse, HttpStatus.OK);
    }
}
