/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasjsoup;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author GaldosV
 */
public class Pruebasjsoup {

    /**
     * @param args the command line arguments
     * String  s es la query que quieres buscar es decir si escribes camiseta te buscara camisetas en esas webs 	
     */
    public static void main(String[] args) throws IOException {
        {
			
            String s = "3060";
            // ebay();
            //  Amazon(buscaAma(s));
            //aussar();
            // buscador();
            //  buscadorebay(s);
            //System.out.println(Arrays.toString(getLinks("3060", 5)));
            // getLinks("3060", 5);
            //buscadorebay(s).length

            for (int i = 0; i < 1; i++) {
                // System.out.println(buscadorebay(s)[i]);
                //  ebay(buscadorebay(s)[i]);
                aussar(buscadorassuar(s)[i]);
            }

            for (int i = 0; i < 10; i++) {
                //  Amazon(buscaAma(s)[1]);
                //  System.out.println(buscaassua(s)[1]);

            }
            System.out.println(buscadorassuar(s)[1]);
            //buscaAma(s);
        }
    }

    public static void ebay(String url) throws IOException {

        Document doc = Jsoup.connect(url)
                .timeout(6000).get();
        Elements image = doc.select("#icImg");
        Elements title = doc.select("#vi-lkhdr-itmTitl");
        Elements price = doc.select("#vi-mskumap-none #prcIsum");
        Elements location = doc.select("#SRPSection [class='ux-textspans ux-textspans--SECONDARY']");
        Elements payments = doc.select("#SRPSection [role='img']");
        ArrayList<String> paymentMethods = new ArrayList<>();
        for (Element payment : payments) {
            paymentMethods.add(payment.attr("aria-label"));
        }
        Elements ratingEle = doc.select("#LeftSummaryPanel [itemprop='ratingValue']");
        String ele = ratingEle.attr("content");

        Elements condition1 = doc.select("#viTabs_0_is .ux-layout-section__row .ux-labels-values__values .ux-labels-values__values-content .ux-textspans");
        Elements condtion2 = doc.select("#vi-desc-maincntr");
        Elements Time = doc.select("#vi-cdown_timeLeft");

        System.out.println(image.attr("src"));
        System.out.println(title.text());
        System.out.println(price.text());
        System.out.println(location.text().replace("See detailsfor shipping Located in:", "").replace("See details- for more information about returns Learn moreLearn more about eBay global shipping program", ""));
        System.out.println(paymentMethods.toString());
        System.out.println(ele);
        System.out.println(condition1.text().replace(" Read moreabout the condition", "").replaceAll("[()]", "").replaceAll("[.]", ""));
        System.out.println(Time.text());
    }

    public static void Amazon(String url) throws IOException {
        ///    String uri = "https://www.amazon.es/H-P-Lovecraft-anotado-Grandes-Libros/dp/8446043866/?_encoding=UTF8&pd_rd_w=ZBx1s&content-id=amzn1.sym.5f6951c0-9d61-4e03-b39a-a5647d9ae575&pf_rd_p=5f6951c0-9d61-4e03-b39a-a5647d9ae575&pf_rd_r=1FCJ96PGP309Q3YBKKQQ&pd_rd_wg=6LP5u&pd_rd_r=64c52dfa-dd78-46ce-bc4b-d8267ef44ba8&ref_=pd_gw_ci_mcx_mr_hp_atf_m";
        String url2 = "https://www.amazon.es/Tarjeta-gr%C3%A1fica-ZOTAC-Gaming-GEFORCE/dp/B08P34VCVN/ref=sr_1_1?keywords=3060+ti+segunda+mano&qid=1653731280&sprefix=3060%2Caps%2C84&sr=8-1";
        Document doc = Jsoup.connect(url)
                .timeout(6000).get();
        Elements image = doc.select("#landingImage");
        Elements title = doc.select("#title");
        Elements price = doc.select("#corePrice_feature_div [class='a-offscreen']");
        Elements entrega = doc.select("#mir-layout-DELIVERY_BLOCK-slot-PRIMARY_DELIVERY_MESSAGE_LARGE [class='a-text-bold']");
        Elements ratingEle = doc.select("#averageCustomerReviews [class='a-icon-alt']");
        Elements descripcion = doc.select("#productDescription span");

        System.out.println(image.attr("src"));
        System.out.println(title.text());
        System.out.println(price.text());
        System.out.println(entrega.text());
        System.out.println(ratingEle.text().substring(0, 19));
        System.out.println(descripcion.text());

    }

    public static void aussar(String url) throws IOException {
//        String url = "https://www.aussar.es/alimentacion/evga-supernova-750-gt-80gold-full-modular.html";

        Document doc = Jsoup.connect(url)
                .timeout(10000).get();
        Elements image = doc.select("#zoom_product");
        Elements title = doc.select("#main [class='h1 product-detail-name']");

        Elements price = doc.select("#main [class='current-price-value']");
        Elements entrega = doc.select("#product-availability");
        Elements descripcion = doc.select("#tab-content [class='product-description'] span");

        System.out.println(image.attr("src"));
        System.out.println(title.text());
        System.out.println(price.text());
        System.out.println(entrega.text());
        System.out.println(descripcion.text());

    }

    public static String[] buscadorebay(String query) throws IOException {
        String url2 = "https://www.ebay.com/sch/i.html?_nkw=" + query;
        Document doc = Jsoup.connect(url2).timeout(10000).get();

        Elements uri = doc.select("#srp-river-main [class ='srp-results srp-list clearfix']");
        int num = uri.select("li").size();

        System.out.println(num);
        int max = 0;
        //if (uri != uri.) {}
        // System.out.println(uri.select("li").size());
        for (Element e : uri.select("li")) {
            String url = e.select("[class ='s-item__info clearfix'] a ").attr("href");
            if (url != "") {
                max++;
                // System.out.println(max + "--> " + url);

            }
        }
        //System.out.println(max);
        String[] stringUrl = new String[max];
        int i = 0;
        for (Element e : uri.select("li")) {
            String url = e.select("[class ='s-item__info clearfix'] a ").attr("href");
            if (url != "") {
                stringUrl[i] = url;
                i++;
            }
        }

        return stringUrl;
    }

    public static String[] buscaAma(String query) throws IOException {
        String url = "https://www.amazon.es/s?k=" + query;
        Document doc = null;
        String[] stringUrl = new String[5];

        try {
            doc = Jsoup.connect(url).get();
            Elements links = doc.select(".rush-component > a");
            Element link;

            for (int j = 0; j < 1; j++) {
                link = links.get(j);
                String uri = link.attr("abs:href");
                System.out.println(link.attr("abs:href"));
                stringUrl[1] = uri;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringUrl;
    }

    public static String[] buscadorassuar(String query) throws IOException {
        String url = "https://www.aussar.es/#/dfclassic/query=" + query;
        Document doc = null;
        String[] stringUrl = null;

        try {
            doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href$=.html]:contains(" + query + ") ");
            stringUrl = new String[links.size()];
            System.out.println(links.size());
            Element link;

            for (int j = 0; j < links.size(); j++) {
                link = links.get(j);
                String uri = link.attr("abs:href");
                System.out.println(link.attr("abs:href"));
                stringUrl[j] = uri;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringUrl;
    }

}
