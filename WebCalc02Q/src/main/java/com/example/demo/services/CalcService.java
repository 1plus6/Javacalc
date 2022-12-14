package com.example.demo.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

@Component 
/*
 * webのmvcアプリを作成するときに、
 * DIコンテナに管理させて、DIできるようにしたいクラスにつける
 *  service = 実行者
 */
public class CalcService { //CalcServiceのクラス

	public String calculateAdd(
			String NumA,
			String NumB
			)

	{	
		String AdResult = null; //AdResultにnull代入
		BigDecimal AdA = null;   //BigDecimalは正確な計算をする AdAはnull
		BigDecimal AdB = null;
		try {      //例外が発生する可能性のある処理
			AdA = new BigDecimal(NumA); //　AdAをNumAを代入
			AdB = new BigDecimal(NumB);
			BigDecimal AdR = AdA.add(AdB); //AdRにAdA + AdBの答えを代入
			AdResult = AdR.toString(); //AdResultにString型にしたAdRを入れる →型変更：キャスト

		} catch (Exception e) {  //	(例外クラス 例外クラスを表す変数名)
			AdResult = "Aderror";//エラーの場合はこれをキャッチ

		}
		return AdResult; //AdResultを返す　最終的にはこっちを返す
	}

	/*
	 * 引き算
	 */

	public String calculateSubtract(
			String NumC,
			String NumD

			)

	{
		String SubResult = null;
		BigDecimal SubC = null;
		BigDecimal SubD = null;
		try {
			SubC = new BigDecimal(NumC); //
			SubD = new BigDecimal(NumD);
			BigDecimal SubR = SubC.subtract(SubD);
			SubResult = SubR.toString();
		} catch (Exception e) {
			SubResult = "Suerror";//エラーの場合はこれをキャッチ
		}
		return SubResult;

	}
	/*
	 * 掛け算
	 */
	public String calculateMultiply(
			String NumE,
			String NumF
			)

	{
		String MulResult = null;
		BigDecimal MulE = null;
		BigDecimal MulF = null;
		try {
			MulE = new BigDecimal(NumE);
			MulF = new BigDecimal(NumF);
			BigDecimal MulR = MulE.multiply(MulF);
			MulResult = MulR.toString();
		} catch (Exception e) {
			MulResult = "Muerror" ;
		}
		return MulResult;

	}

	/*
	 * 割り算
	 */
	public String calculateDivide(
			String NumG,
			String NumH
			)

	{
		String DivResult = null;
		BigDecimal DiG = null;
		BigDecimal DiH = null;
		try {
			DiG = new BigDecimal(NumG);
			DiH = new BigDecimal(NumH);
			BigDecimal DiR = DiG.divide(DiH,7,RoundingMode.HALF_UP);
			DivResult = DiR.toString();
		} catch (Exception e) {
			DivResult = "Dierror" ;
			System.out.println( e );

		}
		return DivResult ;
	}
	//		割り算に関しては特殊なので注意
	//		
	//		ヒントとしてtry、catch構文も記載はしておきます。
	//		
	//		後は調べてね！

	//		try {
	//			BigDecimal AdR = 〇〇.〇〇(AdB);
	//			return AdR.toString();
	//		} catch (Exception e) {
	//			return "無限小数の答えになりました";
	//		}

	/*このコメントアウトは消さない方がいい
	 * これは無限少数の桁を設定する際に必要
	BigDecimal AdR = AdA.divide(AdB,7,RoundingMode.HALF_UP); //BigDecimal 〇〇= 〇〇.add(〇〇); これは足し算を書くとき
	String AdResult = AdR.toString();//toStringはクラスで定義されている文字列表現を返すメソッド
	return AdResult;
	 */
}

