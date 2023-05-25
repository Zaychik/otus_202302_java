package ru.otus;

import ru.otus.crm.model.Client;
import ru.otus.jdbc.mapper.EntityClassMetaData;
import ru.otus.jdbc.mapper.EntitySQLMetaData;

public class EntitySQLMetaDataImpl implements EntitySQLMetaData {
    private EntityClassMetaData entityClassMetaDataClient;
    public EntitySQLMetaDataImpl(EntityClassMetaData entityClassMetaDataClient) {
        this.entityClassMetaDataClient = entityClassMetaDataClient;
    }

    @Override
    public String getSelectAllSql() {
        return "select * from " + entityClassMetaDataClient.getName();
    }

    @Override
    public String getSelectByIdSql() {
        StringBuilder s = new StringBuilder();
        s.append("select * from ");
        s.append(entityClassMetaDataClient.getName());
        s.append(" where ");
        s.append(entityClassMetaDataClient.getIdField().getName());
        s.append("  = ");
        return s.toString();
    }

    @Override
    public String getInsertSql() {
        return null;
    }

    @Override
    public String getUpdateSql() {
        return null;
    }
}
