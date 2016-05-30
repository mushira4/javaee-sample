package org.javaee.sample.views;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 * Add a Message to the Faces View. <br />
 * <b>Abstraction for Faces Messages.<b/>
 *
 * @author mushira4
 */
public class FacesMessageHelper {

    @Inject
    private FacesContext facesContext;

    public void addMesage(String message){
        facesContext.getExternalContext().getFlash().setKeepMessages(true);
        facesContext.addMessage(null, new FacesMessage(message));
    }

}
