package cn.itcast.multipart;

public class DataSourceContextHolder {
	
	  public static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	    public static void setDataSourceType(String dataSourceType) {
	    	contextHolder.set(dataSourceType);
	    }

	    public static String getDataSouceType() {
	        return contextHolder.get();
	    }
	    
	    public static void clearDataSoureType(){
	    	contextHolder.remove();
	    }

}
