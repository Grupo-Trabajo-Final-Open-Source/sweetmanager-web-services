package com.git.sweetmanager.profile.interfaces;

import com.git.sweetmanager.profile.domain.model.queries.company.GetAllCompaniesQuery;
import com.git.sweetmanager.profile.domain.model.queries.company.GetCompanyByIdQuery;
import com.git.sweetmanager.profile.domain.services.company.CompanyCommandService;
import com.git.sweetmanager.profile.domain.services.company.CompanyQueryService;
import com.git.sweetmanager.profile.interfaces.rest.resources.company.CreateCompanyResource;
import com.git.sweetmanager.profile.interfaces.rest.resources.company.CompanyResource;
import com.git.sweetmanager.profile.interfaces.rest.transform.company.CreateCompanyCommandFromResourceAssembler;
import com.git.sweetmanager.profile.interfaces.rest.transform.company.CompanyResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value= "/api/v1/companies", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Companies", description = "Company Management Endpoints")
public class CompanyController {
    private final CompanyQueryService companyQueryService;

    private final CompanyCommandService companyCommandService;

    public CompanyController(CompanyQueryService companyQueryService, CompanyCommandService companyCommandService) {
        this.companyQueryService = companyQueryService;
        this.companyCommandService = companyCommandService;
    }

    @PostMapping
    public ResponseEntity<CompanyResource> createCompany(@RequestBody CreateCompanyResource resource) {
        var createCompanyCommand = CreateCompanyCommandFromResourceAssembler.toCommandFromResource(resource);

        var company = companyCommandService.handle(createCompanyCommand);

        if (company.isEmpty()) return ResponseEntity.badRequest().build();

        var companyResource = CompanyResourceFromEntityAssembler.toResourceFromEntity(company.get());

        return new ResponseEntity<>(companyResource, HttpStatus.CREATED);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyResource> getCompanyById(@PathVariable Long companyId) {
        var getCompanyByIdQuery = new GetCompanyByIdQuery(companyId);

        var company = companyQueryService.handle(getCompanyByIdQuery);

        if (company.isEmpty()) return ResponseEntity.badRequest().build();

        var companyResource = CompanyResourceFromEntityAssembler.toResourceFromEntity(company.get());

        return ResponseEntity.ok(companyResource);
    }

    @GetMapping
    public ResponseEntity<List<CompanyResource>> getAllCompanies() {
        var getAllCompaniesQuery = new GetAllCompaniesQuery();

        var companies = companyQueryService.handle(getAllCompaniesQuery);

        var companyResources = companies.stream()
                .map(CompanyResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(companyResources);
    }
}