import java.util.Scanner;

public class WeatherController {
	private WeatherService weatherService;
	private Scanner scanner;

	public WeatherController() {
		weatherService = new WeatherService();
		scanner = new Scanner(System.in);
	}

	public void start() {
		System.out.println("Enter the city name:");
		String city = scanner.nextLine();

		WeatherData weatherData = weatherService.getWeather(city);

		if (weatherData != null) {
			System.out.println("Weather forecast for " + city + ":");
			System.out.println("Temperature: " + weatherData.getTemperature() + "°C");
			System.out.println("Humidity: " + weatherData.getHumidity() + "%");
			System.out.println("Description: " + weatherData.getDescription());
		} else {
			System.out.println("Failed to fetch weather data for " + city);
		}
	}
}
