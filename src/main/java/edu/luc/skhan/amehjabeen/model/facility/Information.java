package edu.luc.skhan.amehjabeen.model.facility;

public class Information implements IInformation{
	
	private long id;
	private int totalCapacity;
	private int availableCapacity;
	private String description;
	private String status;
	
	public Information(){}
	
	@Override
	public int getTotalCapacity() {
		return totalCapacity;
	}

	@Override
	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getStatus() {
		return status;
	}

	@Override
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int getAvailableCapacity() {
		return availableCapacity;
	}

	@Override
	public void setAvailableCapacity(int availableCapacity) {
		this.availableCapacity = availableCapacity;
	}
}
