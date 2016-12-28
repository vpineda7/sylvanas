import scrapy

class SchoolSpider(scrapy.Spider):
    
    name = "school"
    
    # http://www.ruyile.com/xxlb.aspx?p=1 15280
    
    start_urls = [
        'http://www.ruyile.com/xxlb.aspx?p=1'
    ]

    def parse(self, response):
        for one in response.css('div.sk'):
            yield {
                'name': one.css('a::text').extract_first()
            }