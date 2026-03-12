package com.mediway.hos.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.mediway.hos.generator.config.*;
import com.mediway.hos.generator.config.converts.MySqlTypeConvert;
import com.mediway.hos.generator.config.rules.IColumnType;
import com.mediway.hos.generator.config.rules.NamingStrategy;
import com.mediway.hos.generator.engine.FreemarkerTemplateEngine;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 代码生成器演示
 * </p>
 *
 * @author 王鑫
 * @since 2022-02-15
 */
public class MysqlGenerator{

    /**
     * <p>
     * MySQL 生成演示
     * </p>
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator generator = new AutoGenerator();
        setDataSource(generator);//数据库配置
        setGlobalConfig(generator);//全局配置
        setStrategy(generator);//策略规则配置，如需要生成的表、排除生成的表、忽略字段、自定义父类等信息
        setPackageInfo(generator);//设置代码生成路径、包名（包路径）、模块名等路径信息
        generator.setTemplateEngine(new FreemarkerTemplateEngine());
        generator.execute();
    }

    /**
     * 全局配置
     * @param generator
     */
    private static void setGlobalConfig(AutoGenerator generator){
        generator.setGlobalConfig(
                // 全局配置
                new GlobalConfig()
                        .setFileOverride(false)// 是否覆盖文件
                        .setEnableCache(false)// XML 二级缓存
                        .setBaseResultMap(true)// XML ResultMap
                        .setBaseColumnList(true)// XML columList
                        .setAuthor("代码生成器")
                        .setSwagger2(true)
        );
    }

    /**
     * 数据源配置
     * @param generator
     */
    private static void setDataSource(AutoGenerator generator){
        generator.setDataSource(
                // 数据源配置
                new DataSourceConfig()
                        .setDbType(DbType.MYSQL)// 数据库类型
                        .setTypeConvert(new MySqlTypeConvert() {
                            // 自定义数据库表字段类型转换【可选】
                            @Override
                            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                                System.out.println("转换类型：" + fieldType);
                                // if ( fieldType.toLowerCase().contains( "tinyint" ) ) {
                                //    return DbColumnType.BOOLEAN;
                                // }
                                return super.processTypeConvert(globalConfig, fieldType);
                            }
                        })
                        .setDriverName("com.mysql.cj.jdbc.Driver")
                        .setUsername("root")
                        .setPassword("root")
                        .setUrl("jdbc:mysql://127.0.0.1:3306/srm?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8")
        );
    }

    /**
     * 策略规则配置
     * 需要生成的表、排除生成的表、忽略字段、自定义父类等信息
     * @param generator
     */
    private static void setStrategy(AutoGenerator generator){


        // 自定义需要填充的字段
//        List<TableFill> tableFillList = new ArrayList<>();
//        tableFillList.add(new TableFill("ASDD_SS", FieldFill.INSERT_UPDATE));

        generator.setStrategy(
                // 策略配置
                new StrategyConfig()
                        // .setCapitalMode(true)// 全局大写命名
                        // .setDbColumnUnderline(true)//全局下划线命名
                        .setTablePrefix(new String[]{"cf_srm_"})// 此处可以修改为您的表前缀
                        .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
//                .setColumnNaming(NamingStrategy.underline_to_camel)
                        .entityTableFieldAnnotationEnable(true)//是否强制带上注解
                        .setInclude(new String[] { "cf_srm_fileconfig" }) // 需要生成的表
                        //.setExclude(new String[]{"sys_oper_log","contract"}) // 排除生成的表

//                         公共字段、忽略字段（子实体类不生成）
//                        .setSuperEntityColumns(new String[]{"id","create_time","update_time"})
//                        自定义需要填充的字段
//                        .setTableFillList(tableFillList)

                        // 自定义实体父类
                        .setSuperEntityClass("srm.business.base.model.entity.BasePO")
                        // 自定义 service 父类
                        .setSuperServiceClass("srm.business.base.service.BaseService")
                        // 自定义 service 实现类父类
                        .setSuperServiceImplClass("srm.business.base.service.impl.BaseServiceImpl")
                        // 自定义 controller 父类
                        //.setSuperControllerClass("com.mediway.hos.database.controller.BaseController")
                        //【实体】是否为lombok模型（默认 false）
                        .setEntityLombokModel(true)
                        .setRestControllerStyle(true)
        );
    }

    /**
     * 设置代码生成路径、包名（包路径）、模块名等路径信息
     * @param generator
     */
    private static void setPackageInfo(AutoGenerator generator){
        //需要修改的
        String modelPath = "/srm-business";
        String servicePath = "/srm-business";
        String webPath = "/srm-business";
        String projectPath = System.getProperty("user.dir");
        Map<String, String> pathInfo = new HashMap<>();
        pathInfo.put(ConstVal.ENTITY_PATH,projectPath + modelPath+ "/src/main/java/" );
        pathInfo.put(ConstVal.MAPPER_PATH,projectPath + servicePath +"/src/main/java/");
        pathInfo.put(ConstVal.XML_PATH, projectPath + servicePath +"/src/main/resources/");
        pathInfo.put(ConstVal.SERVICE_PATH,projectPath + servicePath +"/src/main/java/");
        pathInfo.put(ConstVal.SERVICE_IMPL_PATH,projectPath + servicePath +"/src/main/java/" );
        pathInfo.put(ConstVal.CONTROLLER_PATH,projectPath+ webPath+  "/src/main/java/" );

        generator.setPackageInfo(
                new PackageConfig()
                        .setModuleName("center")//模块名
                        .setParent("srm.business")// 包路径
                        .setPathInfo(pathInfo)//entity、mapper、service、controller的位置信息
        );

    }

    private static void setTemplate(AutoGenerator generator){
        // 关闭默认 xml 生成，调整生成 至 根目录
        generator.setTemplate(new TemplateConfig().setXml(null)
                // 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
                // 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
                // .setController("...");
                // .setEntity("...");
                // .setMapper("...");
                // .setXml("...");
                // .setService("...");
                // .setServiceImpl("...");
        );
    }
}
