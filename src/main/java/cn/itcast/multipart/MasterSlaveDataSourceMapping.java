package cn.itcast.multipart;

import java.util.Map;

public class MasterSlaveDataSourceMapping {
	
	private Map<String,MasterSlaveDataSourceItem> targetMasterSlaveDataSourceItems;

	public Map<String, MasterSlaveDataSourceItem> getTargetMasterSlaveDataSourceItems() {
		return targetMasterSlaveDataSourceItems;
	}

	public void setTargetMasterSlaveDataSourceItems(
			Map<String, MasterSlaveDataSourceItem> targetMasterSlaveDataSourceItems) {
		this.targetMasterSlaveDataSourceItems = targetMasterSlaveDataSourceItems;
	}
	
}
