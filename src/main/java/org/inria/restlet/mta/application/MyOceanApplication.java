package org.inria.restlet.mta.application;


import org.inria.restlet.mta.resources.RequinResources;
import org.inria.restlet.mta.resources.RequinsRessources;
import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 *
 * Application.
 *
 * @author
 *
 */
public class MyOceanApplication extends Application
{

    public MyOceanApplication(Context context)
    {
        super(context);
    }

    @Override
    public Restlet createInboundRoot()
    {
        Router router = new Router(getContext());
        router.attach("/sharks", RequinsRessources.class);
        router.attach("/sharks/{shark_id}", RequinResources.class);
        return router;
    }
}
