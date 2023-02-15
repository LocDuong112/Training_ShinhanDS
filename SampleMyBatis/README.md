# TUTORIAL DEMO

---

* [Docker Hub](#docker-hub)
* [Create tutorial](#create-tutorial)
* [Get all tutorials](#get-all-tutorials)
* [Get tutorial by id](#get-tutorial-by-id)
* [Update tutorial by id](#update-tutorial)
* [Delete tutorial by id](#delete-tutorial-by-id)
* [Delete all tutorials](#delete-all-tutorials)
* [Get tutorial by published](#get-tutorials-by-published)
* [Get all tutorial by title matching](#get-tutorials-by-title)
* [Further reading]()

***

## Docker Hub

Run the following code to run the image

`docker pull dmloc/tutorial_project`

`docker run -p 8080:8080 dmloc/tutorial_project`

***


## Initial database

**Database config**

![](./Image/Database_spring-config.png)

Please make sure your database url, username, password is the same as config
* Database url: **jdbc:h2:mem:testdb**
* Database username: **sa**
* Database password: is a blank space

To check the database go to: **localhost:8080/h2-ui** 

**Initialize database**

```sql
INSERT INTO "PUBLIC"."TUTORIAL" (DESCIPTION, PUBLISHED, TITLE) VALUES

('description 1', TRUE, 'title 1'),

('description 2', TRUE, 'title 2'),

('des 3', TRUE, 'til 3'),

('des 4', FALSE, 'til 4'),

('des 5', FALSE, 'til 5'),

('des 6', TRUE, 'til 6'),

('des 7', FALSE, 'til 7'),

('des 8', FALSE, 'til 8 '),

('des 9', FALSE, 'til 9'),

('des 10', TRUE, 'til 10');
```

![Initial database](./Image/Initial-database.png)

***


## Create tutorial

![Postman create tutorial](./Image/postman_create-tutorial.png)

**New value in database**

![](./Image/Database_create-tutorial_new-value.png)

***


## Get all tutorials

![](./Image/postman_get-all-tutorials.png)

***


## Get tutorial by id

![](./Image/postman_get-tutorial-by-id.png)

***


## Update tutorial

![](./Image/postman_update-tutorial-by-id.png)

**Row 3 is updated**

![](./Image/Database_update-tutorial-by-id_updated-value.png)

***


## Delete tutorial by id

![](./Image/postman_delete-tutorial-by-id.png)

**Tutorial with id 3 is deleted**

![](./Image/Database_delete-tutorial-by-id_id-3-is-missing.png)

***


## Delete all tutorials

![](./Image/postman_delete-all.png)

**All tutorials were deleted**

![](./Image/Database_delete-all_all-has-gone.png)

***


## Get tutorials by published

![](./Image/postman_get-tutorial-by-true-published.png)

***


## Get tutorial(s) by title

![](./Image/postman_get-tutorials-by-title-matching.png)

***


## Further reading

[Spring boot Docker starter](https://spring.io/guides/topicals/spring-boot-docker/)

[H2 database webAllowUser error solution](https://stackoverflow.com/questions/44867227/h2-console-throwing-a-error-weballowothers-in-h2-database)
