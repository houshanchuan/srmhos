/*
 * Copyright (c) 2011-2020, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.mediway.hos.generator.config.querys;

import com.baomidou.mybatisplus.annotation.DbType;

/**
 * <p>
 * MySql 表数据查询
 * </p>
 *
 * @author hubin
 * @since 2018-01-16
 */
public class KingbaseesQuery extends AbstractDbQuery {


    @Override
    public DbType dbType() {
        return DbType.KINGBASE_ES;
    }


    @Override
    public String tablesSql() {
        return "SELECT * from (" +
                "   SELECT (CURRENT_DATABASE())::information_schema.sql_identifier AS table_catalog, " +
                "   (nc.NSPNAME)::information_schema.sql_identifier AS table_schema, " +
                "   (c.RELNAME)::information_schema.sql_identifier AS table_name, " +
                "   ( CASE WHEN (nc.OID = SYS_MY_TEMP_SCHEMA()) THEN 'LOCAL TEMPORARY'::TEXT WHEN (c.RELKIND = 'r'::\"CHAR\") THEN 'BASE TABLE'::TEXT WHEN (c.RELKIND = 'v'::\"CHAR\") THEN 'VIEW'::TEXT WHEN (c.RELKIND = 'f'::\"CHAR\") THEN 'FOREIGN TABLE'::TEXT ELSE NULL::TEXT END)::information_schema.character_data AS table_type, " +
                "   (SELECT wm_concat(description) FROM sys_description WHERE objoid=c.oid AND objsubid=0) AS comment, " +
                "   c.oid AS toid " +
                "   FROM ((SYS_NAMESPACE nc JOIN SYS_CLASS c ON ((nc.OID = c.RELNAMESPACE))) LEFT JOIN (SYS_TYPE t JOIN SYS_NAMESPACE nt ON ((t.TYPNAMESPACE = nt.OID))) ON ((c.RELOFTYPE = t.OID))) " +
                "   WHERE ((c.RELKIND = ANY (ARRAY['r'::\"CHAR\", 'v'::\"CHAR\", 'f'::\"CHAR\"])) AND (NOT SYS_IS_OTHER_TEMP_SCHEMA(nc.OID)) AND (SYS_HAS_ROLE(c.RELOWNER, 'USAGE'::TEXT) OR HAS_TABLE_PRIVILEGE(c.OID, 'SELECT, INSERT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER'::TEXT) OR HAS_ANY_COLUMN_PRIVILEGE(c.OID, 'SELECT, INSERT, UPDATE, REFERENCES'::TEXT)))" +
                ") where table_schema='%s'";
    }


    @Override
    public String tableFieldsSql() {
        return "SELECT * from (" +
                "   SELECT (CURRENT_DATABASE())::information_schema.sql_identifier AS table_catalog, " +
                "   (nc.NSPNAME)::information_schema.sql_identifier AS table_schema, " +
                "   (c.RELNAME)::information_schema.sql_identifier AS table_name, " +
                "   (a.ATTNAME)::information_schema.sql_identifier AS column_name, " +
                "   (a.ATTNUM)::information_schema.cardinal_number AS ordinal_position, " +
                "   (CURRENT_DATABASE())::information_schema.sql_identifier AS udt_catalog, " +
                "   (COALESCE(nbt.NSPNAME, nt.NSPNAME))::information_schema.sql_identifier AS udt_schema, " +
                "   (COALESCE(bt.TYPNAME, t.TYPNAME))::information_schema.sql_identifier AS udt_name, " +
                "   (SELECT wm_concat(description) FROM sys_description WHERE objoid=c.oid AND objsubid=a.ATTNUM) AS comment, " +
                "   (SELECT IF((conkey && array[a.attnum]),'PRI','') FROM SYS_CONSTRAINT WHERE CONRELID=c.oid AND contype='p') AS ispk" +
                "   FROM (((((SYS_ATTRIBUTE a LEFT JOIN SYS_ATTRDEF ad ON (((a.ATTRELID = ad.ADRELID) AND (a.ATTNUM = ad.ADNUM)))) JOIN (SYS_CLASS c JOIN SYS_NAMESPACE nc ON ((c.RELNAMESPACE = nc.OID))) ON ((a.ATTRELID = c.OID))) JOIN (SYS_TYPE t JOIN SYS_NAMESPACE nt ON ((t.TYPNAMESPACE = nt.OID))) ON ((a.ATTTYPID = t.OID))) LEFT JOIN (SYS_TYPE bt JOIN SYS_NAMESPACE nbt ON ((bt.TYPNAMESPACE = nbt.OID))) ON (((t.TYPTYPE = 'd'::\"CHAR\") AND (t.TYPBASETYPE = bt.OID)))) LEFT JOIN (SYS_COLLATION co JOIN SYS_NAMESPACE nco ON ((co.COLLNAMESPACE = nco.OID))) ON (((a.ATTCOLLATION = co.OID) AND ((nco.NSPNAME <> 'sys_catalog'::NAME) OR (co.COLLNAME <> 'default'::NAME))))) " +
                "   WHERE ((NOT SYS_IS_OTHER_TEMP_SCHEMA(nc.OID)) AND (a.ATTNUM > 0) AND (NOT a.ATTISDROPPED) AND (c.RELKIND = ANY (ARRAY['r'::\"CHAR\", 'v'::\"CHAR\", 'f'::\"CHAR\"])) AND (SYS_HAS_ROLE(c.RELOWNER, 'USAGE'::TEXT) OR HAS_COLUMN_PRIVILEGE(c.OID, a.ATTNUM, 'SELECT, INSERT, UPDATE, REFERENCES'::TEXT)))" +
                ") where table_schema = '#schema' AND table_name = '%s'";
    }


    @Override
    public String tableName() {
        return "table_name";
    }


    @Override
    public String tableComment() {
        return "comment";
    }


    @Override
    public String fieldName() {
        return "column_name";
    }


    @Override
    public String fieldType() {
        return "udt_name";
    }


    @Override
    public String fieldComment() {
        return "comment";
    }


    @Override
    public String fieldKey() {
        return "ispk";
    }

}
