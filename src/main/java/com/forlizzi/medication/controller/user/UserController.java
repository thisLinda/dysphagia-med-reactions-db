package com.forlizzi.medication.controller.user;

import com.forlizzi.medication.Constants;
import com.forlizzi.medication.entity.reaction.Reaction;
import com.forlizzi.medication.entity.reaction.ReactionSeverity;
import com.forlizzi.medication.entity.user.User;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

@Validated
@RequestMapping("/user")
@OpenAPIDefinition(info = @Info(title = "User Service"), servers = {
        @Server(url = "http://localhost:8080", description = "Local server.")})
public interface UserController {

    //    @formatter:off
    @Operation(
            summary = "Creates a user",
            description = "Returns user",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "The created user is returned",
                            content = @Content(
                                    mediaType="application/json",
                                    schema = @Schema(implementation = User.class))),
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
                            name = "user",
                            required = false,
                            description = "Enter the new user's pseudoName"),
            }
    )
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    int createUser(@Valid int user_pk, String pseudo_name, int age, String date_of_eval, String date_of_discharge, String med_dx_icd, String tx_dx_icd);

    @Operation(
            summary = "Returns a list of users",
            description = "Returns a list of users by userPK",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "A list of users is returned.",
                            content = @Content(
                                    mediaType="application/json",
                                    schema = @Schema(implementation = User.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "The request parameters are invalid.",
                            content = @Content(
                                    mediaType="application/json")),
                    @ApiResponse(
                            responseCode = "404",
                            description = "No users were found with the input criteria.",
                            content = @Content(
                                    mediaType="application/json")),
                    @ApiResponse(
                            responseCode = "500",
                            description = "An unplanned error occurred.",
                            content = @Content(
                                    mediaType="application/json"))
            },
            parameters = {
                    @Parameter(
                            name = "userPK",
                            allowEmptyValue = false,
                            required = true,
                            description = "userPK"),
            }
    )
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<User> getUsers(@RequestParam int userPK);

    @Operation(
            summary = "Updates an existing user",
            description = "Returns a new/created user",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "The user has been updated",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = User.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "The request parameters are invalid",
                            content = @Content(
                                    mediaType = "application/json")),
                    @ApiResponse(
                            responseCode = "404",
                            description = "An user name was not found with the input criteria",
                            content = @Content(
                                    mediaType = "application/json")),
                    @ApiResponse(
                            responseCode = "500",
                            description = "An unplanned error occurred",
                            content = @Content(
                                    mediaType = "application/json"))
            }
//            parameters = {
//                    @Parameter(name = "pseudoName",
//                            required = true,
//                            description = "Enter the pseudoName that needs to be updated"),
//            }
    )
    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    void updateUser(
//            @RequestParam(required = true)
                    String newPseudoName, int userPK);

    @Operation(
            summary = "Deletes a user",
            description = "Deletes a user",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "The user was deleted",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = User.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "The request parameters are invalid",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(
                            responseCode = "404",
                            description = "No users were found with the input criteria",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(
                            responseCode = "500",
                            description = "An unplanned error occurred",
                            content = @Content(mediaType = "application/json")),
            },
            parameters = {
                    @Parameter(
                            name = "UserPK",
                            allowEmptyValue = false,
                            required = false,
                            description = "Enter the userPK to be deleted"),
            }
    )
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    void deleteUser(@RequestParam int userPK);

}