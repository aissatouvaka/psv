/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetisolutions.smartcal.administrationmanager.resource;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.SwaggerConfigLocator;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.jaxrs.listing.ApiListingResource;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 *
 * @author vaka
 */

@Component
@ApplicationPath("/vetisolutions")
public class MyConfigAdministration extends ResourceConfig{
    
     public MyConfigAdministration(){
        register(ClasseResource.class);
        register(EnseignantResource.class);
        register(UtilisateurResource.class);
        
        BeanConfig swaggerConfig = new BeanConfig();
            swaggerConfig.setBasePath("/vetisolutions");
        SwaggerConfigLocator.getInstance().putConfig(SwaggerContextService.CONFIG_ID_DEFAULT, swaggerConfig);

        packages(getClass().getPackage().getName(),
                ApiListingResource.class.getPackage().getName());
     }
    
}
