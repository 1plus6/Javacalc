package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

//このURLにきたら何らかの処理をしてテンプレートエンジン
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.ResultEntity;
import com.example.demo.repositories.calcresult_Repository;
import com.example.demo.services.CalcService;


@Controller //司令塔 htmlとjavaの橋渡し役、画面表示にまつわる処理
public class CalcController {


	@Autowired //他のクラスを呼び出す
	private CalcService service;

	@Autowired
	private calcresult_Repository calcresult_Repository;



	@PostMapping("calc") //htmlのhistoryにとぶ、actionにつながってる
	public String calc() {
		return "calc";

	}

	@PostMapping("history")
	public String history(
			Model model
			) {
		calcresult_Repository.findall(); //findallメソッド呼び出し

		List<ResultEntity> EntityList = new ArrayList<ResultEntity>(); //ResultEntityをリスト型インスタンスしてる

		EntityList = calcresult_Repository.findall();
		model.addAttribute("kotae" , EntityList); //kotaeにEntityListを代入

		return "history"; // history.hmtlへ飛ぶ

	}	

	/*
	 * 足し算
	 */

	@PostMapping("resAdd") //htmlのpostにつながってる
	public String resAdd(
			Model model, //引数のところでインスタンスする　変数名model
			@RequestParam("numA") String NumA, //引数NumAにnumAが渡される
			@RequestParam("numB") String NumB

			) {
		String AdResult = service.calculateAdd(NumA, NumB); //サービスのcalclateAddのnubAとBをAdResultへ代入
		if( AdResult == "Aderror") { //もし、AdResultとAderrorが同じになったらerrorへ飛ぶ
			return "error";
		}
		model.addAttribute("kotae", AdResult );//AdResultの値をhtmlのkotae変数に代入 model＝インタフェース

		calcresult_Repository.insertResult(AdResult); //insertResultメソッド、AdResult引数を渡してる


		return "res"; // resへ飛ぶ


	}

	/*
	 * 引き算
	 */

	@PostMapping("resSubtract") //
	public String resSubtract(
			Model model,
			@RequestParam("numC") String NumC,
			@RequestParam("numD") String NumD

			) {
		String SubResult = service.calculateSubtract(NumC, NumD);
		if( SubResult == "Suerror") { //もし、AdResultとAderrorが同じになったらerrorへ飛ぶ
			return "error";
		}
		model.addAttribute("kotae", SubResult );

		calcresult_Repository.insertResult(SubResult);

		return "res";

	}

	/*
	 * 掛け算
	 */

	@PostMapping("resMultiply") //ルーティング
	public String resMultiply(
			Model model,
			@RequestParam("numE") String NumE,
			@RequestParam("numF") String NumF

			) {
		String MulResult = service.calculateMultiply(NumE, NumF);
		if( MulResult == "Muerror") { //もし、AdResultとAderrorが同じになったらerrorへ飛ぶ
			return "error";
		}
		model.addAttribute("kotae", MulResult);

		calcresult_Repository.insertResult(MulResult);

		return "res";

	}
	/*
	 * 割り算
	 */
	@PostMapping("resDivide") //htmlのpostにつながってる
	public String resDivide(
			Model model,
			@RequestParam("numG") String NumG,
			@RequestParam("numH") String NumH

			) {
		String DivResult = service.calculateDivide(NumG, NumH);
		if( DivResult == "Dierror") { //もし、AdResultとAderrorが同じになったらerrorへ飛ぶ
			return "error";
		}
		model.addAttribute("kotae", DivResult);

		calcresult_Repository.insertResult(DivResult);

		return "res";

	}	


	//	}
	//	引き算、掛け算、割り算を記載していきましょう。
	//	ですが、割り算はちょっと特殊なので注意しましょう！
	//	割り算の答えの出し方をよく思い出してくださいね、他の掛け算までの答え方とは別で回答パターンが複数あると思います、
	//	それを意識してコードを書いていってください。
}
