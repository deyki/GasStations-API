# Tech-stack
* Java 17
* Spring-boot 3
* Spring-data-jpa
* PostgreSQL
* Docker

# Local setup
* 1 - Download project
* 2 - Run this command -> docker compose up -d

# Description
* GasStations-API is a small project with a simple purpose to collect gas stations data in Germany and present it in a convenient way.
* 1 - Collect data for stations -> **/api/getData
* 2 - Get all stations names -> **/api/getStationsNames
* 3 - Search for a station by name -> **/api/getStation/{stationName}
* 4 - Get info about specific fuel type: E5, E10 or Diesel. -> **/api/getFuelInfo/{fuelType}
