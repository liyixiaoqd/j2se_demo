package hutubill.model;

public class CategoryModel {
	public static String[] TableColumnNames = new String[]{"分类名称","消费次数"};
	public static String[] categorys=new String[]{"餐饮","住宿","交通"};
	
	public static String[][] getTableCount(){
		String [][] tableCount = new String[][]{
			{"餐饮","0"},{"住宿","0"},{"交通","0"}
		};
		
		return tableCount;
	}
}
