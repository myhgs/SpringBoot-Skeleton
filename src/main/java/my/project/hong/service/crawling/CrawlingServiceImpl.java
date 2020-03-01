package my.project.hong.service.crawling;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kiseokhong on 01/03/2020.
 */
@Service
public class CrawlingServiceImpl implements CrawlingService {

    private static final Logger LOG = LoggerFactory.getLogger(CrawlingServiceImpl.class);

    private final Document getJsoup;

    @Autowired
    public CrawlingServiceImpl(Document getJsoup) {
        this.getJsoup = getJsoup;
    }

    @Override
    public void crawlingTest() {

        Elements elems = getJsoup.select(".card_el.n_ntc.clear");

        elems.forEach(data -> System.out.println(data.select(".rt_area.is_tmb").select(".card_content").select("h3").select("a").text()));
        elems.forEach(data -> System.out.println(data.select(".rt_area.is_tmb").select(".card_content").select("h3").select("a").attr("href")));

    }
}
