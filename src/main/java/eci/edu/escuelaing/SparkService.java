package eci.edu.escuelaing;

import static spark.Spark.*;


public class SparkService {
	public static void main(String[] args) {
		port(getPort());

		
		get("/sin", (req, res) -> {
                        Calculadora c = new Calculadora();
			res.status(200);
			res.type("application/json");
			String value = req.queryParamsValues("value")[0];
			double num=c.sin(Double.parseDouble(value));
                         return "{\"operation\": \"sin\", \"input\":"+value+",\"output\": "+num+"}";
		});
		
		get("/log", (req, res) -> {
                        Calculadora c = new Calculadora();
			res.status(200);
			res.type("application/json");
			String value = req.queryParamsValues("value")[0];
			double num=c.log(Double.parseDouble(value));
                        return "{\"operation\": \"log\", \"input\":"+value+",\"output\": "+num+"}";
		});
	}

	private static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4000;
	}
}
