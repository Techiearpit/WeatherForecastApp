import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class WeatherService {
	private static final String API_KEY = "8ed3d765c30a0d912d597c22b539b3c1";
	private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather";

	public WeatherData getWeather(String city) {
		try {
			String apiUrl = API_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric";
			URL url = new URL(apiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String line;

			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();

			return parseJson(response.toString());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private WeatherData parseJson(String json) {
		try {
			JSONObject jsonObject = new JSONObject(json);

			String city = jsonObject.getString("name");

			JSONObject main = jsonObject.getJSONObject("main");
			double temperature = main.getDouble("temp");
			int humidity = main.getInt("humidity");

			JSONObject weather = jsonObject.getJSONArray("weather").getJSONObject(0);
			String description = weather.getString("description");

			return new WeatherData(city, temperature, humidity, description);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
