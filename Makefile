app.build:
	docker-compose -f docker/docker-compose.yml build
	docker-compose -f docker/docker-compose.yml run bbs ./gradlew build

app.run:
	docker-compose -f docker/docker-compose.yml up

app.down:
	docker-compose -f docker/docker-compose.yml down
