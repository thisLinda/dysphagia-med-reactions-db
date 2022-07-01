package com.forlizzi.medication.controller;

import com.forlizzi.medication.Constants;
import com.forlizzi.medication.entity.Reaction;
import com.forlizzi.medication.entity.ReactionSeverity;
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
@RequestMapping("/reactions")
@OpenAPIDefinition(info = @Info(title = "Medication Reaction Service"), servers = {
        @Server(url = "http://localhost:8080", description = "Local server.")})
public interface ReactionController {

    //    @formatter:off
    @Operation(
            summary = "Returns a list of medication adverse reactions",
            description = "Returns the adverse reaction",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "The adverse reaction is returned",
                            content = @Content(
                                    mediaType="application/json",
                                    schema = @Schema(implementation = Reaction.class))),
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