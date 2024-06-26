package presentation.parser.catalogs

import org.jsoup.Jsoup

class CatalogParser {
    fun parseCatalogs(
        mainPage: String = "https://hramalnevskogo.ru/", clazzName: String = "t451m__list_item"
    ): List<String> = Jsoup.connect(mainPage).get()
        .getElementsByClass(clazzName)
        .html()
        .replace("<a[\\w\\s-.\"=/>]*".toRegex(), "")
        .split("</a>")
        .map { it.replace("\n", "") }
}