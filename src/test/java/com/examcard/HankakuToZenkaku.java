package com.examcard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringJoiner;

public class HankakuToZenkaku {

	private static final String kanaHanZenTbl[][] = {
			// 2文字構成の濁点付き半角カナ
			// 必ずテーブルに先頭に置いてサーチ順を優先すること
			{ "ｶﾞ", "ガ" }, { "ｷﾞ", "ギ" }, { "ｸﾞ", "グ" }, { "ｹﾞ", "ゲ" }, { "ｺﾞ", "ゴ" }, { "ｻﾞ", "ザ" }, { "ｼﾞ", "ジ" },
			{ "ｽﾞ", "ズ" }, { "ｾﾞ", "ゼ" }, { "ｿﾞ", "ゾ" }, { "ﾀﾞ", "ダ" }, { "ﾁﾞ", "ヂ" }, { "ﾂﾞ", "ヅ" }, { "ﾃﾞ", "デ" },
			{ "ﾄﾞ", "ド" }, { "ﾊﾞ", "バ" }, { "ﾋﾞ", "ビ" }, { "ﾌﾞ", "ブ" }, { "ﾍﾞ", "ベ" }, { "ﾎﾞ", "ボ" }, { "ﾊﾟ", "パ" },
			{ "ﾋﾟ", "ピ" }, { "ﾌﾟ", "プ" }, { "ﾍﾟ", "ペ" }, { "ﾎﾟ", "ポ" }, { "ｳﾞ", "ヴ" },
			// 1文字構成の半角カナ
			{ "ｱ", "ア" }, { "ｲ", "イ" }, { "ｳ", "ウ" }, { "ｴ", "エ" }, { "ｵ", "オ" }, { "ｶ", "カ" }, { "ｷ", "キ" },
			{ "ｸ", "ク" }, { "ｹ", "ケ" }, { "ｺ", "コ" }, { "ｻ", "サ" }, { "ｼ", "シ" }, { "ｽ", "ス" }, { "ｾ", "セ" },
			{ "ｿ", "ソ" }, { "ﾀ", "タ" }, { "ﾁ", "チ" }, { "ﾂ", "ツ" }, { "ﾃ", "テ" }, { "ﾄ", "ト" }, { "ﾅ", "ナ" },
			{ "ﾆ", "ニ" }, { "ﾇ", "ヌ" }, { "ﾈ", "ネ" }, { "ﾉ", "ノ" }, { "ﾊ", "ハ" }, { "ﾋ", "ヒ" }, { "ﾌ", "フ" },
			{ "ﾍ", "ヘ" }, { "ﾎ", "ホ" }, { "ﾏ", "マ" }, { "ﾐ", "ミ" }, { "ﾑ", "ム" }, { "ﾒ", "メ" }, { "ﾓ", "モ" },
			{ "ﾔ", "ヤ" }, { "ﾕ", "ユ" }, { "ﾖ", "ヨ" }, { "ﾗ", "ラ" }, { "ﾘ", "リ" }, { "ﾙ", "ル" }, { "ﾚ", "レ" },
			{ "ﾛ", "ロ" }, { "ﾜ", "ワ" }, { "ｦ", "ヲ" }, { "ﾝ", "ン" }, { "ｧ", "ァ" }, { "ｨ", "ィ" }, { "ｩ", "ゥ" },
			{ "ｪ", "ェ" }, { "ｫ", "ォ" }, { "ｬ", "ャ" }, { "ｭ", "ュ" }, { "ｮ", "ョ" }, { "ｯ", "ッ" }, { "｡", "。" },
			{ "｢", "「" }, { "｣", "」" }, { "､", "、" }, { "･", "・" }, { "ｰ", "ー" }, { "", "" } };
	private static String result;

	public static void main(String[] args) {
		HankakuToZenkaku hankakuToZenkaku = new HankakuToZenkaku();
		String saitama = "C:/Users/user/workspace/examcard/14KANAGA.CSV";
		String saitama_converted = "C:/Users/user/workspace/examcard/14KANAGA_converted.CSV";
		hankakuToZenkaku.output(saitama, saitama_converted);
		result = hankakuToZenkaku.HanToZenForKKana("ｶﾞｷﾞ");
		System.out.println(result);
	}

	private void output(String src, String dest) {
		try (BufferedReader br = new BufferedReader(new FileReader(src));
				BufferedWriter bw = new BufferedWriter(new FileWriter(dest))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] items = line.split(",");
				StringJoiner joiner = new StringJoiner(",");
				joiner.add(items[2].replace("\"", ""));
				joiner.add(items[2].substring(0, 4).replace("\"", ""));
				joiner.add(items[2].substring(4, 8).replace("\"", ""));
				joiner.add(items[0].substring(0, 2).replace("\"", ""));
				joiner.add(items[0].substring(2, 5).replace("\"", ""));
				joiner.add(items[6].replace("\"", ""));
				joiner.add(items[7].replace("\"", ""));
				joiner.add(items[8].replace("\"", "").replace("以下に掲載がない場合", ""));
				joiner.add(HanToZenForKKana(items[3]).replace("\"", ""));
				joiner.add(HanToZenForKKana(items[4]).replace("\"", ""));
				joiner.add(HanToZenForKKana(items[5]).replace("\"", ""));
				joiner.add("2018-08-19");
				joiner.add("operator");
				joiner.add("2018-08-19");
				joiner.add("operator");
				joiner.add("");
				joiner.add("");
				joiner.add("0");
				System.out.println(joiner.toString());
				bw.write(joiner.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String HanToZenForKKana(String p) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0, j = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			// 半角全角変換テーブルを検索する
			for (j = 0; j < kanaHanZenTbl.length; j++) {
				if (c == kanaHanZenTbl[j][0].charAt(0)) {
					sb.append(kanaHanZenTbl[j][1]);
					i += kanaHanZenTbl[j][0].length() - 1;
					break;
				}
			}
			// 検索できなければ、変換しない
			if (j >= kanaHanZenTbl.length) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
