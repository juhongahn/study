package com.jsouptest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Application {

    public static void main(String[] args) {

        String monsterRatUrl = "https://www.op.gg/summoners/kr/%EA%B4%B4%EB%AC%BC%EC%A5%90";

        Document doc = null;

        try {
            doc = Jsoup.connect(monsterRatUrl).get();
            Element soloRankContent = doc.getElementsByAttributeValue("class", "css-er3yn6 e1x14w4w1").first();
            Element soloRankInfo = soloRankContent.select(".info").first();

            System.out.println(soloRankInfo.text());

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
