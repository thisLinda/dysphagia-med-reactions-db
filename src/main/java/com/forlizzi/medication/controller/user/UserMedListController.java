package com.forlizzi.medication.controller.user;

import com.forlizzi.medication.entity.user.UserMedList;
import com.forlizzi.medication.entity.user.UserMedListRequest;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

@Validated
@RequestMapping("/usermedlist")
@OpenAPIDefinition(info = @Info(title = "User Med List Service"), servers = {
        @Server(url = "http://localhost:8080", description = "Local server.")})
public interface UserMedListController {

    //    @formatter:off
    @Operation(
            summary = "Creates a user med",
            description = "Returns a user's med.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "The created med is returned",
                            content = @Content(
                                    mediaType="application/json",
                                    schema = @Schema(implementation = UserMedList.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "The request parameters are invalid",
                            content = @Content(
                                    mediaType="application/json")),
                    @ApiResponse(
                            responseCode = "404",
                            description = "A user component was not found with the input criteria",
                            content = @Content(
                                    mediaType="application/json")),
                    @ApiResponse(
                            responseCode = "500",
                            description = "An unplanned error occurred",
                            content = @Content(
                                    mediaType="application/json"))
            },
            parameters = {
                    @Parameter(
                            name = "userMedListRequest",
                            required = true,
                            description = "The userMedList as JSON"),
            }
    )
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    UserMedList createUserMedList(@Valid @RequestBody UserMedListRequest userMedListRequest);

}