docker-compose up -d postgres
./mvnw package
docker-compose build springproj
docker-compose up -d