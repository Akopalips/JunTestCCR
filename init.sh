./mvnw package
docker-compose up -d postgres
docker-compose build springproj
docker-compose up