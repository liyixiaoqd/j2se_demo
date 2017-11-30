package hutubill.service;

import hutubill.dao.ConfigDao;
import hutubill.entity.Config;

public class ConfigService {
	public static final String budget = "budget";
	public static final String mysqlPath = "mysqlPath";
	public static final String default_budget = "500";

	static ConfigDao dao = new ConfigDao();
	static {
		init();
	}

	public static void init() {
		init(budget,default_budget);
		init(mysqlPath,"");
	}

	public static void init(String key, String value) {
		Config config = dao.getByKey(key);
		if (config == null) {
			config = new Config();
			config.setKey(key);
			config.setValues(value);
			dao.add(config);
		}
	}
	
	public String get(String key){
		return dao.getByKey(key).getValues();
	}
	
	public void update(String key,String value){
		Config config = dao.getByKey(key);
		config.setValues(value);
		dao.update(config);
	}
}
