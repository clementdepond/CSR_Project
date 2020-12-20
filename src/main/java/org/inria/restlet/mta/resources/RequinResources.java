package org.inria.restlet.mta.resources;

import org.inria.restlet.mta.backend.Backend;
import org.inria.restlet.mta.internals.MultiThreading.Requin;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class RequinResources extends ServerResource {

    /** Backend.*/
    private Backend backend_;

    /** Utilisateur géré par cette resource.*/
    private Requin requin_;

    /**
     * Constructor.
     * Call for every single user request.
     */
    public RequinResources()
    {
        backend_ = (Backend)getApplication().getContext().getAttributes()
                .get("backend");
    }


    @Get("json")
    public Representation getRequin() throws Exception
    {
        String userIdString = (String) getRequest().getAttributes().get("shark_id");
        int userId = Integer.valueOf(userIdString);
        requin_ = backend_.getDatabase().getRequin(userId);

        JSONObject userObject = new JSONObject();
        userObject.put("zone", requin_.getZone());
        userObject.put("cycles restants", requin_.getNbCycles());

        return new JsonRepresentation(userObject);
    }

}
