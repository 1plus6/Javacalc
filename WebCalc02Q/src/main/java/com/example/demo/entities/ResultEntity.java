package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data //変数定義　ゲッター；値を出力する、セッター：値を入れる
@Entity //データベースのデータとなる部分
@Table(name="CALCRESULT") //データベースに値を渡すor受け取る箱
public class ResultEntity {
	  
	  @Id //主キーであることを示す
	  private String Result;
	  
		
}