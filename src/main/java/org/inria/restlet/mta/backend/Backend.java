package org.inria.restlet.mta.backend;

import org.inria.restlet.mta.database.api.Ocean;

/**
 *
 * Backend for all resources.
 *
 *
 */
public class Backend
{
    /** Database.*/
    private Ocean ocean_;

    public Backend()
    {
        ocean_ = new Ocean();
    }

    public Ocean getDatabase()
    {
        return ocean_;
    }

}
