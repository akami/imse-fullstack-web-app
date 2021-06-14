package at.ac.univie.team17.controller;

import at.ac.univie.team17.MariaDBModel;
import at.ac.univie.team17.MongoDBModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public abstract class BackendController
{
    @Autowired
    protected MariaDBModel mariaDBModel;

    @Autowired
    protected  MongoDBModel mongoDBModel;
}
