public class WeatherData {
	private String city;
	private double temperature;
	private int humidity;
	private String description;

	public WeatherData(String city, double temperature, int humidity, String description) {
		this.city = city;
		this.temperature = temperature;
		this.humidity = humidity;
		this.description = description;
	}

	public String getCity() {
		return city;
	}

	public double getTemperature() {
		return temperature;
	}

	public int getHumidity() {
		return humidity;
	}

	public String getDescription() {
		return description;
	}
}
