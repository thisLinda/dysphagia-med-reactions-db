package com.forlizzi.medication.controller.user;

import com.forlizzi.medication.Constants;
import com.forlizzi.medication.entity.reaction.Reaction;
import com.forlizzi.medication.entity.reaction.ReactionSeverity;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.Pattern;
import java.util.List;

@Validated
@RequestMapping("/usermedlist")
@OpenAPIDefinition(info = @Info(title = "User Med List Service"), servers = {
        @Server(url = "http://localhost:8080", description = "Local server.")})
public interface UserMedListController {

    //    @formatter:off
    @Operation(
            summary = "Create a user med list",
            description = "Returns the user's med list",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "The created med list is returned",
                            content = @Content(
                                    mediaType="application/json",
                                    schema = @Schema(implementation = MedList.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "The request parameters are invalid",
                            content = @Content(
                                    mediaType="application/json")),
                    @ApiResponse(
                            responseCode = "404",
                            description = "A reaction component was found with the input criteria",
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
                            name = "severity",
                            allowEmptyValue = false,
                            required = false,
                            description = "The severity as JSON"),
                    @Parameter(
                            name = "reaction",
                            allowEmptyValue = false,
                            required = false,
                            description = "The reaction as JSON")
            }
    )
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<Reaction> fetchReactions(
            @RequestParam(required = false)
                    ReactionSeverity severity,
            @Length(max = Constants.REACTION_MAX_LENGTH)
            @Pattern(regexp = "[\\w\\s]*")
            @RequestParam(required = false)
                    String reaction);
    //    @formatter:on

}