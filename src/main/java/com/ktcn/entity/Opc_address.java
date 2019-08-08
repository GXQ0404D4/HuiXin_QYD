package com.ktcn.entity;
/*
 * 通道，标记，设备的地址都是这个表(配置小黑盒)
 */
public class Opc_address {
	private int Id;					// 主键
	private String channel_name;	// 通道名称
	private String equipment_name;	// 设备名称
	private String tag_name;		// 标记名称
	private String type;			// 这个地址的数据类型，使用int值代表
	private String content;			// 描述这个地址做什么的
	private int state;				// 状态码
	public Opc_address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Opc_address(int id, String channel_name, String equipment_name, String tag_name, String type, String content,
			int state) {
		super();
		Id = id;
		this.channel_name = channel_name;
		this.equipment_name = equipment_name;
		this.tag_name = tag_name;
		this.type = type;
		this.content = content;
		this.state = state;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getChannel_name() {
		return channel_name;
	}
	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}
	public String getEquipment_name() {
		return equipment_name;
	}
	public void setEquipment_name(String equipment_name) {
		this.equipment_name = equipment_name;
	}
	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Opc_address [Id=" + Id + ", channel_name=" + channel_name + ", equipment_name=" + equipment_name
				+ ", tag_name=" + tag_name + ", type=" + type + ", content=" + content + ", state=" + state + "]";
	}
	
}
