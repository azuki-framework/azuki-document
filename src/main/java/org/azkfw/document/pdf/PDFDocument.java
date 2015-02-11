package org.azkfw.document.pdf;

import java.io.IOException;

import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDFontDescriptorDictionary;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

public class PDFDocument {

	public static void main(final String[] args) {
		PDFDocument document = new PDFDocument();
		document.create("c:\\tmp\\sample.pdf");
	}

	private void create(final String aPDFFile) {
		try {
			PDDocument document = new PDDocument();

			PDPage page = new PDPage();
			document.addPage(page);

			//書き込む用のストリームを準備
			PDPageContentStream stream = new PDPageContentStream(document, page);

			//テキスト出力開始
			stream.beginText();

			//日本語を設定する場合にはいくつかのフォント情報を指定する
			COSDictionary systeminfo = new COSDictionary();
			systeminfo.setString(COSName.REGISTRY, "Adobe");
			systeminfo.setString(COSName.ORDERING, "Japan1");
			systeminfo.setInt(COSName.SUPPLEMENT, 6);

			//フォントディスクリプタ設定
			PDFontDescriptorDictionary fd = new PDFontDescriptorDictionary();
			//ソフトウェア側で用意されている日本語フォントを指定
			fd.setFontName("KozGoPr6N-Medium");
			fd.setFlags(4);
			//fd.setFontBoundingBox(new PDRectangle(new BoundingBox(-500, -300, 1200, 1400)));
			fd.setFontBoundingBox(new PDRectangle(new BoundingBox()));
			fd.setItalicAngle(0);
			fd.setAscent(1400);
			fd.setDescent(-300);
			fd.setCapHeight(700);
			fd.setStemV(100);

			//CIDフォント設定
			COSDictionary cid = new COSDictionary();
			cid.setItem(COSName.TYPE, COSName.FONT);
			cid.setItem(COSName.SUBTYPE, COSName.CID_FONT_TYPE0);
			cid.setItem(COSName.BASE_FONT, COSName.getPDFName("KozGoPr6N-Medium"));
			cid.setItem(COSName.CIDSYSTEMINFO, systeminfo);
			cid.setItem(COSName.FONT_DESC, fd);

			//フォント設定
			COSDictionary font = new COSDictionary();
			font.setItem(COSName.TYPE, COSName.FONT);
			font.setItem(COSName.SUBTYPE, COSName.TYPE0);
			font.setItem(COSName.BASE_FONT, COSName.getPDFName("KozGoPr6N-Medium"));
			font.setItem(COSName.ENCODING, COSName.ENCODING_90MS_RKSJ_H);

			COSArray array = new COSArray();
			array.add(cid);
			font.setItem(COSName.DESCENDANT_FONTS, array);

			//フォンと作成
			PDFont pdFont = new PDType0Font(font);
			//フォントとフォントサイズを設定
			stream.setFont(pdFont, 36);

			//文字の配置設定
			stream.moveTextPositionByAmount(50, 300);
			//文字列をMS932のバイト列にしつつ、ASCIIコード(1byte文字列)として出力
			stream.drawString(new String("test漢字OK?".getBytes("MS932"), "ISO8859-1"));
			stream.endText();
			
			stream.setLineWidth(10);
			stream.setStrokingColor(255, 0, 0);
			stream.drawLine(100.f, 100.f, 200.f, 100.f);			

			//書き込む用のストリームを閉じる
			stream.close();

			//作成したPDFを保存
			document.save(aPDFFile);
			document.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (COSVisitorException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unused")
	private PDRectangle getA4Rectangle() {
		PDRectangle rect = new PDRectangle();
		rect.setUpperRightX(0);
		rect.setUpperRightY(0);
		//rect.setLowerLeftX(mm2pt(210.f));
		//rect.setLowerLeftY(mm2pt(297.f));
		rect.setLowerLeftX(1000);
		rect.setLowerLeftY(1000);
		return rect;
	}

	@SuppressWarnings("unused")
	private float mm2pt(final float aMm) {
		return aMm / 0.353f;
	}
}
