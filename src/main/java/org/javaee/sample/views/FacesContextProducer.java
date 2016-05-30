package org.javaee.sample.views;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

/**
 * FacesContext producer to fulfiil the actual gap between JSF 2.2 and CDI
 *
 * @author mushira4
 */
@ApplicationScoped  // Scoped to the entire application.
public class FacesContextProducer {

    @Produces //Used for produce a class not managed by the CDI.
    @RequestScoped // Genertaed for each request.
    public FacesContext getInstance(){
        return FacesContext.getCurrentInstance();
    }

}
