# Hateaos Spring Boot

Small Spring Boot project based on Spring Boot 2.0.4 that probably included a bug
from Spring HATEOAS 0.25.0

## Configure

* Clone the repository.
* Create the database and the user.

```sql
CREATE DATABASE hateoas DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;

CREATE USER 'hateoas'@'localhost' IDENTIFIED BY 'hateoas';

GRANT ALL ON hateoas.* TO 'hateoas'@'localhost';
```

## Test the Web Service

* POST a contact (correct links):

```bash
curl --request POST \
  --url http://localhost:8080/api/contacts \
  --header 'content-type: application/json' \
  --data '{
	"firstName": "Recipient",
	"lastName": "Recipient"
}'
```

* GET a contact (correct links):

```bash
curl --request GET \
  --url http://localhost:8080/api/contacts/<CONTACT_ID> \
  --header 'content-type: application/json'
```

* GET a pagination of contacts (incorrect links):

```bash
curl --request GET \
  --url http://localhost:8080/api/contacts \
  --header 'content-type: application/json'
```
