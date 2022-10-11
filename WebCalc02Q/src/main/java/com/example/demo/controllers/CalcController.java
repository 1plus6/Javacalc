package com.example.demo.controllers;
//このURLにきたら何らかの処理をしてテンプレートエンジン
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.services.CalcService;

@Controller
public class CalcController {

	@Autowired
	private CalcService service;

	@PostMapping("resAdd") //ルーティング
	public String resAdd(
			Model model,
			@RequestParam("numA") String NumA,
			@RequestParam("numB") String NumB

	) {

		model.addAttribute("kotae", service.calculateAdd(NumA, NumB));

		return "res";

	}

	@PostMapping("resSubtract") //ルーティング
	public String resSubtract(
			Model model,
			@RequestParam("numC") String NumC,
			@RequestParam("numD") String NumD

	) {

		model.addAttribute("kotae", service.calculateSubtract(NumC, NumD));

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

		model.addAttribute("kotae", service.calculateMultiply(NumE, NumF));

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

		model.addAttribute("kotae", service.calculateDivide(NumG, NumH));

		return "res";

	}	
	
	//	引き算、掛け算、割り算を記載していきましょう。
	//	ですが、割り算はちょっと特殊なので注意しましょう！
	//	割り算の答えの出し方をよく思い出してくださいね、他の掛け算までの答え方とは別で回答パターンが複数あると思います、
	//	それを意識してコードを書いていってください。

}