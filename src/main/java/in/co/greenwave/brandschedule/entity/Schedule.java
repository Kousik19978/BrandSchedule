package in.co.greenwave.brandschedule.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "[dbo].[BrandMaster]")
public class Schedule {

	@Column(name = "UserId")
	String userId;
	
	@Id
	@Column(name = "BrandScheduleId")
	String brandScheduleId;
	
	@Column(name = "Machine")
	String machine;
	
	@Column(name = "ProductionType")
	String productionType;
	
	@Column(name = "Brand")
	String brand;
	
	@Column(name = "BrandSapCode")
	String brandSapCode;
	
	@Column(name = "StartDate")
	String startDate;
	
	@Column(name = "Output")
	String output;
	
	@Column(name = "Active")
	boolean active;
	
	@Column(name = "ClosedBy")
	String closedBy;
	
	@Column(name = "CloseTime")
	String closeTime;
	
	public Schedule() {
		super();
	}

	
	public Schedule(String userId, String brandScheduleId, String machine, String productionType, String brand,
			String brandSapCode, String startDate, String output, boolean active, String closedBy, String closeTime) {
		super();
		this.userId = userId;
		this.brandScheduleId = brandScheduleId;
		this.machine = machine;
		this.productionType = productionType;
		this.brand = brand;
		this.brandSapCode = brandSapCode;
		this.startDate = startDate;
		this.output = output;
		this.active = active;
		this.closedBy = closedBy;
		this.closeTime = closeTime;
	}

	@Override
	public String toString() {
		return "Schedule [userId=" + userId + ", brandScheduleId=" + brandScheduleId + ", machine=" + machine
				+ ", productionType=" + productionType + ", brand=" + brand + ", brandSapCode=" + brandSapCode
				+ ", startDate=" + startDate + ", output=" + output + ", active=" + active + ", closedBy=" + closedBy
				+ ", closeTime=" + closeTime + "]";
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBrandScheduleId() {
		return brandScheduleId;
	}

	public void setBrandScheduleId(String brandScheduleId) {
		this.brandScheduleId = brandScheduleId;
	}

	public String getMachine() {
		return machine;
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}

	public String getProductionType() {
		return productionType;
	}

	public void setProductionType(String productionType) {
		this.productionType = productionType;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrandSapCode() {
		return brandSapCode;
	}

	public void setBrandSapCode(String brandSapCode) {
		this.brandSapCode = brandSapCode;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


	public String getClosedBy() {
		return closedBy;
	}


	public void setClosedBy(String closedBy) {
		this.closedBy = closedBy;
	}


	public String getCloseTime() {
		return closeTime;
	}


	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	
	
		
}
