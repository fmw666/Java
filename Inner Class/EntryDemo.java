import java.util.Arrays;

public class EntryDemo{
    public static void main(String []args){
    	MyContainer container=new MyContainer();
    	container.put("fmw","范茂伟");
    	container.put("jay","周杰伦");
    	container.put("rose","玫瑰");
    	container.put("john","小明");
    	container.put("fmw","范茂伟");

    	MyContainer.Entry [] entrys=container.entryArrays();
    	for(int i=0;i<entrys.length;i++){
    		MyContainer.Entry entry=entrys[i];
    		System.out.println(entry.getKey()+"--"+entry.getValue());
    	}
    }
}

class  MyContainer{
	//存放entry对象的数组.默认大小为5
	private Entry [] entrys=new Entry[5];
	private int count=0;//下标

	//对外提供一个接口向容器中存放封装好的数据(Entry对象)
	public void put(String key,String value){
		Entry entry=new Entry();
		entry.setKey(key);
		entry.setValue(value);
		entrys[count++]=entry;//存放entry对象到数组中
		//数组的扩容
		if(count>=entrys.length){
			//扩容后的新数组的大小
			int newCapacity=entrys.length*2;
			//把老数组中的数据复制到长度为newCapacity的新数组中
			entrys=Arrays.copyOf(entrys,newCapacity);
		}
	}

	//把容器中的有数据的内容返回
	public Entry[] entryArrays(){
		return Arrays.copyOfRange(entrys,0,count);
	}

	//把键值对封装在Entry对象中
	public static class Entry{
		private String key;
		private String value;
		public void setKey(String key){
			this.key=key;
		}
		public String getKey(){
			return key;
		}
		public void setValue(String value){
			this.value=value;
		}
		public String getValue(){
			return value;
		}
	}
}
