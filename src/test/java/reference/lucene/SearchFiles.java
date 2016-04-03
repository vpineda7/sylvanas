package reference.lucene;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

public class SearchFiles {
	
	public static void main(String[] args) throws IOException, ParseException {
		
		String index = "/Users/subin/Project/Doc/Apache/lucene-index";
		String field = "contents";
		//String queries = null;
		//int repeat = 0;
		//boolean raw = false;
		String queryString = "lucene";
		//int hitsPerPage = 10;
		
		IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(index)));
		IndexSearcher searcher = new IndexSearcher(reader);
		
		Analyzer analyzer = new StandardAnalyzer();
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
		
		QueryParser parser = new QueryParser(field, analyzer);
		
		Query query = parser.parse(queryString);
		
		System.out.println("Searching for: " + query.toString(field));
		
		TopDocs td = searcher.search(query, 100);
		
		System.out.println(td.totalHits);
	}
}