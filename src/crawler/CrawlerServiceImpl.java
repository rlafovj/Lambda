package crawler;

import java.io.IOException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;
import user.User;
import user.UserServiceImpl;

public class CrawlerServiceImpl implements CrawlerService {
  private static CrawlerServiceImpl instance = new CrawlerServiceImpl();

  Map<String, ?> map;
  private CrawlerServiceImpl(){
    this.map = new HashMap<>();
  }
  public static CrawlerServiceImpl getInstance(){return instance;}
  @Override
  public void findNamesFromWeb() throws IOException {
    Document doc = Jsoup.connect("https://music.bugs.co.kr/chart").timeout(10 * 1000).get();
    Elements elems = doc.select("");
    Iterator<Element> title = elems.select("p.title").iterator();
    Iterator<Element> artist = elems.select("p.artist").iterator();
    Iterator<Element> rank = elems.select("strong").iterator();
    while (rank.hasNext()) {
      System.out.println(rank.next().text() + "위 " + artist.next().text() + " - " + title.next().text());
    }
  }
}
