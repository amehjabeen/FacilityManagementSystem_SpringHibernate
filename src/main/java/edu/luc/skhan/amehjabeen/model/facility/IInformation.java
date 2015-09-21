package edu.luc.skhan.amehjabeen.model.facility;



public interface IInformation {
	public int getTotalCapacity();
	public void setTotalCapacity(int total_capacity);
	public String getDescription();
	public void setDescription(String description);
	public String getStatus();
	public void setStatus(String status);
	public void setId(long id);
	public long getId();
	public int getAvailableCapacity();
	public void setAvailableCapacity(int availableCapacity);
}
