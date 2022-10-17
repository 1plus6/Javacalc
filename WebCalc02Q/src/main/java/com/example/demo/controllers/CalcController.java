package com.example.demo.controllers;
//このURLにきたら何らかの処理をしてテンプレートエンジン
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repositories.calcresult_Repository;
import com.example.demo.services.CalcService;

@Controller //司令塔
public class CalcController {

	@Autowired
	private CalcService service;

	@Autowired
	private calcresult_Repository calcresult_Repository;
	
	@PostMapping("calc") //htmlのpostにつながってる
	public String calc() {
		return "calc";

	}

		
	
	@PostMapping("resAdd") //htmlのpostにつながってる
	public String resAdd(
			Model model,
			@RequestParam("numA") String NumA,
			@RequestParam("numB") String NumB

	) {
		String AdResult = service.calculateAdd(NumA, NumB);
		if( AdResult == "Aderror") { //計算結果がエラーならエラー画面へ飛ぶ
			return "error";
		}
		model.addAttribute("kotae", AdResult );//htmlのkotaeから参照しAdResultへ格納
		
		calcresult_Repository.insertResult(AdResult);
		
		return "res";

	}

	/*
	 * 引き算
	 */
	
	@PostMapping("resSubtract") //ルーティング
	public String resSubtract(
			Model model,
			@RequestParam("numC") String NumC,
			@RequestParam("numD") String NumD

	) {
		String SubResult = service.calculateSubtract(NumC, NumD);
		if( SubResult == "Suerror") { //計算結果がエラーならエラー画面へ飛ぶ
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
		if( MulResult == "Muerror") { //計算結果がエラーならエラー画面へ飛ぶ
			return "error";
		}
		model.addAttribute("kotae", MulResult);

		calcresult_Repository.insertResult(MulResult);
		
		return "res";

	}
/*
 * 割り算
 */
	@PostMapping("resDivide") //ルーティング
	public String resDivide(
			Model model,
			@RequestParam("numG") String NumG,
			@RequestParam("numH") String NumH

	) {
		String DivResult = service.calculateDivide(NumG, NumH);
		if( DivResult == "Dierror") { //計算結果がエラーならエラー画面へ飛ぶ
			return "error";
		}
		model.addAttribute("kotae", DivResult);

		calcresult_Repository.insertResult(DivResult);
		
		return "res";

	}	
	
	//	引き算、掛け算、割り算を記載していきましょう。
	//	ですが、割り算はちょっと特殊なので注意しましょう！
	//	割り算の答えの出し方をよく思い出してくださいね、他の掛け算までの答え方とは別で回答パターンが複数あると思います、
	//	それを意識してコードを書いていってください。

}