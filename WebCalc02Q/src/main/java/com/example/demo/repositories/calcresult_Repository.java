package com.example.demo.repositories;



import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper

public interface  calcresult_Repository {
	  
	  @Insert("INSERT INTO CALCRESULT(RESULT) VALUES (#{result})")
	 public void insertResult(String result);
	  
	  
	  @Select("SELECT RESULT FROM CALCRESULT")// SQL文
	  public List <String> findall();//SQLを実行する
}





