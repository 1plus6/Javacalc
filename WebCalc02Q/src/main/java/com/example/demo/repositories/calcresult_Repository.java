package com.example.demo.repositories;



import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper

public interface  calcresult_Repository {
	  
	  @Insert("INSERT INTO CALCRESULT(RESULT) VALUES (#{result})")
	 public void insertResult(String result);
	  
	  
	  @Select("SELECT RESULT FROM CALCRESULT")
	  public void selectResult(String result);
}





