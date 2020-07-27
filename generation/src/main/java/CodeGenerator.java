import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO mybatis-plus自动生成
 *
 * @author xtysummer1121@foxmail.com
 * @className CodeGenerator
 * @date 2019-07-02
 * @return
 */
public class CodeGenerator {

	/**
	 * TODO 需要根据项目而变化的内容
	 */

	//数据库url
	public static String url = "jdbc:mysql://  ip:port  / database ?useUnicode=true&useSSL=false" +
			"&characterEncoding=utf8";

	//数据库名称(为空则不指定)
	public static String schemaName = "";

	public static String userName = "";

	public static String password = "";

	//设置作者
	public static String author = "xtysummer1121@foxmail.com";

	//设定父包名
	public static String packageName = "com.huichao.erp";

	//指定表名中需要去除的前缀(无匹配则不删除)  为空，默认删除模块名前缀（生成前缀的情况下）
	public static String CommonPreFix = "tb_";

	//设置目标目录 可为空，则默认是当前工程下的src目录
	public static String projectPath = null;

	//指定驱动名称 可为空，默认使用com.mysql.cj.jdbc.Driver
	public static String driverName = null;


	/**
	 * TODO 必填项目
	 */
	//要使用的数据库表名
	public static String[] tables = new String[]{
			"tb_base_info_driver",
			"tb_base_info_freezer",
			"tb_base_info_freezer_region",
			"tb_base_info_inspection",
			"tb_base_info_kind",
			"tb_base_info_level",
			"tb_base_info_place",
			"tb_base_info_vehicle"
	};


	/**
	 * TODO 主方法
	 */
	public static void main(String[] args) {
		init();

		// 代码生成器
		AutoGenerator mpg = new AutoGenerator();

		//全局设置
		mpg.setGlobalConfig(getGlobalConfig());

		// 数据源配置
		mpg.setDataSource(getDataSourceConfig());

		// 包配置
		mpg.setPackageInfo(getPackageConfig());

		// 自定义配置
		mpg.setCfg(getInjectionConfig());

		// 配置模板
		mpg.setTemplate(getTemplateConfig());

		// 策略配置
		mpg.setStrategy(getStrategy());

//		mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		mpg.execute();
	}


	/**
	 * TODO 配置逻辑以及不是很需要修改的内容
	 */

	/**
	 * TODO 设置默认参数
	 *
	 * @param
	 * @return void
	 * @className CodeGenerator
	 * @author xtysummer1121@foxmail.com
	 * @methodName init
	 * @date 2019/11/16
	 */
	public static void init() {
		//会生成在项目根目录下，与本moudle平级
		if (projectPath == null) projectPath = System.getProperty("user.dir");

		if (driverName == null) driverName = "com.mysql.cj.jdbc.Driver";

		if (CommonPreFix == null) CommonPreFix = getPackageConfig().getModuleName() + "_";
	}


	/**
	 * 读取控制台内容
	 */
//	public static String scanner(String tip) {
//		Scanner scanner = new Scanner(System.in);
//		StringBuilder help = new StringBuilder();
//		help.append("请输入" + tip + "：");
//		System.out.println(help.toString());
//		if (scanner.hasNext()) {
//			String ipt = scanner.next();
//			if (StringUtils.isNotEmpty(ipt)) {
//				return ipt;
//			}
//		}
//		throw new MybatisPlusException("请输入正确的" + tip + "！");
//	}

	/**
	 * TODO 获取数据库表名列表
	 *
	 * @return
	 * @className CodeGenerator
	 * @author xtysummer1121@foxmail.com
	 * @methodName
	 * @date 2019/11/16
	 */
	public static String[] getTablesName() {
		return tables;
	}


	/**
	 * TODO 初始化数据库连接
	 *
	 * @return com.baomidou.mybatisplus.generator.config.DataSourceConfig
	 * @className CodeGenerator
	 * @author xtysummer1121@foxmail.com
	 * @methodName init
	 * @date 2019/11/16
	 */
	public static DataSourceConfig getDataSourceConfig() {
		DataSourceConfig config = new DataSourceConfig();
		config.setUrl(url);
		if (schemaName != null)
			config.setSchemaName(schemaName);
		config.setDriverName(driverName);
		config.setUsername(userName);
		config.setPassword(password);
		return config;
	}

	/**
	 * TODO 获取全局设置
	 *
	 * @return com.baomidou.mybatisplus.generator.config.GlobalConfig
	 * @className CodeGenerator
	 * @author xtysummer1121@foxmail.com
	 * @methodName getGlobalConfig
	 * @date 2019/11/16
	 */
	public static GlobalConfig getGlobalConfig() {
		GlobalConfig gc = new GlobalConfig();
		//获取当前路径
		String projectPath = System.getProperty("user.dir");
		gc.setOutputDir(projectPath + "/src/main/java");
		gc.setAuthor(author);
		gc.setOpen(false);
		gc.setBaseResultMap(true);//设置生成baseResultMap
		gc.setSwagger2(false); //实体属性 Swagger2 注解，这样会生成自动注解
		return gc;
	}

	/**
	 * TODO 获取包配置
	 *
	 * @return com.baomidou.mybatisplus.generator.config.PackageConfig
	 * @className CodeGenerator
	 * @author xtysummer1121@foxmail.com
	 * @methodName getPackageConfig
	 * @date 2019/11/16
	 */
	public static PackageConfig getPackageConfig() {
		PackageConfig pc = new PackageConfig();
		pc.setParent(packageName);
		return pc;
	}

	/**
	 * TODO 获取自定义配置
	 *
	 * @return com.baomidou.mybatisplus.generator.InjectionConfig
	 * @className CodeGenerator
	 * @author xtysummer1121@foxmail.com
	 * @methodName getInjectionConfig
	 * @date 2019/11/16
	 */
	public static InjectionConfig getInjectionConfig() {
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			//注入自定义 Map 对象
			public void initMap() {
				// to do nothing
			}
		};
		// 自定义输出配置列表
		List<FileOutConfig> focList = new ArrayList<FileOutConfig>();

		// 如果模板引擎是 freemarker
//		String templatePath = "/templates/mapper.xml.ftl";
		// 如果模板引擎是 velocity
		String templatePath = "/templates/mapper.xml.vm";

		//指定文件输出位置
		focList.add(new FileOutConfig(templatePath) {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
				return projectPath + "/src/main/resources/mapper/xml"//." + pc.getModuleName()
						+ "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
			}
		});

		//指定覆盖已有代码
		cfg.setFileCreate(new IFileCreate() {

			public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
				// 判断自定义文件夹是否需要创建
				checkDir(filePath);
				return true;
			}
		});

		cfg.setFileOutConfigList(focList);
		return cfg;
	}

	/**
	 * TODO 获取配置模板
	 *
	 * @return com.baomidou.mybatisplus.generator.config.TemplateConfig
	 * @className CodeGenerator
	 * @author xtysummer1121@foxmail.com
	 * @methodName getTemplateConfig
	 * @date 2019/11/16
	 */
	public static TemplateConfig getTemplateConfig() {
		TemplateConfig templateConfig = new TemplateConfig();

		// 配置自定义输出模板
		//指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
//		 templateConfig.setEntity("templates/entity2.java");
//		 templateConfig.setService();
//		 templateConfig.setController();

		templateConfig.setXml(null);
		return templateConfig;
	}

	/**
	 * TODO 获取生成策略
	 *
	 * @return com.baomidou.mybatisplus.generator.config.StrategyConfig
	 * @className CodeGenerator
	 * @author xtysummer1121@foxmail.com
	 * @methodName getStrategyConfig
	 * @date 2019/11/16
	 */
	public static StrategyConfig getStrategy() {
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//		strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
		strategy.setEntityLombokModel(true);
		strategy.setRestControllerStyle(true);
//		strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");

		//改为使用在代码中声明表的方式
//		strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
		strategy.setInclude(getTablesName());

		//指定父类公有字段，则不会生成本字段
//		strategy.setSuperEntityColumns("id");
		strategy.setControllerMappingHyphenStyle(true);
		//指定要去除的前缀

		strategy.setTablePrefix(CommonPreFix);
//		strategy.setTablePrefix();
		return strategy;
	}
}
