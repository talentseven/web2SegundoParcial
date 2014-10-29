package ar.edu.uces.progweb2.booksmov.search.filter;


public class CriteriaBuilder {
	
	private String query;
	private static CriteriaBuilder criteriaBuilder;
	
	private CriteriaBuilder(){}
	
	public static CriteriaBuilder getInstance(){
		if(criteriaBuilder == null){
			criteriaBuilder = new CriteriaBuilder();
		}
		return criteriaBuilder;
	}
	
	public String build(){
		return query;
	}
	
	public void userName(String name){
		query += "Use.firstName = :firstName";
	}
	
	public void author(String name){
		query += "Aut.fullName = :fullName";
	}
	
	public void actor(String name){
		query += "Act.fullName = :fullName";
	}
	
	public void director(String name){
		query += "Dir.fullName = :fullName";
	}
	
	public void title(String title, String prefix){
		query += prefix + ".title = :title";
	}
	
	public void rating(String rating, String prefix){
		query += prefix + ".rating = :rating";
	}
	
	public void borrowable(String borrowable, String prefix){
		query += prefix + ".borrowable = :borrowable";
	}
	
	public void from(Class clazz){
		String className = clazz.getSimpleName();
		query = "FROM " + clazz.getSimpleName() + " " + className.substring(0, 3);
	}
	
	public void join(Class clazz){
		String className = clazz.getSimpleName();
		query += " INNER JOIN " + clazz.getSimpleName() + " " + className.substring(0, 3);
	}
	
	public void on(String prefixMaster, String fieldMaster, String prefixSlave,  String fieldSlave){
		query += prefixMaster + "." + fieldMaster + " = " + prefixSlave + "." + fieldSlave;
	}
	
	public void where(){
		query += " WHERE "; 
	}
	
	public void and(){
		query += " AND "; 
	}
	
	public void or(){
		query += " OR "; 
	}
	
	public void like(String value){
		query += " LIKE :" + value;
	}
}
