# JunTestCCR
Solve test problem, keys: java, Spring, Postgres, REST API, Docker.

Run init.sh to launch project.

----------------------------------------------
  db structure:

News
name - text, not null
type_id - bigint, not null, references news_type(id),
about_short - text
about_full - text

NewsType
name - text, not null
color - text
----------------------------------------------
  request examples:

create entity
curl -X POST http://localhost:8080/newsType/new -H "Content-type: application/json" -d '"{"name":"testNews", "typeId":1, "aboutShort":"short", "aboutFull":"full"}"'

take entity info from db
curl -X GET http://localhost:8080/news/get/1

take all entities from db
curl -X GET http://localhost:8080/news/

update entity
curl -X PUT http://localhost:8080/news/update/1 -H "Content-type: application/json" -d '{"name":"Armageddon"}'

delete entity
curl -X DELETE http://localhost:8080/news/del/1

take all entities with NewsType id = 1
curl -X GET http://localhost:8080/news/typeFilter/1
