/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetisolutions.smartcal.studentmanager.SwaggerConfig;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Resource;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 *
 * @author vaka
 */

@Component
@Primary
public class CombinedResourceProviderConfigStudent implements SwaggerResourcesProvider{
    
    @Resource
    private InMemorySwaggerResourcesProvider inMemorySwaggerResourcesProvider;

    @Override
    public List<SwaggerResource> get() {

        SwaggerResource jerseySwaggerResource = new SwaggerResource();
        jerseySwaggerResource.setLocation("/vetisolutions/swagger.json");
        jerseySwaggerResource.setSwaggerVersion("2.0");
        jerseySwaggerResource.setName("Jersey");

        return Stream.concat(Stream.of(jerseySwaggerResource),
                inMemorySwaggerResourcesProvider.get().stream()).collect(Collectors.toList());
    }
    
}
