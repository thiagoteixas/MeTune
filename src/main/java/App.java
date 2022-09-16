import static spark.Spark.*;

public class App {
	
	public static void main(String[] args) {
		
		
        staticFiles.location("/public");
        
        get("/", (req, res) -> "<html><head><title>Ola mundo</title></head><body><h1>Metune</h1></body></html>");
	}
}