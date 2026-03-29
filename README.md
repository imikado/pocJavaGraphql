# pocJavaGraphql

## Installation

- Need docker
- Launch ./setup.sh to build docker image
- Then ./run.sh to launch the app

## Use

Open your graphQL client to http://localhost:8080/graphql

## auth

### query
```graphql
mutation login($login:String!,$password:String!) {
  login(login: $login, password: $password) 
}
```

### variables

user 1
```json
{
	"login": "login1@mail.com",
	"password": "myPassword"
}
```

user 2
```json
{
	"login": "login2@mail.com",
	"password": "myPassword2"
}
```

## query folders

### query
```graphql
query getFolders {
	getFolders {
		id
		name
	}
}
```

### output

user 1
```json
{
	"data": {
		"getFolders": [
			{
				"id": 1,
				"name": "my pics 2024"
			},
			{
				"id": 2,
				"name": "my pics 2025"
			}
		]
	}
}
```

user 2
```json
{
	"data": {
		"getFolders": [
			{
				"id": 4,
				"name": "my invoices 2024"
			},
			{
				"id": 5,
				"name": "my invoices 2025"
			}
		]
	}
}
```