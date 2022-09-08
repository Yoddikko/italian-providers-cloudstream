
fun main() {
    val url = "https://github.com/Blatzar/scraping-tutorial"
    val response = khttp.get(url)
    val soup = Jsoup.parse(response.text)
    val element = soup.select("p.f4.mt-3") // Using the CSS selector
    println(element.text().trim()) // Gets the text and strips it (removes starting and ending spaces)
    val jsonString = khttp.get("https://swapi.dev/api/planets/1/").text
    val mapper: JsonMapper = JsonMapper.builder().addModule(KotlinModule())
    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build()
}