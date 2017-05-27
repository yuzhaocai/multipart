package cn.itcast.multipart;

import java.util.List;

public class MasterSlaveDataSourceItem {
	
	private String masterDataSource;
	
	private List<String> slaveDataSources;

	public String getMasterDataSource() {
		return masterDataSource;
	}

	public void setMasterDataSource(String masterDataSource) {
		this.masterDataSource = masterDataSource;
	}

	public List<String> getSlaveDataSources() {
		return slaveDataSources;
	}

	public void setSlaveDataSources(List<String> slaveDataSources) {
		this.slaveDataSources = slaveDataSources;
	}
	
}
