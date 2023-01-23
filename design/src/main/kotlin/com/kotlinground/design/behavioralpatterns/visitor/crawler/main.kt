package com.kotlinground.design.behavioralpatterns.visitor.crawler

fun Container.accept(feature: LinksCrawler) {
    feature.visit(this)
}

// Same as above but shorter
fun Page.accept(feature: LinksCrawler) = feature.visit(this)

fun collectLinks(page: Page): List<String> {
    // No need for intermediate variable there
    return LinksCrawler().run {
        page.accept(this)
        this.links
    }
}

fun main() {

    val page = Page(
        Container(
            Image,
            Link,
            Image
        ),
        Table,
        Link,
        Container(
            Table,
            Link
        ),
        Container(
            Image,
            Container(
                Image,
                Link
            )
        )
    )

    println(collectLinks(page))
}