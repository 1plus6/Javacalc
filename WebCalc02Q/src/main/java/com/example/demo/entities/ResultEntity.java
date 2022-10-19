package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="CALCRESULT") //データベースに値を渡すor受け取る箱
public class ResultEntity {
	  
	  @Id
	  private String Result;
	  
		
}