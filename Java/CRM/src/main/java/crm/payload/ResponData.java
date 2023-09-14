package crm.payload;

//package crm.payload chứa các class chuyển code sang dạng Json
public class ResponData {
	private boolean success;
	private String data;
	private String description;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
