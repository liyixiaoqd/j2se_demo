package object.item;

/***
 * 物品类
 * @author Liyixiao
 *
 */
public abstract class Item {
	String name;	//名称
	int	price;		//价格
	
	public void buy(){
		System.out.println("购买");
	}
	
	public void effect(){
		System.out.println("item.effect");
	}
	
	public static class UseInfo{
		public void use_info(){
			System.out.println("use_info");
		}
	}
	
	public class AddInfo{
		public void add_info(){
			System.out.println("add_info");
		}
	}
	
	public abstract boolean disposable();
	
	public static void main(String args[]){
		Item new_item = new Item(){
			@Override
			public boolean disposable() {
				// TODO Auto-generated method stub
				return false;
			}
		};
		System.out.println(new_item.disposable());
		
		class Item2 extends Item{
			@Override
			public boolean disposable() {
				// TODO Auto-generated method stub
				return true;
			}
		}
		Item2 item2 = new Item2();
		System.out.println(item2.disposable());
		AddInfo ai = item2.new AddInfo();
		ai.add_info();
		UseInfo ui = new Item.UseInfo();
		ui.use_info();
	}
}
