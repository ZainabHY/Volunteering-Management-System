package com.Volunteering.VolunteeringManagementSystem.entity;

import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateError
    {
        String prefix = "";

        if (object instanceof Manager)
            prefix = "mgr";
        else if (object instanceof Volunteer)
            prefix = "vol";
        else
            throw new HibernateException("Unsupported entity type: " + object.getClass().getSimpleName());

        int uniqueNumber = getUniqueNumber(); // Retrieve a unique number based on the current timestamp
        String id = prefix + String.format("%04d", uniqueNumber);
        return id;
    }

    private int getUniqueNumber() {
        long timestamp = System.currentTimeMillis();
        return (int) (timestamp % 10000);
    }
}
