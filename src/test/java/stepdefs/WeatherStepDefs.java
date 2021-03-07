package stepdefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import java.util.Map;


public class WeatherStepDefs {
    private int cityId;
    private WeatherResponse response;

    @Given("city id: {int}")
    public void set_city_id(int cityId) {
        this.cityId = cityId;
    }

    @When("we are requesting weather data")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(cityId);

    }

    @Then("lon is: {double}")
    public void check_lon(double lon) {
        Assertions.assertEquals(lon, response.getCoord().getLon(), "Wrong Lon!");

    }

    @Then("lat is: {double}")
    public void check_lat(double lat) {
        Assertions.assertEquals(lat, response.getCoord().getLat(), "Wrong Lat!");

    }

    @Then("weather is:")
    public void check_weather(Map<String, String> params) {
        Assertions.assertEquals(Integer.parseInt(params.get("id")), response.getWeathers().get(0).getId(), "Wrong weather ID");
        Assertions.assertEquals(params.get("main"), response.getWeathers().get(0).getMain(), "Wrong weather main");
        Assertions.assertEquals(params.get("description"), response.getWeathers().get(0).getDescription(), "Wrong weather description");
        Assertions.assertEquals(params.get("icon"), response.getWeathers().get(0).getIcon(), "Wrong weather icon");
    }

    @And("base is: {string}")
    public void check_base(String base) {

        Assertions.assertEquals(base, response.getBase(), "Wrong base");
    }

    @And("main is:")
    public void check_main(Map<String, String> params) {
        Assertions.assertEquals(Double.parseDouble(params.get("temp")), response.getMain().getTemp(), "Wrong main temp");
        Assertions.assertEquals(Integer.parseInt(params.get("pressure")), response.getMain().getPressure(), "Wrong main pressure");
        Assertions.assertEquals(Integer.parseInt(params.get("humidity")), response.getMain().getHumidity(), "Wrong main humidity");
        Assertions.assertEquals(Double.parseDouble(params.get("temp_min")), response.getMain().getTemp_min(), "Wrong main temp_min");
        Assertions.assertEquals(Double.parseDouble(params.get("temp_max")), response.getMain().getTemp_max(), "Wrong main temp_max");
    }

    @And("visibility is: {int}")
    public void check_visibility(int visibility) {
        Assertions.assertEquals(visibility, response.getVisibility(), "Wrong visibility");
    }

    @And("wind is:")
    public void check_wind(Map<String, String> params) {
        Assertions.assertEquals(Double.parseDouble(params.get("speed")), response.getWind().getSpeed(), "Wrong wind speed");
        Assertions.assertEquals(Integer.parseInt(params.get("deg")), response.getWind().getDeg(), "Wrong speed deg");
    }

    @And("clouds is:")
    public void check_clouds(Map<String, String> params) {
        Assertions.assertEquals(Integer.parseInt(params.get("all")), response.getClouds().getAll(), "Wrong clouds all");
    }

    @And("dt is: {int}")
    public void check_dt(int dt) {
        Assertions.assertEquals(dt, response.getDt(), "Wrong dt");
    }

    @And("sys is:")
    public void check_sys(Map<String, String> params) {
        Assertions.assertEquals(Integer.parseInt(params.get("type")), response.getSys().getType(), "Wrong sys type");
        Assertions.assertEquals(Integer.parseInt(params.get("id")), response.getSys().getId(), "Wrong sys id");
        Assertions.assertEquals(Double.parseDouble(params.get("message")), response.getSys().getMessage(), "Wrong sys message");
        Assertions.assertEquals(params.get("country"), response.getSys().getCountry(), "Wrong sys country");
        Assertions.assertEquals(Integer.parseInt(params.get("sunrise")), response.getSys().getSunrise(), "Wrong sys sunrise");
        Assertions.assertEquals(Integer.parseInt(params.get("sunset")), response.getSys().getSunset(), "Wrong sys sunset");
    }

    @And("id is: {int}")
    public void check_id(int id){
        Assertions.assertEquals(id, response.getId(), "Wrong id");
    }

    @And("name is: {string}")
    public void check_name(String name) {
        Assertions.assertEquals(name, response.getName(), "Wrong name");
    }

    @And("cod is: {int}")
    public void check_cod(int cod) {
        Assertions.assertEquals(cod, response.getCod(), "Wrong cod");
    }




}
