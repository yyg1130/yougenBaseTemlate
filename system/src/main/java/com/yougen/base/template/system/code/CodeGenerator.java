package com.yougen.base.template.system.code;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author yyg
 */
public class CodeGenerator {
    /**
     * 作者、包名、去除表前缀
     */
    private static final String AUTHOR = "youGen";
    private static final String PACKAGE_NAME = "com.yougen.base.template.system";
    private static final String TABLE_PREFIX = "tb_";
    private static final String URL = "jdbc:mysql://localhost:3306/user_db?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&autoReconnect=true&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true";
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "123123";

   /* private static final String AUTHOR = "youGen";
    private static final String PACKAGE_NAME = "com.yougen.base.template.system";
    private static final String TABLE_PREFIX = "tb_";
    private static final String URL = "jdbc:mysql://cdb-k21fch9f.gz.tencentcdb.com:10111/tiros_dev?characterEncoding=UTF-8&useUnicode=true&useSSL=false&tinyInt1isBit=false";
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "5i023@nuoli";*/



    /**
     * 读取控制台内容
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator();
        /**
         * 数据源
         */
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUrl(URL);
        dataSourceConfig.setDriverName(DRIVER_NAME);
        dataSourceConfig.setUsername(USER_NAME);
        dataSourceConfig.setPassword(PASSWORD);
        generator.setDataSource(dataSourceConfig);
        /**
         * 全局配置
         */
        GlobalConfig global = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        global.setOutputDir(projectPath + "/system/src/main/java");
        global.setActiveRecord(true);
        global.setAuthor(AUTHOR);
        global.setIdType(IdType.UUID);
        global.setBaseColumnList(true);
        global.setBaseResultMap(true);
        global.setEnableCache(false);
        global.setFileOverride(true);
        global.setMapperName("%sMapper");
        global.setXmlName("%sMapper");
        global.setServiceName("%sService");
        global.setControllerName("%sController");
        global.setOpen(false);
        global.setSwagger2(true);
        global.setDateType(DateType.ONLY_DATE);
        generator.setGlobalConfig(global);
        /**
         * 包名配置
         */
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName(scanner("模块名"));
        packageConfig.setParent(PACKAGE_NAME);
        packageConfig.setEntity("bean");
        packageConfig.setService("service");
        packageConfig.setMapper("mapper");
        packageConfig.setController("controller");
        generator.setPackageInfo(packageConfig);
        /**
         * 策略配置
         */
        StrategyConfig  strategyConfig=new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setEntitySerialVersionUID(true);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setControllerMappingHyphenStyle(true);
        strategyConfig.setSuperEntityClass(PACKAGE_NAME+".system.code.bean.BaseBean");
        strategyConfig.setInclude(scanner("表名,多个英文逗号分割").split(","));
        generator.setStrategy(strategyConfig);
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {}
        };
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        cfg.setFileOutConfigList(focList);
        generator.setCfg(cfg);
        generator.execute();

    }

}
