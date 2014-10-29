package ar.edu.uces.progweb2.booksmov.search.filter;

public class OptionSearch {
	
	protected Class clazz;
	protected String field;
	protected Object value;
	protected boolean boolValue;
	
	public OptionSearch(Class clazz, String field, Object value) {
		this.clazz = clazz;
		this.field = field;
		this.value = value;
	}
	
	public OptionSearch(Class clazz, String field, boolean value) {
		this.clazz = clazz;
		this.field = field;
		this.boolValue = value;
	}
	public Class getClazz() {
		return clazz;
	}
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public boolean isBoolValue() {
		return boolValue;
	}
	public void setBoolValue(boolean boolValue) {
		this.boolValue = boolValue;
	}
	
}
