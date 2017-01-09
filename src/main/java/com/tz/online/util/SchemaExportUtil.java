package com.tz.online.util;


import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/22 16:24.
 * Project: BookStore01.
 */
public class SchemaExportUtil {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SchemaExport export = new SchemaExport(cfg);
        export.create(true, true);
    }
}
