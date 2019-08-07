package com.ktcn.entity;
/**
 * 报警设置类
 * @author Administrator
 *
 */
public class Alarmseteings {
	private int ala_id;				// 序号
	private String position_name;   // 点位名
	private String describe;        // 描述
	private String measured_value;  // 实测值
	private String company;         // 单位
	private String ala_state;       // 状态
	private String upperlimit;      // 上限
	private String lowerlimit;      // 下限
	private String ULrange;         // 量程比例
	private String LLlimit;         // 量程零点
	public Alarmseteings() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Alarmseteings(int ala_id, String position_name, String describe, String measured_value, String company,
			String ala_state, String upperlimit, String lowerlimit, String uLrange, String lLlimit) {
		super();
		this.ala_id = ala_id;
		this.position_name = position_name;
		this.describe = describe;
		this.measured_value = measured_value;
		this.company = company;
		this.ala_state = ala_state;
		this.upperlimit = upperlimit;
		this.lowerlimit = lowerlimit;
		ULrange = uLrange;
		LLlimit = lLlimit;
	}
	public int getAla_id() {
		return ala_id;
	}
	public void setAla_id(int ala_id) {
		this.ala_id = ala_id;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getMeasured_value() {
		return measured_value;
	}
	public void setMeasured_value(String measured_value) {
		this.measured_value = measured_value;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAla_state() {
		return ala_state;
	}
	public void setAla_state(String ala_state) {
		this.ala_state = ala_state;
	}
	public String getUpperlimit() {
		return upperlimit;
	}
	public void setUpperlimit(String upperlimit) {
		this.upperlimit = upperlimit;
	}
	public String getLowerlimit() {
		return lowerlimit;
	}
	public void setLowerlimit(String lowerlimit) {
		this.lowerlimit = lowerlimit;
	}
	public String getULrange() {
		return ULrange;
	}
	public void setULrange(String uLrange) {
		ULrange = uLrange;
	}
	public String getLLlimit() {
		return LLlimit;
	}
	public void setLLlimit(String lLlimit) {
		LLlimit = lLlimit;
	}
	@Override
	public String toString() {
		return "Alarmseteings [ala_id=" + ala_id + ", position_name=" + position_name + ", describe=" + describe
				+ ", measured_value=" + measured_value + ", company=" + company + ", ala_state=" + ala_state
				+ ", upperlimit=" + upperlimit + ", lowerlimit=" + lowerlimit + ", ULrange=" + ULrange + ", LLlimit="
				+ LLlimit + "]";
	}
	
}
